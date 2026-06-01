//package com.bank.service;
//
//import com.bank.UserEntity.User;
//import com.bank.dto.*;
//import com.bank.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    // REGISTER
//    public String register(RegisterRequest request) {
//
//        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
//            throw new RuntimeException("Email already exists");
//        }
//
//        User user = new User();
//        user.setName(request.getName());
//        user.setEmail(request.getEmail());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setRole(request.getRole());
//
//        userRepository.save(user);
//
//        return "User Registered Successfully";
//    }
//
//    // LOGIN
//    public AuthResponse login(LoginRequest request){
//
//        User user = userRepository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new RuntimeException("Invalid Email"));
//
//        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid Password");
//        }
//
//        return new AuthResponse(
//                "Login Successful",
//                user.getEmail(),
//                user.getRole().name()
//        );
//    }
//}