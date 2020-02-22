package org.bobo.silence.model.usermaster;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
public class CheckValidateModel {
	@NotBlank
	private String code;

}
