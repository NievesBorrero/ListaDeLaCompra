package estructurasIII.listaDeLaCompra;

import utiles.Menu;
import utiles.Teclado;

/**
 * 8.2. Genera un interfaz con el usuario que permita entre otras acciones:
*	e. A�adir un producto nuevo a la lista.
*	f. Eliminar un elemento de la lista.
*	g. Incrementar las existencias de un art�culo.
*	h. Decrementar las existencias de un art�culo.
*	i. Modificar la cantidad m�nima del art�culo.
*	j. Mostrar la lista de todos los art�culos.
*	k. Mostrar la lista de la compra.
 * @author Nieves Borrero Barea.
 *
 */
public class TestListaDeLaCompra {
	static ListaDeLaCompra listaDeLaCompra;
	
	public static void main(String[] args) {
		Menu menu= new Menu("OPCIONES:", new String[]{"A�adir a la nevera",
				"Eliminar de la nevera", "Comprar", "consumir", 
				"Modificar cantidad minima de un producto","Mostrar nevera",
				"Mostrar lista de la compra","Salir" });
		listaDeLaCompra= new ListaDeLaCompra();
		deseaPregenerar();
		int opcion;
		 do{
			switch(opcion=menu.gestionar()){
			 	case 1: a�adirProducto(); break;
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

	private static void a�adirProducto() {
		Articulo articulo;
		String nombre;
		int existencias;
		int minimo;
		do{
			System.out.println("Introduce un producto:");
			nombre=Teclado.leerCadena("Nombre:");
			existencias=Teclado.leerEntero("Existencias:");
			minimo=Teclado.leerEntero("Minimo:");
			articulo=listaDeLaCompra.a�adirProducto(nombre,existencias,minimo);
			if(articulo==null){
				System.out.println("Ese producto ya existe o los valores introducidos no son v�lidos");
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
		listaDeLaCompra.a�adirProducto("Cerveza", 10, 5);
		listaDeLaCompra.a�adirProducto("Queso", 3, 2);
		listaDeLaCompra.a�adirProducto("york", 4, 2);
		listaDeLaCompra.a�adirProducto("platanos", 8, 4);
		listaDeLaCompra.a�adirProducto("naranjas", 8, 4);
		listaDeLaCompra.a�adirProducto("huevos", 12, 4);
		listaDeLaCompra.a�adirProducto("espinacas", 4, 2);
		listaDeLaCompra.a�adirProducto("pizza", 4, 2);
		listaDeLaCompra.a�adirProducto("Bacon", 5, 2);
		listaDeLaCompra.a�adirProducto("mantequilla", 5, 2);
	}
}//class
