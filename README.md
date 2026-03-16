#  Assistente de Verificação de Subgrupos (SubGruposTester)

Um sistema desenvolvido em **Java** com Interface Gráfica (Swing) que atua como um assistente educacional para a **Álgebra Abstrata**. Ele é capaz de testar e validar se um dado subconjunto X forma um **Subgrupo** válido de um grupo G, dadas operações matemáticas específicas.

O sistema gera um relatório passo a passo detalhando as verificações de propriedades fundamentais, como fechamento, elemento neutro (identidade), inverso e associatividade.

##  Funcionalidades

O sistema suporta testes automatizados para diferentes tipos de conjuntos matemáticos e operações:

* **Tipos de Conjuntos Suportados:**
    *  **Numérico (Reais):** Operações com números de ponto flutuante.
    *  **Binário:** Operações baseadas em números na base 2.
    *  **Matrizes:** Operações com matrizes quadradas bidimensionais.
    *  **Classes de Congruência (Mod):** Aritmética modular (ex: Z_n).
* **Operações Suportadas:**
    * Adição (+)
    * Multiplicação (*)
* **Análise Matemática Detalhada:**
    * Validação se o grupo pai (G) é realmente um grupo.
    * Validação de Subconjunto (se X está contido em G).
    * Teste de Fechamento.
    * Teste de Elemento Neutro / Identidade.
    * Teste de Elemento Inverso.
    * Teste de Associatividade.
* **Interface Gráfica Guiada:** Um assistente em etapas (Wizard) para inserção de dados passo a passo.

---

##  Arquitetura e Estrutura do Projeto

O projeto foi construído utilizando o padrão **Facade** para separar a lógica de negócios da interface gráfica e está modularizado nos seguintes pacotes:

* `grupo`: Contém a inteligência matemática central. As classes `Grupo` e `SubGrupo` aplicam as regras da álgebra abstrata de forma genérica (`<T>`).
* `operacao`: Padrão *Strategy/Factory* para definir como as operações matemáticas ocorrem para diferentes tipos de dados (`OperacaoReais`, `OperacaoBinario`, `OperacaoMatrizes`, `OperacaoMod`).
* `conversor`: Responsável por interpretar as *Strings* digitadas pelo usuário na interface gráfica e convertê-las nos tipos de dados adequados (Matrizes, Doubles, Inteiros, etc).
* `subgrupostester`: O motor de orquestração do sistema (`SubGruposTester`) e o formatador de saída (`Relatorio`).
* `SubGruposTesterUi`: Contém as classes da Interface Gráfica Swing (`VerificadorSubgrupoUI`) e a fachada (`FacadeController`).

---

##  Como Executar o Projeto

### Pré-requisitos
* **Java Development Kit (JDK):** Versão 8 ou superior.

### Passos para rodar:
1. Compile todos os pacotes e arquivos `.java` do projeto.
2. Execute a classe principal da interface gráfica:
   ```bash
   java SubGruposTesterUi.VerificadorSubgrupoUI