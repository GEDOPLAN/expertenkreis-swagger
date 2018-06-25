package de.gedoplan.ek.swagger.resource.security;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@JWTAuthed
@Priority(Priorities.AUTHENTICATION)
public class JWTAuthedFilter implements ContainerRequestFilter {

    public JWTAuthedFilter() {
        System.out.println("Example Key: " + Jwts.builder()
                .claim("groups", "demo")
                .signWith(SignatureAlgorithm.HS512.HS512, "dummy")
                .compact());
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        try {
            valid(token);
        } catch (Exception e) {
            requestContext
                    .abortWith(Response.status(Response.Status.UNAUTHORIZED)
                            .build());
        }
    }

    public void valid(String token) {
        JwtParser signed = Jwts.parser().setSigningKey("dummy");

        String username = signed.parseClaimsJws(token).getBody().getSubject();
        System.out.println("Request is JWT-signed with user: " + username);
    }
}
