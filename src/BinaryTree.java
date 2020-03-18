/**
 * 
 */

/**
 * @author Orlando
 * @author Duane A Bailey, (2001). Recuperado de Java Structure
 * @param <K>
 * Clase que modela el arbol binario de busqueda, sacado del libro Java Structure y modificado gracias a la ayuda de muchos ejemplos de internet. Uno de ellos es: https://www.geeksforgeeks.org/binary-tree-data-structure/
 *
 */
public class BinaryTree<K extends Comparable <K> , V>
{
	BinaryTree <K,V> right;
	BinaryTree <K,V> left;
	private ComparableAssociation <K,V> data;
	/**
	 * 
	 * @param data
	 * Constructor con parametros
	 */
	public BinaryTree (ComparableAssociation <K,V> data) {
		this.data = new ComparableAssociation<K,V> (data);
		right = null;
		left = null;
	}
	/**
	 * Constructor sin parametros
	 */
	public BinaryTree () {
		this.data = null;
		right = null;
		left = null;
	}
	
	/**
	 * @post Ingresa la llave junto con su valor en el arbol
	 * @param data
	 */
	public void add(ComparableAssociation <K,V> data) {
		//Si el lugar esta vacio, que coloque en esa posicion el valor
		if (this.data == null) {
			this.data = data;
		}
		//Busca primero por la izquiera
		else if (this.data.compareTo(data.key) < 0) {
			if (left != null) {
				left.add(data);
			}else {
				left = new BinaryTree <K,V>(data);
			}		
		}
		//Busco luego por la derecha
		else if (this.data.compareTo(data.key) > 0) {
			if (right != null) {
				right.add(data);
			}else {
				right = new BinaryTree <K,V>(data);
			}		
		}
		
	}
	/**
	 * @pre el arbol no esta vacio 
	 * @post devuelve el valor de la llave
	 * @param data
	 * @return el valor de la llave que de ingreso o regresa null si no se encuentra la llave
	 */
	public V searchRecursive(K data) {
		
		if (data == null) {
			return null;
		}
		else if (this.data.key.compareTo(data) == 0) {
			return this.data.getValue();
		}
			
		//Busca primero por la izquiera
		else if (this.data.key.compareTo(data) < 0) {
			if (left == null) {
				return null;
			}else {
				return left.searchRecursive(data);	
			}
					
				
		}
			
		//Busco luego por la derecha
		else if (this.data.key.compareTo(data) > 0) {
				
			if (right == null) {
				return null;
			}else {
				return right.searchRecursive(data);	
			}	
				
		}
		
		
		
				
		return null;
	
	
	
	}
	/**
	 * @pre hay por lo menos un valor en el arbol
	 * @post devuelve todos los valores del arbol en el orden In-order
	 */
	public String toString () {
		String resultado = "";
		if (right != null) {
			resultado = resultado + right.toString()+ "\n";
		}
		if (data != null) {
			resultado = resultado + data.toString() + "\n";
		}
		if (left != null) {
			resultado = resultado + left.toString()+ "\n";
		}
		
		
		return resultado;
		
	}
	
	
	
}
