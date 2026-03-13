package operacao;

/**
 * Implementação das operações matemáticas para números reais.
 * Esta enumeração centraliza a lógica de cálculo, símbolos e elementos neutros.
 * 
 * @author joaopazvdo
 */
public enum OperacaoReais implements Operacao<Double> {
	
	MULTIPLICACAO("*", 1.0) {
		/** {@inheritDoc} */
		@Override
		public Double faz(Double v1, Double v2) {
			return v1 * v2;
		}
	},
	SOMA("+", 0.0) {
		/** {@inheritDoc} */
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
	
	/** {@inheritDoc} */
	@Override
	public Double getIdentidade(Double v) {
		return identidade;
	}
}
