package operacao;

/**
 * Implementação das operações matemáticas para matrizes de mesmo tamanho. Esta
 * enumeração centraliza a lógica de cálculo, símbolos e elementos neutros.
 * 
 * @author joaopazvdo
 */
public enum OperacaoMatrizes implements Operacao<Double[][]> {

	MULTIPLICACAO("*", 1.0) {

		/**
		 * Realiza a multiplicação de duas matrizes
		 * 
		 * @param v1 Primeira matriz
		 * @param v2 Segunda matriz
		 * @return O resultado da multiplicação
		 * @throws IllegalArgumentException Se as matrizes tem dimensões diferentes.
		 * @throws ArrayIndexOutOfBoundsException Se alguma matriz for vazia.
		 * @throws NullPointerException Se alguma matriz for vazia.s
		 */
		@Override
		public Double[][] faz(Double[][] v1, Double[][] v2) {
			verificaMatrizQuadrada(v1);
			verificaMatrizQuadrada(v2);
			verificaTamMatrizez(v1, v2);

			int linhas1 = v1.length;
			int colunas1 = v1[0].length;

			int linhas2 = v2.length;
			int colunas2 = v2[0].length;

			Double[][] produto = new Double[linhas1][colunas2];

			for (int lin = 0; lin < linhas1; lin++) {
				for (int col = 0; col < colunas2; col++) {
					produto[lin][col] = 0.0;
					for (int k = 0; k < colunas1; k++) {
						produto[lin][col] += v1[lin][k] * v2[k][col];
					}
				}
			}

			return produto;
		}
	},

	SOMA("+", 0.0) {

		/**
		 * Realiza a soma de duas matrizes.
		 * 
		 * @param v1 Primeira matriz
		 * @param v2 Segunda matriz
		 * @return O resultado da multiplicação
		 * @throws IllegalArgumentException Se as matrizes tem dimensões diferentes.
		 * @throws ArrayIndexOutOfBoundsException Se alguma matriz for vazia.
		 * @throws NullPointerException Se alguma matriz for vazia.
		 */
		@Override
		public Double[][] faz(Double[][] v1, Double[][] v2) {
			verificaTamMatrizez(v1, v2);
			Double[][] soma = new Double[v1.length][v1[0].length];
			for (int lin = 0; lin < soma.length; lin++) {
				for (int col = 0; col < soma[lin].length; col++) {
					soma[lin][col] = v1[lin][col] + v2[lin][col];
				}
			}

			return soma;
		}
	};

	private String operador;

	private Double identidade;

	private OperacaoMatrizes(String operador, Double identidade) {
		this.operador = operador;
		this.identidade = identidade;
	}

	private Double getIdentidade() {
		return identidade;
	}

	/**
	 * Uma matriz de mesmas dimensões, elemento neutro ou identidade da operação.
	 * 
	 * @param matriz a ser comparada.
	 * @return O elemento identidade referente a matriz passada.
	 */
	@Override
	public Double[][] getIdentidade(Double[][] matriz) {
		Double[][] retorno = new Double[matriz.length][matriz[0].length];

		for (int lin = 0; lin < matriz.length; lin++) {
			for (int col = 0; col < matriz[0].length; col++) {
				if (lin == col)
					retorno[lin][col] = getIdentidade();
				else
					retorno[lin][col] = 0.0;
			}
		}

		return retorno;
	}

	/** {@inheritDoc} */
	@Override
	public boolean operadorEquals(String outroOperador) {
		return operador.equals(outroOperador);
	}

	/**
	 * Verifica se as matrizes tem as dimensões iguais.
	 * 
	 * @param v1 Primeira matriz
	 * @param v2 Segunda matriz
	 * @throws IllegalArgumentException Se as matrizes tem dimensões diferentes.
	 * @throws ArrayIndexOutOfBoundsException Se alguma matriz for vazia.
	 * @throws NullPointerException Se alguma matriz for vazia.

	 */
	public void verificaTamMatrizez(Double[][] v1, Double[][] v2) {
		try {
			int numLinhas1 = v1.length;
			int numColunas1 = v1[0].length;

			int numLinhas2 = v2.length;
			int numColunas2 = v2[0].length;

			if (numColunas1 == 0 || numColunas2 == 0) {
				throw new NullPointerException("Matriz vazia não permitido");
			}
			if (numLinhas1 != numLinhas2 || numColunas1 != numColunas2) {
				throw new IllegalArgumentException(
						"Matrizes de tamanhos diferentes não formam grupo com multiplicação.");
			}
		} catch (ArrayIndexOutOfBoundsException ae) {
			throw new ArrayIndexOutOfBoundsException("Matriz vazia não permitido");
		}
	}

	/**
	 * Verifica se a matriz é quadrada.
	 * 
	 * @param matriz
	 * @throws IllegalArgumentException Se a matriz não for quadrada.
	 */
	public void verificaMatrizQuadrada(Double[][] matriz) {
		if (matriz[0].length != matriz.length) {
			throw new IllegalArgumentException("Matrizes não quadradas não formam grupo com multiplicação");
		}
	}
}
