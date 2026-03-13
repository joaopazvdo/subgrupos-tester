package operacao;

/**
 * Implementação das operações matemáticas para números binários.
 * Esta enumeração centraliza a lógica de cálculo, símbolos e elementos neutros.
 * 
 * @author joaopazvdo
 */
public enum OperacaoBinario implements Operacao<String> {
	
	MULTIPLICACAO("*", 1) {
		
		/**
		* Realiza a multiplicação de dois números binários.
		* @param v1 Primeiro operando.
		* @param v2 Segundo operando.
	 	* @return O produto da multiplicação.
		 */
		@Override
		public String faz(String v1, String v2) {
			int bin1 = Integer.parseInt(v1, 2);
			int bin2 = Integer.parseInt(v2, 2);
			
			int produto = bin1 * bin2;
			return Integer.toBinaryString(produto);
		}
	},
	
	SOMA("+", 0) {
		
		/**
		* Realiza a soma de dois números binários.
		* @param v1 Primeiro operando.
		* @param v2 Segundo operando.
	 	* @return O resultado da operação.
		 */
		@Override
		public String faz(String v1, String v2) {
			int bin1 = Integer.parseInt(v1, 2);
			int bin2 = Integer.parseInt(v2, 2);
			
			int soma = bin1 + bin2;
			return Integer.toBinaryString(soma);
		}
	};
	
	private int identidade;
	
	private String operador;
	
	private OperacaoBinario(String operador, int identidade) {
		this.operador = operador;
		this.identidade = identidade;
	}
	
	/** {@inheritDoc} */

	@Override
	public String getIdentidade(String v) {
		return Integer.toBinaryString(identidade);
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean operadorEquals(String outroOperador) {
		return this.operador.equals(outroOperador);
	}
}
