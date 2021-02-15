package com.mifel.service.saldo.adapters.web;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MonedaValidator implements ConstraintValidator<ValidMoneda, String> {

  @Override
  public void initialize(ValidMoneda constraintAnnotation) {

  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.length() == 3
        && (value.equals("EUR") || value.equals("USD"));
  }
}
