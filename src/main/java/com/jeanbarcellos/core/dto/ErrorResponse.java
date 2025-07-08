package com.jeanbarcellos.core.dto;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;

/**
 * Response para Erro com lista de detalhes
 *
 * @author Jean Silva de Barcellos (www.jeanbarcellos.com.br)
 */
@Getter
public class ErrorResponse {

    @Schema(description = "Descrição do erro")
    private final String message;

    @Schema(description = "Lista de erros")
    @JsonInclude(Include.NON_NULL)
    private final List<String> errors;

    public ErrorResponse(String message) {
        this.message = message;
        this.errors = null;
    }

    public ErrorResponse(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public boolean hasErros() {
        return ObjectUtils.isNotEmpty(this.errors);
    }

    public static ErrorResponse of(String message) {
        return new ErrorResponse(message);
    }

    public static ErrorResponse of(String message, List<String> errors) {
        return new ErrorResponse(message, errors);
    }

}
