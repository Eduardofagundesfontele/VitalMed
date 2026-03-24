package com.developer.VitalMed.infra.exception;

import java.time.LocalDateTime;

public record ErroResposta(LocalDateTime timeStamp,
                           int status,
                           String mensagem){

}
