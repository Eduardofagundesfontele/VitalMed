package com.developer.VitalMed.domain.model;

import com.developer.VitalMed.domain.enums.Especialidade;
import com.developer.VitalMed.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Setter
public class MedicoModel {

       @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;

        private String telefone;

        private String crm;

        @Enumerated(EnumType.STRING)
        private Especialidade especialidade;

        @Embedded
        private Endereco endereco;

        private Boolean ativo = true;

    }
