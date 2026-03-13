package subgrupostester;

import conversor.Conversor;
import java.util.*;

public class SubGruposTester {
	private Conversor conversor = new Conversor();

	public SubGruposTester(){
	}

	public boolean ehSubGrupoNumerico(String conjuntoOriginal, String operacao, 
		String subConjunto){

		HashSet<Double> conjunto = conversor.paraConjuntoNumerico(conjuntoOriginal);
		HashSet<Double> subConj = conversor.paraConjuntoNumerico(subConjunto);
		Operacao op = OperacaoController.getOperacaoNumerica(operacao);

		SubGrupo SubGrupo = new SubGrupo(conjunto, op, subConj);

		return subGrupo.ehSubGrupo();
	}

	public boolean ehSubGrupoMatriz(String conjuntoOriginal, String operacao,
	 String subConjunto){

		HashSet<Double[][]> conjunto = conversor.paraConjuntoMatriz(conjuntoOriginal);
		HashSet<Double[][]> subConj = conversor.paraConjuntoMatriz(subConjunto);
		Operacao op = OperacaoController.getOperacaoMatriz(operacao);

		SubGrupo SubGrupo = new SubGrupo(conjunto, op, subConj);

		return subGrupo.ehSubGrupo();

	}


	public boolean ehSubGrupoBinario(String conjuntoOriginal, String operacao,
	 String subConjunto){

	 	HashSet<String> conjunto = conversor.paraConjuntoBinario(conjuntoOriginal);
		HashSet<String> subConj = conversor.paraConjuntoBinario(subConjunto);
		Operacao op = OperacaoController.getOperacaoBinaria(operacao);

		SubGrupo SubGrupo = new SubGrupo(conjunto, op, subConj);

		return subGrupo.ehSubGrupo();

	}

	public boolean ehSubGrupoMod(String conjuntoOriginal, String operacao,
	 String subConjunto){

	 	HashSet<Integer> conjunto = conversor.paraConjuntoMod(conjuntoOriginal);
		HashSet<Integer> subConj = conversor.paraConjuntoMod(subConjunto);
		Operacao op = OperacaoController.getOperacaoClasseCongruencia(operacao);

		SubGrupo SubGrupo = new SubGrupo(conjunto, op, subConj);

		return subGrupo.ehSubGrupo();
	}
}
