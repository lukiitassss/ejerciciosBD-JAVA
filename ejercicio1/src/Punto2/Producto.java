package Punto2;

public class Producto {
  private int id;
  private String descripcion;
  private int stock;
  private float precioBase;
  
  //Construcctores
  public Producto() {
	  
  }
  
  public Producto(int id) {
	  setId(id);
	  setDescripcion(null);
	  setStock(0);
	  setPrecioBase(0);
  }
  public Producto(int id, String descr){
	  setId(id);
	  setDescripcion(descr);
	  setStock(0);
	  setPrecioBase(0);
  }
  public Producto(int id, String descr,int stock) {
	  setId(id);
	  setDescripcion(descr);
	  setStock(stock);
	  setPrecioBase(0);
  }
  public Producto(int id, String descr,int stock, float precioBase) {
	  setId(id);
	  setDescripcion(descr);
	  setStock(stock);
	  setPrecioBase(precioBase);
  }
  
  //Setters
  public void setId(int id) { this.id = id;}
  public void setDescripcion(String descripcion) {this.descripcion= descripcion;}
  public void setStock(int stock) {this.stock = stock;}
  public void setPrecioBase(float precioBase) {this.precioBase = precioBase;}

  //Getters
  public int getId() { return id;}
  public String getDescripcion() {return descripcion;}
  public int getStock() {return stock;}
  public float getPrecioBase() {return precioBase;}
  
  @Override
  public String toString() {
	return "Id :" +getId() +"\n"+ "Descripcion: "+ getDescripcion()+ "\n"+ "Stock: "+ getStock() + "\n"+ "Precio Base: "+getPrecioBase();
	  
  }
}
