package com.rose.bandle_portfolio.admin;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class AdminKeyValidator {
    @Value("${admin.api.key}")
    private String adminKey;

    public void validate(String key){
        if(adminKey.equals(key)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not authorized");
        }
    }
}
