package com.developer.VitalMed.domain.dto.medico.response;

import com.developer.VitalMed.domain.enums.Especialidade;
import com.developer.VitalMed.endereco.Endereco;

public record MedicoResponseDTO(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
}
