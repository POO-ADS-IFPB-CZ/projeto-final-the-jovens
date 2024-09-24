import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import model.Loja;
import model.Produto;

public class TelaAdicionaProduto extends JDialog {
    private JPanel contentPane;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JTextField inputCodigo;
    private JTextField inputNome;
    private JTextField inputMarca;
    private JTextField inputPreco;
    private JTextField inputQuantidade;

    private LojaDao lojaDao = new LojaDao();
    public TelaAdicionaProduto(Loja loja) {
        setContentPane(contentPane);
        pack();
        getRootPane().setDefaultButton(salvarButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = inputNome.getText();
                String codigo = inputCodigo.getText();
                String marca = inputMarca.getText();
                double preco = Double.parseDouble(inputPreco.getText()) ;
                int quantidade = Integer.parseInt(inputQuantidade.getText()) ;
                Produto produto = new Produto(nome,codigo,preco,quantidade,marca);
                List<Produto> produtos = lojaDao.getLoja().getProdutos();

                boolean verifica= false;
                for(Produto produto1:produtos){
                    if(produto1.getCodigo().equals(codigo)){
                        verifica=true;
                    }
                }

                if (!verifica) {
                    loja.adicionarProduto(produto);
                    lojaDao.salvarLoja(loja);
                    JOptionPane.showMessageDialog(contentPane, "Produto adicionado com sucesso!");
                    TelaPrincipalProdutos telaPrincipalProdutos = new TelaPrincipalProdutos();
                    telaPrincipalProdutos.pack();
                    telaPrincipalProdutos.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(contentPane,
                            "Falha ao adicionar produto com código igual!",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalProdutos telaPrincipalProdutos = new TelaPrincipalProdutos();
                telaPrincipalProdutos.pack();
                telaPrincipalProdutos.setVisible(true);
                setVisible(false);
            }
        });
    }
}
