package grupo;

import java.util.HashSet;
import operacao.Operacao;

/**
 * Classe que verifica se um subconjunto H é um subgrupo de G.
 * * @param <T> Tipo dos elementos.
 * @author Viniciusdionizio (Marcos Vinicius)
 */
public class SubGrupo<T> extends Grupo<T> {
	
	private HashSet<T> subconjunto;

	/**
	 * Cria um verificador de subgrupo.
	 * @param conjunto O grupo principal (G).
	 * @param op A operação do grupo.
	 * @param subconjunto O subconjunto a ser testado (H).
	 */
	public SubGrupo(HashSet<T> conjunto, Operacao<T> op, HashSet<T> subconjunto) {
		super(conjunto, op);
		this.subconjunto = subconjunto;
	}
	
	/**
	 * Verifica se o subconjunto atende aos requisitos de um subgrupo.
	 */
	public boolean ehSubGrupo() {
		// Valida se o subconjunto é válido e se está contido no grupo principal
		if (subconjunto == null || subconjunto.isEmpty() || 
				!this.getConjunto().containsAll(subconjunto)) {
	        return false;
	    }

		// Valida se o grupo pai é um grupo e se o subconjunto herda as propriedades
		if (!super.ehGrupo() || !subEhFechado() || !subTemIdentidade() || !subTemInverso()) {
	        return false; 
	    }
		
		return true;
	}
	
	/**
	 * Verifica se operar dois elementos do subconjunto resulta em um elemento que ainda está no subconjunto.
	 */
	public boolean subEhFechado() {
		for (T a : subconjunto) {
			for (T b : subconjunto) {
				T resultado = super.getOperacao().faz(a, b);
				if (!subconjunto.contains(resultado)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Verifica se a identidade do grupo principal está presente no subconjunto.
	 */
	public boolean subTemIdentidade() {
		T id = super.getIdentidade();
		return id != null && subconjunto.contains(id);
	}
	
	/**
	 * Verifica se para cada elemento no subconjunto, o seu inverso também está no subconjunto.
	 */
	public boolean subTemInverso() {
		T id = super.getIdentidade();
		for (T a : subconjunto) {
			boolean achouInversoEmH = false;
			for (T b : subconjunto) {
				if (super.getOperacao().faz(a, b).equals(id) && 
					super.getOperacao().faz(b, a).equals(id)) {
					achouInversoEmH = true;
					break;
				}
			}
			if (!achouInversoEmH) return false;
		}
		return true;
	}
}