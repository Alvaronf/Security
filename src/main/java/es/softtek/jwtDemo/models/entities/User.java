package es.softtek.jwtDemo.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Usuario")
public class User {

	private String user;
	private String pwd;
	private String token;
	private String email;
	private String apellido;
	private Date fechacreacion;
	private Date fechaactualizacion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	/**
	 * @return the fechaactualizacion
	 */
	public Date getFechaactualizacion() {
		return fechaactualizacion;
	}

	/**
	 * @param fechaactualizacion the fechaactualizacion to set
	 */
	public void setFechaactualizacion(Date fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	/**
	 * @return the fechacreacion
	 */
	public Date getFechacreacion() {
		return fechacreacion;
	}

	/**
	 * @param fechacreacion the fechacreacion to set
	 */
	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
        this.id = id;
    }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
    }
}