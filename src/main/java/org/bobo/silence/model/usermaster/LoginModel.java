package org.bobo.silence.model.usermaster;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
public class LoginModel {
	@NotBlank
	@Size(min = 1, max = 64)
	private String email;

	@NotBlank
	@Size(min = 8, max = 32)
	private String password;

}
