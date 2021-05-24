package com.example.mssqldemoback.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * <p>
 * jwt工具类
 * </p>
 *
 * @author vannmaureen
 * @since 2021/5/17 21:22:24
 */
public class JwtUtil {
    public static final String SIGN = "!(SDFjklwe2@#";

    /**
     * 获取token
     *
     * @param map payload的参数
     * @return token
     */
    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);

        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(instance.getTime())
                      .sign(Algorithm.HMAC256(SIGN));
    }

    /**
     * 验证token合法性并抛异常
     *
     * @param token 令牌
     * @return 解码后的token
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SIGN))
                  .build()
                  .verify(token);
    }
}
