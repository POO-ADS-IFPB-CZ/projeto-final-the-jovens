import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;
import model.Produto;

public class TelaListaProduto extends JDialog {
    private JPanel contentPane;
    private JButton voltarButton;
    private JTable table1;
    private LojaDao lojaDao;

    public TelaListaProduto() {
        lojaDao = new LojaDao();
        setContentPane(contentPane);
        getRootPane().setDefaultButton(voltarButton);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalProdutos telaPrincipalProdutos = new TelaPrincipalProdutos();
                telaPrincipalProdutos.pack();
                telaPrincipalProdutos.setVisible(true);
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
        String titulos[] = { "Nome","Marca", "Codigo", "Preço","Quantidade"};
        List<Produto> produtos = lojaDao1.getLoja().getProdutos();
        List<Produto> produtoList = produtos.stream().toList();
        String dados[][] = new String[produtos.size()][5];

        for(int i=0; i<produtoList.size(); i++) {
            dados[i][0] = produtoList.get(i).getNome();
            dados[i][1] = produtoList.get(i).getCodigo();
            dados[i][2] = produtoList.get(i).getMarca();
            dados[i][3] = String.valueOf(produtoList.get(i).getQuantidade());
            dados[i][4] ="R$ " + String.valueOf(produtoList.get(i).getPreco());
        }

        DefaultTableModel model = new DefaultTableModel(dados, titulos);
        table1.setModel(model);
    }
}
