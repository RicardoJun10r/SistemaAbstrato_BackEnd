package com.group05.abstractbusiness.exception;

import com.group05.abstractbusiness.exception.details.ExceptionDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ValidationException extends ExceptionDetails{
    private final String fields;
    private final String fieldsMessage;
}
