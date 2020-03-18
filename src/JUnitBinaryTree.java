import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitBinaryTree {
	BinaryTree <String, String> biTree = new BinaryTree<String,String>();
	BinaryTree <String, String> biTree2 = new BinaryTree<String,String>();
	/**
	 * Compruebo que las entradas sean exactamente iguales
	 */
	@Test
	public void testBinaryTree1(){
		biTree.add(new ComparableAssociation <String,String> ("Entrada","Salida"));
		biTree.add(new ComparableAssociation <String,String> ("Entrada2","Salida2"));
		biTree2.add(new ComparableAssociation <String,String> ("Entrada","Salida"));
		biTree2.add(new ComparableAssociation <String,String> ("Entrada2","Salida2"));
		String comprobante = biTree.toString();
		String comprobante2 = biTree2.toString();
		if (comprobante.equals(comprobante2)) {
			assertEquals(1, 1);
		}else {
			assertEquals(2, 1);
		}
		
	}
	/**
	 * Compruebo que las entradas si sean diferentes
	 */
	@Test
	public void testBinaryTree2(){
		biTree.add(new ComparableAssociation <String,String> ("Entrada","Salida"));
		biTree.add(new ComparableAssociation <String,String> ("Entrada2","Salida2"));
		biTree2.add(new ComparableAssociation <String,String> ("Entrada3","Salida3"));
		biTree2.add(new ComparableAssociation <String,String> ("Entrada4","Salida4"));
		String comprobante = biTree.toString();
		String comprobante2 = biTree2.toString();
		if (!comprobante.equals(comprobante2)) {
			assertEquals(1, 1);
		}else {
			assertEquals(2, 1);
		}
		
	}

}
