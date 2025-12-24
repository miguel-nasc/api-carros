package com.projeto.Carros.controllers.security;

import com.projeto.Carros.controllers.docs.AuthControllerDocs;
import com.projeto.Carros.dtos.security.AccountCredentialsDTO;
import com.projeto.Carros.servicos.security.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication endpoint")
@RestController
@RequestMapping("/auth")
public class AuthController implements AuthControllerDocs {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @Override
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody AccountCredentialsDTO credentials) {
        if (credentialsIsInvalid(credentials)) return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("Invalid Client Request");
        var token = authService.signIn(credentials);
        if (token == null) return ResponseEntity.status((HttpStatus.FORBIDDEN))
                .body("Invalid Client Request");
        return ResponseEntity.ok().body(token);
    }


    @Override
    @PutMapping("/refresh/{username}")
    public ResponseEntity<?> refresh(@PathVariable("username") String username,
                                     @RequestHeader("Authorization") String refreshToken) {
        if(parametersAreInvalid(username, refreshToken)) return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("Invalid Client Request");
        var token = authService.refreshToken(username, refreshToken);
        if (token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Client Request");
        return ResponseEntity.ok().body(token);
    }

    private boolean parametersAreInvalid(String username, String refreshToken) {
        return StringUtils.isEmpty(username) && StringUtils.isEmpty(refreshToken)
                || StringUtils.isEmpty(refreshToken) || StringUtils.isEmpty(username);
    }

    private boolean credentialsIsInvalid(AccountCredentialsDTO credentials) {
        return StringUtils.isBlank(credentials.getUsername()) && StringUtils.isEmpty(credentials.getPassword());
    }


}
