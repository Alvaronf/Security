package es.softtek.jwtDemo.models.dao;

import java.util.List;

import es.softtek.jwtDemo.models.entities.UsuarioEmpresa;
import es.softtek.jwtDemo.models.entities.UsuarioEmpresaPK;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEmpresaDAO extends CrudRepository<UsuarioEmpresa, UsuarioEmpresaPK> {

    public List<UsuarioEmpresa> findAll();

}