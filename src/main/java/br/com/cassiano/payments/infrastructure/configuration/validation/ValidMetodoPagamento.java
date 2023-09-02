package br.com.cassiano.payments.infrastructure.configuration.validation;

import br.com.cassiano.payments.infrastructure.configuration.validation.MetodoPagamentoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = MetodoPagamentoValidator.class)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMetodoPagamento {
    String message() default "Método de pagamento inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
