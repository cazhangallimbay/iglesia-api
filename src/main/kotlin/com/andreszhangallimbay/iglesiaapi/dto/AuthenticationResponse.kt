package com.andreszhangallimbay.iglesiaapi.dto

class AuthenticationResponse(jwt: String) {
    var username: String? = null
    var password: String? = null
}