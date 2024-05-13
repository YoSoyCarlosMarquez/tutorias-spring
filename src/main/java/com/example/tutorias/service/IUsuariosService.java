package com.example.tutorias.service;

import com.example.tutorias.dto.UserDTO;
import com.example.tutorias.entity.UsuarioEntity;

import java.util.List;

public interface IUsuariosService {

    UsuarioEntity save(UserDTO dto) throws Exception;
    UsuarioEntity crear(UserDTO dto);
    List<UsuarioEntity> getAll(String estado);
    String login();
    List<UsuarioEntity> getByUsername(String usuario);
    UsuarioEntity getById(Integer id);
    String getByStatus();
    UsuarioEntity update(UserDTO dto) throws Exception;

}
