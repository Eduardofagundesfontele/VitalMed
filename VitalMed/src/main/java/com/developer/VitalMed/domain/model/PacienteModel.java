package com.developer.VitalMed.domain.model;

import com.developer.VitalMed.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "paciente")
@Entity(name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Setter
public class PacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String telefone;

    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;
}
