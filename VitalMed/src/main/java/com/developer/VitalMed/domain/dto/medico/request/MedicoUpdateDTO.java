package com.developer.VitalMed.domain.dto.medico.request;

import com.developer.VitalMed.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(@NotNull
                              Long id,
                              String nome,
                              String telefone,
                              DadosEndereco endereco) {
}
