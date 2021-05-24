package com.example.mssqldemoback;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class MssqlDemoBackApplicationTests {
    private final String alg = "ajdsklifa!@#$%1";
    private String sign;

    @Test
    void contextLoads() {
    }

    @Test
    public void getToken() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 100);

        this.sign = JWT.create()
                       .withClaim("userId", 12)
                       .withClaim("username", "xiaoming")
                       .withExpiresAt(instance.getTime())
                       .sign(Algorithm.HMAC256(alg));
        System.out.println(sign);
        verifyToken();
    }

    @Test
    public void verifyToken() {
        JWTVerifier build = JWT.require(Algorithm.HMAC256(alg))
                               .build();
        DecodedJWT verify = build.verify(sign);
        System.out.println(verify.getClaim("userId")
                                 .toString());
        System.out.println(verify.getClaim("username")
                                 .asString());
    }
}
