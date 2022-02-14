package entidade;

public class Velha {

	private String[][] matrizVelha = new String[3][3];
	private boolean vencedor;
	private String marcador = "X";
	int jogadas = 0;

	/*----------------metodos------------------*/
	public void prencherMatriz() {
		int cont = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cont++;
				matrizVelha[i][j] = String.valueOf(cont);

			}
		}
	}

	public void exibirMatriz() {
		System.out.println("   ===================   ");
		System.out.println("      JOGO DA VELHA");
		System.out.println("   ===================   ");

		for (int i = 0; i < 3; i++) {
			if (i > 0) {
				System.out.println("  -------------------");
			}

			for (int j = 0; j < 3; j++) {

				System.out.print("    " + matrizVelha[i][j] + "  ");

				if (j < 2) {
					System.out.print("|");
				}
			}
			System.out.println(" ");
		}

	}

	public void jogarVelha(int valor) {
		int linha;

		if ((valor > 0) && (valor < 10)) {
			if ((valor > 0) && (valor < 4)) {
				linha = 0;
				if (matrizVelha[linha][valor - 1] == "X" || matrizVelha[linha][valor - 1] == "O") {
					System.out.println("Esse valor já está preenchendo");
				} else {
					matrizVelha[linha][valor - 1] = this.marcador;
					this.vencedor = this.verificarVencedor();
					this.trocarJogador();
				}

			}
			if ((valor > 3) && (valor < 7)) {
				linha = 1;
				if (matrizVelha[linha][valor - 4] == "X" || matrizVelha[linha][valor - 4] == "O") {
					System.out.println("Esse valor já está preenchendo");
				} else {
					matrizVelha[linha][valor - 4] = this.marcador;
					this.vencedor = this.verificarVencedor();
					this.trocarJogador();
				}

			}
			if ((valor > 6) && (valor < 10)) {
				linha = 2;
				if (matrizVelha[linha][valor - 7] == "X" || matrizVelha[linha][valor - 7] == "O") {

				} else {
					matrizVelha[linha][valor - 7] = this.marcador;
					this.vencedor = this.verificarVencedor();
					this.trocarJogador();
				}

			}

		} else {
			System.out.println("VALOR INVALIDO");
		}
		System.out.flush();
		exibirMatriz();
	}

	public boolean verificarVencedor() {
		this.vencedor = false;
		for (int i = 0; i < 3; i++) {
			if ((matrizVelha[i][0] == matrizVelha[i][1]) && (matrizVelha[i][1] == matrizVelha[i][2])) {
				this.vencedor = true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if ((matrizVelha[0][i] == matrizVelha[1][i]) && (matrizVelha[1][i] == matrizVelha[2][i])) {
				this.vencedor = true;
			}
		}

		if ((matrizVelha[0][0] == matrizVelha[1][1]) && (matrizVelha[1][1] == matrizVelha[2][2])) {
			this.vencedor = true;
		}

		if ((matrizVelha[0][2] == matrizVelha[1][1]) && (matrizVelha[1][1] == matrizVelha[2][0])) {
			this.vencedor = true;
		}

		return this.vencedor;
	}

	public void trocarJogador() {

		if (!this.vencedor) {
			if (this.jogadas % 2 != 0) {
				this.marcador = "X";
			} else {
				this.marcador = "O";
			}

		}

		jogadas++;
	}

	/*-----------getter setter----------------*/
	public boolean isVencedor() {
		return vencedor;
	}

	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}

	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}

	public int getJogadas() {
		return jogadas;
	}

	public void setJogadas(int jogadas) {
		this.jogadas = jogadas;
	}
}
