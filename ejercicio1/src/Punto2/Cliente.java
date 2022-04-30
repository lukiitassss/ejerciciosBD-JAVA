package Punto2;

public class Cliente {
	private int id;
	private String razonSocial;
	
	//Constructores
	public Cliente(){}

	public Cliente(int id){
		setId(id);
		setRazonSocial(null);
	}

	public Cliente(int id, String razonSocial){
		setId(id);
		setRazonSocial(razonSocial);
	}
	
	//Setters
	public void setId(int id) { this.id = id;}
	public void setRazonSocial(String descr) {this.razonSocial = descr;}
	
	//Getters
	public int getId() { return id;}
	public String getRazonSocial() {return razonSocial;}
	
	@Override
	public String toString() {
		return "Id:  " +getId()+ "\n"+"  Razon Social: "+getRazonSocial() ;
	}
}

