package br.com.fiap.startup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Entidade não encontrada")
public class NotContent extends RuntimeException {

    public NotContent(String msg) {
        super(msg);
    }
}
