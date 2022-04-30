package Punto2;

import java.util.Calendar;
import java.util.Date;

public class Factura {
	private int idFactura;
	private Cliente cliente;
	private Date fecha;
	private float importe;
	private Estado estado;
	
//Constructores
	public Factura() {}
	
	public Factura (int idFactura) {
		setIdFactura(idFactura);
		setCliente(null);
		setFecha(null);
		setImporte(0);
		setEstado(Estado.INICIALIZADA);
		
	}
	
	public Factura (int idFactura,Date date) {
		setIdFactura(idFactura);
		setCliente(null);
		setFecha(date);
		setImporte(0);
		setEstado(Estado.INICIALIZADA);
	}
	
	
	public Factura (int idFactura, Cliente cliente, Date fecha) {
		setIdFactura(idFactura);
		setCliente(cliente);
		setFecha(fecha);
		setImporte(0);
		setEstado(Estado.INICIALIZADA);
	}
	
	public Factura (int idFactura, Cliente cliente, Date fecha,float importe) {
		setIdFactura(idFactura);
		setCliente(cliente);
		setFecha(fecha);
		setImporte(importe);
		setEstado(Estado.INICIALIZADA);
	}
	
	
	
//Setters
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
//Getters
	public int getIdFactura() {	return idFactura;}
	public Cliente getCliente() {return cliente;}
	public Date getFecha() {return fecha;}
	public float getImporte() {return importe;}
	public Estado getEstado() {return estado;}
	
	@Override
	public String toString() {
		return "IdFactura:" + getIdFactura() + "\n" + "Cliente" + getCliente() + "\n" + "Fecha: " +getFecha()+ "\n" + "Importe: "+ getImporte()+"\n"+ "Estado:  " +getEstado() + "\n";
	}

	

	
	



	

	
	
	
	
	
}
