package Punto2;

public class Detalle {
   private Factura idFactura;
   private Producto idProducto;
   private int cantidad;
   private float precio;
   

   //Constructores
   public Detalle () {}
   
   public Detalle( Factura factura, Producto producto, int cantidad, float precio){
	   setIdFactura(factura);
	   setIdProducto(producto);
	   setCantidad(cantidad);
	   setPrecio(precio); 
   }

   
   
   //Getters
   public Factura getIdFactura() {return idFactura;}
   public Producto getIdProducto() {return idProducto;}
   public int getCantidad() {return cantidad;}
   public float getPrecio() {return precio;}
   
   
   //Setters
   public void setIdFactura(Factura idFactura) {
	   this.idFactura = idFactura;
   }

   public void setIdProducto(Producto idProducto) {
	   this.idProducto = idProducto;
   }

   public void setCantidad(int cantidad) {
	   this.cantidad = cantidad;
   }

   public void setPrecio(float precio) {
	   this.precio = precio;
   }
   
   
   @Override
   public String toString() {
	   return "Factura:  "+getIdFactura().getIdFactura() +"\n" + "Producto: " + getIdProducto() +"\n" + "Cantidad solicitada: " + getCantidad() +"\n" + "Precio Venta" + getPrecio() +"\n" ; 
   }
}
