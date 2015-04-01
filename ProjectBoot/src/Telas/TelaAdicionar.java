package Telas;

import Classes.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaAdicionar extends javax.swing.JFrame {

    public TelaAdicionar() {
        initComponents();
        PopulateTable(); //Chamamos no começo, pra tabela já sair bem exibida na tela
    }

    ArrayList <String> AllTags = new ArrayList<> (); //ArrayList auxiliar, a ser usada no Botão + (PlusButton)
        
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NomeLabel = new javax.swing.JLabel();
        URLLabel = new javax.swing.JLabel();
        ComentariosLabel = new javax.swing.JLabel();
        TagLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComentariosCampo = new javax.swing.JTextArea();
        SalvarButton = new javax.swing.JButton();
        TagCampo = new javax.swing.JTextField();
        NomeCampo = new javax.swing.JTextField();
        URLCampo = new javax.swing.JTextField();
        PlusButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TagsTable = new javax.swing.JTable();
        addExistingTags = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        RemoveTagLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar Hyperlink", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 255))); // NOI18N

        NomeLabel.setText("Nome:");

        URLLabel.setText("URL:");

        ComentariosLabel.setText("Comentários:");

        TagLabel.setText("Adicionar Tag:");

        ComentariosCampo.setColumns(20);
        ComentariosCampo.setRows(5);
        jScrollPane1.setViewportView(ComentariosCampo);

        SalvarButton.setText("Salvar");
        SalvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarButtonActionPerformed(evt);
            }
        });

        PlusButton.setText("+");
        PlusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusButtonActionPerformed(evt);
            }
        });

        TagsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TagsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TagsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TagsTable);

        addExistingTags.setText("Adicionar Tags Existentes");
        addExistingTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExistingTagsActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        RemoveTagLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RemoveTagLabel.setText("Clique na tag para removê-la");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(URLLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(URLCampo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(TagCampo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PlusButton))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComentariosLabel)
                                .addComponent(TagLabel))
                            .addComponent(addExistingTags))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelButton)
                                .addGap(17, 17, 17)
                                .addComponent(SalvarButton))
                            .addComponent(RemoveTagLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(URLLabel)
                    .addComponent(NomeLabel)
                    .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(URLCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ComentariosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TagLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveTagLabel)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 39, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton)
                            .addComponent(SalvarButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TagCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlusButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addExistingTags)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarButtonActionPerformed
        HyperLink novoHyperlink;
        String nome = NomeCampo.getText();
        String URL = URLCampo.getText();
        String AllComentarios = ComentariosCampo.getText();
        String[] Comentarios = AllComentarios.split("\\s*\n\\s*");
        String[] Tags = (String[]) AllTags.toArray(new String[AllTags.size()]);
        Date criacao = new Date();
        novoHyperlink = new HyperLink(-1, nome, URL, Tags, Comentarios, criacao, null);
        DatabaseHandle dbh = new DatabaseHandle();
        dbh.saveNewLink(novoHyperlink);
        JOptionPane.showMessageDialog(this, "Adicionado com sucesso");
        this.dispose();
        new TelaInicial().setVisible(true);
    }//GEN-LAST:event_SalvarButtonActionPerformed
    
    // Início de uma função auxiliar que transforma uma tabela adicionada no
    //JFrame em uma tabela de uma única coluna, onde serão adicionadas as Tags 
    private void PopulateTable () {
        DefaultTableModel dtm = new DefaultTableModel();
        String[] Cabecalho = new String[]{"Tags"};
        dtm.setColumnIdentifiers(Cabecalho);
        TagsTable.setModel(dtm);
        for(String tag: AllTags){
            dtm.addRow(new Object[]{tag});
        }
    } // Fim da função auxiliar
        
    // Definição do botão + de adição de Tags
    private void PlusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlusButtonActionPerformed
        if (TagCampo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escreva um nome para a tag!");
        } else {
            if(!AllTags.contains(TagCampo.getText())) {
                AllTags.add(TagCampo.getText());
                PopulateTable();
            }
            TagCampo.setText("");
        }
    }//GEN-LAST:event_PlusButtonActionPerformed

    private void addExistingTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExistingTagsActionPerformed
        ArrayList<Integer> selectedIDs =  SelectTags.showTagsForSelection();
        DatabaseHandle dbh = new DatabaseHandle();
        Map<String, Integer> tags = dbh.getTagsByID(selectedIDs);
        for(String key: tags.keySet()) {
            if(!AllTags.contains(key)) {
                AllTags.add(key);
            }
        }
        PopulateTable();
    }//GEN-LAST:event_addExistingTagsActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
        new TelaInicial().setVisible(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void TagsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TagsTableMouseClicked
        String tag = (String)TagsTable.getValueAt(TagsTable.rowAtPoint(evt.getPoint()), TagsTable.columnAtPoint(evt.getPoint()));
        AllTags.remove(tag);
        PopulateTable();
    }//GEN-LAST:event_TagsTableMouseClicked
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new TelaAdicionar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComentariosCampo;
    private javax.swing.JLabel ComentariosLabel;
    private javax.swing.JTextField NomeCampo;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JButton PlusButton;
    private javax.swing.JLabel RemoveTagLabel;
    private javax.swing.JButton SalvarButton;
    private javax.swing.JTextField TagCampo;
    private javax.swing.JLabel TagLabel;
    private javax.swing.JTable TagsTable;
    private javax.swing.JTextField URLCampo;
    private javax.swing.JLabel URLLabel;
    private javax.swing.JButton addExistingTags;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
