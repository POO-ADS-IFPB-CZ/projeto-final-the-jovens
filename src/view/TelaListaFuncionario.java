import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;
import model.Funcionario;

public class TelaListaFuncionario extends JDialog {
    private JPanel contentPane;
    private JTable table1;
    private JButton voltarButton;
    private LojaDao  lojaDao;

    public TelaListaFuncionario() {
        lojaDao = new LojaDao();
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(voltarButton);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalFuncionario telaPrincipalFuncionario = new TelaPrincipalFuncionario();
                telaPrincipalFuncionario.pack();
                telaPrincipalFuncionario.setVisible(true);
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
        String titulos[] = { "Nome","CPF", "Cargo"};
        List<Funcionario> funcionarios = lojaDao1.getLoja().getFuncionarios();
        List<Funcionario> FuncionariosList = funcionarios.stream().toList();
        String dados[][] = new String[funcionarios.size()][3];

        for(int i=0; i<funcionarios.size(); i++) {
            dados[i][0] = FuncionariosList.get(i).getNome();
            dados[i][1] = FuncionariosList.get(i).getCpf();
            dados[i][2] = FuncionariosList.get(i).getCargo();
        }

        DefaultTableModel model = new DefaultTableModel(dados, titulos);
        table1.setModel(model);
    }
}
