package com.hubachov.form.validator;

import com.hubachov.form.bean.UserForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserFormValidator implements Validator {
	@Override
	public void validate(Object target, Errors errors) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}
}
