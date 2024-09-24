import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import model.Funcionario;
import model.Loja;

public class TelaEditarFuncionario extends JDialog {
    private JPanel contentPane;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JTextField nomeInput;
    private JTextField cpfInput;
    private JTextField cargoInput;
    private LojaDao lojaDao;

    public TelaEditarFuncionario() {
        lojaDao= new LojaDao();

        List<Funcionario> funcionarios = lojaDao.getLoja().getFuncionarios();
        setContentPane(contentPane);
        getRootPane().setDefaultButton(salvarButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeInput.getText();
                String cpf = cpfInput.getText();
                String  cargo = cargoInput.getText();

                boolean valida = false;
                for(Funcionario funcionario:funcionarios){
                    if(funcionario.getCpf().equals(cpf)){
                        valida=true;
                        funcionario.setNome(nome);
                        funcionario.setCargo(cargo);
                    }
                }

                if(!valida){
                    JOptionPane.showMessageDialog(contentPane,
                            "Falha ao atualizar funcionário!",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);

                    TelaEditarFuncionario telaEditarFuncionario = new TelaEditarFuncionario();
                    telaEditarFuncionario.pack();
                    telaEditarFuncionario.setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(contentPane,"Funcionário atualizado com sucesso!");
                    Loja loja = lojaDao.getLoja();
                    loja.setFuncionarios(funcionarios);
                    lojaDao.salvarLoja(loja);

                    TelaPrincipalFuncionario telaPrincipalFuncionario = new TelaPrincipalFuncionario();
                    telaPrincipalFuncionario.pack();
                    telaPrincipalFuncionario.setVisible(true);
                    setVisible(false);
                }

            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalFuncionario telaPrincipalFuncionario = new TelaPrincipalFuncionario();
                telaPrincipalFuncionario.pack();
                telaPrincipalFuncionario.setVisible(true);
                setVisible(false);;
            }
        });





    }



}
