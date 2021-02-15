package com.mifel.service.saldo.adapters.web;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import org.springframework.stereotype.Component;

@Target({ElementType.FIELD})
@Constraint(validatedBy = MonedaValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ValidMoneda {

  String message() default "La moneda no es válida";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

}
