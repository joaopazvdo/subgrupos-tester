package operacao;

/**
 * Controlador das operações.
 * 
 * @author joaopazvdo
 */
public class OperacaoController {
	
	/**
	 * @param operacao
	 * @return Operacao de reais referente ao operacao
	 */
	public static Operacao<Double> getOperacaoNumerica(String operacao) {
		return OperacaoReais.valueOf(operacao.toUpperCase());
	}
	
	/**
	 * @param operacao
	 * @return Operacao de números em base 2 referente ao operacao
	 */
	public static Operacao<Integer> getOperacaoBinaria(String operacao) {
		return OperacaoBinario.valueOf(operacao.toUpperCase());
	}
	
	/**
	 * @param operacao
	 * @return Operacao de matriz referente ao operacao
	 */
	public static Operacao<Double[][]> getOperacaoMatriz(String operacao) {
		return OperacaoMatrizes.valueOf(operacao.toUpperCase());
	}
	
	/**
	 * @param operacao
	 * @return Operacao de classes de congruência referente ao operacao
	 */
	public static Operacao<String> getOperacaoMod(String operacao) {
		return OperacaoMod.valueOf(operacao.toUpperCase());
	}
}
