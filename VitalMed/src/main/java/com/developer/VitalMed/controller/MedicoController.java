package com.developer.VitalMed.controller;

import com.developer.VitalMed.domain.dto.medico.request.MedicoRequestDTO;
import com.developer.VitalMed.domain.dto.medico.request.MedicoUpdateDTO;
import com.developer.VitalMed.domain.dto.medico.response.MedicoListResponseDTO;
import com.developer.VitalMed.domain.dto.medico.response.MedicoResponseDTO;
import com.developer.VitalMed.domain.service.MedicoService;
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
@RequestMapping("medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> cadastrarMedico(@RequestBody @Valid MedicoRequestDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        MedicoResponseDTO medico = medicoService.cadastarMedico(dto);

        URI uri = uriComponentsBuilder
                .path("/medicos/{id}")
                .buildAndExpand(medico.id())
                .toUri();

        return ResponseEntity.created(uri).body(medico);
    }
    @GetMapping
    public ResponseEntity<Page<MedicoListResponseDTO>> getAllMedico(@PageableDefault(size = 10, sort = "nome") Pageable pageable){
        return ResponseEntity.ok(medicoService.listarMedicos(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO>buscarPorId(@PathVariable Long id){
        MedicoResponseDTO medico = medicoService.buscarMedicoPorId(id);
        return ResponseEntity.ok(medico);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> atualizarMedico(@RequestBody @Valid MedicoUpdateDTO dto,@PathVariable Long id){
        return ResponseEntity.ok(medicoService.atualizarMedico(id,dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id){
        medicoService.excluirMedico(id);
        return ResponseEntity.noContent().build();
    }






}
