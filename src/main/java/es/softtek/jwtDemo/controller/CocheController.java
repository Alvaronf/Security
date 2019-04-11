package es.softtek.jwtDemo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import es.softtek.jwtDemo.models.entities.Coche;
import es.softtek.jwtDemo.models.entities.Empresa;
import es.softtek.jwtDemo.models.services.CocheService;
import es.softtek.jwtDemo.models.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coches")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/crear")
    public Coche save(@PathParam("marca") String marca, @PathParam("modelo") String modelo,
            @PathParam("color") String color, @PathParam("idempresa") int idempresa) {
        Coche user = null;

        try {
            if (empresaService.findById(idempresa).toString() != "Optional.empty") {
                user = new Coche();
                
                user.setModelo(modelo);
                user.setColor(color);
                Empresa bla=new Empresa();
                bla.setId(idempresa);
                user.setEmpresa(bla);
                user.setMarca(marca);
                
                cocheService.save(user);
                
            }

        } catch (Exception ex) {
            System.out.println("a");
            System.out.println(ex.toString());
        }
        return user;
    }

    @GetMapping("/mostrar")
    public String mostrar() {

        List<Coche> usuarios = cocheService.findAll();
        String b = "";
        for (Coche a : usuarios) {
            Empresa emp = (empresaService.findById(a.getEmpresa().getId())).orElse(null);
            b += "\n Modelo :" + a.getModelo() + "\t ID: " + a.getId() + "\t Empresa:" + (emp.getNombreEmpresa());
        }

        return b;
    }

    @GetMapping("/update")
    public Coche update(@PathParam("id") int id, @PathParam("marca") String marca, @PathParam("modelo") String modelo,
            @PathParam("color") String color, @PathParam("idempresa") int idempresa) {
        Coche user = null;
        if (cocheService.findById(id).toString() != "Optional.empty") {

            if (empresaService.findById(idempresa).toString() != "Optional.empty") {
                user = new Coche();
                user.setId(id);
                user.setModelo(modelo);
                user.setColor(color);
                Empresa bla=new Empresa();
                bla.setId(idempresa);
                user.setEmpresa(bla);
                user.setMarca(marca);

                cocheService.save(user);
            }
        }
        return user;
    }

    @GetMapping("/del")
    public Coche delete(@PathParam("id") int id) {
        Coche user = new Coche();
        if (cocheService.findById(id).toString() != "Optional.empty") {
            user.setId(id);
            cocheService.delete(user);
            
        }
        return user;
    }

}