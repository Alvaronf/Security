package es.softtek.jwtDemo.models.dao;

import java.util.List;

import es.softtek.jwtDemo.models.entities.Coche;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheDAO extends CrudRepository<Coche, Integer> {

    public List<Coche> findAll();
}