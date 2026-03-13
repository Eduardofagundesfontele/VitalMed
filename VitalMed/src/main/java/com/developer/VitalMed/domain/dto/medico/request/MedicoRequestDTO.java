package com.developer.VitalMed.domain.dto.medico.request;

import com.developer.VitalMed.domain.enums.Especialidade;
import com.developer.VitalMed.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoRequestDTO(@NotBlank
                               String nome,
                               @NotBlank
                               @Email
                               String email,

                               @NotBlank
                               String telefone,
                               @NotBlank
                               @Pattern(regexp = "\\d{4,6}")
                               String crm,
                               @NotNull
                               Especialidade especialidade,

                               @NotNull @Valid DadosEndereco endereco) {
}
