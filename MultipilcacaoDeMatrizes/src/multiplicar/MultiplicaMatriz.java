package multiplicar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import threads.ThreadMultiplicacao;

public class MultiplicaMatriz {
	
	private Integer matriz1[][];
	private Integer matriz2[][];
	private Scanner leitura; 
	private Integer linhaMatriz1;
	private Integer colunaMatriz1;
	private Integer linhaMatriz2;
	private Integer colunaMatriz2;
	private Integer matrizResultante[][];
	private Integer matrizResultanteComThread[][];
	private ArrayList<Thread> threads;
	
	public MultiplicaMatriz(int linhaMatriz1, int colunaMatriz1, int linhaMatriz2, int colunaMatriz2) {
		this.linhaMatriz1 = linhaMatriz1;
		this.colunaMatriz1 = colunaMatriz1;
		this.linhaMatriz2 = linhaMatriz2;
		this.colunaMatriz2 = colunaMatriz2;
		this.matriz1 = new Integer[this.linhaMatriz1][this.colunaMatriz1];
		this.matriz2 = new Integer[this.linhaMatriz2][this.colunaMatriz2];
		this.threads = new ArrayList<Thread>();
	}
	
	public void povoarMatrizRandomicamente(){
		Random gerador = new Random();
		
		//Povoando matriz 1
		for (int indiceLinha = 0; indiceLinha < linhaMatriz1; indiceLinha++) {
			for (int indiceColuna = 0; indiceColuna < colunaMatriz1; indiceColuna++) {
				int numero = gerador.nextInt(10);
				matriz1[indiceLinha][indiceColuna] = numero;
			}
		}
		
		//Povoando matriz 2
		for (int indiceLinha = 0; indiceLinha < linhaMatriz2; indiceLinha++) {
			for (int indiceColuna = 0; indiceColuna < colunaMatriz2; indiceColuna++) {
				int numero2 = gerador.nextInt(10);
				matriz2[indiceLinha][indiceColuna] = numero2;
			}
		}
		imprimirMatrizes1e2Preenchidas();
	}
	
	public void imprimirMatrizes1e2Preenchidas(){
		
		//Imprimindo matriz 1
		System.out.println("Matriz 1");
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz1; coluna++) {
	        	System.out.print(matriz1[linha][coluna]+ " ");
	        }
	        System.out.println(" ");
		}
		
		//Imprimindo matriz 2
		System.out.println("Matriz 2");
		for (int linha = 0; linha < linhaMatriz2; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	System.out.print(matriz2[linha][coluna]+ " ");
	        }
	        System.out.println(" ");
		}
	}
	
	public void multiplicarSemThreads(){
		matrizResultante = new Integer[linhaMatriz1][colunaMatriz2];
		povoarComZeroMatrizResultante();
		
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	            for (int indiceColunaMatriz1 = 0; indiceColunaMatriz1 < colunaMatriz1; indiceColunaMatriz1++) {
	                matrizResultante[linha][coluna] += matriz1[linha][indiceColunaMatriz1] * matriz2[indiceColunaMatriz1][coluna];
	            }  
	        }
	    }
		this.imprimirMatrizResultante();
	}
	
	public void multiplicarComThreads(){
		matrizResultanteComThread = new Integer[linhaMatriz1][colunaMatriz2];
		povoarComZeroMatrizResultanteComThreads();
		
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	ThreadMultiplicacao thread = new ThreadMultiplicacao(linha, coluna, colunaMatriz1, matriz1, 
	        			matriz2, matrizResultanteComThread);
	        	threads.add(thread);
	        }
	    }
		
		for (Thread thread : threads) {
			thread.start();
		}
		
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.imprimirMatrizResultanteComThreads();
	}
	
	private void imprimirMatrizResultante(){
		System.out.println("Matriz Resultante: ");
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	System.out.print(matrizResultante[linha][coluna]+ " ");
	        }
	        System.out.println(" ");
		}
	}
	
	private void imprimirMatrizResultanteComThreads(){
		System.out.println("Matriz Resultante com Threads: ");
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	System.out.print(matrizResultanteComThread[linha][coluna]+ " ");
	        }
	        System.out.println(" ");
		}
	}
	
	private void povoarComZeroMatrizResultante(){
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	matrizResultante[linha][coluna] = 0;
	        }
		}
	}
	
	private void povoarComZeroMatrizResultanteComThreads(){
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	matrizResultanteComThread[linha][coluna] = 0;
	        }
		}
	}
}
