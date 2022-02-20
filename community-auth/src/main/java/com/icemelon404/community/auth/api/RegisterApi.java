package com.icemelon404.community.auth.api;

import com.icemelon404.community.auth.domain.register.RegisterService;
import com.icemelon404.community.auth.domain.dto.RegisterCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class RegisterApi {

    private final RegisterService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterCommand command) {
        service.registerUser(command);
        return ResponseEntity.ok().build();
    }
}
