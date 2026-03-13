package operacao;

/**
 * Implementação das operações matemáticas para números reais.
 * Esta enumeração centraliza a lógica de cálculo, símbolos e elementos neutros.
 * 
 * @author joaopazvdo
 */
public enum OperacaoReais implements Operacao<Double> {
	
	MULTIPLICACAO("*", 1.0) {
		
		/**
		* Realiza a multiplicação de dois números reais.
		* @param v1 Primeiro operando.
		* @param v2 Segundo operando.
	 	* @return O produto da multiplicação.
		*/
		@Override
		public Double faz(Double v1, Double v2) {
			return v1 * v2;
		}
	},
	SOMA("+", 0.0) {

		/**
		* Realiza a soma de dois números reais.
		* @param v1 Primeiro operando.
		* @param v2 Segundo operando.
	 	* @return O resultado da operação.
		*/
		@Override
		public Double faz(Double v1, Double v2) {
			return v1 + v2;
		}
	};
	
	private String operador;
	
	private Double identidade;
	
	private OperacaoReais(String operador, Double identidade) {
		this.operador = operador;
		this.identidade = identidade;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean operadorEquals(String outroOperador) {
		return operador.equals(outroOperador);
	}
	
	/** {@inheritDoc} 
	 * @param v irrelevante para o resultado
	 */
	@Override
	public Double getIdentidade(Double v) {
		return identidade;
	}
}
