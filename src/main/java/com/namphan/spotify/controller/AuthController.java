package com.namphan.spotify.controller;

import com.namphan.spotify.model.reponse.JwtAuthenticationResponse;
import com.namphan.spotify.model.request.SignInRequest;
import com.namphan.spotify.model.request.SignUpRequest;
import com.namphan.spotify.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authService.signin(request));
    }
}
