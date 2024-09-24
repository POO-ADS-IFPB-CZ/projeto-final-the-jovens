import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import model.Funcionario;
import model.Loja;

public class TelaAdicionaFuncionario extends JDialog {
    private JPanel contentPane;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JTextField inputNome;
    private JTextField inputCPF;
    private JTextField inputCargo;
    private LojaDao lojaDao = new LojaDao();

    public TelaAdicionaFuncionario(Loja loja) {
        setContentPane(contentPane);
        pack();
        getRootPane().setDefaultButton(salvarButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = inputNome.getText();
                String cpf = inputCPF.getText();
                String cargo = inputCargo.getText();
                Funcionario funcionario = new Funcionario(nome, cpf, cargo);
                List<Funcionario> funcionarios = lojaDao.getLoja().getFuncionarios();

                boolean verifica= false;
                for(Funcionario funcionario1:funcionarios){
                    if(funcionario1.getCpf().equals(cpf)){
                        verifica=true;
                    }
                }

                if (!verifica) {
                    loja.adicionarFuncionario(funcionario);
                    lojaDao.salvarLoja(loja);
                    JOptionPane.showMessageDialog(contentPane, "Funcionario adicionado com sucesso!");
                    TelaPrincipalFuncionario telaPrincipalFuncionario = new TelaPrincipalFuncionario();
                    telaPrincipalFuncionario.pack();
                    telaPrincipalFuncionario.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(contentPane,
                            "Falha ao adicionar Funcionario com cpf já existente!",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalFuncionario telaPrincipalFuncionario = new TelaPrincipalFuncionario();
                telaPrincipalFuncionario.pack();
                telaPrincipalFuncionario.setVisible(true);
                setVisible(false);
            }
        });
    }
}
