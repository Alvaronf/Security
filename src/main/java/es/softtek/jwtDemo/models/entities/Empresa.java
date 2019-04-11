package es.softtek.jwtDemo.models.entities;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nombre_Empresa")
    @NotEmpty
    @Size(max = 100)
    private String nombreEmpresa;

    private Date created_at;

    private Date updated_at;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the updated_at
     */
    public Date getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    /**
     * @return the created_at
     */
    public Date getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "empresa")
    private Set<UsuarioEmpresa> UsuarioEmpresa = new HashSet<UsuarioEmpresa>();

    @OneToMany(mappedBy="empresa")
    private Set<Coche> coches = new HashSet<Coche>();
}