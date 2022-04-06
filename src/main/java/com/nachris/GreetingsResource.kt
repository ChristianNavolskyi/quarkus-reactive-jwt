package com.nachris

import io.quarkus.security.Authenticated
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("")
class GreetingsResource(private val greetingsService: GreetingsService) {

    @GET
    @Path("/reactive")
    @Authenticated
    @Produces(MediaType.TEXT_PLAIN)
    suspend fun reactiveHello(): String {
        return greetingsService.getPersonalisedGreeting()
    }

    @GET
    @Authenticated
    @Path("/imperative")
    @Produces(MediaType.TEXT_PLAIN)
    fun imperativeHello(): String {
        return greetingsService.getPersonalisedGreeting()
    }
}