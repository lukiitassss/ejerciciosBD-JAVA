package Punto2;

import java.util.Calendar;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import com.db4o.query.Constraint;
import com.db4o.query.Query;

public class Main {
	private static Scanner miScanner;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		miScanner = new Scanner(System.in);
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"db4oej2.db");
		
		/*
		//----------LO TENGO QUE HACER CUANDO VOY A ELIMINAR O ACTUALIZAR, DEBO DE:
		//1° CERRAR LA DB
		//2° ABRIR LA DB CON LA NUEVA CONFIGURACION
		//Lo que va a permitir es cuando actualicemos un detalle, la cantidad y monto tambien se actualizara Factura
		//aumentando el importe y restando de Producto cantidad.
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().objectClass(Detalle.class).cascadeOnUpdate(true);
		ObjectContainer db=Db4oEmbedded.openFile(config,"db4oej2.db");
		
		//Lo que va a permitir es cuando eliminemos un detalle, la cantidad y monto tambien se actualizara Factura
		//disminuyendo el importe y aumentando de Producto cantidad.
		EmbeddedConfiguration config1 = Db4oEmbedded.newConfiguration();
		config1.common().objectClass(Detalle.class).cascadeOnDelete(true);
		ObjectContainer db=Db4oEmbedded.openFile(config1,"db4oej2.db");
		*/
				
		menuPrincipal(db);
		
	}catch(Exception ex) {
        System.err.println(ex.getMessage());
    	}
	}	
	
	//-----------------------------------------[MENUS]------------------------------------------	
	public static void menuPrincipal (ObjectContainer db) {
		System.out.println("-------------[ MENU ]----------------");
		System.out.println();
		System.out.println("1) Listar Clientes");
		System.out.println("2) Listar Facturas");
		System.out.println("3) Listar Detalles");
		System.out.println("4) Listar Productos");
		System.out.println("5) ABM Clientes");
		System.out.println("6) AMB Facturas");
		System.out.println("7) ABM Detalles");
		System.out.println("8) ABM Productos");
		System.out.println("9) Realizar Consultas");
		System.out.println("0) Salir ");
		System.out.println();
		
	
		System.out.println("Ingrese Una Opcion");
		String opcion = miScanner.nextLine();
		
		switch (opcion) {
		
		case "1": 
			listarCliente(db);
			menuPrincipal(db);
			break;
		case "2": 
			listarFactura(db);
			menuPrincipal(db);
			break;
		
		case "3": 
			listarDetalle(db);
			menuPrincipal(db);
			break;
			
		case "4": 
			listarProducto(db);
			menuPrincipal(db);
			break;
			
		case "5": 
			menuABMCliente(db);
		
			break;
			
		case "6": 
			menuABMFactura(db);
			
			break;
			
		case "7": 
			menuABMDetalle(db);
			
			break;
			
		case "8": 
			menuABMProducto(db);
			
			break;
			
		case "9": 
			menuConsultas(db);
			break;
			
		case "0": 
			db.close();
			miScanner.close();
			System.exit(0);
			break;
			
		default: menuPrincipal(db);	
		}

	}

	public static void menuABMCliente(ObjectContainer db) {
		System.out.println("-------------[ MENU ABM CLIENTE]----------------");
		System.out.println();
		System.out.println("1) Listar Clientes");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Anterior" );
		
		
		
		System.out.println("Ingrese Una Opcion");
		String opcion = miScanner.nextLine();
		
		switch (opcion) {
		
		case "1":
			listarCliente(db);
			menuABMCliente(db);
			break;
		
		case "2":
			altaCliente(db);
			menuABMCliente(db);
			break;
		
		case "3":
			bajaCliente(db);
			menuABMCliente(db);
			break;
		
		case "4":
			modificarCliente(db);
			menuABMCliente(db);
			break;
			
		case "0" : menuPrincipal(db);
		
		
		default: menuABMCliente(db);
		
		}
	} 

	public static void menuABMFactura (ObjectContainer db) {
		System.out.println("-------------[ MENU ABM FACTURAS]----------------");
		System.out.println();
		System.out.println("1) Listar Facturas");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Anterior" );
	
	
		System.out.println("Ingrese Una Opcion");
		String opcion = miScanner.nextLine();
		
		switch (opcion) {
		
		case "1":
			listarFactura(db);
			menuABMFactura(db);
			break;
		
		case "2":
			altaFactura(db);
			menuABMFactura(db);
			break;
		
		case "3":
			bajaFactura(db);
			menuABMFactura(db);
			break;
			
		case "4":
			modificarFactura(db);
			menuABMFactura(db);
			break;
		
		case "0" : menuPrincipal(db);
		
		default: menuABMFactura(db);
		
		}
	}

	public static void menuABMDetalle(ObjectContainer db) {
		System.out.println("-------------[ MENU ABM DETALLES]----------------");
		System.out.println();
		System.out.println("1) Listar Detalles");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Anterior" );
	
		
		System.out.println("Ingrese Una Opcion");
		String opcion = miScanner.nextLine();
		
		switch (opcion) {
		
		case "1":
			listarDetalle(db);
			menuABMDetalle(db);
			break;
		
		case "2":
			altaDetalle(db);
			menuABMDetalle(db);
			break;
		
		case "3":
			bajaDetalle(db);
			menuABMDetalle(db);
			break;
			
		case "4":
			modificarDetalle(db);
			menuABMDetalle(db);
			break;
		
		case "0" : menuPrincipal(db);
		
		default: menuABMDetalle(db);
		
		}
	}

	public static void menuABMProducto(ObjectContainer db) {
		System.out.println("-------------[ MENU ABM PRODUCTO]----------------");
		System.out.println();
		System.out.println("1) Listar Productos");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Anterior" );
	
	
		System.out.println("Ingrese Una Opcion");
		String opcion = miScanner.nextLine();
		
		switch (opcion) {
		
		case "1":
			listarProducto(db);
			menuABMProducto(db);
			break;
		
		case "2":
			altaProducto(db);
			menuABMProducto(db);
			break;
		
		case "3":
			bajaProducto(db);
			menuABMProducto(db);
			break;
			
		case "4":
			modificarProducto(db);
			menuABMProducto(db);
			break;
		
		case "0" : menuPrincipal(db);
		
		default: menuABMProducto(db);
		
		}
	}

	
	
	public static void menuConsultas (ObjectContainer db) {
		System.out.println("-------------[MENU CONSULTAS]----------------");
		System.out.println("1)  Listar Facturas Con un Importe entre un rango");
		System.out.println("2)  Listar Facturas de un Cliente");
	//	System.out.println("3)  Listar Clientes que No tienen Facturas");
	//	System.out.println("4)  Listar Clientes que Tienen Facturas");
		System.out.println("5)  Listar Facturas Inicializadas");
		System.out.println("6)  Listar Facturas Finalizadas");
		System.out.println("7)  Listar Productos Sin Stock");
	//	System.out.println("8)  Listar Productos No Vendidos");
		System.out.println("9)  Listar Productos con un rango de precio");
		System.out.println("10) Listar Producto con un rango de Stock");
		System.out.println("11) Listar Detalles de Una Factura");
		System.out.println("12) Listar Clientes");
		System.out.println("13) Listar Facturas");
		System.out.println("14) Listar Detalles");
		System.out.println("15) Listar Productos");
		System.out.println("0) Volver Al Menu Anterior");
		

		System.out.println("Ingrese Una Opcion");
		String opcion = miScanner.nextLine();
		
		switch (opcion) {
		case "1":
			listarFacturasConImporte(db);
			menuConsultas(db);
			break;
		case "2":
			listarFacturasdeCliente(db);
			menuConsultas(db);
			break;
		case "3":
//			listarClientesSinFacturas(db);
			menuConsultas(db);
			break;
		case "4":
	//		listarClientesConFacturas(db);
			menuConsultas(db);
			break;
		case "5":
			listarFacturasInicializadas(db);
			menuConsultas(db);
			break;
			
		case "6":
			listarFacturasFinalizadas(db);
			menuConsultas(db);
			break;
		case "7":
			listarProductosSinStock(db);
			menuConsultas(db);
			break;
		case "8":
//			listarProductosNoVendidos(db);
			menuConsultas(db);
			break;
		case "9":
			listarProductosConPrecio(db);
			menuConsultas(db);
			break;
		case "10":
			listarProductoConStock(db);
			menuConsultas(db);
			break;
		case "11":
			listarDetallesFactura(db);
			menuConsultas(db);
			break;
		case "12":
			listarCliente(db);
			menuConsultas(db);
			break;

		case "13":
			listarFactura(db);
			menuConsultas(db);
			break;
			
		case "14":
			listarDetalle(db);
			menuConsultas(db);
			break;
			
		case "15":
			listarProducto(db);
			menuConsultas(db);
			break;

		case "0":
			menuPrincipal(db);
			break;
			
		default: menuConsultas(db);
		}
	}
	
	
//-----------------------------------------[LISTAR]------------------------------------------	
//-------------------------------------------------------------------------------------------	
	public static void listarCliente (ObjectContainer db) {
		System.out.println("______________________");
    	System.out.println("Listar Clientes");
    	//Cliente proto=new Cliente();
    	Query qry = db.query();
    	qry.constrain(Cliente.class);
        //ObjectSet result=db.queryByExample(proto);
    	ObjectSet<Factura> result=qry.execute();
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();
	    }
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	
	public static void listarFactura (ObjectContainer db) {
		System.out.println("______________________");
    	System.out.println("Listar Factura");
    	//Cliente proto=new Factura();
    	Query qry = db.query();
    	qry.constrain(Factura.class);
        //ObjectSet result=db.queryByExample(proto);
    	ObjectSet<Factura> result=qry.execute();
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();
	    }
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	
	public static void listarDetalle (ObjectContainer db) {
		System.out.println("______________________");
    	System.out.println("Listar Detalle");
    	//Cliente proto=new Factura();
    	Query qry = db.query();
    	qry.constrain(Detalle.class);
        //ObjectSet result=db.queryByExample(proto);
    	ObjectSet<Detalle> result=qry.execute();
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();
	    }
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	
	public static void listarProducto (ObjectContainer db) {
		System.out.println("______________________");
    	System.out.println("Listar Productos");
    	//Cliente proto=new Factura();
    	Query qry = db.query();
    	qry.constrain(Producto.class);
        //ObjectSet result=db.queryByExample(proto);
    	ObjectSet<Producto> result=qry.execute();
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();
	    }
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	

//-----------------------------------------[ABM CLIENTE]------------------------------------------	
//-------------------------------------------------------------------------------------------	

	public static void altaCliente(ObjectContainer db) {
		
		System.out.println("Ingrese Id Cliente");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);

		ObjectSet<Cliente> resul = db.queryByExample(new Cliente(numero));
		
		if (resul.size()>0 ){
			System.out.println("Id Existente");
		}else
			{
				
			System.out.println("Ingrese Nombre");
			opcion = miScanner.nextLine();
			Cliente cliente = new Cliente(numero,opcion);
			//Guardamos un Cliente en la BD
			db.store(cliente); 
			System.out.println("Alta Exitosa!!");
			System.out.println("");
			}
	}
	
	public static void bajaCliente(ObjectContainer db){
		
		System.out.println("Ingrese Id A Eliminar");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);
		
		ObjectSet<Cliente> result = db.queryByExample(new Cliente(numero));
		
		if (result.size()>0) {
			Cliente cliente = (Cliente) result.next();
			db.delete(cliente);

			System.out.println("Eliminacion Exitosa!!");
			System.out.println("");
		}else {
				System.out.println("Cliente Inexistente");
			  }

	}
	
	public static void modificarCliente (ObjectContainer db) {
	
		System.out.println("Ingrese Id A Modificar");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);
		
		ObjectSet<Cliente> result = db.queryByExample(new Cliente(numero));
		
		if (result.size()>0) {
		Cliente cliente = (Cliente) result.next();
		System.out.println("Ingrese Nueva Descripcion");
		opcion = miScanner.nextLine();
		cliente.setRazonSocial(opcion);
		db.store(cliente);

		System.out.println("Modificacion Exitosa!!");
		System.out.println("");
		}else {
			System.out.println("Id inexistente");
		}
		
	}

//-----------------------------------------[ABM FACTURA]------------------------------------------	
//-------------------------------------------------------------------------------------------	
	public static void altaFactura (ObjectContainer db) {
		System.out.println("Ingrese Id Factura");
		String opcion = miScanner.nextLine();
		
		int numeroFac = Integer.parseInt(opcion);
		
		System.out.println("Ingrese Id CLiente");
		opcion = miScanner.nextLine();
		
		int numeroId = Integer.parseInt(opcion);
		// Primero ingreamos el id del cliente para asignarlo a una factura,pero debe de existir
		
		ObjectSet<Cliente> resul = db.queryByExample(new Cliente(numeroId));
		
		if (resul.size()>0) {
			//el cliente existe, por lo tanto podemos craer la factura si no existe ya ese id
			Cliente cliente = (Cliente)resul.next();
			
			/**/
			Query qry = db.query();
			qry.constrain(Factura.class);
			qry.descend("idFactura").constrain(numeroFac);
			ObjectSet<Factura> resulFactura = qry.execute(); 
			
			//resul = db.queryByExample(new Factura(numeroFac));debo de modicarla porque si una factura cambia a estado finalizado no va a ser la misma que la que tenga un estado inicializado
																//por lo tanto puedeo dar de alta la factura dos veces xon distinto estado.
			if (resulFactura.size()==0) {
				//No existe esa factura, por lo tanto podemos crearla
				//seteamos a la factura el cliente que encontramos con el id.
				Calendar fecha = Calendar.getInstance();
				Factura factura = new Factura(numeroFac,fecha.getTime());
				factura.setCliente(cliente);
				db.store(factura);
				System.out.println("Alta Exitosa!!");
				System.out.println();
			}else {
				System.out.println("Factura Existente");	
				} 
			
		}else {
			System.out.println("Cliente Inexistente");
		}
	}
	
	
	public static void bajaFactura (ObjectContainer db) {
		
		System.out.println("Ingrese Id Factura");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);
		
		Query qryFac = db.query();
		qryFac.constrain(Factura.class);
		qryFac.descend("idFactura").constrain(numero);
		ObjectSet<Factura> result = qryFac.execute();


		if (result.size()>0) {
			
			Factura factura = result.next();
			//primero debo eliminar TODOS LOS DETALLES
			
			Query qry = db.query();
			qry.constrain(Detalle.class);
			qry.descend("idFactura").constrain(factura);
			ObjectSet<Detalle> resultDetalle = qry.execute();
		
			//me devolvera todos los detalles de la factura.
			//SUPONIENDO QUE LA FACTURA TIENE DOS ESTADOS INICIALIZADA = si se elimina se devuelve el stock O FINALIDADA = no se devuelve el stock y se borran los detalles.
	
			
				while (resultDetalle.hasNext()) {
					Detalle detalle = resultDetalle.next();
						
					if (factura.getEstado() == Estado.INICIALIZADA) {
					//debo recorrer para cada producto de detalle y actualizar el stock
					
					Query qry1 = db.query();
					qry1.constrain(Producto.class);
					qry1.constrain(detalle.getIdProducto());
					ObjectSet<Producto> resultproductos = qry1.execute();

					while (resultproductos.hasNext()) {
						int stock = 0;
						Producto producto = (Producto) resultproductos.next();
						stock = producto.getStock() + detalle.getCantidad(); 
						producto.setStock(stock);
						db.store(producto);
						}
					}

					db.delete(detalle);
			}

			db.delete(factura); //Luego de que eliminamos todos los detalles eliminamos la factura

			System.out.println("Eliminacion Exitosa!!");
			System.out.println("");
		}else {
				System.out.println("Factura Inexistente");
			  }
		
	}
	
	public static void modificarFactura (ObjectContainer db) {
		
		System.out.println("Ingrese Id Factura");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);
		
		ObjectSet<Factura> result = db.queryByExample(new Factura(numero));
		if (result.size()>0) {
			Factura factura = result.next();
			System.out.println("Desea Cambiar Estado a FINALIZADA");
			System.out.println("1) Si");
			System.out.println("0) NO");
			opcion = miScanner.nextLine();
			if (Integer.parseInt(opcion) == 1) {
				factura.setEstado(Estado.FINALIZADA);
				db.store(factura);
				System.out.println("Modificacion Exitosa!!");
				
			}
				
			
		}else {
			System.out.println("Id Inexistente");
			}
	}
	
//-----------------------------------------[ABM DETALLE]------------------------------------------	
//-------------------------------------------------------------------------------------------	
/*debo de fijarme que cuando actualize una factura se actualize en todos los detalles, lo mismo para producto*/
	public static void altaDetalle (ObjectContainer db) {
		
		
		System.out.println("Ingrese Id Factura");
		String opcion = miScanner.nextLine();
		//Debo buscar que exista la factura a la que agregaremos el detalle
		int idFactura = Integer.parseInt(opcion);
		ObjectSet<Factura> resultFactura = db.queryByExample(new Factura(idFactura));
		
		if (resultFactura.size()>0) {
				//quiere decir que existe la factura por lo tanto podemos crearle un detalle
				Factura factura = resultFactura.next();
				System.out.println("Ingrese Id Producto");
				opcion = miScanner.nextLine();
				int idProducto = Integer.parseInt(opcion);
				//primero verificamos que exista el producto
				ObjectSet<Producto> resultProducto = db.queryByExample(new Producto(idProducto));
				
				if (resultProducto.size()>0) {
					//sabemos que existe el producto
					//por lo tanto buscaremos una detalle que tenga como producto el id ingresado,
					//si nos devuelve un resultado es porque existe un detalle con estas claves 
					//de lo contrario no existe y debemos crearla y aumentar el monto de factura y restar stock de producto si alcanza
					Producto producto = resultProducto.next();
					
					Query qry = db.query();
					qry.constrain(Detalle.class);
					
					qry.descend("idFactura").constrain(factura).and(qry.descend("idProducto").constrain(producto));
					ObjectSet<Detalle> resultDetalle = qry.execute();
					
					if (resultDetalle.size()==0) {
						//Esto indica que no existe una combinacion Factura Producto en la lista
						//Por lo tanto debemos seguir pidiendo los datos pero primero controlar el stock que quiere ingresar.
						System.out.println("Ingrese Cantidad de Producto");
						opcion = miScanner.nextLine();
						
						int stock = Integer.parseInt(opcion);
						if (stock>0) {
							//compararemos el stock actual con el ingresado
							if (stock <= producto.getStock()){
								//Alcanza el Stock por lo tanto decrementamos el stock
								int totalStock = producto.getStock() - stock;
								// Como el stock alcanza , preguntamos por el precio que le va a asignar al produco
								//no puede ser menor al precioBase de producto
								System.out.println("Ingrese Precio de Producto");
								opcion = miScanner.nextLine();
								
								float precio = Float.parseFloat(opcion);
								if (precio >= producto.getPrecioBase()) {
									// Podremos dar el alta del detalle 
									// Debemos de actualizar el importe de Factura y el stock de Producto
									float totalFac = factura.getImporte() + (stock*precio);
									factura.setImporte(totalFac);
									producto.setStock(totalStock);
									Detalle detalle = new Detalle (factura,producto,stock,precio);
									db.store(factura);
									db.store(producto);
									db.store(detalle);
									System.out.println("Alta Exitosa!!!");
									System.out.println("");
									
									
								}else {
									System.out.println("Precio menor al Precio Base Del Producto");
								}
								
							}else {
								System.out.println("Stock Insuficiente");
							}
								
						}else {
							System.out.println("El stock no puede ser Negativo");
						}
							
						
					}else {
						System.out.println("Detalle Existente");
					}
						
					
					
					
				}else {
					System.out.println("Producto Inexistente");
					
				}
					
				
		}else {
			System.out.println("Id Factura Inexistente");} 
		}
			
	 public static void bajaDetalle (ObjectContainer db) {
		 	
			System.out.println("Ingrese Id Detalle A Eliminar ");
			String opcion = miScanner.nextLine();
			int idDetalle = Integer.parseInt(opcion);
			
			System.out.println("Ingrese Id Producto A Eliminar ");
			opcion = miScanner.nextLine();
			int idProducto = Integer.parseInt(opcion);
			
			Query qry = db.query();
			
			qry.constrain(Detalle.class);
			/*
			qry.descend("idFactura").constrain(new Factura(idDetalle)).and(qrypro.constrain(new Producto(idProducto)));
			*/
			
			Constraint qrypro = qry.descend("idProducto").descend("id").constrain(idProducto);
			qry.descend("idFactura").descend("idFactura").constrain(idDetalle).and(qrypro);
			
			ObjectSet<Detalle> resultDetalle = qry.execute();
			
			if (resultDetalle.size()>0) {
				
				//existe un detalle para dar de baja
				Detalle detalle = resultDetalle.next();
				Query qryFac = db.query();
				qryFac.constrain(Factura.class);
				qryFac.descend("idFactura").constrain(idDetalle);
				ObjectSet<Factura> resultFactura = qryFac.execute();
				System.out.println("Longitud de resultados de FACTURA"+ resultFactura.size());
				Factura factura = resultFactura.next();
				
				System.out.println("Id Producto--------------->"+ idProducto);
				
				Query qryPro = db.query();
				qryPro.constrain(Producto.class);
				qryPro.descend("id").constrain(idProducto);
				ObjectSet<Producto> resultProducto = qryPro.execute();
				System.out.println("Longitud de resultados de PRODUCTO"+ resultProducto.size());
				
				Producto producto = resultProducto.next();
				
				if (factura.getEstado() == Estado.INICIALIZADA) {
					//debemos de actualizar importe de factura y stock de producto
					int stocktotal = producto.getStock() + detalle.getCantidad();
					float importeTotal = factura.getImporte() - (detalle.getCantidad()*detalle.getPrecio());
					producto.setStock(stocktotal);
					factura.setImporte(importeTotal);
					db.store(producto);
					db.store(factura);
					db.delete(detalle);
					System.out.println("Baja Exitosa!!!");
				}else {
					System.out.println("No se puede Dar Baja, Factura FINALIZADA");
					}
			}else {
				System.out.println("Detalle Inexistente");
			}
	 }
	 
		
	 public static void modificarDetalle (ObjectContainer db) {
		 	
			System.out.println("Ingrese Id Detalle A Modificar ");
			String opcion = miScanner.nextLine();
			int idDetalle = Integer.parseInt(opcion);
			
			System.out.println("Ingrese Id Producto A Modificar ");
			opcion = miScanner.nextLine();
			int idProducto = Integer.parseInt(opcion);
			
			Query qry = db.query();
			qry.constrain(Detalle.class);
			qry.descend("idFactura").constrain(new Factura(idDetalle)).and(qry.descend("idProducto").constrain(new Producto(idProducto)));
			
			ObjectSet<Detalle> resultDetalle = qry.execute();
			
			System.out.println(""+resultDetalle.size());
			if (resultDetalle.size()>0) {
				
				//existe un detalle para modificar 
				Detalle detalle = resultDetalle.next();
				Query qryFac = db.query();
				qryFac.constrain(Factura.class);
				qryFac.descend("idFactura").constrain(idDetalle);
				ObjectSet<Factura> resultFactura = qryFac.execute();
				Factura factura = resultFactura.next();
				
				System.out.println("FACTURAAAAA "+factura);
				Query qryPro = db.query();
				qryPro.constrain(Producto.class);
				qryPro.constrain(new Producto(idProducto));
				ObjectSet<Producto> resultProducto = qryPro.execute();
				Producto producto = resultProducto.next();
				
				if (factura.getEstado() == Estado.INICIALIZADA) {
					//debemos de actualizar importe de factura y stock de producto
					
					subMenuModificacion(producto,detalle,factura);
					
					db.store(producto);
					db.store(factura);
					db.store(detalle);
					System.out.println("Modificacion Exitosa!!!");
				}else {
					System.out.println("No se puede Modificar, Factura FINALIZADA");
					}
			}else {
				System.out.println("Detalle Inexistente");
			}
	 }
	 
	 private static void subMenuModificacion (Producto producto, Detalle detalle,Factura factura) {
		 	
		 	System.out.println("Ingrese Id Producto A Modificar ");
			System.out.println("");
			System.out.println("1) Cantidad ");
			System.out.println("2) Precio");
			String opcion = miScanner.nextLine();
			switch (opcion) {
			case "1":
				System.out.println("Ingrese Cantidad ");
				opcion = miScanner.nextLine();
				int cantidad = Integer.parseInt(opcion);
				
				if (cantidad > 0) {
					if (cantidad <= producto.getStock()) {
						float importetotal;
						int stocktotal;
						if (cantidad>detalle.getCantidad()) {
							cantidad = cantidad -detalle.getCantidad();
							 importetotal = factura.getImporte() + (detalle.getPrecio()*cantidad);
							 // se tiene que restar el stock ya que se esta agregando mas de lo que tenia 
							 stocktotal = producto.getStock() - cantidad;
						}else {
								cantidad = detalle.getCantidad()- cantidad;
								importetotal = factura.getImporte() - (detalle.getPrecio()*cantidad);
								//se debe de sumar ya que se necesita una menor cantidad de la que se tenia
							    stocktotal = producto.getStock() + cantidad;
							  }
						factura.setImporte(importetotal);
						producto.setStock(stocktotal); 
					}else {
						System.out.println("Stock Insuficiente");
						}
				}else {
						System.out.println("Cantidad no admitible");
						}
					break;
			
			case "2": 
				System.out.println("Ingrese precio");
				opcion = miScanner.nextLine();
				int precio = Integer.parseInt(opcion);
				if ((precio < 0) || (precio < producto.getPrecioBase())){
					System.out.println("Precio no admitible");
				}
				producto.setPrecioBase(precio);
				break;
			default: subMenuModificacion(producto,detalle,factura);	
			}
	 }
//-----------------------------------------[ABM PRODUCTO]------------------------------------------	
//-------------------------------------------------------------------------------------------	

	 public static void altaProducto(ObjectContainer db) {
			
			System.out.println("Ingrese Id Producto");
			String opcion = miScanner.nextLine();
			int numero = Integer.parseInt(opcion);

			ObjectSet<Producto> resul = db.queryByExample(new Producto(numero));
			
			if (resul.size()>0 ){
				System.out.println("Id Existente");
			}else
				{
					
				System.out.println("Descripcion");
				String descripcion = miScanner.nextLine();
				
				System.out.println("Stock");
				opcion = miScanner.nextLine();
				int stock = Integer.parseInt(opcion);
				if (stock <0) {
					System.out.println("Stock no permitido");
				}
				
				System.out.println("Precio Base");
				opcion = miScanner.nextLine();
				float precio = Float.parseFloat(opcion);
				if (precio <0) {
					System.out.println("Precio no permitido");
				}
				
				Producto producto = new Producto(numero,descripcion,stock,precio);
				//Guardamos un Cliente en la BD
				db.store(producto); 
				System.out.println("Alta Exitosa!!");
				System.out.println("");
				}
		}
		
		public static void bajaProducto (ObjectContainer db){
			
			System.out.println("Ingrese IdProducto A Eliminar");
			String opcion = miScanner.nextLine();
			int numero = Integer.parseInt(opcion);
			
			ObjectSet<Producto> result = db.queryByExample(new Producto(numero));
			
			if (result.size()>0) {
				Producto producto= (Producto) result.next();
				db.delete(producto);

				System.out.println("Eliminacion Exitosa!!");
				System.out.println("");
			}else {
					System.out.println("Cliente Inexistente");
				  }

		}
		
		public static void modificarProducto (ObjectContainer db){
			
			System.out.println("Ingrese Id Producto A Modificar");
			String opcion = miScanner.nextLine();
			int numero = Integer.parseInt(opcion);
			
			ObjectSet<Producto> result = db.queryByExample(new Producto(numero));
			if (result.size()>0) {
				Producto producto = (Producto) result.next();
				subMenuModicacionModificacionProducto(producto);
				
				db.store(producto);
				
				System.out.println("Modificacion Exitosa!!");
				System.out.println("");
			}else {
					System.out.println("Cliente Inexistente");
				  }

			
		}



		private static void subMenuModicacionModificacionProducto(Producto producto) {
		
		 	System.out.println("Ingrese Id Producto A Modificar ");
			System.out.println("");
			System.out.println("1) Descripcion");
			System.out.println("2) Cantidad ");
			System.out.println("3) Precio");
			System.out.println("0) Salir y Confirmar");
			String opcion = miScanner.nextLine();
			switch (opcion) {
			case "1":
				System.out.println("Ingrese Nueva Descripcion");
				System.out.println("");
				opcion = miScanner.nextLine();
				producto.setDescripcion(opcion);
				subMenuModicacionModificacionProducto(producto);
				break;
				
			case "2":

				System.out.println("Ingrese Nuevo Stock");
				System.out.println("");
				opcion = miScanner.nextLine();
				int stock = Integer.parseInt(opcion);
				if (stock >0) {
					producto.setStock(stock);
				}
				subMenuModicacionModificacionProducto(producto);
				break;
				
			case "3":
				System.out.println("Ingrese Nuevo Precio");
				System.out.println("");
				opcion = miScanner.nextLine();
				float precio = Float.parseFloat(opcion);
				if (precio >0) {
					producto.setPrecioBase(precio);
				}
				subMenuModicacionModificacionProducto(producto);
				break;
				
			case "0": 
				break;		
			}
		}



//-----------------------------------------[Consultas]------------------------------------------	
//-------------------------------------------------------------------------------------------	

		private static void listar (ObjectSet result) {
			
		  while(result.hasNext()) {
		        System.out.println(result.next());
		        System.out.println();
		    }
	        System.out.println("");
	        System.out.println("______________________");
	        System.out.println("");
	    }
		

		public static void listarFacturasConImporte(ObjectContainer db) {
			
		 	System.out.println("Ingrese Importe Minimo ");
		 	float min = Float.parseFloat(miScanner.nextLine());
		 	System.out.println("Ingrese Importe Maximo ");
		 	float max = Float.parseFloat(miScanner.nextLine());
		 	Query qryFac = db.query();
		 	qryFac.constrain(Factura.class);
		 	qryFac.descend("importe").constrain(min).greater().and(qryFac.descend("importe").constrain(max).smaller());
		 	ObjectSet<Factura> resultFacturas = qryFac.execute();
		 	System.out.println("Facturas Con importe mayor a : "+min + "  y menor a : "+max);
		 	System.out.println("");

		 	if (resultFacturas.size()>0) {
			 	listar(resultFacturas);	
		 	}else {
		 		System.out.println("No hay Facturas con importe indicado");
		 		  };
		}
		
		public static void listarFacturasdeCliente(ObjectContainer db) {
		 	System.out.println("Ingrese Id que desea Saber las Facturas ");
		 	int idCliente = Integer.parseInt(miScanner.nextLine());
		    
		    Query qryFac = db.query();
		 	qryFac.constrain(Factura.class);
		 	qryFac.descend("cliente").descend("id").constrain(idCliente);
		 	ObjectSet<Factura> resultFacturas = qryFac.execute();
		 	System.out.println("Facturas Del Cliente : "+ idCliente);
		 	System.out.println("");

		 	if (resultFacturas.size()>0) {
			 	listar(resultFacturas);	
		 	}else {
		 		System.out.println("El cliente no tiene Facturas ");
		 		  }
			
		}

	
		public static void listarFacturasInicializadas(ObjectContainer db) {
		    Query qryFac = db.query();
		 	qryFac.constrain(Factura.class);
		 	qryFac.descend("estado").constrain(Estado.INICIALIZADA);
		 	ObjectSet<Factura> resultFacturas = qryFac.execute();
		 	System.out.println("Facturas Con Estado Inicializado : ");
		 	System.out.println("");

		 	if (resultFacturas.size()>0) {
			 	listar(resultFacturas);	
		 	}else {
		 		System.out.println("No hay Facturas Inicializadas");
		 		  }
	
		}
		public static void listarFacturasFinalizadas(ObjectContainer db) {
			Query qryFac = db.query();
		 	qryFac.constrain(Factura.class);
		 	qryFac.descend("estado").constrain(Estado.FINALIZADA);
		 	ObjectSet<Factura> resultFacturas = qryFac.execute();
		 	System.out.println("Facturas Con Estado Finalizado : ");
		 	System.out.println("");
		 	
		 	if (resultFacturas.size()>0) {
			 	listar(resultFacturas);	
		 	}else {
		 		System.out.println("No hay Facturas Finalizadas");
		 		  }
		}
		public static void listarProductosSinStock(ObjectContainer db) {
			Query qryPro = db.query();
		 	qryPro.constrain(Producto.class);
		 	qryPro.descend("stock").constrain(0);
		 	ObjectSet<Producto> resultProductos = qryPro.execute();
		 	System.out.println("Productos Con Stock 0 : ");
		 	System.out.println("");
		 	
		 	if (resultProductos.size()>0) {
			 	listar(resultProductos);	
		 	}else {
		 		System.out.println("No hay Productos con Stock 0");
		 		  }
		}
		

		public static void listarProductosConPrecio(ObjectContainer db) {

		 	System.out.println("Ingrese Importe Minimo ");
		 	float min = Float.parseFloat(miScanner.nextLine());
		 	System.out.println("Ingrese Importe Maximo ");
		 	float max = Float.parseFloat(miScanner.nextLine());
		 	Query qryPro = db.query();
		 	qryPro.constrain(Producto.class);
		 	qryPro.descend("precioBase").constrain(min).greater().and(qryPro.descend("precioBase").constrain(max).smaller());
		 	ObjectSet<Producto> resultProductos = qryPro.execute();
		 	System.out.println("Productos Con importe mayor a : "+min + "  y menor a : "+max);
		 	System.out.println("");
		 	
		 	if (resultProductos.size()>0) {
			 	listar(resultProductos);	
		 	}else {
		 		System.out.println("No hay Productos con importe dado");
		 		  }
		 	}
		public static void listarProductoConStock (ObjectContainer db) {
			System.out.println("Ingrese Stock Minimo ");
		 	float min = Float.parseFloat(miScanner.nextLine());
		 	System.out.println("Ingrese Stock Maximo ");
		 	float max = Float.parseFloat(miScanner.nextLine());
		 	
		 	Query qryPro = db.query();
		 	qryPro.constrain(Producto.class);
		 	qryPro.descend("stock").constrain(min).greater().and(qryPro.descend("stock").constrain(max).smaller());
		 	ObjectSet<Producto> resultProductos = qryPro.execute();
		 	System.out.println("Productos Con Stock mayor a : "+min + "  y menor a : "+max);
		 	System.out.println("");
		 	if (resultProductos.size()>0) {
			 	listar(resultProductos);	
		 	}else {
		 		System.out.println("No hay Productos con Stock dado");
		 		  }
		}
		
		public static void listarDetallesFactura(ObjectContainer db) {
		 	System.out.println("Ingrese Id Factura que desea Saber los Detalles ");
		 	int idFactura = Integer.parseInt(miScanner.nextLine());
		    
		    Query qryDet = db.query();
		 	qryDet.constrain(Detalle.class);
		 	qryDet.descend("idFactura").descend("idFactura").constrain(idFactura);
		 	ObjectSet<Factura> resultDetalles = qryDet.execute();
		 	System.out.println("Facturas Del Cliente : "+ idFactura);
		 	System.out.println("");
		 	
		 	if (resultDetalles.size()>0) {
			 	listar(resultDetalles);	
		 	}else {
		 		System.out.println("No hay Detalles Para Id Ingresado");
		 		  }
			
		}
}
