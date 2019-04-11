package es.softtek.jwtDemo.models.services;

import java.util.List;
import java.util.Optional;

import es.softtek.jwtDemo.models.dao.UsuarioEmpresaDAO;
import es.softtek.jwtDemo.models.entities.UsuarioEmpresa;
import es.softtek.jwtDemo.models.entities.UsuarioEmpresaPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEmpresaService {

     @Autowired 
    private UsuarioEmpresaDAO usuarioDAO;

    public UsuarioEmpresa save(UsuarioEmpresa usuario) {
        return usuarioDAO.save(usuario);
    }

    public UsuarioEmpresa update(UsuarioEmpresa usuario) {
        return usuarioDAO.save(usuario);
    }

    public void delete(UsuarioEmpresa usuario) {
        usuarioDAO.delete(usuario);
    }

    public Optional<UsuarioEmpresa> findById(UsuarioEmpresaPK id) {
        return usuarioDAO.findById(id);
    }

    public List<UsuarioEmpresa> findAll(){
        return usuarioDAO.findAll(); 
    }


}