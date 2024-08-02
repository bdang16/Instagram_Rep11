package com.demo.apilogin.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> {
    private boolean status;
    private String message;
    private String responseCode;
    private T data;

}
