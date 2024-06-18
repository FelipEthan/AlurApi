package com.aluracuros.forohub.security;
import com.aluracuros.forohub.modelos.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class ServiceToken {

    @Value("${api.security.secret}")
    private String apiSecrect;
    
    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecrect);
            return JWT.create()
                .withIssuer("foro hub")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(generarFechaExpiracion())
                .sign(algorithm);
      } catch (JWTCreationException exception){
          throw new RuntimeException();
      }
    }
    
    public String getSubject(String token){
        //Decifra el token
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecrect);  // Valida la firma
            verifier = JWT.require(algorithm)
                // specify any specific claim validations
                .withIssuer("foro hub")
                .build()
                .verify(token);
            verifier.getSubject();
            System.out.println(verifier.getSubject());
        } catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }
        if(verifier.getSubject()== null){
            throw new RuntimeException("Verifier Invalido");
        }
        return verifier.getSubject();
    }
    
    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
    
    
}
