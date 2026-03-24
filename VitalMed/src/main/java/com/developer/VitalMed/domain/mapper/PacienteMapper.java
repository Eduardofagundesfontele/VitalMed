package com.developer.VitalMed.domain.mapper;

import com.developer.VitalMed.domain.dto.medico.response.MedicoListResponseDTO;
import com.developer.VitalMed.domain.dto.paciente.request.PacienteRequestDTO;
import com.developer.VitalMed.domain.dto.paciente.request.PacienteUpdateDTO;
import com.developer.VitalMed.domain.dto.paciente.response.PacienteListResponseDTO;
import com.developer.VitalMed.domain.dto.paciente.response.PacienteResponseDTO;
import com.developer.VitalMed.domain.model.MedicoModel;
import com.developer.VitalMed.domain.model.PacienteModel;
import com.developer.VitalMed.endereco.DadosEndereco;
import com.developer.VitalMed.endereco.Endereco;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    // DTO -> Entity
    PacienteModel toEntity(PacienteRequestDTO dto);
    // Entity -> DTO (detalhado)
    PacienteResponseDTO toResponseDTO(PacienteModel entity);

    // Entity -> DTO (listagem)
    PacienteListResponseDTO toListDto(PacienteModel paciente);
    // Atualizar dados existentes
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(PacienteUpdateDTO dto, @MappingTarget PacienteModel paciente);

    Endereco toEndereco(DadosEndereco endereco);
}
