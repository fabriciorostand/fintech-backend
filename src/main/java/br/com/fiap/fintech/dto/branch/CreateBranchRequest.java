package br.com.fiap.fintech.dto.branch;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CreateBranchRequest {
    @NotNull
    private Long bankId;

    @Pattern(regexp = "\\d{4,5}") @NotBlank
    private String number;
}