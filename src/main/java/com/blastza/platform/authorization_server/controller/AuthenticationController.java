package com.blastza.platform.authorization_server.controller;

import com.blastza.platform.authorization_server.models.AuthenticationRequest;
import com.blastza.platform.authorization_server.models.AuthenticationResponse;
import com.blastza.platform.authorization_server.models.RegisterRequest;
import com.blastza.platform.authorization_server.models.RegistrationResponse;
import com.blastza.platform.authorization_server.service.AuthenticationService;
import com.blastza.platform.authorization_server.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@Valid @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verifyEmail(@RequestParam("token") String token) {
        return ResponseEntity.ok(service.updateUserVerificationStatus(token));
    }


    @PostMapping("/resend-verification")
    public ResponseEntity<?> resendVerificationEmail(@RequestBody String email) {
        return ResponseEntity.ok(service.resendEmailVerification(email));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
