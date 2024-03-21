package com.namphan.spotify.service;

import com.namphan.spotify.model.reponse.JwtAuthenticationResponse;
import com.namphan.spotify.model.request.SignInRequest;
import com.namphan.spotify.model.request.SignUpRequest;

public interface AuthService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
