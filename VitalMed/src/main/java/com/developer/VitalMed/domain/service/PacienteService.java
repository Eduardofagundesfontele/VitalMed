package com.developer.VitalMed.domain.service;

import com.developer.VitalMed.domain.dto.paciente.request.PacienteRequestDTO;
import com.developer.VitalMed.domain.dto.paciente.request.PacienteUpdateDTO;
import com.developer.VitalMed.domain.dto.paciente.response.PacienteListResponseDTO;
import com.developer.VitalMed.domain.dto.paciente.response.PacienteResponseDTO;
import com.developer.VitalMed.domain.mapper.PacienteMapper;
import com.developer.VitalMed.domain.model.MedicoModel;
import com.developer.VitalMed.domain.model.PacienteModel;
import com.developer.VitalMed.domain.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteMapper mapper;
    private final PacienteRepository repository;

    public PacienteResponseDTO cadastrarPaciente(PacienteRequestDTO dto){
        PacienteModel paciente = mapper.toEntity(dto);

        System.out.println(paciente.getCpf());
        System.out.println(paciente.getEndereco());

        repository.save(paciente);

        return mapper.toResponseDTO(paciente);
    }

    public Page<PacienteListResponseDTO> listarPaciente(Pageable pageable){
        return repository.findAllByAtivoTrue(pageable)
                .map(mapper::toListDto);
    }

    public PacienteResponseDTO buscarPacientePorId(Long id){
        PacienteModel paciente = repository.findById(id)
                .orElseThrow(()->new jakarta.persistence.EntityNotFoundException());

        return mapper.toResponseDTO(paciente);

    }
    @Transactional
    public PacienteResponseDTO atualizarPaciente(Long id,PacienteUpdateDTO dto){
        PacienteModel paciente = repository.findById(id)
                        .orElseThrow(()-> new jakarta.persistence.EntityNotFoundException());
        mapper.updateEntityFromDto(dto,paciente);
        return mapper.toResponseDTO(paciente);
    }
    @Transactional
    public void excluirPaciente(Long id ){
        PacienteModel paciente = repository.findById(id)
                        .orElseThrow(()-> new jakarta.persistence.EntityNotFoundException());
        paciente.setAtivo(false);

        
    }



}
