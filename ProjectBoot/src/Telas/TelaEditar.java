package Telas;

import Classes.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaEditar extends javax.swing.JFrame {

    private HyperLink Editando;
    private int id;
    ArrayList <String> AllTags = new ArrayList<> (); //ArrayList auxiliar, a ser usada no Botão + (PlusButton)
        
    public TelaEditar(int LinkID) {
        this.id = LinkID;
        initComponents();
        DatabaseHandle dbh = new DatabaseHandle();
        Editando = dbh.getLinkByID(id);
        DateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
        NomeCampo.setText(Editando.getName());
        URLCampo.setText(Editando.getURL());
        ComentariosCampo.setText(Editando.getAllComments());
        AllTags.addAll(Arrays.asList(Editando.getTags()));
        PopulateTable();
        CreationLabel.setText(dateFormat.format(Editando.getCreation()));
        if (Editando.getModification() != null) {
            ModificationLabel.setText(dateFormat.format(Editando.getModification()));
        }
        else ModificationLabel.setText("Hyperlink nunca modificado");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NomeCampo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        URLCampo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComentariosCampo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        CreationLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ModificationLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TagsTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        TagCampo = new javax.swing.JTextField();
        PlusButton = new javax.swing.JButton();
        addExistingTags = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Hyperlink", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setText("Nome:");

        jLabel2.setText("URL:");

        jLabel3.setText("Comentários:");

        ComentariosCampo.setColumns(20);
        ComentariosCampo.setRows(5);
        jScrollPane1.setViewportView(ComentariosCampo);

        jLabel4.setText("Tags:");

        SaveButton.setText("Salvar");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancelar");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Data de Criação:");

        CreationLabel.setText("DD/MM/AA    HH:MM:SS");

        jLabel6.setText("Última Modificação:");

        ModificationLabel.setText("DD/MM/AA      HH:MM:SS");

        deleteButton.setText("Apagar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
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
        jScrollPane3.setViewportView(TagsTable);

        jLabel7.setText("Adicionar Tag: (Clique para remover)");

        PlusButton.setText("+");
        PlusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusButtonActionPerformed(evt);
            }
        });

        addExistingTags.setText("Adicionar Tags Existentes");
        addExistingTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExistingTagsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(URLCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(CreationLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ModificationLabel)))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TagCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PlusButton))
                            .addComponent(addExistingTags))
                        .addGap(35, 35, 35)
                        .addComponent(CancelButton))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CancelButton, SaveButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(URLCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreationLabel)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ModificationLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(SaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CancelButton)
                            .addComponent(deleteButton))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TagCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlusButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addExistingTags))))
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

    private void PopulateTable () {
        DefaultTableModel dtm = new DefaultTableModel();
        String[] Cabecalho = new String[]{"Tags"};
        dtm.setColumnIdentifiers(Cabecalho);
        TagsTable.setModel(dtm);
        AllTags.stream().forEach((tag) -> {
            dtm.addRow(new Object[]{tag});
        });
    }
    
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
        new TelaBusca().setVisible(true);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        ArrayList<String> comentariosTodos = new ArrayList<>(Arrays.asList(ComentariosCampo.getText().split("\\s*\n\\s*")));
        ArrayList<String> comentariosRemover = new ArrayList<>();
        for(String comentario: Editando.getComments()) {
            if(comentariosTodos.contains(comentario)) {
                comentariosTodos.remove(comentario);
            }
            else {
                comentariosRemover.add(comentario);
            }
        }
        
        ArrayList<String> tagsRemover = new ArrayList<>();
        for(String tag: Editando.getTags()) {
            if(AllTags.contains(tag)) {
                AllTags.remove(tag);
            }
            else {
                tagsRemover.add(tag);
            }
        }
        
        DatabaseHandle dbh = new DatabaseHandle();
        HyperLink NewLink = new HyperLink(id, NomeCampo.getText(), URLCampo.getText(), AllTags.toArray(new String[AllTags.size()]), comentariosRemover.toArray(new String[comentariosRemover.size()]), null, new Date());
        dbh.alterLink(NewLink, tagsRemover, comentariosRemover);
        
        this.dispose();
        new TelaBusca().setVisible(true);
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DatabaseHandle dbh = new DatabaseHandle();
        dbh.deleteLink(Editando.getID());
        this.dispose();
        new TelaBusca().setVisible(true);
    }//GEN-LAST:event_deleteButtonActionPerformed

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
            if(!AllTags.contains(key))
                AllTags.add(key);
        }
        PopulateTable();
    }//GEN-LAST:event_addExistingTagsActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            //new TelaEditar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextArea ComentariosCampo;
    private javax.swing.JLabel CreationLabel;
    private javax.swing.JLabel ModificationLabel;
    private javax.swing.JTextField NomeCampo;
    private javax.swing.JButton PlusButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField TagCampo;
    private javax.swing.JTable TagsTable;
    private javax.swing.JTextField URLCampo;
    private javax.swing.JButton addExistingTags;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
