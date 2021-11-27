package py.una.entidad;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	Long cedula;
	String nombre;
	String apellido;
	String chapa;
	String marca;
	Long tipo_operacion;

	public Persona(Long cedula, String nombre, String apellido, String chapa,String marca, Long TipoOp){
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.chapa = chapa;
		this.marca = marca;
		this.tipo_operacion=TipoOp;
	}
	public Persona() {

	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String Apellido) {
		this.apellido = Apellido;
	}

	public String getChapa() {
		return chapa;
	}

	public void setChapa(String chapa) {
		this.chapa = chapa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getTipo_operacion() {
		return tipo_operacion;
	}

	public void setTipo_operacion(Long tipo_operacion) {
		this.tipo_operacion = tipo_operacion;
	}

}
