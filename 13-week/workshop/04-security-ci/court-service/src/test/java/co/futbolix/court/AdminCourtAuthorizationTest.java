package co.futbolix.court;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Story #52 "[security] Only ADMIN can call /admin routes".
 * Criterion: PATCH /admin/courts/{id} without a JWT or with a JWT without role ADMINISTRATOR returns 403.
 */
@SpringBootTest(properties = "futbolix.jwt.secret=test-secret-for-ci-only")
@AutoConfigureMockMvc
class AdminCourtAuthorizationTest {

    static final String COURT_ID = "c0000000-0000-4000-8000-000000000001";
    static final String BODY = "{\"status\":\"INACTIVE\"}";

    @Autowired
    MockMvc mvc;

    @Test
    void patchCourtWithoutTokenIsForbidden() throws Exception {
        mvc.perform(patch("/admin/courts/{id}", COURT_ID)
                        .contentType(MediaType.APPLICATION_JSON).content(BODY))
                .andExpect(status().isForbidden());
    }

    @Test
    void patchCourtWithCustomerTokenIsForbidden() throws Exception {
        String token = TestTokens.sign("{\"sub\":\"customer\",\"role\":\"CUSTOMER\"}", "test-secret-for-ci-only");
        mvc.perform(patch("/admin/courts/{id}", COURT_ID)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON).content(BODY))
                .andExpect(status().isForbidden());
    }

    @Test
    void patchCourtWithForgedAdminTokenIsForbidden() throws Exception {
        String token = TestTokens.sign("{\"sub\":\"attacker\",\"role\":\"ADMINISTRATOR\"}", "wrong-secret");
        mvc.perform(patch("/admin/courts/{id}", COURT_ID)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON).content(BODY))
                .andExpect(status().isForbidden());
    }

    @Test
    void patchCourtWithAdminTokenIsAllowed() throws Exception {
        String token = TestTokens.sign("{\"sub\":\"admin\",\"role\":\"ADMINISTRATOR\"}", "test-secret-for-ci-only");
        mvc.perform(patch("/admin/courts/{id}", COURT_ID)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON).content(BODY))
                .andExpect(status().isOk());
    }
}
