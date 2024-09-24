import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Loja;
import model.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class TelaListaClientes extends JDialog {
    private JPanel contentPane;
    private JButton voltarButton;
    private JTable table1;
    private LojaDao lojaDao;

    public TelaListaClientes(Loja loja) {
        lojaDao = new LojaDao();
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(voltarButton);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(lojaDao.getLoja());
                telaPrincipalCliente.pack();
                telaPrincipalCliente.setVisible(true);
                setVisible(false);
            }
        });

    }

    private void createUIComponents() {
        table1 = new JTable();
        preencherTabela();
    }

    private void preencherTabela() {
        LojaDao lojaDao1 = new LojaDao();
        String titulos[] = { "Nome","CPF", "Telefone", "Endereço"};
        List<Cliente> clientes = lojaDao1.getLoja().getClientes();
        List<Cliente> clienteList = clientes.stream().toList();
        String dados[][] = new String[clientes.size()][4];

        for(int i=0; i<clientes.size(); i++) {
            dados[i][0] = clienteList.get(i).getNome();
            dados[i][1] = clienteList.get(i).getCpf();
            dados[i][2] = clienteList.get(i).getTelefone();
            dados[i][3] = clienteList.get(i).getEndereco();
        }

        DefaultTableModel model = new DefaultTableModel(dados, titulos);
        table1.setModel(model);
    }
}
