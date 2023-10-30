package br.com.fiap.startup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Validação falhou.")
public class BadRequest extends RuntimeException {

    public BadRequest(String msg) {
        super(msg);
    }
}
