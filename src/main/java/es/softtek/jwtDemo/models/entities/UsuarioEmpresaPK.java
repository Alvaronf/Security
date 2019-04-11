package es.softtek.jwtDemo.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioEmpresaPK implements Serializable{

    @Column(name = "Usuario_ID")
    private int usuarioid;

    @Column(name = "Empresa_ID")
    private int empresaid;

	/**
	 * @return the usuarioid
	 */
	public int getUsuarioid() {
		return usuarioid;
	}

	/**
	 * @param usuarioid the usuarioid to set
	 */
	public void setUsuarioid(int usuarioid) {
		this.usuarioid = usuarioid;
	}

	/**
	 * @return the empresaid
	 */
	public int getEmpresaid() {
		return empresaid;
	}

	/**
	 * @param empresaid the empresaid to set
	 */
	public void setEmpresaid(int empresaid) {
		this.empresaid = empresaid;
	}
}