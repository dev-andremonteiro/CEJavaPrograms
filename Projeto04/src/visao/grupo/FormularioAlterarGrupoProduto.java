package visao.grupo;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import negocio.GrupoProduto;
import negocio.NegocioException;
import vo.GrupoProdutoVO;

public class FormularioAlterarGrupoProduto extends JDialog {

    private int codigoGrupo;
    private GrupoProduto grupo;

    public FormularioAlterarGrupoProduto(int codigo) {
        this.codigoGrupo = codigo;
        initComponents();
        try {
            grupo = new GrupoProduto();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.preecheCampos();
    }

    private void confirmaOperacao() {

        int codigo=0;
        String nome=null;
        float promocao=0;
        float margem=0;

        try {
            codigo = Integer.parseInt(campoCodigo.getText());
            nome = this.campoNome.getText();
            margem = Float.parseFloat(this.campoMargem.getText());
            promocao = Float.parseFloat(this.campoPromocao.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Digitacao inconscistente");
            return;
        }

        try {
            GrupoProdutoVO grupoVO = new GrupoProdutoVO();
            grupoVO.setCodigo(codigo);
            grupoVO.setNome(nome);
            grupoVO.setMargemLucro(margem);
            grupoVO.setPromocao(promocao);
            grupo.alterar(grupoVO);
            JOptionPane.showMessageDialog(this, "Alteração realizada com sucesso");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void preecheCampos(){
        try {
            GrupoProdutoVO grupoVO = grupo.buscarPorCodigo(codigoGrupo);

            if (grupoVO != null) {
                this.campoCodigo.setText(String.valueOf(grupoVO.getCodigo()));
                this.campoNome.setText(grupoVO.getNome());
                this.campoMargem.setText(String.valueOf(grupoVO.getMargemLucro()));
                this.campoPromocao.setText(String.valueOf(grupoVO.getPromocao()));
            }
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao recuperar dados de produtos \n" + ex.toString());
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        campoPromocao = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoMargem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();

        setTitle("Alteração de Grupo de Produtos");
        setBackground(new java.awt.Color(204, 204, 204));
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 60, 60, 20);

        jLabel3.setText("% Margem Lucro");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 90, 120, 20);

        jLabel4.setText("% Promoção");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 120, 90, 20);

        botaoConfirma.setText("Confirmar");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoConfirma);
        botaoConfirma.setBounds(50, 180, 110, 30);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCancelar);
        botaoCancelar.setBounds(300, 180, 110, 30);
        getContentPane().add(campoPromocao);
        campoPromocao.setBounds(150, 120, 100, 20);
        getContentPane().add(campoNome);
        campoNome.setBounds(150, 60, 290, 20);
        getContentPane().add(campoMargem);
        campoMargem.setBounds(150, 90, 100, 20);

        jLabel5.setText("Código");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 30, 60, 20);

        campoCodigo.setEditable(false);
        getContentPane().add(campoCodigo);
        campoCodigo.setBounds(150, 30, 100, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-469)/2, (screenSize.height-250)/2, 469, 250);
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
    this.confirmaOperacao();
    this.closeDialog(null);
}//GEN-LAST:event_botaoConfirmaActionPerformed

private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
    this.closeDialog(null);
}//GEN-LAST:event_botaoCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoMargem;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPromocao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
    
}
