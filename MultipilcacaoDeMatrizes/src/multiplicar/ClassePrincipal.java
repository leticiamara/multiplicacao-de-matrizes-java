package multiplicar;

public class ClassePrincipal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MultiplicaMatriz multiplicaMatriz = new MultiplicaMatriz(20, 20, 20, 20);
		multiplicaMatriz.povoarMatrizRandomicamente();
		multiplicaMatriz.multiplicarSemThreads();
		multiplicaMatriz.multiplicarComThreads();

	}

}
