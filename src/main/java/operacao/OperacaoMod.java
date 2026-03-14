package operacao;

public enum OperacaoMod implements Operacao<String> {

	MULTIPLICACAO("*", 1) {
	
		@Override
		public String faz(String v1, String v2) {
			String[] operando1_mod1 = v1.split(" mod ");
			int operando1 = Integer.parseInt(operando1_mod1[0]);
			int mod1 = Integer.parseInt(operando1_mod1[1]);
			
			String[] operando2_mod2 = v2.split(" mod ");
			int operando2 = Integer.parseInt(operando2_mod2[0]);
//			int mod2 = Integer.parseInt(operando2_mod2[1]);
			
			int resultado = (operando1 * operando2) % mod1;
			return resultado + " mod " + mod1;
		}
	},
	
	SOMA("+", 0) {
		
		@Override
		public String faz(String v1, String v2) {
			String[] operando1_mod1 = v1.split(" mod ");
			int operando1 = Integer.parseInt(operando1_mod1[0]);
			int mod1 = Integer.parseInt(operando1_mod1[1]);
			
			String[] operando2_mod2 = v2.split(" mod ");
			int operando2 = Integer.parseInt(operando2_mod2[0]);
//			int mod2 = Integer.parseInt(operando2_mod2[1]);
			
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
	
	@Override
	public String getIdentidade(String v) {
		return identidade + " mod 6";
	}
	
	@Override
	public boolean operadorEquals(String outroOperador) {
		return this.operador.equals(outroOperador);
	}
}
