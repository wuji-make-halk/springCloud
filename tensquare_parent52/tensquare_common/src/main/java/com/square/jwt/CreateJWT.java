package com.square.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/21
 * Description:
 */
public class CreateJWT {
    public static void main(String[] args) {

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")
                .setSubject("小马")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "itcast")
                .setExpiration(new Date(new Date().getTime() + 3600000));
        System.out.println(jwtBuilder.compact());
    }
}
