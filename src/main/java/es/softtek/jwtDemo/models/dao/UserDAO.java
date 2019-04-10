package es.softtek.jwtDemo.models.dao;

import java.util.List;

import es.softtek.jwtDemo.models.entities.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

    public List<User> findAll();
}
