import javax.swing.*;
import java.awt.event.*;

public class TelaPrincipalProdutos extends JDialog {
    private JPanel contentPane;
    private JButton voltarButton;
    private JButton listaButton;
    private JButton adicionarProdutoButton;
    private JButton removerProdutoButton;
    private JButton editarProdutoButton;
    private JButton buttonCancel;

    private LojaDao lojaDao;

    public TelaPrincipalProdutos() {
        lojaDao = new LojaDao();
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(adicionarProdutoButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        adicionarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Tela adiciona produto
                TelaAdicionaProduto telaAdicionaProduto = new TelaAdicionaProduto(lojaDao.getLoja());
                telaAdicionaProduto.pack();
                telaAdicionaProduto.setVisible(true);
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
                TelaListaProduto telaListaProduto = new TelaListaProduto();
                telaListaProduto.pack();
                telaListaProduto.setVisible(true);
                setVisible(false);
            }
        });

        editarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEditarProduto telaEditarProduto = new TelaEditarProduto();
                telaEditarProduto.pack();
                telaEditarProduto.setVisible(true);
                setVisible(false);
            }
        });

        removerProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRemoverProduto telaRemoverProduto = new TelaRemoverProduto();
                telaRemoverProduto.pack();
                telaRemoverProduto.setVisible(true);
                setVisible(false);
            }
        });
    }
}
