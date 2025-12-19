package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlteracaoProduto extends JFrame {

    private JTextField CAMPO_NOME;
    private JTextField CAMPO_CATEGORIA;
    private JTextField CAMPO_TAMANHO;
    private JTextField CAMPO_PRECO_VENDA;
    private JTextField CAMPO_CUSTO_PRODUCAO;
    private JRadioButton RADIO_PRECO_LOTE_SIM;
    private JRadioButton RADIO_PRECO_LOTE_NAO;
    private JTextField CAMPO_PRECO_LOTE;
    private JTextField CAMPO_MARCA_FORNECEDORES;
    private JTextField CAMPO_ESTOQUE;
    private JTextArea AREA_DESCRICAO;
    private JButton BOTAO_EXCLUIR;
    private JButton BOTAO_SALVAR_ALTERACOES;
    private JComboBox <String> tamanhoAlteracoes;

    public AlteracaoProduto() {

        this.setTitle("Alteração de Produto");
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);

        // --- 2. PAINEL PRINCIPAL
        JPanel PAINEL_PRINCIPAL = new JPanel(new GridBagLayout());
        PAINEL_PRINCIPAL.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        GridBagConstraints GBC = new GridBagConstraints();
        GBC.insets = new Insets(5, 5, 5, 5);
        GBC.fill = GridBagConstraints.HORIZONTAL;

        // --- 3. TÍTULO DA TELA ---
        JLabel ROTULO_TITULO = new JLabel("Alteração de Produto");
        ROTULO_TITULO.setFont(new Font("SansSerif", Font.BOLD, 18));
        GBC.gridx = 0;
        GBC.gridy = 0;
        GBC.gridwidth = 6;
        GBC.anchor = GridBagConstraints.WEST;
        PAINEL_PRINCIPAL.add(ROTULO_TITULO, GBC);

        GBC.gridwidth = 1;

        // --- 4. LINHA 1: NOME, CATEGORIA E TAMANHO ---

        // Nome
        GBC.gridx = 0; GBC.gridy = 1;
        GBC.anchor = GridBagConstraints.WEST;
        PAINEL_PRINCIPAL.add(new JLabel("Nome:"), GBC);

        CAMPO_NOME = new JTextField();
        GBC.gridx = 1; GBC.gridy = 1;
        GBC.weightx = 1.0;
        PAINEL_PRINCIPAL.add(CAMPO_NOME, GBC);

        // Categoria
        GBC.gridx = 2; GBC.gridy = 1;
        GBC.weightx = 0.0;
        PAINEL_PRINCIPAL.add(new JLabel("Categoria:"), GBC);

        CAMPO_CATEGORIA = new JTextField("", 10);
        GBC.gridx = 3; GBC.gridy = 1;
        PAINEL_PRINCIPAL.add(CAMPO_CATEGORIA, GBC);

        // Tamanho
        GBC.gridx = 4; GBC.gridy = 1;
        PAINEL_PRINCIPAL.add(new JLabel("Tamanho:"), GBC);

        String [] tamanho = {
                "PP", "P", "M", "G", "GG"
        };
        tamanhoAlteracoes = new JComboBox<String>(tamanho);
        GBC.gridx = 5; GBC.gridy = 1;
        PAINEL_PRINCIPAL.add(tamanhoAlteracoes, GBC);

        //  PREÇO VENDA, CUSTO PRODUÇÃO E ESTOQUE

        // Preço Venda
        GBC.gridx = 0; GBC.gridy = 2;
        PAINEL_PRINCIPAL.add(new JLabel("Preço:"), GBC);

        CAMPO_PRECO_VENDA = new JTextField();
        GBC.gridx = 1; GBC.gridy = 2;
        GBC.weightx = 1.0;
        PAINEL_PRINCIPAL.add(CAMPO_PRECO_VENDA, GBC);

        // Custo Produção
        GBC.gridx = 2; GBC.gridy = 2;
        GBC.weightx = 0.0;
        PAINEL_PRINCIPAL.add(new JLabel("Custo da Produção:"), GBC);

        CAMPO_CUSTO_PRODUCAO = new JTextField();
        GBC.gridx = 3; GBC.gridy = 2;
        PAINEL_PRINCIPAL.add(CAMPO_CUSTO_PRODUCAO, GBC);

        // Estoque (Rótulo e Campo)
        GBC.gridx = 4; GBC.gridy = 2;
        PAINEL_PRINCIPAL.add(new JLabel("Estoque:"), GBC);

        CAMPO_ESTOQUE = new JTextField("", 5);
        GBC.gridx = 5; GBC.gridy = 2;
        PAINEL_PRINCIPAL.add(CAMPO_ESTOQUE, GBC);

        // PREÇO POR LOTE E PROMOÇÃO ---

        // Preço por Lote
        GBC.gridx = 0; GBC.gridy = 3;
        PAINEL_PRINCIPAL.add(new JLabel("Preço por Lote:"), GBC);

        RADIO_PRECO_LOTE_SIM = new JRadioButton("Sim");
        RADIO_PRECO_LOTE_NAO = new JRadioButton("Não");
        ButtonGroup GRUPO_LOTE = new ButtonGroup();
        GRUPO_LOTE.add(RADIO_PRECO_LOTE_SIM);
        GRUPO_LOTE.add(RADIO_PRECO_LOTE_NAO);
        RADIO_PRECO_LOTE_SIM.setSelected(true);

        JPanel PAINEL_RADIO_LOTE = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        PAINEL_RADIO_LOTE.add(RADIO_PRECO_LOTE_SIM);
        PAINEL_RADIO_LOTE.add(RADIO_PRECO_LOTE_NAO);

        GBC.gridx = 1; GBC.gridy = 3;
        PAINEL_PRINCIPAL.add(PAINEL_RADIO_LOTE, GBC);

        // Campo Preço Lote
        CAMPO_PRECO_LOTE = new JTextField("");
        GBC.gridx = 2; GBC.gridy = 3;
        GBC.weightx = 0.5;
        PAINEL_PRINCIPAL.add(CAMPO_PRECO_LOTE, GBC);


        // MARCA/FORNECEDORES E VENDAS ---

        // Marca/Fornecedores
        GBC.gridx = 0; GBC.gridy = 4;
        PAINEL_PRINCIPAL.add(new JLabel("Marca/Fornecedores:"), GBC);

        CAMPO_MARCA_FORNECEDORES = new JTextField("");
        GBC.gridx = 1; GBC.gridy = 4;
        GBC.gridwidth = 3;
        PAINEL_PRINCIPAL.add(CAMPO_MARCA_FORNECEDORES, GBC);

        GBC.gridwidth = 1;

        // --- 8. LINHAS 5-7: DESCRIÇÃO ---

        // Rótulo Descrição
        GBC.gridx = 0; GBC.gridy = 5;
        PAINEL_PRINCIPAL.add(new JLabel("Descrição:"), GBC);

        AREA_DESCRICAO = new JTextArea(8, 20);
        JScrollPane SCROLL_DESCRICAO = new JScrollPane(AREA_DESCRICAO);

        GBC.gridx = 1; GBC.gridy = 5;
        GBC.gridwidth = 5;
        GBC.gridheight = 3;
        GBC.weighty = 1.0;
        PAINEL_PRINCIPAL.add(SCROLL_DESCRICAO, GBC);

        // BOTÕES DE AÇÃO ---

        GBC.gridwidth = 1;
        GBC.gridheight = 1;
        GBC.weighty = 0.0;

        GBC.gridx = 0; GBC.gridy = 8;
        GBC.weightx = 1.0;
        GBC.fill = GridBagConstraints.HORIZONTAL;
        PAINEL_PRINCIPAL.add(Box.createHorizontalGlue(), GBC);

        // Excluir
        BOTAO_EXCLUIR = new JButton("Excluir");
        GBC.gridx = 4; GBC.gridy = 8;
        GBC.weightx = 0.0;
        GBC.fill = GridBagConstraints.NONE;
        GBC.anchor = GridBagConstraints.EAST;
        PAINEL_PRINCIPAL.add(BOTAO_EXCLUIR, GBC);

        // Salvar Alterações (Ajustado)
        BOTAO_SALVAR_ALTERACOES = new JButton("Salvar Alterações");
        GBC.gridx = 5; GBC.gridy = 8;
        GBC.anchor = GridBagConstraints.EAST;
        PAINEL_PRINCIPAL.add(BOTAO_SALVAR_ALTERACOES, GBC);


        // --- 10. ADICIONA PAINEL E FINALIZA JANELA ---
        this.getContentPane().add(PAINEL_PRINCIPAL);
        this.pack();

        // --- 11. LISTENERS ---
        ADICIONAR_LISTENERS();

        this.setVisible(true);

        // --- 12. CHAMADA PARA CARREGAR DADOS (SIMULAÇÃO) ---
        CARREGAR_DADOS_PRODUTO_EXISTENTE();
    }

    // Simula o carregamento de dados de um produto que já existe no sistema
    private void CARREGAR_DADOS_PRODUTO_EXISTENTE() {
        // Em um sistema real, aqui você chamaria o ProdutoDAO para buscar o produto pelo ID.
        // Os campos já estão preenchidos no construtor para simular esse carregamento inicial.
        System.out.println("Produto existente carregado e pronto para alteração.");
    }

    // Método para adicionar as ações aos botões
    private void ADICIONAR_LISTENERS() {
        BOTAO_SALVAR_ALTERACOES.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LÓGICA DE ATUALIZAÇÃO: Pegar todos os dados dos campos e chamar o ProdutoDAO.atualizar()
                JOptionPane.showMessageDialog(AlteracaoProduto.this, "Alterações Salvas com Sucesso!",
                        "AÇÃO: SALVAR", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        BOTAO_EXCLUIR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(AlteracaoProduto.this,
                        "Tem certeza que deseja excluir permanentemente este produto?",
                        "CONFIRMAR EXCLUSÃO", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // LÓGICA DE EXCLUSÃO: Chamar o ProdutoDAO.excluir(id)
                    JOptionPane.showMessageDialog(AlteracaoProduto.this, "Produto Excluído.", "AÇÃO: EXCLUIR", JOptionPane.INFORMATION_MESSAGE);
                    AlteracaoProduto.this.dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AlteracaoProduto();
        });
    }
}