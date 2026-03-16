package com.developer.VitalMed.domain.mapper;

import com.developer.VitalMed.domain.dto.medico.request.MedicoRequestDTO;
import com.developer.VitalMed.domain.dto.medico.request.MedicoUpdateDTO;
import com.developer.VitalMed.domain.dto.medico.response.MedicoListResponseDTO;
import com.developer.VitalMed.domain.dto.medico.response.MedicoResponseDTO;
import com.developer.VitalMed.domain.model.MedicoModel;
import com.developer.VitalMed.domain.model.PacienteModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    MedicoModel toEntity(MedicoRequestDTO dto);

    MedicoResponseDTO toResponseDTO(MedicoModel medico);

    //Dto para listagem
    MedicoListResponseDTO toListDto(MedicoModel medico);

    // Atualiza a entidade Paciente a partir de PacienteUpdateRequest
    void updateEntityFromDto(MedicoUpdateDTO dto, @MappingTarget MedicoModel medico);
}



