package pl.lodz.uni.biobank.foam.app.cega_user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cega-users")
public class CegaUserController {
    private final CegaUserService service;

    public CegaUserController(CegaUserService service) {
        this.service = service;
    }


    @GetMapping("full-name")
    ResponseEntity<HeaderResponse> getFullUsername(Authentication authentication) {
        HeaderResponse response = new HeaderResponse(service.getUserFullName((String) authentication.getPrincipal()));
        return ResponseEntity.ok(response);
    }

}
