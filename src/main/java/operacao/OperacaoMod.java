package operacao;

/**
 * Implementação das operações matemáticas para classes de congruência.
 * Esta enumeração centraliza a lógica de cálculo, símbolos e elementos neutros.
 * 
 * @author joaopazvdo
 */
public enum OperacaoMod implements Operacao<String> {

	MULTIPLICACAO("Multiplicação", 1) {
	
		/**
		* Realiza a multiplicação de duas classes de congruência.
		* @param v1 Primeiro operando.
		* @param v2 Segundo operando.
	 	* @return O produto da multiplicação.
	 	* @throws IllegalArgumentException Se os módulos forem diferentes
		*/
		@Override
		public String faz(String v1, String v2) {
			String[] operando1_mod1 = v1.split(" mod ");
			int operando1 = Integer.parseInt(operando1_mod1[0]);
			int mod1 = Integer.parseInt(operando1_mod1[1]);
			
			String[] operando2_mod2 = v2.split(" mod ");
			int operando2 = Integer.parseInt(operando2_mod2[0]);
			int mod2 = Integer.parseInt(operando2_mod2[1]);
			
			verificaModsDiferentes(mod1, mod2);
			int resultado = (operando1 * operando2) % mod1;
			return resultado + " mod " + mod1;
		}
	},
	
	ADICAO("Adição", 0) {
		
		/**
		* Realiza a soma de duas classes de congruência.
		* @param v1 Primeiro operando.
		* @param v2 Segundo operando.
	 	* @return O resultado da operação.
	 	* @throws IllegalArgumentException Se os módulos forem diferentes
		*/
		@Override
		public String faz(String v1, String v2) {
			String[] operando1_mod1 = v1.split(" mod ");
			int operando1 = Integer.parseInt(operando1_mod1[0]);
			int mod1 = Integer.parseInt(operando1_mod1[1]);
			
			String[] operando2_mod2 = v2.split(" mod ");
			int operando2 = Integer.parseInt(operando2_mod2[0]);
			int mod2 = Integer.parseInt(operando2_mod2[1]);
			
			verificaModsDiferentes(mod1, mod2);
			
			int resultado = (operando1 + operando2) % mod1;
			return resultado + " mod " + mod1;
		}
	};
	
	private Integer identidade;
	
	private String operador;
	
	private OperacaoMod(String operador, int identidade) {
		this.operador = operador;
		this.identidade = identidade;
	}
	
	/**
	 * O elemento identidade ou neutro.
	 * 
	 * @param v um elemento de comparação para saber o módulo.
	 * @return O elemento identidade ou neutro.
	 */
	@Override
	public String getIdentidade(String v) {
		String[] operando_mod = v.split(" mod ");
		int mod = Integer.parseInt(operando_mod[1]);
		return identidade + " mod " + mod;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean operadorEquals(String outroOperador) {
		return this.operador.equals(outroOperador);
	}
	
	/**
	 * @param mod1
	 * @param mod2
	 * @throws IllegalArgumentException Se os módulos forem diferentes
	 */
	public void verificaModsDiferentes(int mod1, int mod2) {
		if (mod1 != mod2) {
			throw new IllegalArgumentException("Operações com mods diferentes inválidas");
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public String getOperador() {
		return operador;
	}
}
