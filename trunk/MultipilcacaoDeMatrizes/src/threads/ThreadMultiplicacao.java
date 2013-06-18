package threads;

public class ThreadMultiplicacao extends Thread{
	
	private int linhaMatriz1;
	private int colunaMatriz2;
	private int numeroColunasMatriz1;
	private Integer matriz1[][];
	private Integer matriz2[][];
	private Integer matrizResultante[][];
	
	public ThreadMultiplicacao(int linhaMatriz1, int colunaMatriz2, int colunaMatriz1, Integer matriz1[][], 
			Integer matriz2[][], Integer matrizResultante[][]) {
		this.linhaMatriz1 = linhaMatriz1;
		this.colunaMatriz2 = colunaMatriz2;
		this.numeroColunasMatriz1 = colunaMatriz1;
		this.matriz1 = matriz1;
		this.matriz2 = matriz2;
		this.matrizResultante = matrizResultante;
	}

	@Override
	public void run() {
		for(int indiceColunaMatriz1 = 0; indiceColunaMatriz1 < numeroColunasMatriz1; indiceColunaMatriz1++){
			matrizResultante[linhaMatriz1][colunaMatriz2] += matriz1[linhaMatriz1][indiceColunaMatriz1] 
			* matriz2[indiceColunaMatriz1][colunaMatriz2];
		}
	}
}
