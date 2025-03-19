package com.projeto.supermercado_api.controller.mappers;

import com.projeto.supermercado_api.controller.dto.UsuarioDTO;
import com.projeto.supermercado_api.model.Usuario;

public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);

}
