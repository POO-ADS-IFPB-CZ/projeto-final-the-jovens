import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.Loja;

public class TelaRemoverFuncionario extends JDialog {
    private JPanel contentPane;
    private JButton removerButton;
    private JButton cancelarButton;
    private JTextField cpfInput;
    private LojaDao lojaDao;

    public TelaRemoverFuncionario() {
        lojaDao = new LojaDao();
        List<Funcionario> funcionarios = lojaDao.getLoja().getFuncionarios();

        setContentPane(contentPane);
        getRootPane().setDefaultButton(removerButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cpf =  cpfInput.getText();
                boolean valida = false;
                List<Funcionario> funcionariosAtualizados = new ArrayList<>();

                for(Funcionario funcionario:funcionarios){
                    if(!funcionario.getCpf().equals(cpf)){
                        valida=true;
                        funcionariosAtualizados.add(funcionario);
                    }
                }


                if(!valida){
                    JOptionPane.showMessageDialog(contentPane,
                            "Falha ao remover funcionário, cpf inválido!",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);

                   TelaRemoverFuncionario telaRemoverFuncionario = new TelaRemoverFuncionario();
                   telaRemoverFuncionario.pack();
                   telaRemoverFuncionario.setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(contentPane,"Funcionário removido com sucesso!");
                    Loja loja = lojaDao.getLoja();
                    loja.setFuncionarios(funcionariosAtualizados);
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
                setVisible(false);
            }
        });


    }


}
