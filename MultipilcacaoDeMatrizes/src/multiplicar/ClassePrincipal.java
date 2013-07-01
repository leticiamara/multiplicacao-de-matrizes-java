package multiplicar;

public class ClassePrincipal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MultiplicaMatriz multiplicaMatriz = new MultiplicaMatriz(500, 500, 500, 500);
		multiplicaMatriz.povoaTodasMatrizesRandomicamente();
		multiplicaMatriz.multiplicarSemThreads();
		multiplicaMatriz.multiplicarComThreads();
		multiplicaMatriz.multiplicarMatrizComThreadsSegundaAbordagem();

	}

}
