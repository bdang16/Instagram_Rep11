package com.demo.apilogin.model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginReponse {

    private final String accessToken;


}
