package pacifico.mvm.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pacifico.mvm.constraints.Username.List;
import pacifico.mvm.constraints.validators.UsernameValidator;

/**
 * Validates an username.
 *
 * @author Matheus Pacifico
 */
@Documented
@Constraint(validatedBy = { UsernameValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Repeatable(List.class)
public @interface Username {

	String message() default "invalid username";
	
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
    
    /**
     * Defines whether to check if the username is a reserved word.
     */
    boolean checkReservedWord() default false;

	/**
	 * Defines several {@code @Username} constraints on the same element.
	 */    
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		Username[] value();
	}
}
