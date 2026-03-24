package com.developer.VitalMed.domain.dto.paciente.request;

import com.developer.VitalMed.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record PacienteUpdateDTO(
                                String nome,
                                String telefone,
                                DadosEndereco endereco) {
}
