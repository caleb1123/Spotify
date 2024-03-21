package com.namphan.spotify.service.impl;

import com.namphan.spotify.model.entity.Account;
import com.namphan.spotify.model.entity.ERole;
import com.namphan.spotify.model.reponse.JwtAuthenticationResponse;
import com.namphan.spotify.model.request.SignInRequest;
import com.namphan.spotify.model.request.SignUpRequest;
import com.namphan.spotify.repository.AccountRepository;
import com.namphan.spotify.service.AccountService;
import com.namphan.spotify.service.AuthService;
import com.namphan.spotify.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.namphan.spotify.model.entity.ERole.ROLE_USER;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = Account.builder().userName(request.getUserName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(ROLE_USER).build();
        accountRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        Account user = accountRepository.findByUsername(request.getUserName())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

}
