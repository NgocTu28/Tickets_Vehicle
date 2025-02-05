package project.tickets_vehicle.tickets.controller;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.Config.JwtUtil;
import project.tickets_vehicle.tickets.Config.dto.AuthRequest;
import project.tickets_vehicle.tickets.Config.dto.AuthResponse;
import project.tickets_vehicle.tickets.model.user.User;
import project.tickets_vehicle.tickets.repository.User_Repository;
import project.tickets_vehicle.tickets.service.User_Service;

@RestController
@RequestMapping("/api/v1/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class Authentication_Controller {
    AuthenticationManager authenticationManager;
    User_Repository user_Repository;
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        String token = jwtUtil.generateToken(authRequest.getEmail());
        AuthResponse response = getInfoGuest(authRequest.getEmail());
        response.setJwt(token);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify-token")
    public ResponseEntity<?> verifyToken() {
      Optional<String> optional = JwtUtil.getCurrentUserLogin();
      if(!optional.isPresent()|| optional.get().equals("anonymousUser")) {
          return ResponseEntity.status(401).body("Invalid credentials");
      }
        AuthResponse response = getInfoGuest(optional.get());
        return ResponseEntity.ok(response);
    }

    public AuthResponse getInfoGuest(String email){
        AuthResponse response = new AuthResponse();
        User user = user_Repository.findByEmail(email);
        if(user.getRole().equals("USER")){
            response.setId(user.getId());
            response.setRole("USER");
            response.setTen(user.getUserName());
            response.setEmail(user.getEmail());
            response.setSdt(user.getPhoneNumber());
            response.setAvatar(user.getImage());
            response.setTrangThai(user.getUserStatus());
        } else {
            if(user.getRole().equals("ADMIN")){
                response.setRole("ADMIN");
            } else  if(user.getRole().equals("MANAGER")){
                response.setRole("MANAGER");
            }
            response.setId(user.getId());
            response.setTen(user.getUserName());
            response.setEmail(user.getEmail());
            response.setSdt(user.getPhoneNumber());
            response.setAvatar(user.getImage());
            response.setTrangThai(user.getUserStatus());
        }
        return response;
    }
}


