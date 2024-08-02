package com.demo.apilogin.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtToPrincicalConverter {

    public UserPrincipal convert(DecodedJWT jwt) {
        return UserPrincipal.builder()
                .userId(Long.valueOf(jwt.getSubject()))
                .email(jwt.getClaim("e").asString())
                .Authorities(extractAuthoritiesFromClaim(jwt))
                .role(jwt.getClaim("a").asString())
                .build();
    }

    private List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT JWT) {
        var claim = JWT.getClaim("a");
        if(claim.isNull() || claim.isMissing()){
            return List.of();
        }
        return claim.asList(SimpleGrantedAuthority.class);

    }


}
