package com.projeto.supermercado_api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.projeto.supermercado_api.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;


    public String generateToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("supermercado-login-auth-api")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("Erro ao autenticar.");
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("supermercado-login-auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e){
            return null;
        }
    }

    private Instant generateExpirationDate(){
        return ZonedDateTime.now(ZoneOffset.of("-03:00"))
                .plusHours(2)
                .toInstant();
    }
}
