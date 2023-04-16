package com.thecatlong.back.application;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class ValidationUtils {
    
    public static void validateNotNull(Object o, String mensaje){
        if (o == null) 
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, mensaje); 
    }
}
