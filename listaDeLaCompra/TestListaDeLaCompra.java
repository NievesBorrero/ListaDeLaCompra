package estructurasIII.listaDeLaCompra;

import utiles.Menu;
import utiles.Teclado;

/**
 * 8.2. Genera un interfaz con el usuario que permita entre otras acciones:
*	e. Añadir un producto nuevo a la lista.
*	f. Eliminar un elemento de la lista.
*	g. Incrementar las existencias de un artículo.
*	h. Decrementar las existencias de un artículo.
*	i. Modificar la cantidad mínima del artículo.
*	j. Mostrar la lista de todos los artículos.
*	k. Mostrar la lista de la compra.
 * @author Nieves Borrero Barea.
 *
 */
public class TestListaDeLaCompra {
	static ListaDeLaCompra listaDeLaCompra;
	
	public static void main(String[] args) {
		Menu menu= new Menu("OPCIONES:", new String[]{"Añadir a la nevera",
				"Eliminar de la nevera", "Comprar", "consumir", 
				"Modificar cantidad minima de un producto","Mostrar nevera",
				"Mostrar lista de la compra","Salir" });
		listaDeLaCompra= new ListaDeLaCompra();
		deseaPregenerar();
		int opcion;
		 do{
			switch(opcion=menu.gestionar()){
			 	case 1: añadirProducto(); break;
			 	case 2: eliminarProducto();break;
			 	case 3: comprarProducto();break;
			 	case 4: consumirProducto();break;
			 	case 5: modificarMinimoProducto(); break;
			 	case 6: mostrarNevera(); break;
			 	case 7: mostrarListaDeLaCompra(); break;
			 	case 8: System.out.println("Hasta otra");break;
			}
		 }while(opcion!=8);
		}//main

	private static void modificarMinimoProducto() {
		boolean boleano=listaDeLaCompra.modificarMinimo(Teclado.leerEntero("Codigo del elemento:"),
	 			Teclado.leerEntero("Minimo:"));
		if(boleano==false)
			System.out.println("No ha sido posible");
	}

	private static void mostrarListaDeLaCompra() {
		System.out.println(listaDeLaCompra.mostrarLista());	
	}

	private static void mostrarNevera() {
		System.out.println(listaDeLaCompra.toString());	
	}

	private static void consumirProducto() {
		boolean boleano=listaDeLaCompra.consumir(Teclado.leerEntero("Codigo del elemento a consumir"),
	 			Teclado.leerEntero("Cantidad:"));
		if(boleano==false)
			System.out.println("No ha sido posible");
		
	}

	private static void comprarProducto() {
		boolean boleano=listaDeLaCompra.comprar(Teclado.leerEntero("Codigo del elemento a comprar"),
				Teclado.leerEntero("Cantidad:"));
		if(boleano==false)
			System.out.println("No ha sido posible realizar la compra");
	}

	private static void eliminarProducto(){
		boolean boleano=listaDeLaCompra.remove(Teclado.leerEntero("Introduce el codigo del elemento a borrar:"));
		if(boleano==false)
			System.out.println("El articulo no existe");
	}

	private static void añadirProducto() {
		Articulo articulo;
		String nombre;
		int existencias;
		int minimo;
		do{
			System.out.println("Introduce un producto:");
			nombre=Teclado.leerCadena("Nombre:");
			existencias=Teclado.leerEntero("Existencias:");
			minimo=Teclado.leerEntero("Minimo:");
			articulo=listaDeLaCompra.añadirProducto(nombre,existencias,minimo);
			if(articulo==null){
				System.out.println("Ese producto ya existe o los valores introducidos no son válidos");
			}
		}while(articulo==null);
		
	}
	
	private static void deseaPregenerar(){
		boolean boleano=false;
		do{
			switch(Teclado.leerCaracter("Desea pregenerar los productos?")){
			case 's':
			case 'S': boleano=true; pregenerarProductos();break;
			case 'n':
			case 'N': boleano=true; break;
			default:boleano=false;
			}
		}while(boleano==false);
		
		}
	

	private static void pregenerarProductos() {
		listaDeLaCompra.añadirProducto("Cerveza", 10, 5);
		listaDeLaCompra.añadirProducto("Queso", 3, 2);
		listaDeLaCompra.añadirProducto("york", 4, 2);
		listaDeLaCompra.añadirProducto("platanos", 8, 4);
		listaDeLaCompra.añadirProducto("naranjas", 8, 4);
		listaDeLaCompra.añadirProducto("huevos", 12, 4);
		listaDeLaCompra.añadirProducto("espinacas", 4, 2);
		listaDeLaCompra.añadirProducto("pizza", 4, 2);
		listaDeLaCompra.añadirProducto("Bacon", 5, 2);
		listaDeLaCompra.añadirProducto("mantequilla", 5, 2);
	}
}//class
