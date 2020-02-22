package org.bobo.silence.model.usermaster;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
public class RegisterModel {
	@NotBlank
	@Size(min = 1, max = 32)
	private String nickName;

	@NotBlank
	@Size(min = 1, max = 64)
	@Email
	private String email;

	@NotBlank
	@Size(min = 8, max = 32)
	private String password;

	@NotBlank
	private String validateId;
}
