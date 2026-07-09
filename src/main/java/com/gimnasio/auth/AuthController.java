package com.gimnasio.auth;

import com.gimnasio.model.Usuario;
import com.gimnasio.security.JwtService;
import com.gimnasio.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getPassword())
            );

            UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
            Usuario usuario = principal.getUsuario();

            String token = jwtService.generarToken(principal);
            String nombreRol = usuario.getRol() != null ? usuario.getRol().getNombre() : null;

            LoginResponse response = new LoginResponse(
                    token,
                    usuario.getCorreo(),
                    usuario.getNombres() + " " + usuario.getApellidos(),
                    nombreRol
            );

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Correo o contraseña incorrectos");
        }
    }
}