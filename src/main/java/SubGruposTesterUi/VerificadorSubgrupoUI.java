package SubGruposTesterUi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author jose-vinicius
 */

public class VerificadorSubgrupoUI extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelPrincipal;
    private FacadeController controller;

    private String tipoSelecionado;
    private String operacaoSelecionada;
    private String grupoG;
    private String subgrupoX;

    private JTextField campoTextoG;
    private JTextField campoTextoX;
    private JLabel labelExemploG;
    private JLabel labelExemploX;
    private JTextArea areaRelatorio;

    public VerificadorSubgrupoUI() {
        this.controller = new FacadeController();
        this.cardLayout = new CardLayout();
        this.painelPrincipal = new JPanel(cardLayout);

        setTitle("Assistente de Verificação de Subgrupos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        painelPrincipal.add(criarPassoTipo(), "passo1");
        painelPrincipal.add(criarPassoOperacao(), "passo2");
        painelPrincipal.add(criarPassoGrupoG(), "passo3");
        painelPrincipal.add(criarPassoSubgrupoX(), "passo4");
        painelPrincipal.add(criarPassoResultado(), "passoFinal");

        add(painelPrincipal);
    }

    private void configurarBotaoTeclado(JButton btn, Runnable acao) {
        btn.addActionListener(e -> acao.run());
        btn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    acao.run();
                }
            }
        });
    }

    private String obterExemploEntrada() {
        if (tipoSelecionado == null) return "";
        switch (tipoSelecionado) {
            case "Matriz":
            	return "Ex: [[1,2],[1,2]], [[1,2],[1,2]]";
            case "Binário":
            	return "Ex: 000 001 010";
            case "Mod":
            	return "Ex: [0, 1, 2, 3, 4, 5] 6";
            case "Numérico":
            	return "Ex: 0.0, 1.0, 2.5, 4.3";
            default:
            	return "";
        }
    }

    private JPanel criarPassoTipo() {
        JPanel p = new JPanel(new GridLayout(5, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        p.add(new JLabel("1. Tipo de Conjunto (Tab/Enter):", SwingConstants.CENTER));
        
        String[] tipos = {"Matriz", "Binário", "Mod", "Numérico"};
        for (String t : tipos) {
            JButton btn = new JButton(t);
            configurarBotaoTeclado(btn, () -> {
                this.tipoSelecionado = t;
                String exemplo = obterExemploEntrada();
                labelExemploG.setText(exemplo);
                labelExemploX.setText(exemplo);
                cardLayout.show(painelPrincipal, "passo2");
                focarPrimeiroComponente();
            });
            p.add(btn);
        }
        return p;
    }

    private JPanel criarPassoOperacao() {
        JPanel p = new JPanel(new GridLayout(4, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        p.add(new JLabel("2. Operação:", SwingConstants.CENTER));
        
        String[] operacoes = {"Adicao", "Multiplicacao"};
        for (String op : operacoes) {
            JButton btn = new JButton(op);
            configurarBotaoTeclado(btn, () -> {
                this.operacaoSelecionada = op;
                cardLayout.show(painelPrincipal, "passo3");
                campoTextoG.requestFocusInWindow();
            });
            p.add(btn);
        }

        JButton btnVoltar = new JButton("< Voltar");
        configurarBotaoTeclado(btnVoltar, () -> cardLayout.show(painelPrincipal, "passo1"));
        p.add(btnVoltar);

        return p;
    }

    private JPanel criarPassoGrupoG() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        JPanel topo = new JPanel(new GridLayout(3, 1, 5, 5));
        topo.add(new JLabel("3. Digite os elementos do Grupo G:"));
        
        labelExemploG = new JLabel("");
        labelExemploG.setForeground(Color.GRAY);
        labelExemploG.setFont(new Font("SansSerif", Font.ITALIC, 11));
        topo.add(labelExemploG);

        campoTextoG = new JTextField();
        campoTextoG.addActionListener(e -> acaoProximoG());
        topo.add(campoTextoG);
        
        p.add(topo, BorderLayout.NORTH);
        JButton btnProx = new JButton("Próximo (Enter)");
        configurarBotaoTeclado(btnProx, this::acaoProximoG);
        p.add(btnProx, BorderLayout.SOUTH);
        return p;
    }

    private void acaoProximoG() {
        this.grupoG = campoTextoG.getText().trim();
        if(!grupoG.isEmpty()) {
            cardLayout.show(painelPrincipal, "passo4");
            campoTextoX.requestFocusInWindow();
        }
    }

    private JPanel criarPassoSubgrupoX() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        JPanel topo = new JPanel(new GridLayout(3, 1, 5, 5));
        topo.add(new JLabel("4. Digite os elementos do Subgrupo X:"));
        
        labelExemploX = new JLabel("");
        labelExemploX.setForeground(Color.GRAY);
        labelExemploX.setFont(new Font("SansSerif", Font.ITALIC, 11));
        topo.add(labelExemploX);

        campoTextoX = new JTextField();
        campoTextoX.addActionListener(e -> acaoFinalizar());
        topo.add(campoTextoX);
        
        p.add(topo, BorderLayout.NORTH);
        JButton btnFinalizar = new JButton("Finalizar (Enter)");
        configurarBotaoTeclado(btnFinalizar, this::acaoFinalizar);
        p.add(btnFinalizar, BorderLayout.SOUTH);
        return p;
    }

    private void acaoFinalizar() {
        this.subgrupoX = campoTextoX.getText().trim();
        if(!subgrupoX.isEmpty()) exibirResultado();
    }

    private JPanel criarPassoResultado() {
        JPanel p = new JPanel(new BorderLayout());
        areaRelatorio = new JTextArea();
        areaRelatorio.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        areaRelatorio.setEditable(false);
        JButton btnReiniciar = new JButton("Novo Teste");
        configurarBotaoTeclado(btnReiniciar, this::reiniciarSistema);
        p.add(new JScrollPane(areaRelatorio), BorderLayout.CENTER);
        p.add(btnReiniciar, BorderLayout.SOUTH);
        return p;
    }

    private void reiniciarSistema() {
        tipoSelecionado = null;
        operacaoSelecionada = null;
        grupoG = null;
        subgrupoX = null;
        campoTextoG.setText("");
        campoTextoX.setText("");
        labelExemploG.setText("");
        labelExemploX.setText("");
        areaRelatorio.setText("");
        cardLayout.show(painelPrincipal, "passo1");
        focarPrimeiroComponente();
    }

    private void focarPrimeiroComponente() {
        SwingUtilities.invokeLater(() -> {
            for (Component card : painelPrincipal.getComponents()) {
                if (card.isVisible()) {
                    for (Component c : ((JPanel) card).getComponents()) {
                        if (c instanceof JButton || c instanceof JTextField) {
                            c.requestFocusInWindow();
                            break;
                        }
                    }
                }
            }
        });
    }

    private void exibirResultado() {
        String relatorio = controller.processarVerificacao(tipoSelecionado, operacaoSelecionada, grupoG, subgrupoX);
        areaRelatorio.setText(relatorio);
        cardLayout.show(painelPrincipal, "passoFinal");
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> {
            VerificadorSubgrupoUI ui = new VerificadorSubgrupoUI();
            ui.setVisible(true);
            ui.focarPrimeiroComponente();
        });
    }
}