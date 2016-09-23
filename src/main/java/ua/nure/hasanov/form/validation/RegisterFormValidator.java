package ua.nure.hasanov.form.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.nure.hasanov.form.RegisterForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFormValidator implements Validator {

    public static final Pattern EMAIL_REGEX = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
    public static final Pattern NAME_REGEX = Pattern.compile("^[a-zA-ZА-Яа-яіІїЇъЪ]{2,255}$");
    private static final Pattern PASSWORD_REGEX = Pattern.compile("^[a-zA-Z0-9]{6,255}$");

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterForm registerForm = (RegisterForm) target;
        String email = registerForm.getEmail();
        String password = registerForm.getPassword();
        String firstName = registerForm.getFirstName();
        String lastName = registerForm.getLastName();

        if (StringUtils.isBlank(firstName) || !validateField(firstName, NAME_REGEX)) {
            errors.rejectValue("firstName", "register.firstName.invalid");
        }

        if (StringUtils.isBlank(lastName) || !validateField(lastName, NAME_REGEX)) {
            errors.rejectValue("lastName", "register.lastName.invalid");
        }

        if (StringUtils.length(firstName) + StringUtils.length(lastName) > 255) {
            errors.rejectValue("lastName", "register.name.invalid");
            errors.rejectValue("firstName", "register.name.invalid");
        }

        if (StringUtils.isEmpty(email)) {
            errors.rejectValue("email", "register.email.invalid");
        } else if (StringUtils.length(email) > 255 || !validateField(email, EMAIL_REGEX)) {
            errors.rejectValue("email", "register.email.invalid");
        }

        if (StringUtils.isEmpty(password) || !validateField(password, PASSWORD_REGEX)) {
            errors.rejectValue("password", "register.password.invalid");
        }
    }

    private boolean validateField(final String value, final Pattern regex) {
        final Matcher matcher = regex.matcher(value);
        return matcher.matches();
    }
}
