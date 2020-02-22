package org.bobo.silence.common.handler;

import java.util.List;
import java.util.function.Consumer;

import org.bobo.silence.common.result.ResultStatus;
import org.bobo.silence.constant.SystemConstant;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class BindErrorHandler {

	public static void handle(ResultStatus status, BindingResult bind) {
		if (bind.hasFieldErrors()) {
			List<FieldError> errors = bind.getFieldErrors();
			errors.forEach(new Consumer<FieldError>() {

				@Override
				public void accept(FieldError error) {
					String message = status.getMessage();
					String newMessage = error.getField() + ":" + error.getDefaultMessage();
					if (StringUtils.isEmpty(message)) {
						status.setMessage(newMessage);
					} else {
						status.setMessage(message + ";" + newMessage);
					}
				}
			});
			status.setCode(SystemConstant.FIELD_ERROR);
		}
	}
}
