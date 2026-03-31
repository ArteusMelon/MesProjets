// package com.example.EDLB.controllers.old;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.EDLB.DTO.authDTO.LoginResponse;
// import com.example.EDLB.DTO.authDTO.LoginUserDto;
// import com.example.EDLB.DTO.authDTO.RegisterUserDto;
// import com.example.EDLB.models.entities.User;
// import com.example.EDLB.services.old.AuthenticationService;
// import com.example.EDLB.services.old.JwtService;

// @RequestMapping("/auth")
// @RestController
// public class AuthenticationController {
//     private final JwtService jwtService;

//     private final AuthenticationService authenticationService;

//     public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
//         this.jwtService = jwtService;
//         this.authenticationService = authenticationService;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        
//         User registeredUser = authenticationService.registerUser(registerUserDto);
//         return ResponseEntity.ok(registeredUser);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
//         User authenticatedUser = authenticationService.authenticateUser(loginUserDto);

//         String jwtToken = jwtService.generateToken(authenticatedUser);

//         LoginResponse loginResponse = new LoginResponse(authenticatedUser.getUserId(), jwtToken, jwtService.getExpirationTime());

//         return ResponseEntity.ok(loginResponse);
//     }
// }
