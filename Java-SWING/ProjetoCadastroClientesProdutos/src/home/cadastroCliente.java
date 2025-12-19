package home;

import javax.swing.*;
import java.awt.*;
import cliente.*;
import java.lang.*;
import java.awt.event.*;



public class cadastroCliente extends JFrame {
    private JTextField nomeCliente, emailCliente, idadeCliente, telefoneCliente, identficadorCliente;
    private JPasswordField  senhaCliente, confirmarSenhaCliente;
    private JComboBox<String> estadoCliente;
    private JRadioButton cpfCliente, cnpjCliente, femininoCliente, masculinoCliente, outrosCliente;
    private JButton botaocadastrarCliente;

    public cadastroCliente(){ 
        setTitle("Cadastro de cliente");
        this.setSize(600, 350);
        setMinimumSize(new Dimension(600,350));
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuVoltar = new JMenu("Voltar");
        JMenuItem itemLogar = new JMenuItem("Logar");
        menuVoltar.add(itemLogar);
        barraMenu.add(menuVoltar);
        setJMenuBar(barraMenu);

        Cliente cliente = new Cliente();

        JPanel painelGeral = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        painelGeral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));      

        c.insets = new Insets(4,8,4,8);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;

        JLabel tituloCliente = new JLabel("Cadastro de cliente");
        tituloCliente.setFont(new Font("Segoe UI", Font.BOLD, 24));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.insets = new Insets(5, 0, 20, 0);
        painelGeral.add(tituloCliente, c);

        c.gridwidth = 1;
        c.insets = new Insets(6, 8, 6, 8);

        nomeCliente = new JTextField(15);
        emailCliente = new JTextField(15);
        idadeCliente = new JTextField(3);
        senhaCliente = new JPasswordField(15);
        confirmarSenhaCliente = new JPasswordField(15);
        telefoneCliente = new JTextField(15);
        String [] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
        estadoCliente = new JComboBox<>(estados);

        adicionarComponente(painelGeral, c, 1, "Nome: ", nomeCliente, "Email: ", emailCliente);
        adicionarComponente(painelGeral, c, 2, "Idade: ", idadeCliente, "Senha: ", senhaCliente);
        adicionarComponente(painelGeral, c, 3,"Telefone:",  telefoneCliente, "Confirmar senha: ", confirmarSenhaCliente);         

        JPanel painelIdentificacao = new JPanel();
        cpfCliente = new  JRadioButton("CPF");
        cnpjCliente = new JRadioButton("CNPJ");
        ButtonGroup grupoIdentificacao = new ButtonGroup();
        grupoIdentificacao.add(cpfCliente);
        grupoIdentificacao.add(cnpjCliente);
        painelIdentificacao.add(cpfCliente);
        painelIdentificacao.add(cnpjCliente);


        JPanel painelGenero = new JPanel();
        masculinoCliente = new JRadioButton("Masculino");
        femininoCliente = new JRadioButton("Feminino");
        outrosCliente = new JRadioButton("outros");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(masculinoCliente);
        grupoGenero.add(femininoCliente);
        grupoGenero.add(outrosCliente);
        painelGenero.add(masculinoCliente);
        painelGenero.add(femininoCliente);
        painelGenero.add(outrosCliente);
        componenteLabel(painelGeral, c, 4, "Genero: ", "Tipo de identificação: ");
        componenteCampo(painelGeral, c, 5, painelIdentificacao, painelGenero);

        JPanel painelBotoes = new JPanel();
        botaocadastrarCliente = new JButton("Cadastrar");
        c.gridx = 0;
        c.gridy = 8;
        painelBotoes.add(botaocadastrarCliente);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);

        botaocadastrarCliente.addActionListener(e -> cadastrarCliente());

        add(painelGeral);

        pack();
        setVisible(true);

    }

    public void adicionarComponente(JPanel painelGeral, GridBagConstraints c, int linha, String lableText, JComponent campo, String labelText2, JComponent campo2){
        c.gridx = 0;
        c.gridy = linha;
        c.weightx = 0;
        painelGeral.add(new JLabel(lableText), c);

        c.gridx = 1;
        c.weightx = 2.5;
        painelGeral.add(campo, c);
        
        c.gridx = 2;
        c.weightx = 0;
        painelGeral.add(new JLabel(labelText2), c);

        c.gridx = 3;
        c.gridy = linha;
        c.weightx = 2;
        painelGeral.add(campo2, c);
    }

    public void componenteLabel(JPanel painelgeral, GridBagConstraints c, int linha, String lableText, String lableText2){
        c.gridx = 0;
        c.gridy = linha;
        c.weightx= 0.1;
        painelgeral.add(new JLabel(lableText), c);

        c.gridx = 2;
        painelgeral.add(new JLabel(lableText2), c);
    }

    public void componenteCampo(JPanel painelgeral, GridBagConstraints c, int linha, JComponent campo, JComponent campo2){
        c.gridx = 0;
        c.gridy = linha;
        c.weightx = 0.5;
        painelgeral.add(campo, c);

        c.gridx = 2;
        painelgeral.add(campo2, c);
    }

    public void cadastrarCliente(){
        Cliente cliente = new  Cliente();
        cliente.setNome(nomeCliente.getText());
        cliente.setEmail(emailCliente.getText());
        cliente.setIdade(Integer.parseInt(idadeCliente.getText()));
        cliente.setSenha1(senhaCliente.getPassword().toString());
        cliente.setSenha2(confirmarSenhaCliente.getPassword().toString());
        cliente.setTelefone(telefoneCliente.getText());
        cliente.setEstado2((String) estadoCliente.getSelectedItem());

        if (!cliente.getSenha1().equals(cliente.getSenha2())){
            JOptionPane.showMessageDialog(this, "As senhas não coincidem. Por favor, tente novamente.");
            return;
        }

        String generos = "";
        if (masculinoCliente.isSelected()){
            generos = "Masculino";
        } else if (femininoCliente.isSelected()){
        generos = "Feminino";
        } else if (outrosCliente.isSelected()){
            generos = "Outros";
        }
        cliente.setGen(generos);
        
        String tipoA = "";
        if(cpfCliente.isSelected()){
            tipoA = "CPF";
        } else if(cnpjCliente.isSelected()){
            tipoA = "CNPJ";
        }
        cliente.setTipo(tipoA);

        if (cpfCliente.isSelected()){
            String cpf = JOptionPane.showInputDialog(this, "Digite seu CPF:");
            cliente.setIdentificador(cpf);
        } else if (cnpjCliente.isSelected()){
            String cnpj = JOptionPane.showInputDialog(this, "Digite seu CNPJ:");
            cliente.setIdentificador(cnpj);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um valor valido");
        }

          JOptionPane.showMessageDialog(this,
            "Cliente cadastrado \n" +
            "nome: " + cliente.getNome() + "\n" +
            "email: " + cliente.getEmail() + "\n" +
            "idade: " + cliente.getIdade() + "\n" +
            "telefone: " + cliente.getTelefone() + "\n" +
            "estado: " + cliente.getEstado2() + "\n" +
            "genero: " + cliente.getGen() + "\n" +
            "tipo: " + cliente.getTipo() + "\n" +
            "identificador: " + cliente.getIdentificador());
        }
        
      
    public static void main(String[] args) {
        new cadastroCliente();
    }
}
