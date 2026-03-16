package com.developer.VitalMed.domain.service;

import com.developer.VitalMed.domain.dto.medico.request.MedicoRequestDTO;
import com.developer.VitalMed.domain.dto.medico.request.MedicoUpdateDTO;
import com.developer.VitalMed.domain.dto.medico.response.MedicoListResponseDTO;
import com.developer.VitalMed.domain.dto.medico.response.MedicoResponseDTO;
import com.developer.VitalMed.domain.mapper.MedicoMapper;
import com.developer.VitalMed.domain.model.MedicoModel;
import com.developer.VitalMed.domain.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoMapper mapper;
    private final MedicoRepository repository;

public MedicoResponseDTO cadastarMedico(MedicoRequestDTO dto){
    MedicoModel medico = mapper.toEntity(dto);
    repository.save(medico);
    return mapper.toResponseDTO(medico);
}

public Page<MedicoListResponseDTO> listarMedicos(Pageable pageable){

    return repository
            .findAllByAtivoTrue(pageable)
            .map(mapper::toListDto);
}

public MedicoResponseDTO buscarMedicoPorId(Long id){

    MedicoModel medico = repository.getReferenceById(id);
    return mapper.toResponseDTO(medico);
}

public MedicoResponseDTO atualizarMedico(Long id ,MedicoUpdateDTO dto){
    MedicoModel medico = repository.getReferenceById(id);
    mapper.updateEntityFromDto(dto,medico);
    return mapper.toResponseDTO(medico);
}

public void excluirMedico(Long id){
    MedicoModel medico = repository.getReferenceById(id);

    medico.setAtivo(false);
}


}
