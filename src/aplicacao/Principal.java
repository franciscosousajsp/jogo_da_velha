package aplicacao;

import java.util.Scanner;

import entidade.Velha;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Velha velha = new Velha();

		velha.prencherMatriz();
		velha.exibirMatriz();

		do {
			System.out.println("");
			System.out.print("Escreva o valor para " + velha.getMarcador() + ":  ");
			int valor = sc.nextInt();
			velha.jogarVelha(valor);

			if (velha.getJogadas() == 9) {
				System.out.println("");
				System.out.println("   Não houve Vencedor!");
			}
			if (velha.isVencedor()) {
				System.out.println("");
				System.out.println("O Jogador  " + velha.getMarcador() + " Venceu o Jogo ");
			}
		} while (!velha.isVencedor() && velha.getJogadas() < 9);

		sc.close();
	}
	
}
