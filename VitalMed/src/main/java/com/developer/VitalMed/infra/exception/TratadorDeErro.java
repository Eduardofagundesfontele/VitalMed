package com.developer.VitalMed.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class TratadorDeErro {

    //erro404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroResposta> tratarErro404(EntityNotFoundException ex){
        ErroResposta erro = new ErroResposta(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso Não Encontrado"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    //erro400
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex){
           List<DadosErroValidacao> erros = ex.getFieldErrors()
                   .stream()
                   .map(DadosErroValidacao::new)
                   .toList();
           return ResponseEntity.badRequest().body(erros);
        }
    }

