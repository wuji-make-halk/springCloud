package com.square.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/21
 * Description:
 */
public class PraseJwt {
    public static void main(String[] args) {
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NjYzOTQwMjR9.juUodXGgpwmmN6R-hnCSVhAGrakzH-YHpEaMmnCeKic")
                .getBody();
        System.out.println("用户Id:" + claims.getId() + "\n" + "登陆时间:" + new SimpleDateFormat("yyyy-MM-dd").format(claims.getIssuedAt()) + "\n" + "用户名:" + claims.getSubject());
    }
}
