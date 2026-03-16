package SubGruposTesterUi;

import subgrupostester.*;

/*
 * @author jose-vinicius
 */

public class FacadeController {
	private SubGruposTester sub;

	public FacadeController() {
		this.sub = new SubGruposTester();
	}

	public String processarVerificacao(String tipo, String operacao, String grupoG, String subgrupoX) {

		try {
			switch (tipo) {
			case "Numérico":
				return sub.ehSubGrupoNumerico(grupoG, operacao, subgrupoX);
			case "Matriz":
				return sub.ehSubGrupoMatriz(grupoG, operacao, subgrupoX);
			case "Binário":
				return sub.ehSubGrupoBinario(grupoG, operacao, subgrupoX);
			case "Mod":
				return sub.ehSubGrupoMod(grupoG, operacao, subgrupoX);
			default:
				return "Erro: Tipo de conjunto desconhecido.";
			}
		} catch (IllegalArgumentException e) {
			return e.getMessage();
//		} catch (ArrayIndexOutOfBoundsException e) {
//			return e.getMessage();
		} catch (NullPointerException e) {
			return e.getMessage();
		}
	}
}
