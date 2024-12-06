package com.poker.poker.controller;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import com.poker.poker.dto.UserResponse;
import com.poker.poker.dto.UserRequest;


@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @PostMapping("/login")
    public UserResponse login(@RequestBody UserRequest userRequest) {

        String generatedUuid = UUID.randomUUID().toString();

        return new UserResponse(generatedUuid);
    }
}
