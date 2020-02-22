package org.bobo.silence.model.usermaster;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
public class EmailValidateSendModel {
	@NotBlank
	@Size(min = 1, max = 64)
	@Email
	private String email;
}
