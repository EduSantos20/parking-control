package com.api.parking_control.controller;

import com.api.parking_control.configs.security.TokenService;
import com.api.parking_control.dto.AuthenticationDto;
import com.api.parking_control.dto.LoginResponseDTO;
import com.api.parking_control.dto.RegistterDTO;
import com.api.parking_control.models.User;
import com.api.parking_control.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto authentication) {
        var usernamePassaword = new UsernamePasswordAuthenticationToken(authentication.login(), authentication.password());//juntando login e senha e formando um token
        var auth = this.authenticationManager.authenticate(usernamePassaword);//recebendo o token

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegistterDTO registterDTO) {
        if(this.userRepository.findByLogin(registterDTO.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registterDTO.password());
        User newUser = new User(registterDTO.login(), encryptedPassword, registterDTO.role());

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

}
