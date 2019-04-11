package es.softtek.jwtDemo.controller;

import java.sql.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import es.softtek.jwtDemo.models.entities.Coche;
import es.softtek.jwtDemo.models.entities.Empresa;
import es.softtek.jwtDemo.models.entities.UsuarioEmpresa;
import es.softtek.jwtDemo.models.services.CocheService;
import es.softtek.jwtDemo.models.services.EmpresaService;
import es.softtek.jwtDemo.models.services.UsuarioEmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;


    @Autowired
    private UsuarioEmpresaService ueService;

    @Autowired
    private CocheService cService;
    
    @GetMapping("/crear")
    public Empresa save(@PathParam("nombre") String nombre) {
        Empresa user = null;
        try {
            user = new Empresa();
            user.setNombreEmpresa(nombre);
            Date dateobj = new Date(System.currentTimeMillis());
            user.setCreated_at(dateobj);
            user.setUpdated_at(dateobj);

            empresaService.save(user);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return user;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/mostrar")    
    public List<Empresa> mostrar() {
        // ModelAndView mav = new ModelAndView("/mostrar");
        List<Empresa> usuarios = empresaService.findAll();
        String b = "";
        for (Empresa a : usuarios) {
            b += "\n Nombre :" + a.getNombreEmpresa() + "\t ID: " + a.getId();
        }

        return usuarios;
    }

    @GetMapping("/{id}")
    public Empresa mostraruna(@PathVariable("id") int id){
        Empresa b = empresaService.findById(id).orElse(null);
        return b;
    }
    
    @GetMapping("/update")
    public Empresa update(@PathParam("id") int id, @PathParam("nombre") String nombre) {
        Empresa user = new Empresa();
        if (empresaService.findById(id).toString() != "Optional.empty") {

            user.setId(id);

            user.setNombreEmpresa(nombre);
            Date dateobj = new Date(System.currentTimeMillis());
            user.setCreated_at(empresaService.findById(id).orElse(null).getCreated_at());
            user.setUpdated_at(dateobj);
            empresaService.update(user);
        }
        return user;
    }

    @GetMapping("/del")
    public Empresa delete(@PathParam("id") int id) {
        Empresa user = null;
        if (empresaService.findById(id).orElse(null) != null) {
            for (UsuarioEmpresa a : ueService.findAll()) {
                if (a.getEmpresa().getId() == id) {
                    ueService.delete(a);
                }
            }

            for (Coche a : cService.findAll()) {
                if (a.getEmpresa().getId() == id) {
                    cService.delete(a);
                }
            }
            empresaService.delete(empresaService.findById(id).orElse(null));
        }

        return user;
    }
}