package top.aprdec.recruitweb.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JWTutil {
    private static final String SECRET = "Aprdec";

    public static String createToken(Map<String, Object> claims){
        return JWT.create()
                .withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24*7))
                .sign(Algorithm.HMAC512(SECRET));
    }
    public static Map<String, Object> parse(String token){

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(SECRET)).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        return decodedJWT.getClaim("claims").asMap();

    }

}
