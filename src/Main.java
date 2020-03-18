import java.util.*;
import java.io.*;

/**
 * @author Orlando Cabrera
 * @since 17/03/2020
 * Codigo para leer archivos sacado de: https://blog.openalfa.com/como-leer-un-fichero-de-texto-linea-a-linea-en-java
 * Main
 */
public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap <String,String> tree = new TreeMap<String,String>();
		BinaryTree <String, String> biTree = new BinaryTree<String,String>();
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);
		//Parte del programa que lee el diccionario y lo guarda
		System.out.println("Introduzca el nombre del diccionario (diccionario.txt)");
		String documento;
		documento = teclado.nextLine();
		String key = null;
		String val;
		String linea;
		boolean comprobante;
	    try {
	      FileReader fr = new FileReader(documento);
	      BufferedReader br = new BufferedReader(fr);
	 
	      
	      while((linea = br.readLine()) != null) {
	    	key = "";
    	  	val = "";
    	  	comprobante = false;
	        //System.out.println(linea);
	        for (int i = 0; i<linea.length();i++) {
	        	if (linea.substring(i, i+1).equals(" ")) {
	        		
	        	}
	        	else if (!linea.substring(i, i+1).equals(",")&& comprobante == false && !linea.substring(i, i+1).equals("(")) {
	    			 
	    			 key = key +  linea.substring(i, i+1);
	    			
	    		  }else if (linea.substring(i, i+1).equals(",") ) {
	    			  comprobante = true;
	    		  }
	    		  else if (comprobante == true&&!linea.substring(i, i+1).equals(",")&&!linea.substring(i, i+1).equals(")")) {
	    			  val = val + linea.substring(i, i+1);
	    		  }
	    		  	    		  
	    	  }
	        tree.put(key, val);
	        
	      }	        
	        
	 
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento + ": " + e);
	    }
	    System.out.println("Diccionario: ");
	    for (Map.Entry<String, String> arbol:tree.entrySet())
		{
			System.out.println("Ingles:" + arbol.getKey() + "Traduccion:" + arbol.getValue());
			biTree.add(new ComparableAssociation <String,String> (arbol.getKey(),arbol.getValue()));
		}
	    //Finaliza parte de leer el diccionario
	    //Parte para leer el documento con la oracion
	    System.out.println("Introduzca el nombre del documento con la oracion (texto.txt)");
		String documento2;
		ArrayList<String> lista = new ArrayList <String>();
		documento2 = teclado.nextLine();
		String key2 = null;
	    try {
	      FileReader fr = new FileReader(documento2);
	      BufferedReader br = new BufferedReader(fr);	 
	      while((linea = br.readLine()) != null) {
	    	key2 = "";
	        for (int i = 0; i<linea.length();i++) {	
	        	if (!linea.substring(i, i+1).equals(" ")) {	    			 
	    			 key2 = key2 +  linea.substring(i, i+1);
	    			 
	    		  }else {
	    			  
	    			  lista.add(key2.toLowerCase());
	    			  key2 = "";
	    		  }
	        	
	        	 
	        }
	        
	        lista.add(key2.toLowerCase());
	      }
	        	
	        
	        
	 
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento2 + ": " + e);
	    }
	    
	    //Finaliza parte de leer el documento con la oracion
	    String traduccion = "";
	    for (int i = 0; i < lista.size(); i++) {
	    	System.out.print(lista.get(i) + " ");	    	
        	if (biTree.searchRecursive(lista.get(i))==null) {
        		traduccion = traduccion +"*" + lista.get(i) + "* ";
        		
        	}else if (biTree.searchRecursive(lista.get(i))!=null) {
        		traduccion = traduccion + biTree.searchRecursive(lista.get(i)) + " ";
        		
        	}
        }
	    
	    System.out.println();
	    System.out.println("Traduccion:");
	    System.out.println(traduccion);
	    System.out.println(biTree.toString());
	}
	
	

}
