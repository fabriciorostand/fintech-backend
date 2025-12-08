package br.com.fiap.fintech.dto.branch;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CreateBranchRequest {
    @NotNull(message = "{bankId.required}")
    private Long bankId;

    @NotBlank(message = "{number.required}")
    @Pattern(regexp = "\\d{4,5}", message = "{number.invalid}")
    private String number;
}