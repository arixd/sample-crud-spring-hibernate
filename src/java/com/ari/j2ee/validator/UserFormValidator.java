/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.j2ee.validator;

import com.ari.j2ee.entitas.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Ari
 */
@Component
public class UserFormValidator implements Validator
{
//    Adalah anotasi yang digunakan bersama dengan AutorWire yang digunakan sebagai discrimantor.

    @Autowired
    @Qualifier("emailValidator")
    EmailValidator EmailValidator;

    @Override
    public boolean supports(Class<?> clasz)
    {
        return Users.class.equals(clasz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Users users = (Users) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.userForm.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.userForm.confirmPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.userForm.sex");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.userForm.country");

        if (!EmailValidator.valid(users.getEmail()))
        {
            errors.rejectValue("email", "Pattern.userForm.email");
        }

        if (users.getNumber() == null || users.getNumber() <= 0)
        {
            errors.rejectValue("number", "NotEmpty.userForm.number");
        }

        if (users.getCountry().equalsIgnoreCase("none"))
        {
            errors.rejectValue("country", "NotEmpty.userForm.country");
        }

//        if (!users.getPassword().equals(users.getConfirmPassword()))
//        {
//            errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
//        }
//
//        if (users.getFramework() == null || users.getFramework().size() < 2)
//        {
//            errors.rejectValue("framework", "Valid.userForm.framework");
//        }

//        if (users.getSkill() == null || users.getSkill().size() < 3)
//        {
//            errors.rejectValue("skill", "Valid.userForm.skill");
//        }
    }

}
