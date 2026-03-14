package operacao;

/**
 * Controlador das operações.
 * 
 * @author joaopazvdo
 */
public class OperacaoController {
	
	/**
	 * @param operador
	 * @return Operacao de reais referente ao operador
	 * @throws IllegalArgumentException Se o operador não existe
	 */
	public static Operacao<Double> getOperacaoNumerica(String operador) {
		for (OperacaoReais or : OperacaoReais.values()) {
			if (or.operadorEquals(operador)) return or;
		}
		throw new IllegalArgumentException("Operador \"" + operador + "\" inválido!");
	}
	
	/**
	 * @param operador
	 * @return Operacao de números em base 2 referente ao operador
	 * @throws IllegalArgumentException Se o operador não existe
	 */
	public static Operacao<Integer> getOperacaoBinaria(String operador) {
		for (OperacaoBinario ob : OperacaoBinario.values()) {
			if (ob.operadorEquals(operador)) return ob;
		}
		throw new IllegalArgumentException("Operador \"" + operador + "\" inválido!");
	}
	
	/**
	 * @param operador
	 * @return Operacao de matriz referente ao operador
	 * @throws IllegalArgumentException Se o operador não existe
	 */
	public static Operacao<Double[][]> getOperacaoMatriz(String operador) {
		for (OperacaoMatrizes om : OperacaoMatrizes.values()) {
			if (om.operadorEquals(operador)) return om;
		}
		throw new IllegalArgumentException("Operador \"" + operador + "\" inválido!");
	}
	
	/**
	 * @param operador
	 * @return Operacao de classes de congruência referente ao operador
	 * @throws IllegalArgumentException Se o operador não existe
	 */
	public static Operacao<String> getOperacaoMod(String operador) {
		for (OperacaoMod om : OperacaoMod.values()) {
			if (om.operadorEquals(operador)) return om;
		}
		throw new IllegalArgumentException("Operador \"" + operador + "\" inválido!");
	}
}
