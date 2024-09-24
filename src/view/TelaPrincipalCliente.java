import javax.swing.*;
import java.awt.event.*;
import model.Loja;

public class TelaPrincipalCliente extends JDialog {
    private JPanel contentPane;
    private JButton listaButton;
    private JButton adicionarClienteButton;
    private JButton voltarButton;
    private JButton removerClienteButton;
    private JButton editarClienteButton;
    private LojaDao lojaDao = new LojaDao();;

    public TelaPrincipalCliente(Loja loja) {
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(adicionarClienteButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        adicionarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAdicionaCliente telaAdicionaCliente = new TelaAdicionaCliente(lojaDao.getLoja());
                telaAdicionaCliente.pack();
                telaAdicionaCliente.setVisible(true);
                setVisible(false);
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.pack();
                telaPrincipal.setVisible(true);
                setVisible(false);
            }
        });

        listaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaListaClientes telaListaClientes = new TelaListaClientes(lojaDao.getLoja());
                telaListaClientes.pack();
                telaListaClientes.setVisible(true);
                setVisible(false);
            }
        });

        editarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEditarCliente telaEditarCliente = new TelaEditarCliente();
                telaEditarCliente.pack();
                telaEditarCliente.setVisible(true);
                setVisible(false);
            }
        });

        removerClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRemoverCliente telaRemoverCliente = new TelaRemoverCliente();
                telaRemoverCliente.pack();
                telaRemoverCliente.setVisible(true);
                setVisible(false);
            }
        });
    }
}
