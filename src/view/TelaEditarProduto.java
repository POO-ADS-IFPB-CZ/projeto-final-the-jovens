import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import model.Produto;
import model.Loja;

public class TelaEditarProduto extends JDialog {
    private JPanel contentPane;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JTextField codigoInput;
    private JTextField marcaInput;
    private JTextField precoInput;
    private JTextField nomeInput;
    private JTextField quantidadeInput;

    private LojaDao lojaDao;

    public TelaEditarProduto() {
        lojaDao= new LojaDao();

        List<Produto> produtos = lojaDao.getLoja().getProdutos();
        setContentPane(contentPane);
        getRootPane().setDefaultButton(salvarButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeInput.getText();
                String codigo = codigoInput.getText();
                double preco =  Double.parseDouble(precoInput.getText());
                int quantidade = Integer.parseInt(quantidadeInput.getText());
                String  marca = marcaInput.getText();

                boolean valida = false;
                for(Produto produto:produtos){
                    if(produto.getCodigo().equals(codigo)){
                        valida=true;
                        produto.setNome(nome);
                        produto.setPreco(preco);
                        produto.setQuantidade(quantidade);
                        produto.setMarca(marca);
                    }
                }

                if(!valida){
                    JOptionPane.showMessageDialog(contentPane,
                            "Falha ao atualizar produto!",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);

                    TelaEditarProduto telaEditarProduto = new TelaEditarProduto();
                    telaEditarProduto.pack();
                    telaEditarProduto.setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(contentPane,"Produto atualizado com sucesso!");
                    Loja loja = lojaDao.getLoja();
                    loja.setProdutos(produtos);
                    lojaDao.salvarLoja(loja);

                    TelaPrincipalProdutos telaPrincipalProdutos  = new TelaPrincipalProdutos();
                    telaPrincipalProdutos.pack();
                    telaPrincipalProdutos.setVisible(true);
                    setVisible(false);
                }

            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalProdutos telaPrincipalProdutos  = new TelaPrincipalProdutos();
                telaPrincipalProdutos.pack();
                telaPrincipalProdutos.setVisible(true);
                setVisible(false);
            }
        });
    }
}
