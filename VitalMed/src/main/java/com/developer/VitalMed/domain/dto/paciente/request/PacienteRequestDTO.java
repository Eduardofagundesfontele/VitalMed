package com.developer.VitalMed.domain.dto.paciente.request;

import com.developer.VitalMed.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteRequestDTO(  @NotBlank(message = "Nome é obrigatório")
                                   String nome,
                                   @NotBlank(message = "Email é obrigatório")
                                   @Email(message = "Email inválido")
                                   String email,
                                   @NotBlank(message = "Telefone é obrigatório")
                                   String telefone,
                                   @NotBlank(message = "CPF é obrigatório")
                                   @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}",
                                           message = "CPF deve estar no formato 000.000.000-00")
                                   String cpf,
                                   @NotNull(message = "Endereço é obrigatório")
                                   @Valid
                                   DadosEndereco endereco) {
}
