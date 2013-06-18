package semThreads;

public class ClassePrincipal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MultiplicaMatriz multiplicaMatriz = new MultiplicaMatriz(2, 3, 3, 2);
		multiplicaMatriz.povoarMatriz();
		multiplicaMatriz.multiplicar();

	}

}
