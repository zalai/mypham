package validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import form.UserForm;

@Component
public class UserFormValidation implements Validator{

	public boolean supports(Class<?> arg0) {

		return UserForm.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {
		UserForm userForm = (UserForm)target;

		if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {

			errors.rejectValue("confirmPassword", "Diff.userForm.confirmPassword");
		}

		if (userForm.getFramework() == null || userForm.getFramework().size() < 2) {

			errors.rejectValue("framework", "Valid.userForm.framework");
		}
		
	}

}
