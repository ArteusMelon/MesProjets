// package com.example.EDLB.config.old;

// import java.io.IOException;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;

// import com.example.EDLB.services.old.JwtService;

// import jakarta.servlet.Filter;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class JwtAuthenticationFilter implements Filter {

//     private final JwtService jwtService;
//     private final UserDetailsService userDetailsService;

//     // Constructeur
    
//     public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
//         this.jwtService = jwtService;
//         this.userDetailsService = userDetailsService;
//     }

//     @Override
//     public void doFilter(
//             jakarta.servlet.ServletRequest request,
//             jakarta.servlet.ServletResponse response,
//             FilterChain chain
//     ) throws IOException, ServletException {
        
//         // Convertir en HttpServletRequest et HttpServletResponse
//         HttpServletRequest httpRequest = (HttpServletRequest) request;
//         HttpServletResponse httpResponse = (HttpServletResponse) response;
        
//         // Extraction du header "Authorization"
//         final String authHeader = httpRequest.getHeader("Authorization");

//         if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//             chain.doFilter(request, response);  // Passe au filtre suivant
//             return;
//         }

//         try {
//             // Extraction du token JWT du header Authorization
//             final String jwt = authHeader.substring(7);
//             final String userEmail = jwtService.extractUsername(jwt);

//             // Si l'email de l'utilisateur est non nul et pas encore authentifié
//             if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                 UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);

//                 // Si le token JWT est valide
//                 if (jwtService.isTokenValid(jwt, userDetails)) {
//                     UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                             userDetails, null, userDetails.getAuthorities());

//                     // Ajouter les détails à l'authentification
//                     authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));

//                     // Enregistrer l'authentification dans le SecurityContext
//                     SecurityContextHolder.getContext().setAuthentication(authToken);
//                 }
//             }

//             // Passer au filtre suivant
//             chain.doFilter(request, response);

//         } catch (Exception exception) {
//             // Gérer les exceptions (par exemple, un mauvais token)
//             exception.printStackTrace();
//             httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
//         }
//     }
// }
