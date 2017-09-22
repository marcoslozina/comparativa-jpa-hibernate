package ar.com.cdt.marcos.lozina.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CDT_registro")
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_persona")
    Persona persona;

    @Enumerated(EnumType.STRING)
    private TipoRegistro tipoRegistro;

    private String descripcion;

    private Long valor;

    public Registro() {

    }

    public Registro(Persona persona, TipoRegistro tipoRegistro, String descripcion, Long valor) {
	this.persona = persona;
	this.tipoRegistro = tipoRegistro;
	this.descripcion = descripcion;
	this.valor = valor;
    }

    public Long getCodigo() {
	return codigo;
    }

    public void setCodigo(Long codigo) {
	this.codigo = codigo;
    }

    public Persona getPersona() {
	return persona;
    }

    public void setPersona(Persona persona) {
	this.persona = persona;
    }

    public TipoRegistro getTipoRegistro() {
	return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistro tipoRegistro) {
	this.tipoRegistro = tipoRegistro;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public Long getValor() {
	return valor;
    }

    public void setValor(Long valor) {
	this.valor = valor;
    }

}
