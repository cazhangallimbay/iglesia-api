package com.andreszhangallimbay.iglesiaapi.Security.filter

import com.andreszhangallimbay.iglesiaapi.Security.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtFilterRequest: OncePerRequestFilter(){
    @Autowired
    lateinit var jwtUtil: JWTUtil

    @Autowired
    lateinit var userDetailsService: UserDetailsService

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val authorizationHeader:String? = request.getHeader("Authorization")
        authorizationHeader?.let {aut ->
            aut.startsWith("Bearer").let {
                val jwt: String = aut.substring(7)
                val username: String = jwtUtil.extractUsername(jwt)
                SecurityContextHolder.getContext().authentication ?: run {
                    val userDetails: UserDetails = userDetailsService.loadUserByUsername(username)
                    jwtUtil.validateToken(jwt, userDetails).let {
                        val authToken: UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                        authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                        SecurityContextHolder.getContext().authentication = authToken
                    }

                }
            }
        }

        filterChain.doFilter(request,response)
    }

}
