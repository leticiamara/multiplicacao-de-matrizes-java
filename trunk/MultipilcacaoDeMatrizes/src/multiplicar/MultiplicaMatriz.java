package multiplicar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import threads.ThreadMultiplicacao;

public class MultiplicaMatriz {
	
	private Integer matriz1[][];
	private Integer matriz2[][];
	private Integer linhaMatriz1;
	private Integer colunaMatriz1;
	private Integer linhaMatriz2;
	private Integer colunaMatriz2;
	private Integer matrizResultante[][];
	private Integer matrizResultanteComThread[][];
	private Integer matrizResultanteComThreadAborgadem2[][];
	private ArrayList<Thread> threads;
	private ArrayList<Thread> threads2;
	
	public MultiplicaMatriz(int linhaMatriz1, int colunaMatriz1, int linhaMatriz2, int colunaMatriz2) {
		this.linhaMatriz1 = linhaMatriz1;
		this.colunaMatriz1 = colunaMatriz1;
		this.linhaMatriz2 = linhaMatriz2;
		this.colunaMatriz2 = colunaMatriz2;
		this.matriz1 = new Integer[this.linhaMatriz1][this.colunaMatriz1];
		this.matriz2 = new Integer[this.linhaMatriz2][this.colunaMatriz2];
		this.threads = new ArrayList<Thread>();
		this.threads2 = new ArrayList<Thread>();
	}
	
	public void povoaTodasMatrizesRandomicamente(){
		povoarMatrizRandomicamente(matriz1);
		povoarMatrizRandomicamente(matriz2);
	}
	
	public void povoarMatrizRandomicamente(Integer matriz[][]){
		Random gerador = new Random();
		
		for (int indiceLinha = 0; indiceLinha < linhaMatriz1; indiceLinha++) {
			for (int indiceColuna = 0; indiceColuna < colunaMatriz1; indiceColuna++) {
				int numero = gerador.nextInt(10);
				matriz[indiceLinha][indiceColuna] = numero;
			}
		}
	}
	
	public void multiplicarSemThreads(){
		matrizResultante = new Integer[linhaMatriz1][colunaMatriz2];
		povoarComZeroMatrizResultante(matrizResultante);
		
		long tempoResposta = System.currentTimeMillis();
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	            for (int indiceColunaMatriz1 = 0; indiceColunaMatriz1 < colunaMatriz1; indiceColunaMatriz1++) {
	                matrizResultante[linha][coluna] += matriz1[linha][indiceColunaMatriz1] * matriz2[indiceColunaMatriz1][coluna];
	            }  
	        }
	    }
		tempoResposta = System.currentTimeMillis() - tempoResposta;
		System.out.println("Tempo da matriz sem threads em segundos: "+ tempoResposta);
		//this.imprimirMatriz(matrizResultante);
	}
	
	public void multiplicarComThreads(){
		matrizResultanteComThread = new Integer[linhaMatriz1][colunaMatriz2];
		povoarComZeroMatrizResultante(matrizResultanteComThread);
		
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	ThreadMultiplicacao thread = new ThreadMultiplicacao(linha, coluna, colunaMatriz1, matriz1, 
	        			matriz2, matrizResultanteComThread);
	        	threads.add(thread);
	        }
	    }
		
		long tempoResposta = System.currentTimeMillis();
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
		tempoResposta = System.currentTimeMillis() - tempoResposta;
		System.out.println("Tempo da matriz com threads em milisegundos: "+ tempoResposta);
		//this.imprimirMatriz(matrizResultanteComThread);
	}
	
	public void multiplicarMatrizComThreadsSegundaAbordagem(){
		matrizResultanteComThreadAborgadem2 = new Integer[linhaMatriz1][colunaMatriz2];
		povoarComZeroMatrizResultante(matrizResultanteComThreadAborgadem2);
		
		for (int linha = 0; linha < linhaMatriz1; linha++) {
			ThreadMultiplicacaoSegundaAbordagem thread2 = new ThreadMultiplicacaoSegundaAbordagem(linha, colunaMatriz1, 
					colunaMatriz2, matriz1, matriz2, matrizResultanteComThreadAborgadem2);
			threads2.add(thread2);
		}
		
		long tempoResposta = System.currentTimeMillis();
		for (Thread thread : threads2) {
			thread.start();
		}
		
		for (Thread thread : threads2) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		tempoResposta = System.currentTimeMillis() - tempoResposta;
		System.out.println("Tempo da matriz com threads sehunda abordagem em milisegundos: "+ tempoResposta);
		//imprimirMatriz(matrizResultanteComThreadAborgadem2);
	}
	
	private void imprimirMatriz(Integer matriz[][]){
		System.out.println("Matriz Resultante: ");
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	System.out.print(matriz[linha][coluna]+ " ");
	        }
	        System.out.println(" ");
		}
	}
	
	private void povoarComZeroMatrizResultante(Integer matriz[][]){
		for (int linha = 0; linha < linhaMatriz1; linha++) {
	        for (int coluna = 0; coluna < colunaMatriz2; coluna++) {
	        	matriz[linha][coluna] = 0;
	        }
		}
	}
	
}
