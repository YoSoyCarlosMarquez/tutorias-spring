package com.example.tutorias.repository;

import com.example.tutorias.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    List<UsuarioEntity> findByUsuario(String user);

    List<UsuarioEntity> findByEstado(String estado);
}
