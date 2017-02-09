package estructurasIII.listaDeLaCompra;

import java.util.ArrayList;

/**
 * 8.ListaDeLaCompra. Implementa un programa que gestione una lista de la compra
 * de forma autom�tica. Se dispondr� de una lista de art�culos y de sus
 * existencias. En el momento en el que la cantidad de art�culos llegue a un
 * l�mite m�nimo, dicho art�culo aparecer� en la lista de la compra. Cada vez
 * que el usuario utilice uno de los art�culos se decrementar�n las existencias
 * de dicho art�culo. De igual forma, cada vez que el usuario compre el
 * art�culo, se incrementar�n las existencias de dicho art�culo.Quiz�s sea
 * interesante a�adir un campo c�digo del art�culo para facilitar la gesti�n de
 * la lista. Este c�digo ha de ser �nico (static...) Para ello, genera un
 * interfaz con el usuario que permita entre otras acciones:
 * e. A�adir un producto nuevo a la lista. 
 * f. Eliminar un elemento de la lista. 
 * g.Incrementar las existencias de un art�culo. 
 * h. Decrementar las existencias de un art�culo. 
 * i. Modificar la cantidad m�nima del art�culo. 
 * j. Mostrar la lista de todos los art�culos. 
 * k. Mostrar la lista de la compra.
 * 
 * @author Nieves Borrero
 * @version 1.0
 */
public class ListaDeLaCompra {
	
	private ArrayList<Articulo> nevera;

	/**
	 * Constructor que crea una lista de la compra vac�a.
	 */
	ListaDeLaCompra() {
		setNevera(new ArrayList<Articulo>());
	}

	/**
	 * Elimina un producto de la nevera, a partir de su c�digo
	 * @param index
	 * @return true si se ha eliminado el elemento, false si no (si el �ndice
	 * introducido no es v�lido).
	 */
	boolean remove(int codigo) {
		Articulo articulo = new Articulo(codigo); 
		if (!getNevera().contains(articulo)||getNevera().isEmpty())//Si no contiene el art�culo o la nevera est� vac�a
			return false;
		Articulo producto = getNevera().get(getNevera().indexOf(articulo));
		// Producto= de la nevera (getNevera(), el objeto con el �ndice de art�culo 
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
		if (!getNevera().contains(articulo)||getNevera().isEmpty()) //Si no contiene el art�culo o la nevera est� vac�a.
			return false;
		Articulo producto = getNevera().get(getNevera().indexOf(articulo));
		// Producto= de la nevera (getNevera(), el objeto con el �ndice de art�culo 
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
		if (!getNevera().contains(articulo)||getNevera().isEmpty()) //Si no contiene el art�culo o la nevera est� vac�a.
			return false;
		Articulo producto = getNevera().get(getNevera().indexOf(articulo));
		// Producto= de la nevera (getNevera(), el objeto con el �ndice de art�culo 
		return producto.consumir(cantidad);
	}

	/**
	 * Modifica el m�nimo de existencias de un producto
	 * @param int(index)
	 * @param int(minimo)
	 * return boolean
	 */
	boolean modificarMinimo(int codigo, int minimo) {
		Articulo articulo = new Articulo(codigo); 
		if (!getNevera().contains(articulo)||getNevera().isEmpty()) //Si no contiene el art�culo o la nevera est� vac�a
			return false;
		Articulo producto = getNevera().get(getNevera().indexOf(articulo));
		// Producto= de la nevera (getNevera(), el objeto con el �ndice de art�culo 
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
	 * A�ade un producto a la nevera
	 * @param nombre
	 * @param existencias
	 * @param minimo
	 * @return articulo
	 */
	Articulo a�adirProducto(String nombre, int existencias, int minimo) {
		Articulo articulo=Articulo.getInstance(nombre, existencias, minimo);
		for (Articulo producto : getNevera()) {
			if(producto.getNombre().equalsIgnoreCase(nombre))
					return null;
		}
		nevera.add(articulo);
		return articulo;
	}

}// class
