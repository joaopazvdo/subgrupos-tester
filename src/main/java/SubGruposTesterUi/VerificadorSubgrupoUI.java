package SubGruposTesterUi;

import javax.swing.*;
import java.awt.*;

/**
 * Interface Gráfica de Usuário (GUI) para o Assistente de Verificação de Subgrupos.
 * Esta classe utiliza um layout de cartões (CardLayout) para guiar o usuário através
 * de um processo de cinco etapas para validar se um subconjunto X é um subgrupo de G.
 * * @author José Vinícius Tavares Silva
 * @version 1.0
 */

public class VerificadorSubgrupoUI extends JFrame {
	/** Gerenciador de layout para alternar entre as telas do assistente. */
    private CardLayout cardLayout;
    
    /** Painel que contém todos os cartões (passos) da interface. */
    private JPanel painelPrincipal;
    
    /** Controlador da fachada que gerencia a lógica de negócio e verificações. */
    private FacadeController controller;

    /** Armazena o tipo de conjunto selecionado (ex: Matriz, Binário). */
    private String tipoSelecionado;
    
    /** Armazena a operação matemática selecionada (Soma ou Multiplicação). */
    private String operacaoSelecionada;
    
    /** Armazena a representação textual dos elementos do Grupo G. */
    private String grupoG;
    
    /** Armazena a representação textual dos elementos do Subgrupo X. */
    private String subgrupoX;

    /**
     * Construtor da classe. Inicializa os componentes da interface, configura o frame
     * e monta os painéis que compõem o fluxo de verificação.
     */
    public VerificadorSubgrupoUI() {
        this.controller = new FacadeController();
        this.cardLayout = new CardLayout();
        this.painelPrincipal = new JPanel(cardLayout);

        setTitle("Assistente de Verificação de Subgrupos");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        painelPrincipal.add(criarPassoTipo(), "passo1");
        painelPrincipal.add(criarPassoOperacao(), "passo2");
        painelPrincipal.add(criarPassoGrupoG(), "passo3");
        painelPrincipal.add(criarPassoSubgrupoX(), "passo4");
        painelPrincipal.add(criarPassoResultado(), "passoFinal");

        add(painelPrincipal);
    }

    /**
     * Cria o primeiro passo da interface: Seleção do tipo de conjunto.
     * * @return Um JPanel contendo os botões para escolha do tipo.
     */
    private JPanel criarPassoTipo() {
        JPanel p = new JPanel(new GridLayout(5, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        p.add(new JLabel("1. Escolha o Tipo de Conjunto:", SwingConstants.CENTER));
        
        String[] tipos = {"Matriz", "Binário", "Mod", "Numérico"};
        for (String t : tipos) {
            JButton btn = new JButton(t);
            btn.addActionListener(e -> {
                this.tipoSelecionado = t;
                cardLayout.show(painelPrincipal, "passo2");
            });
            p.add(btn);
        }
        return p;
    }

    /**
     * Cria o segundo passo da interface: Seleção da operação.
     * * @return Um JPanel contendo as opções de operação e o botão voltar.
     */
    private JPanel criarPassoOperacao() {
        JPanel p = new JPanel(new GridLayout(4, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        p.add(new JLabel("2. Escolha a Operação:", SwingConstants.CENTER));
        
        String[] operacoes = {"Soma", "Multiplicação"};
        for (String op : operacoes) {
            JButton btn = new JButton(op);
            btn.addActionListener(e -> {
                this.operacaoSelecionada = op;
                cardLayout.show(painelPrincipal, "passo3");
            });
            p.add(btn);
        }

        JButton btnVoltar = new JButton(" < Voltar");
        btnVoltar.addActionListener(e -> cardLayout.show(painelPrincipal, "passo1"));
        p.add(btnVoltar);

        return p;
    }

    /**
     * Cria o terceiro passo da interface: Entrada dos elementos do Grupo G.
     * * @return Um JPanel com campo de texto para o grupo principal.
     */
    private JPanel criarPassoGrupoG() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JPanel topo = new JPanel(new GridLayout(2, 1, 5, 5));
        topo.add(new JLabel("3. Digite os elementos do Grupo G:"));
        JTextField txt = new JTextField();
        topo.add(txt);
        
        p.add(topo, BorderLayout.NORTH);

        JButton btnProx = new JButton("Próximo >");
        p.add(btnProx, BorderLayout.SOUTH);

        btnProx.addActionListener(e -> {
            this.grupoG = txt.getText().trim();
            if(!grupoG.isEmpty()) cardLayout.show(painelPrincipal, "passo4");
            else JOptionPane.showMessageDialog(this, "Por favor, insira o grupo.");
        });
        return p;
    }

    /**
     * Cria o quarto passo da interface: Entrada dos elementos do Subgrupo X.
     * * @return Um JPanel com campo de texto para o subconjunto.
     */
    private JPanel criarPassoSubgrupoX() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JPanel topo = new JPanel(new GridLayout(2, 1, 5, 5));
        topo.add(new JLabel("4. Digite os elementos do Subgrupo X:"));
        JTextField txt = new JTextField();
        topo.add(txt);
        
        p.add(topo, BorderLayout.NORTH);

        JButton btnFinalizar = new JButton("Finalizar e Testar");
        p.add(btnFinalizar, BorderLayout.SOUTH);

        btnFinalizar.addActionListener(e -> {
            this.subgrupoX = txt.getText().trim();
            if(!subgrupoX.isEmpty()) exibirResultado();
            else JOptionPane.showMessageDialog(this, "Por favor, insira o subgrupo.");
        });
        return p;
    }

    /**
     * Cria o painel final onde o resultado do teste de subgrupo será exibido.
     * * @return Um JPanel com área de texto rolável para o relatório.
     */
    private JPanel criarPassoResultado() {
        JPanel p = new JPanel(new BorderLayout());
        JTextArea area = new JTextArea();
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        area.setEditable(false);
        
        JButton btnReiniciar = new JButton("Novo Teste");
        btnReiniciar.addActionListener(e -> cardLayout.show(painelPrincipal, "passo1"));

        p.add(new JScrollPane(area), BorderLayout.CENTER);
        p.add(btnReiniciar, BorderLayout.SOUTH);
        return p;
    }
    
    /**
     * Coleta as escolhas do usuário, envia para a FachadaController processar
     * a lógica matemática e atualiza a interface com o relatório gerado.
     */
    private void exibirResultado() {
        JTextArea area = null;
        
        Component[] components = ((JPanel)painelPrincipal.getComponent(4)).getComponents();
        for (Component c : components) {
            if (c instanceof JScrollPane) {
                area = (JTextArea) ((JScrollPane)c).getViewport().getView();
            }
        }

      
        String relatorio = controller.processarVerificacao(tipoSelecionado, operacaoSelecionada, grupoG, subgrupoX);
        
        if (area != null) area.setText(relatorio);
        cardLayout.show(painelPrincipal, "passoFinal");
    }

    /**
     * Método principal que inicia a execução da aplicação Swing.
     * Define o Look and Feel do sistema operacional para uma melhor experiência visual.
     * * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        
        SwingUtilities.invokeLater(() -> new VerificadorSubgrupoUI().setVisible(true));
    }
}