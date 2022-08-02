package br.com.letscode.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class BadRequestException extends RuntimeException{

    private String campo;
    private String mensagem;
    public BadRequestException(String campo, String mensagem) {
        //super(campo.concat(" ").concat(mensagem));
        this.campo = campo;
        this.mensagem = mensagem;
    }
}
