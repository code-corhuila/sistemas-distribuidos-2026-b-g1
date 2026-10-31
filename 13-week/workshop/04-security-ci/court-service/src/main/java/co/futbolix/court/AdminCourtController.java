package co.futbolix.court;

import java.util.Map;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** Minimal version of PATCH /admin/courts/{id} from court-service.yaml. */
@RestController
public class AdminCourtController {

    @PatchMapping("/admin/courts/{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> body) {
        return Map.of("id", id, "status", body.getOrDefault("status", "ACTIVE"));
    }
}
