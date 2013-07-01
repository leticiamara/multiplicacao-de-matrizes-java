package multiplicar;

public class ThreadMultiplicacaoSegundaAbordagem extends Thread{
	
	private int linhaMatriz1;
	private int colunaMatriz2;
	private int colunaMatriz1;
	private Integer matriz1[][];
	private Integer matriz2[][];
	private Integer matrizResultante[][];
	
	public ThreadMultiplicacaoSegundaAbordagem(int linhaMatriz1, int colunaMatriz1, int colunaMatriz2, 
			Integer matriz1[][], Integer matriz2[][], Integer matrizResultante[][]) {
		this.linhaMatriz1 = linhaMatriz1;
		this.colunaMatriz2 = colunaMatriz2;
		this.colunaMatriz1 = colunaMatriz1;
		this.matriz1 = matriz1;
		this.matriz2 = matriz2;
		this.matrizResultante = matrizResultante;
		
	}
	
	@Override
	public void run() {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	for (int indiceColunaMatriz1 = 0; indiceColunaMatriz1 < colunaMatriz1; indiceColunaMatriz1++) {
	                matrizResultante[linhaMatriz1][coluna] += matriz1[linhaMatriz1][indiceColunaMatriz1] * matriz2[indiceColunaMatriz1][coluna]; 
	    		}
	        }
	    
	}

}
