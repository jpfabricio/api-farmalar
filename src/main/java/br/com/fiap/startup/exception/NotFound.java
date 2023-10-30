package br.com.fiap.startup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entidade não encontrada")
public class NotFound extends RuntimeException {

    private static final long serialVersionUID = -7519721059536820612L;


    public NotFound(String msg) {
        super(msg);
    }
}
