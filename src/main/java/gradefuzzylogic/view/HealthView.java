package gradefuzzylogic.view;

import gradefuzzylogic.logic.HealthLogic;
import javax.swing.table.DefaultTableModel;

public class HealthView extends javax.swing.JFrame {
    private HealthLogic logic;
    private static double height, weight;
    private DefaultTableModel resultTableModel;
    
    public HealthView() {
        initComponents();
        resultTableModel = (DefaultTableModel) resultTable.getModel();
    }

    public void setResult(int flag) {
        String[] result;
        
        logic = new HealthLogic(height, weight);
        resultTableModel.setRowCount(0);
        resultTableModel.addRow(new Object[]{"INDEX", "RESULT"});
        
        if (flag == 1) {
            result = logic.maxMethod();
                       
            resultTable.setValueAt(result[0], resultTableModel.getRowCount() - 1, 0);
            resultTable.setValueAt(result[1], resultTableModel.getRowCount() - 1, 1);
        } else {
            result = logic.sugenoMethod();
            
            resultTable.setValueAt(result[0], resultTableModel.getRowCount() - 1, 0);
            resultTable.setValueAt(result[1], resultTableModel.getRowCount() - 1, 1);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        weightLabel = new javax.swing.JLabel();
        heightTextField = new javax.swing.JTextField();
        weightTextField = new javax.swing.JTextField();
        maxButton = new javax.swing.JButton();
        sugenoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(204, 255, 255));
        backgroundPanel.setToolTipText("");

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setText("HEALTH FUZZY LOGIC");

        heightLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        heightLabel.setText("Height :");

        weightLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        weightLabel.setText("Weight :");

        maxButton.setText("MAX");
        maxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxButtonActionPerformed(evt);
            }
        });

        sugenoButton.setText("SUGENO");
        sugenoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sugenoButtonActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INDEX", "RESULT"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addComponent(maxButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sugenoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(weightLabel)
                            .addComponent(heightLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(heightTextField)
                            .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titleLabel)
                .addGap(31, 31, 31)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heightLabel)
                    .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightLabel)
                    .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sugenoButton)
                    .addComponent(maxButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxButtonActionPerformed
        height = Double.valueOf(heightTextField.getText());
        weight = Double.valueOf(weightTextField.getText());
        
        setResult(1);
    }//GEN-LAST:event_maxButtonActionPerformed

    private void sugenoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sugenoButtonActionPerformed
        height = Double.valueOf(heightTextField.getText());
        weight = Double.valueOf(weightTextField.getText());
        
        setResult(2);
    }//GEN-LAST:event_sugenoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(HealthView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HealthView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HealthView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HealthView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HealthView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton maxButton;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton sugenoButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel weightLabel;
    private javax.swing.JTextField weightTextField;
    // End of variables declaration//GEN-END:variables
}
