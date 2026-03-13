package com.developer.VitalMed.domain.dto.paciente.response;

public record PacienteListResponseDTO(
        Long id,
        String nome,
        String email,
        String cpf) {
}
