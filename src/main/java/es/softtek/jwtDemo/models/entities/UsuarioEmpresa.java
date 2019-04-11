package es.softtek.jwtDemo.models.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "UsuarioEmpresa")
public class UsuarioEmpresa implements Serializable {

    @EmbeddedId
    private UsuarioEmpresaPK id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "Usuario_ID")
    private User usuario;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "Empresa_ID")
    private Empresa empresa;

    private Date created_at;
    private Date updated_at;

    /**
     * @return the id
     */
    public UsuarioEmpresaPK getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UsuarioEmpresaPK id) {
        this.id = id;
    }

    /**
     * @return the usuario
     */
    public User getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    
}