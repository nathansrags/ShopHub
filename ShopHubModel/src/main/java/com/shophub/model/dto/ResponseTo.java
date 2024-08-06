package com.shophub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTo {

    private Object statusCode;
    private String message;
    private Object data;

    public ResponseTo(String message, Object statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }
}
