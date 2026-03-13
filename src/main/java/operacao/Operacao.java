package operacao;

/**
 * Define o contrato para operações matemáticas.
 *
 * @param <T> O tipo numérico ou objeto sobre o qual a operação será realizada.
 * @author joaopazvdo
 */
public interface Operacao<T> {
	
	/**
	 * Realiza o cálculo da operação entre dois operandos.
	 * @param v1 Primeiro operando.
	 * @param v2 Segundo operando.
	 * @return O resultado da operação.
	 */
	public T faz(T v1, T v2);
	
	/**
	 * Retorna o elemento identidade (ou neutro) da operação.
	 * @return O valor de identidade da operação.
	 */
	public T getIdentidade();
	
	/**
	 * Verifica se a representação textual fornecida corresponde ao símbolo 
	 * deste operador.
	 * @param outroOperador String representando o operador a ser comparado.
	 * @return {@code true} se corresponder, {@code false} caso contrário.
	 */
	public boolean operadorEquals(String outroOperador);
}
