package com.example.EDLB.controllers.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EDLB.mappers.security.RegisterRequestMapper;
import com.example.EDLB.models.security.AuthenticationRequest;
import com.example.EDLB.models.security.AuthenticationResponse;
import com.example.EDLB.models.security.RegisterRequest;
import com.example.EDLB.models.security.RegisterResponse;
import com.example.EDLB.services.security.AuthenticationService;
import com.example.EDLB.services.security.TokenService;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;
  private final TokenService tokenService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
    authenticationService.register(request);
    return ResponseEntity.ok("Enregistrement ok !");
  }
  
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
      return ResponseEntity.ok(authenticationService.authenticate(request));
  }
  
  @PostMapping("/refresh-token")
  public ResponseEntity<Map<String, String>> refreshToken(@RequestBody Map<String, String> request) {
      String refreshToken = request.get("refreshToken");
      String newAccessToken = tokenService.refreshAccessToken(refreshToken);

      Map<String, String> response = new HashMap<>();
      response.put("accessToken", newAccessToken);

      return ResponseEntity.ok(response);
  }
  

}
