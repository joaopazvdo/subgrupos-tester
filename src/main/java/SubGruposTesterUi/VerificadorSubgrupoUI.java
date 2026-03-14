package SubGruposTesterUi;

import javax.swing.*;
import java.awt.*;

public class VerificadorSubgrupoUI extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelPrincipal;
    private FacadeController controller;

    // Variáveis para armazenar as escolhas do utilizador
    private String tipoSelecionado;
    private String operacaoSelecionada;
    private String grupoG;
    private String subgrupoX;

    public VerificadorSubgrupoUI() {
        this.controller = new FacadeController();
        this.cardLayout = new CardLayout();
        this.painelPrincipal = new JPanel(cardLayout);

        setTitle("Assistente de Verificação de Subgrupos");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Adicionando os passos ao CardLayout
        painelPrincipal.add(criarPassoTipo(), "passo1");
        painelPrincipal.add(criarPassoOperacao(), "passo2");
        painelPrincipal.add(criarPassoGrupoG(), "passo3");
        painelPrincipal.add(criarPassoSubgrupoX(), "passo4");
        painelPrincipal.add(criarPassoResultado(), "passoFinal");

        add(painelPrincipal);
    }

    // --- PASSO 1: TIPO (SELEÇÃO POR BOTÕES) ---
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

    // --- PASSO 2: OPERAÇÃO (SELEÇÃO POR BOTÕES) ---
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

    // --- PASSO 3: GRUPO G (INPUT NO TOPO) ---
    private JPanel criarPassoGrupoG() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Contentor para label e campo no topo
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

    // --- PASSO 4: SUBGRUPO X (INPUT NO TOPO) ---
    private JPanel criarPassoSubgrupoX() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Contentor para label e campo no topo
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

    // --- JANELA DE RESULTADO ---
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

    private void exibirResultado() {
        JTextArea area = null;
        // Localiza a JTextArea no painel de resultados
        Component[] components = ((JPanel)painelPrincipal.getComponent(4)).getComponents();
        for (Component c : components) {
            if (c instanceof JScrollPane) {
                area = (JTextArea) ((JScrollPane)c).getViewport().getView();
            }
        }

        // Processa os dados através da FachadaController
        String relatorio = controller.processarVerificacao(tipoSelecionado, operacaoSelecionada, grupoG, subgrupoX);
        
        if (area != null) area.setText(relatorio);
        cardLayout.show(painelPrincipal, "passoFinal");
    }

    public static void main(String[] args) {
        // Look and Feel do sistema para melhor integração visual (opcional)
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        
        SwingUtilities.invokeLater(() -> new VerificadorSubgrupoUI().setVisible(true));
    }
}