package com.developer.VitalMed.domain.mapper;

import com.developer.VitalMed.domain.dto.medico.response.MedicoListResponseDTO;
import com.developer.VitalMed.domain.dto.paciente.request.PacienteRequestDTO;
import com.developer.VitalMed.domain.dto.paciente.request.PacienteUpdateDTO;
import com.developer.VitalMed.domain.dto.paciente.response.PacienteListResponseDTO;
import com.developer.VitalMed.domain.dto.paciente.response.PacienteResponseDTO;
import com.developer.VitalMed.domain.model.MedicoModel;
import com.developer.VitalMed.domain.model.PacienteModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    PacienteModel toEntity(PacienteRequestDTO dto);

    PacienteResponseDTO toResponseDTO(PacienteModel entity);

    //Dto para listagem
    PacienteListResponseDTO toListDto(PacienteModel paciente);

    void updateEntityFromDto(PacienteUpdateDTO dto, @MappingTarget PacienteModel paciente);
}
