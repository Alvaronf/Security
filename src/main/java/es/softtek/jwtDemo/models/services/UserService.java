package es.softtek.jwtDemo.models.services;

import java.util.List;
import java.util.Optional;

import es.softtek.jwtDemo.models.dao.UserDAO;
import es.softtek.jwtDemo.models.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

     @Autowired 
    private UserDAO usuarioDAO;

    public User save(User usuario) {
        return usuarioDAO.save(usuario);
    }

    public User update(User usuario) {
        return usuarioDAO.save(usuario);
    }

    public void delete(User usuario) {
        usuarioDAO.delete(usuario);
    }

    public Optional<User> findById(int id) {
        return usuarioDAO.findById(id);
    }

    public List<User> findAll(){
        return usuarioDAO.findAll(); 
    }

}