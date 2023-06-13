package com.group05.abstractbusiness.error.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ResourceForbidden extends RuntimeException {
    
    public ResourceForbidden(String msg){
        super(msg);
    }

}
