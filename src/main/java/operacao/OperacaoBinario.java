package operacao;

/**
 * Implementação das operações matemáticas para números binários.
 * Esta enumeração centraliza a lógica de cálculo, símbolos e elementos neutros.
 * 
 * @author joaopazvdo
 */
public enum OperacaoBinario implements Operacao<Integer> {
	
	MULTIPLICACAO("*", 0b1) {
		
		/**
		* Realiza a multiplicação de dois números binários.
		* @param v1 Primeiro operando.
		* @param v2 Segundo operando.
	 	* @return O produto da multiplicação.
		*/
		@Override
		public Integer faz(Integer v1, Integer v2) {
			Integer produto = v1 * v2;
			return produto;
		}
	},
	
	SOMA("+", 0b0) {
		
		/**
		* Realiza a soma de dois números binários.
		* @param v1 Primeiro operando.
		* @param v2 Segundo operando.
	 	* @return O resultado da operação.
		*/
		@Override
		public Integer faz(Integer v1, Integer v2) {
			int soma = v1 + v2;
			return soma;
		}
	};
	
	private Integer identidade;
	
	private String operador;
	
	private OperacaoBinario(String operador, int identidade) {
		this.operador = operador;
		this.identidade = identidade;
	}
	
	/** {@inheritDoc} 
	 * @param v irrelevante para o resultado
	 */
	@Override
	public Integer getIdentidade(Integer v) {
		return identidade;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean operadorEquals(String outroOperador) {
		return this.operador.equals(outroOperador);
	}
}
