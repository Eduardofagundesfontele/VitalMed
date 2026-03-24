package com.developer.VitalMed.domain.dto.medico.request;

import com.developer.VitalMed.domain.enums.Especialidade;
import com.developer.VitalMed.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoRequestDTO(@NotBlank(message = "Email é obrigatório")
                               @Email(message = "Email inválido")
                               String email,
                               @NotBlank(message = "Telefone é obrigatório")
                               String telefone,
                               @NotBlank(message = "CRM é obrigatório")
                               @Pattern(regexp = "\\d{4,6}", message = "CRM deve ter entre 4 e 6 números")
                               String crm,
                               @NotNull(message = "Especialidade é obrigatória")
                               Especialidade especialidade,
                               @NotNull(message = "Endereço é obrigatório")
                               @Valid
                               DadosEndereco endereco) {
}
