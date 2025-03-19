package com.projeto.supermercado_api.controller.dto;

import com.projeto.supermercado_api.model.TipoCargo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Usuario")
public record UsuarioDTO(
        @NotBlank(message = "campo obrigatório")
        String nome,
        @Email(message = "inválido")
        @NotBlank(message = "campo obrigatório")
        String email,
        @NotBlank(message = "campo obrigatório")
        String senha,
        @NotNull(message = "campo obrigatório")
        TipoCargo cargo
) {
}
