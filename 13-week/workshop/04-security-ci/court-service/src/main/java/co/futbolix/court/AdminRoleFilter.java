package co.futbolix.court;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/** /admin/* only with a valid JWT whose role is ADMINISTRATOR; anything else gets 403 (story #52). */
@Component
public class AdminRoleFilter extends OncePerRequestFilter {

    private final byte[] secret;

    public AdminRoleFilter(@Value("${futbolix.jwt.secret}") String secret) {
        this.secret = secret.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest req) {
        return !req.getRequestURI().startsWith("/admin/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {
        if (isAdmin(req.getHeader("Authorization"))) {
            chain.doFilter(req, res);
            return;
        }
        res.setStatus(HttpServletResponse.SC_FORBIDDEN);
        res.setContentType("application/json");
        res.getWriter().write("{\"error\":\"FORBIDDEN\",\"message\":\"Administrator role required\"}");
    }

    private boolean isAdmin(String authorization) {
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return false;
        }
        String[] parts = authorization.substring(7).split("\\.");
        if (parts.length != 3) {
            return false;
        }
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret, "HmacSHA256"));
            byte[] expected = mac.doFinal((parts[0] + "." + parts[1]).getBytes(StandardCharsets.UTF_8));
            byte[] given = Base64.getUrlDecoder().decode(parts[2]);
            if (!MessageDigest.isEqual(expected, given)) {
                return false;
            }
            String payload = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);
            return payload.replace(" ", "").contains("\"role\":\"ADMINISTRATOR\"");
        } catch (Exception e) {
            return false;
        }
    }
}
