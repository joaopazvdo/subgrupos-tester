package subgrupostester;

import conversor.Conversor;
import java.util.HashSet;

public class SubGruposTester {
	private Conversor conversor = new Conversor();

	public SubGruposTester(){
	}

	/**
	 * Verificação para Grupos Númericos
	 * 
	 * @param conjuntoOriginal que representa um conjunto em forma de String
	 * @param operacao será a operacao usada no conjunto(soma/multiplicao)
	 * @param subConjunto é o subConjunto em formato de String
	 * 
	 * @return irá retorna se o @subConjunto é um sub grupo do conjuntoOriginal com a operacao
	 * */

	public boolean ehSubGrupoNumerico(String conjuntoOriginal, String operacao, 
		String subConjunto){

		HashSet<Double> conjunto = conversor.paraConjuntoNumerico(conjuntoOriginal);
		HashSet<Double> subConj = conversor.paraConjuntoNumerico(subConjunto);
		Operacao op = OperacaoController.getOperacaoNumerica(operacao);

		SubGrupo subGrupo = new SubGrupo(conjunto, op, subConj);

		return subGrupo.ehSubGrupo();
	}

	/**
	 * Verificação para Grupos de Matriz
	 * 
	 * @param conjuntoOriginal que representa um conjunto em forma de String
	 * @param operacao será a operacao usada no conjunto(soma/multiplicao)
	 * @param subConjunto é o subConjunto em formato de String
	 * 
	 * @return irá retorna se o @subConjunto é um sub grupo do conjuntoOriginal com a operacao
	 * */
	public boolean ehSubGrupoMatriz(String conjuntoOriginal, String operacao,
	 String subConjunto){

		HashSet<Double[][]> conjunto = conversor.paraConjuntoMatriz(conjuntoOriginal);
		HashSet<Double[][]> subConj = conversor.paraConjuntoMatriz(subConjunto);
		Operacao op = OperacaoController.getOperacaoMatriz(operacao);

		SubGrupo subGrupo = new SubGrupo(conjunto, op, subConj);

		return subGrupo.ehSubGrupo();

	}


	/**
	 * Verificação para Grupos Binarios
	 * 
	 * @param conjuntoOriginal que representa um conjunto em forma de String
	 * @param operacao será a operacao usada no conjunto(soma/multiplicao)
	 * @param subConjunto é o subConjunto em formato de String
	 * 
	 * @return irá retorna se o @subConjunto é um sub grupo do conjuntoOriginal com a operacao
	 * */
	public boolean ehSubGrupoBinario(String conjuntoOriginal, String operacao,
	 String subConjunto){

	 	HashSet<String> conjunto = conversor.paraConjuntoBinario(conjuntoOriginal);
		HashSet<String> subConj = conversor.paraConjuntoBinario(subConjunto);
		Operacao op = OperacaoController.getOperacaoBinaria(operacao);

		SubGrupo subGrupo = new SubGrupo(conjunto, op, subConj);

		return subGrupo.ehSubGrupo();

	}

	/**
	 * Verificação para Grupos de Classes de Congruencias
	 * 
	 * @param conjuntoOriginal que representa um conjunto em forma de String
	 * @param operacao será a operacao usada no conjunto(soma/multiplicao)
	 * @param subConjunto é o subConjunto em formato de String
	 * 
	 * @return irá retorna se o @subConjunto é um sub grupo do conjuntoOriginal com a operacao
	 * */
	public boolean ehSubGrupoMod(String conjuntoOriginal, String operacao,
	 String subConjunto){

	 	HashSet<Integer> conjunto = conversor.paraConjuntoMod(conjuntoOriginal);
		HashSet<Integer> subConj = conversor.paraConjuntoMod(subConjunto);
		Operacao op = OperacaoController.getOperacaoClasseCongruencia(operacao);

		SubGrupo subGrupo = new SubGrupo(conjunto, op, subConj);

		return subGrupo.ehSubGrupo();
	}
}
