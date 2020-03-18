/**
 * @author Orlando
 * @author Duane A Bailey, (2001). Recuperado de Java Structure
 * Clase comparable, sacada de canvas y adaptada para la hoja de trabajo 7 de Estructura de datos
 */
public class ComparableAssociation<K extends Comparable<K>,V>
{
	K key;
	V value;
    

    /**
     * Construct a key-value association that can be ordered.
     *
     * @pre key is non-null
     * @post constructs association between a comparable key and a value
     * 
     * @param key The (comparable) key.
     * @param value The (possibly comparable) associated value.
     */
    public ComparableAssociation(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    /**
     * @pre hay una llave
     * @post devuelve la llave
     * @return la llave
     */
    public K getKey() {
		return key;
	}

    /**
     * @pre hay un valor de la llave
     * @post devuelve el valor de la llave
     * @return el valor de lallave
     */

	public V getValue() {
		return value;
	}

	/**
	 * 
	 * @param data
	 * Constructor con parametros
	 */
	public ComparableAssociation(ComparableAssociation<K, V> data) {
		// TODO Auto-generated constructor stub
    	this.key = data.key;
    	this.value = data.value;
	}

	/**
     * Compara si dos llaves son iguales
     *
     * @pre La llave tienen que tener un valor
     * @post Regresa cero si los valores son exactamente iguales, si son distintos, regresa un numero positivo o negativo
     * 
     * @param that, llave que se comparara con la ya existente en el Tree
     * @return 0 si son iguales, numero positivo o negativo si son distintos
     */
    public int compareTo(K that)
    {
        return key.compareTo(that);
    }

    /**
     * Muestra los datos del arbol
     *
     * @post retorna el String de la llave junto con su valor
     * 
     * @return Un String con la llave y su valor
     */
    public String toString()
    {       
        return "Key " + key + " :Value " + value;
    }
}

