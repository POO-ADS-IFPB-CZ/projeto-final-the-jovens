import javax.swing.*;
import java.awt.event.*;

public class TelaPrincipalFuncionario extends JDialog {
    private JPanel contentPane;
    private JButton adicionarFuncionarioButton;
    private JButton listaButton;
    private JButton voltarButton;
    private JButton removerFuncionarioButton;
    private JButton editarFuncionarioButton;
    private LojaDao lojaDao;

    public TelaPrincipalFuncionario() {

        lojaDao = new LojaDao();
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(adicionarFuncionarioButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        adicionarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAdicionaFuncionario telaAdicionaFuncionario = new TelaAdicionaFuncionario(lojaDao.getLoja());
                telaAdicionaFuncionario.pack();
                telaAdicionaFuncionario.setVisible(true);
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
                TelaListaFuncionario telaListaFuncionario = new TelaListaFuncionario();
                telaListaFuncionario.pack();
                telaListaFuncionario.setVisible(true);
                setVisible(false);
            }
        });

        editarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEditarFuncionario telaEditarFuncionario = new TelaEditarFuncionario();
                telaEditarFuncionario.pack();
                telaEditarFuncionario.setVisible(true);
                setVisible(false);
            }
        });

        removerFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRemoverFuncionario telaRemoverFuncionario = new TelaRemoverFuncionario();
                telaRemoverFuncionario.pack();
                telaRemoverFuncionario.setVisible(true);
                setVisible(false);
            }
        });
    }
}
