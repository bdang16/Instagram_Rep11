package com.demo.apilogin.controller;


import com.demo.apilogin.security.UserPrincipal;
import com.demo.apilogin.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {



//    @GetMapping("/test/secured")
//    public String secured(@AuthenticationPrincipal UserPrincipal userPrincipal) {
//        BaseRespone.BaseResponse b;
//       try {
//            return ResponseEntity.ok().body(new BaseRespone<>(true, "login", userPrincipal);
//       } catch(Exception) {
//            return
//       }
//
//
//    }

    @GetMapping("/test/secured")
    public ResponseEntity<BaseResponse<UserPrincipal>> secured(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        try {
            BaseResponse<UserPrincipal> baseResponse = new BaseResponse<>(true, "Successfully", "200 OK", userPrincipal);
            return ResponseEntity.ok().body(baseResponse);
        } catch (Exception e) {
            BaseResponse<UserPrincipal> baseResponse = new BaseResponse<>(false, "Access Denied", "403 Forbidden", null);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(baseResponse);
        }
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }



}
