package com.developer.VitalMed.domain.dto.medico.response;

import com.developer.VitalMed.domain.enums.Especialidade;

public record MedicoListResponseDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {
}
