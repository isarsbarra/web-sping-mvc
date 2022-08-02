package br.com.letscode.controller;

import br.com.letscode.exception.BadRequestException;
import br.com.letscode.model.Erro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler{

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex){
        Erro erro = new Erro();
        erro.setMensagem(ex.getMensagem());
        erro.setCampo(ex.getCampo());
        return ResponseEntity.badRequest().body(erro);
    }

}
