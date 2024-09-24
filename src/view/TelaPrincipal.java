import javax.swing.*;
import java.awt.event.*;

public class TelaPrincipal extends JDialog {
    private JPanel contentPane;
    private JButton produtosButton;
    private JButton clientesButton;
    private JButton funcionariosButton;
    private JButton sairButton;
    private LojaDao lojaDao = new LojaDao();

    public TelaPrincipal() {

        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(produtosButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(lojaDao.getLoja());
                    telaPrincipalCliente.pack();
                    telaPrincipalCliente.setVisible(true);
                    setVisible(false);
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        funcionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalFuncionario telaPrincipalFuncionario = new TelaPrincipalFuncionario();
                telaPrincipalFuncionario.pack();
                telaPrincipalFuncionario.setVisible(true);
                setVisible(false);
            }

        });

        produtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalProdutos telaPrincipalProdutos = new TelaPrincipalProdutos();
                telaPrincipalProdutos.pack();
                telaPrincipalProdutos.setVisible(true);
                setVisible(false);
            }
        });

    }


    public static void main(String[] args) {
        TelaPrincipal dialog = new TelaPrincipal();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }

}
