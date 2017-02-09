package estructurasIII.listaDeLaCompra;

import java.util.ArrayList;

/**
 * 8.ListaDeLaCompra. Implementa un programa que gestione una lista de la compra
 * de forma automática. Se dispondrá de una lista de artículos y de sus
 * existencias. En el momento en el que la cantidad de artículos llegue a un
 * límite mínimo, dicho artículo aparecerá en la lista de la compra. Cada vez
 * que el usuario utilice uno de los artículos se decrementarán las existencias
 * de dicho artículo. De igual forma, cada vez que el usuario compre el
 * artículo, se incrementarán las existencias de dicho artículo.Quizás sea
 * interesante añadir un campo código del artículo para facilitar la gestión de
 * la lista. Este código ha de ser único (static...) Para ello, genera un
 * interfaz con el usuario que permita entre otras acciones:
 * e. Añadir un producto nuevo a la lista. 
 * f. Eliminar un elemento de la lista. 
 * g.Incrementar las existencias de un artículo. 
 * h. Decrementar las existencias de un artículo. 
 * i. Modificar la cantidad mínima del artículo. 
 * j. Mostrar la lista de todos los artículos. 
 * k. Mostrar la lista de la compra.
 * 
 * @author Nieves Borrero
 * @version 1.0
 */
public class ListaDeLaCompra {
	
	private ArrayList<Articulo> nevera;

	/**
	 * Constructor que crea una lista de la compra vacía.
	 */
	ListaDeLaCompra() {
		setNevera(new ArrayList<Articulo>());
	}

	/**
	 * Elimina un producto de la nevera, a partir de su código
	 * @param index
	 * @return true si se ha eliminado el elemento, false si no (si el índice
	 * introducido no es válido).
	 */
	boolean remove(int codigo) {
		Articulo articulo = new Articulo(codigo); 
		if (!getNevera().contains(articulo)||getNevera().isEmpty())//Si no contiene el artículo o la nevera está vacía
			return false;
		Articulo producto = getNevera().get(getNevera().indexOf(articulo));
		// Producto= de la nevera (getNevera(), el objeto con el índice de artículo 
		return getNevera().remove(producto);
	}

	/**
	 * Permite comprar la cantidad deseada de un producto
	 * @param index
	 * @param cantidad
	 * @return boolean
	 */
	boolean comprar(int codigo, int cantidad) {
		Articulo articulo = new Articulo(codigo); 
		if (!getNevera().contains(articulo)||getNevera().isEmpty()) //Si no contiene el artículo o la nevera está vacía.
			return false;
		Articulo producto = getNevera().get(getNevera().indexOf(articulo));
		// Producto= de la nevera (getNevera(), el objeto con el índice de artículo 
		return producto.comprar(cantidad);
	}

	private ArrayList<Articulo> getNevera() {
		return nevera;
	}

	private void setNevera(ArrayList<Articulo> nevera) {
		this.nevera = nevera;
	}

	/**
	 * Permite consumir la cantidad deseada de un producto
	 * @param index
	 * @param cantidad
	 * @return boolean
	 */
	boolean consumir(int codigo, int cantidad) {		
		Articulo articulo = new Articulo(codigo); 
		if (!getNevera().contains(articulo)||getNevera().isEmpty()) //Si no contiene el artículo o la nevera está vacía.
			return false;
		Articulo producto = getNevera().get(getNevera().indexOf(articulo));
		// Producto= de la nevera (getNevera(), el objeto con el índice de artículo 
		return producto.consumir(cantidad);
	}

	/**
	 * Modifica el mínimo de existencias de un producto
	 * @param int(index)
	 * @param int(minimo)
	 * return boolean
	 */
	boolean modificarMinimo(int codigo, int minimo) {
		Articulo articulo = new Articulo(codigo); 
		if (!getNevera().contains(articulo)||getNevera().isEmpty()) //Si no contiene el artículo o la nevera está vacía
			return false;
		Articulo producto = getNevera().get(getNevera().indexOf(articulo));
		// Producto= de la nevera (getNevera(), el objeto con el índice de artículo 
		return producto.setMinimo(minimo);
	}

	/**
	 * Muestra los productos de la nevera
	 */
	@Override
	public String toString() {
		if(nevera.isEmpty())
			return "La nevera esta vacia!";
		String cadena = "";
		for (Articulo producto : getNevera()) {
			cadena += producto.toString() + "\n";
		}
		return "Nevera:\n" + cadena;
	}
	
	String mostrarLista() {
		String cadena = "";
		for (Articulo producto : getNevera()) {
			if(producto.getExistencias()<=producto.getMinimo())
			cadena += producto.getNombre() + "\n";
		}
		return "Lista de la compra:\n" + cadena;
	}

	/**
	 * Añade un producto a la nevera
	 * @param nombre
	 * @param existencias
	 * @param minimo
	 * @return articulo
	 */
	Articulo añadirProducto(String nombre, int existencias, int minimo) {
		Articulo articulo=Articulo.getInstance(nombre, existencias, minimo);
		for (Articulo producto : getNevera()) {
			if(producto.getNombre().equalsIgnoreCase(nombre))
					return null;
		}
		nevera.add(articulo);
		return articulo;
	}

}// class
