package listaDeLaCompra;
/**
 * Clase para crear un objeto artículo
 * @author Nieves Borrero
 *
 */
public class Articulo {
	private int codigo;
	private static int id=1;
	private String nombre;
	private int existencias;
	private int minimo;
	
	/**
	 * Constructor
	 * @param nombre
	 * @param existencias
	 * @param minimo
	 */
	private Articulo( String nombre, int existencias, int minimo){		
		setNombre(nombre);
		setExistencias(existencias);
		setMinimo(minimo);
		setCodigo(codigo);
	}
	/**
	 * Controla que los valores, a la hora de crear el objeto, sean válidos.
	 * @param nombre
	 * @param existencias
	 * @param minimo
	 * @return nuevo articulo 
	 */
	static Articulo getInstance(String nombre, int existencias, int minimo) {
		if (existencias < minimo)
			return null;
		if (minimo<0)
			return null;
		return new Articulo(nombre, existencias, minimo); // Si el minimo no es mayor que las existencias y el
															// minimo es válido, devuelve un nuevo artículo
		}
	
	Articulo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	private void setCodigo(int codigo) {
		this.codigo =id++;
	}
	
	String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	int getExistencias() {
		return existencias;
	}
	/**
	 * Modifica el nº de existencias
	 * @param int (existencias)
	 * @return true o false si no ha podido modificarlo porque existencias 
	 * sea un valor inválido.
	 */
	private boolean setExistencias(int existencias) {
		if(existencias<0)
			return false;
		this.existencias = existencias;
		return true;
	}

	int getMinimo() {
		return minimo;
	}
	/**
	 * Permite modificar el mínimo del artículo
	 * @param minimo
	 * @return boolean
	 */
	boolean setMinimo(int minimo) {
		if(minimo<0)
			return false;
		this.minimo = minimo;
		return true;
	}
	/**
	 * Disminuye el nº de existencias
	 * @param int (Cantidad de productos que se consumen)
	 * @return boolean
	 */
	
	boolean consumir(int cantidad){
		if(cantidad<0)
			return false;//Si la cantidad es negativa, no puede consumir
		if(!setExistencias(getExistencias()-cantidad)){//si el setExistencias me devuelve false
		setExistencias(0); 								//porque pretende comer más de lo que hay
		return false;
		}
		return true;//Si puede consumir sin problemas
	}
	
	/**
	 * Aumenta el nº de existencias
	 * @param int (Cantidad de productos que se compran)
	 * @return boolean
	 */
	boolean comprar(int cantidad){
		if(cantidad<=0) return false;
			return setExistencias(getExistencias()+cantidad);
	}

	@Override
	public String toString() {
		return "Producto: "+nombre+", Codigo: "+codigo+", Existencias: "+existencias
				+", Minimo: "+minimo;
	}

}
