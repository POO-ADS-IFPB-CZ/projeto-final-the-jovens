import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import model.Cliente;
import model.Loja;

public class TelaEditarCliente extends JDialog {
    private JPanel contentPane;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JTextField nomeInput;
    private JTextField cpfInput;
    private JTextField telefoneInput;
    private JTextField enderecoInput;
    private LojaDao lojaDao;

    public TelaEditarCliente() {
        lojaDao= new LojaDao();

        List<Cliente> clientes = lojaDao.getLoja().getClientes();
        setContentPane(contentPane);
        getRootPane().setDefaultButton(salvarButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeInput.getText();
                String cpf = cpfInput.getText();
                String telefone = telefoneInput.getText();
                String endereco = enderecoInput.getText();

                boolean valida = false;
                for(Cliente cliente:clientes){
                    if(cliente.getCpf().equals(cpf)){
                        valida=true;
                        cliente.setNome(nome);
                        cliente.setEndereco(endereco);
                        cliente.setTelefone(telefone);
                    }
                }

                if(!valida){
                    JOptionPane.showMessageDialog(contentPane,
                            "Falha ao atualizar cliente!",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);

                    TelaEditarCliente telaEditarCliente = new TelaEditarCliente();
                    telaEditarCliente.pack();
                    telaEditarCliente.setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(contentPane,"Cliente atualizado com sucesso!");
                    Loja loja = lojaDao.getLoja();
                    loja.setClientes(clientes);
                    lojaDao.salvarLoja(loja);

                    TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(lojaDao.getLoja());
                    telaPrincipalCliente.pack();
                    telaPrincipalCliente.setVisible(true);
                    setVisible(false);
                }


            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(lojaDao.getLoja());
                telaPrincipalCliente.pack();
                telaPrincipalCliente.setVisible(true);
                setVisible(false);
            }
        });





    }



}
