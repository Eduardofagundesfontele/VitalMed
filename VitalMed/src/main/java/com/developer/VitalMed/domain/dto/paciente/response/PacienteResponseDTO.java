package com.developer.VitalMed.domain.dto.paciente.response;

import com.developer.VitalMed.endereco.Endereco;

public record PacienteResponseDTO(Long id,
                                  String nome,
                                  String email,
                                  String cpf,
                                  String telefone,
                                  Endereco endereco)  {
}
