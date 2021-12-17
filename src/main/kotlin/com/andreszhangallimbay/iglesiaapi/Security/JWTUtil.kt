package com.andreszhangallimbay.iglesiaapi.Security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.SignatureAlgorithm.*
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil {

    fun generateToken   (userDetails: UserDetails): String{
        //Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody()
        return Jwts.builder().setSubject(userDetails.username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis()+1000*60*60*10))
            .signWith(HS256,"admin")
            .compact()
    }
    fun validateToken(token:String, userDetails: UserDetails):Boolean{
        return userDetails.username.equals(extractUsername(token)) && !isTokenExpired(token)
    }
    fun extractUsername(token:String):String{
        return getClaims(token).subject
    }

    fun isTokenExpired(token:String):Boolean{
        return getClaims(token).expiration.before(Date())
    }

    fun getClaims(token:String): Claims {
        return Jwts.parser().setSigningKey("admin").parseClaimsJws(token).body;

    }
}
