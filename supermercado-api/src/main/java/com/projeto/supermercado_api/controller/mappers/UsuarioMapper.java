package com.projeto.supermercado_api.controller.mappers;

import com.projeto.supermercado_api.controller.dto.UsuarioDTO;
import com.projeto.supermercado_api.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "senha", target = "senha")
    Usuario toEntity(UsuarioDTO dto);

    UsuarioDTO toDTO(Usuario usuario);

}
