package com.developer.VitalMed.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    @NotBlank(message = "Bairro é obrigatório")
    private String bairro;

    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "\\d{8}", message = "CEP deve conter 8 números")
    private String cep;
    @NotBlank(message = "UF é obrigatório")
    private String numero;
    private String complemento;
    @NotBlank(message = "Cidade é obrigatória")
    private String cidade;
    @NotBlank(message = "UF é obrigatório")
    private String uf;
}
