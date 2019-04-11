package es.softtek.jwtDemo.models.dao;

import java.util.List;

import es.softtek.jwtDemo.models.entities.Empresa;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaDAO extends CrudRepository<Empresa, Integer> {

    public List<Empresa> findAll();
}