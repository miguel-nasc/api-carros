package com.projeto.Carros.servicos.security;

import com.projeto.Carros.dtos.security.AccountCredentialsDTO;
import com.projeto.Carros.dtos.security.TokenDTO;
import com.projeto.Carros.repositorios.security.UserRepository;
import com.projeto.Carros.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider tokenProvider;

    private final UserRepository userRepository;

    public AuthService(AuthenticationManager authenticationManager,
                       JwtTokenProvider tokenProvider, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
    }

    public TokenDTO signIn(AccountCredentialsDTO credentialsDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentialsDTO.getUsername(),
                        credentialsDTO.getPassword()));
        var user = userRepository.findByUsername(credentialsDTO.getUsername());

    if (user == null)
        throw new UsernameNotFoundException("Username " + credentialsDTO.getUsername() + " was not found!");

    return tokenProvider.createAccessToken(
                credentialsDTO.getUsername(),
                user.getRoles());
    }

    public TokenDTO refreshToken(String username, String refreshToken) {
        var user = userRepository.findByUsername(username);
        TokenDTO token;
        if (user != null) token = tokenProvider.refreshToken(refreshToken);
        else throw new UsernameNotFoundException("Username " + username + " not found");
        return token;
    }

}
