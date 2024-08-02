package com.igrep11.BE.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> {
    private boolean status;
    private String message;
    private String responseCode;
    private T data;

}
