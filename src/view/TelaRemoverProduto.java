import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import model.Loja;

public class TelaRemoverProduto extends JDialog {
    private JPanel contentPane;
    private JButton removerButton;
    private JButton cancelarButton;
    private JTextField codigoInput;
    private JTextField cpfInput;
    private LojaDao lojaDao;

    public TelaRemoverProduto() {
        lojaDao = new LojaDao();
        List<Produto> produtos = lojaDao.getLoja().getProdutos();

        setContentPane(contentPane);
        getRootPane().setDefaultButton(removerButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String codigo =  codigoInput.getText();
                boolean valida = false;
                List<Produto> produtosAtualizados = new ArrayList<>();

                for(Produto produto:produtos){
                    if(!produto.getCodigo().equals(codigo)){
                        valida=true;
                        produtosAtualizados.add(produto);
                    }
                }


                if(!valida){
                    JOptionPane.showMessageDialog(contentPane,
                            "Falha ao remover produto, código inválido!",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);

                   TelaRemoverProduto telaRemoverProduto  = new TelaRemoverProduto();
                   telaRemoverProduto.pack();
                   telaRemoverProduto.setVisible(true);
                   setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(contentPane,"Produto removido com sucesso!");
                    Loja loja = lojaDao.getLoja();
                    loja.setProdutos(produtosAtualizados);
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
