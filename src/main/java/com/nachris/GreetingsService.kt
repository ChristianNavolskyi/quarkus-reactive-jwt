package com.nachris

import javax.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.jwt.Claims
import org.eclipse.microprofile.jwt.JsonWebToken

@ApplicationScoped
class GreetingsService(private val jsonWebToken: JsonWebToken) {

    fun getPersonalisedGreeting(): String {
        val name = jsonWebToken.getClaim<String>(Claims.preferred_username)

        return "Hello $name"
    }
}