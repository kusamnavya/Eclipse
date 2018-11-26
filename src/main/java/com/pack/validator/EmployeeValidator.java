package com.pack.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pack.model.Employee;

public class EmployeeValidator implements Validator
{
 
    public boolean supports(Class clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors)
    {
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.firstName", "Username is required.");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.lastName", "Password is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password");
 
    }
 
}
 