package com.example.tutorias.service;

import com.example.tutorias.dto.UserDTO;
import com.example.tutorias.entity.UsuarioEntity;

import java.util.List;

public interface IUsuariosService {

    UsuarioEntity crear(UserDTO dto);
    List<UsuarioEntity> getAll();
    String login();
    String getByUsername();
    UsuarioEntity getById(Integer id);
    String getByStatus();
    UsuarioEntity update(UserDTO dto);

}
