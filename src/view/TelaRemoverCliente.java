import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Loja;

public class TelaRemoverCliente extends JDialog {
    private JPanel contentPane;
    private JButton removerButton;
    private JButton cancelarButton;
    private JTextField cpfInput;
    private LojaDao lojaDao;

    public TelaRemoverCliente() {
        lojaDao = new LojaDao();
        List<Cliente> clientes = lojaDao.getLoja().getClientes();

        setContentPane(contentPane);
        getRootPane().setDefaultButton(removerButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cpf =  cpfInput.getText();
                boolean valida = false;
                List<Cliente> clientesAtualizados = new ArrayList<>();

                for(Cliente cliente:clientes){
                    if(!cliente.getCpf().equals(cpf)){
                        valida=true;
                        clientesAtualizados.add(cliente);
                    }
                }

                System.out.println(clientesAtualizados);

                if(!valida){
                    JOptionPane.showMessageDialog(contentPane,
                            "Falha ao remover cliente, cpf inválido!",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);

                    TelaRemoverCliente telaRemoverCliente = new TelaRemoverCliente();
                    telaRemoverCliente.pack();
                    telaRemoverCliente.setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(contentPane,"Cliente removido com sucesso!");
                    Loja loja = lojaDao.getLoja();
                    loja.setClientes(clientesAtualizados);
                    lojaDao.salvarLoja(loja);

                    TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(loja);
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
