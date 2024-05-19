package com.example.tutorias.service.impl;

import com.example.tutorias.dto.UserDTO;
import com.example.tutorias.entity.UsuarioEntity;
import com.example.tutorias.exception.ResourceNotFoundException;
import com.example.tutorias.repository.UsuarioRepository;
import com.example.tutorias.service.IUsuariosService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity save(UserDTO dto) throws Exception {

        List<UsuarioEntity> users = getByUsername(dto.getUser());
        if (!users.isEmpty()) {
            throw new Exception("Ya existe el usuario " + dto.getUser());
        }

        UsuarioEntity usuario = (dto.getId() != null) ? getById(dto.getId()) : new UsuarioEntity();
        /*if (dto.getId() != null) {
            usuario = getById(dto.getId());
        } else {
            usuario = new UsuarioEntity();
        }*/
        //usuario.setId(usuario.getId() == null ? dto.getId() : usuario.getId());

        usuario.setUsuario(dto.getUser());
        usuario.setName(dto.getName());
        usuario.setLastname(dto.getLastname());
        usuario.setPassword(dto.getPassword());
        usuario.setEstado("A");

        usuario = usuarioRepository.save(usuario);

        return usuario;

        /*if (usuario.getId() != null) {
            return update(dto);
        } else {
            return crear(dto);
        }*/
    }

    @Override
    public UsuarioEntity crear(UserDTO dto) {
        UserDTO user = new UserDTO();
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsuario(dto.getUser());
        usuario.setName(dto.getName());
        usuario.setLastname(dto.getLastname());
        usuario.setPassword(dto.getPassword());
        usuario.setEstado("A");
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public List<UsuarioEntity> getAll(String estado) {
        return usuarioRepository.findByEstado(estado);
    }

    @Override
    public String login() {
        return "login";
    }

    @Override
    public List<UsuarioEntity> getByUsername(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    @Override
    public UsuarioEntity getById(Integer id) {
        Optional<UsuarioEntity> opt = usuarioRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        UsuarioEntity usuario = new UsuarioEntity();
        return usuario;
    }

    @Override
    public String getByStatus() {
        return "getByStatus";
    }

    @Override
    public UsuarioEntity update(UserDTO dto) throws ResourceNotFoundException {
        UsuarioEntity usuario = getById(dto.getId());
        if (usuario.getId() == null) {
            throw new ResourceNotFoundException("Usuario con el ID " + dto.getId() + " no existe");
        }

        usuario.setName(dto.getName());
        usuario.setLastname(dto.getLastname());
        usuario.setEstado("A");
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }

}
