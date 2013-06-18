package semThreads;

import java.util.Scanner;

public class MultiplicaMatriz {
	
	private Integer matriz1[][];
	private Integer matriz2[][];
	private Scanner leitura; 
	private Integer linhaMatriz1;
	private Integer colunaMatriz1;
	private Integer linhaMatriz2;
	private Integer colunaMatriz2;
	private Integer matrizResultante[][];
	
	public MultiplicaMatriz(int linhaMatriz1, int colunaMatriz1, int linhaMatriz2, int colunaMatriz2) {
		this.linhaMatriz1 = linhaMatriz1;
		this.colunaMatriz1 = colunaMatriz1;
		this.linhaMatriz2 = linhaMatriz2;
		this.colunaMatriz2 = colunaMatriz2;
		this.matriz1 = new Integer[this.linhaMatriz1][this.colunaMatriz1];
		this.matriz2 = new Integer[this.linhaMatriz2][this.colunaMatriz2];
		this.leitura = new Scanner(System.in);
	}
	
	public void povoarMatriz(){
		
		for (int indiceLinha = 0; indiceLinha < linhaMatriz1; indiceLinha++) {

			for (int indiceColuna = 0; indiceColuna < colunaMatriz1; indiceColuna++) {
				
				System.out.printf("Digite o elemento: " + indiceLinha + ":" + indiceColuna + " da matriz 1!");
				matriz1[indiceLinha][indiceColuna] = leitura.nextInt();
			}
			
		}
		
		for (int indiceLinha = 0; indiceLinha < linhaMatriz2; indiceLinha++) {

			for (int indiceColuna = 0; indiceColuna < colunaMatriz2; indiceColuna++) {
				
				System.out.printf("Digite o elemento: " + indiceLinha + ":" + indiceColuna + " da matriz 2!");
				matriz2[indiceLinha][indiceColuna] = leitura.nextInt();
			}
			
		}
	}
	
	public void multiplicar(){
		matrizResultante = new Integer[linhaMatriz1][colunaMatriz2];
		povoarMatrizResultante();
		
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	            
	            for (int inner = 0; inner < colunaMatriz2+1; inner++) {
	                matrizResultante[linha][coluna] += matriz1[linha][inner] * matriz2[inner][coluna];
	            }  
	        }
	    }
		
		this.imprimirMatriz();
	}
	
	private void imprimirMatriz(){
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	
	        	System.out.print(matrizResultante[linha][coluna]+ " ");
	        	
	        }
	        System.out.println(" ");
		}
	}
	
	private void povoarMatrizResultante(){
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	matrizResultante[linha][coluna] = 0;
	        }
		}
	}


}
