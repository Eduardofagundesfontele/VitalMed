package com.developer.VitalMed.controller;

import com.developer.VitalMed.domain.dto.paciente.request.PacienteRequestDTO;
import com.developer.VitalMed.domain.dto.paciente.request.PacienteUpdateDTO;
import com.developer.VitalMed.domain.dto.paciente.response.PacienteListResponseDTO;
import com.developer.VitalMed.domain.dto.paciente.response.PacienteResponseDTO;
import com.developer.VitalMed.domain.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> cadastrarPaciente(@RequestBody @Valid PacienteRequestDTO dto, UriComponentsBuilder uriComponentsBuilder){

        PacienteResponseDTO paciente = pacienteService.cadastrarPaciente(dto);

        URI uri = uriComponentsBuilder
                .path("/pacientes/{id}")
                .buildAndExpand(paciente.id())
                .toUri();

        return ResponseEntity.created(uri).body(paciente);

    }
    @GetMapping
    public ResponseEntity<Page<PacienteListResponseDTO>> listarPacientes(@PageableDefault(size = 10, sort = "nome") Pageable pageable){
        return ResponseEntity.ok(pacienteService.listarPaciente(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPacientePorId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPacientePorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente(@PathVariable Long id,@Valid @RequestBody PacienteUpdateDTO dto){
        return ResponseEntity.ok(pacienteService.atualizarPaciente(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id){
        pacienteService.excluirPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
