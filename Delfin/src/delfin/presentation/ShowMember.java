/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.presentation;
import delfin.data.*;
import delfin.logic.Member;
import java.awt.FontMetrics;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author Joe
 */
public class ShowMember extends javax.swing.JFrame {

    /**
     * Creates new form ShowMember
     */
    public ShowMember() {
        initComponents();
        
        int count = 0;
        DataAccessor data = null;
        List<Member> members = null;
        
        try{
            data = new DataAccesorMember(new DBConnector());
            members = (List<Member>)(Object)data.getAll();
            count = members.size();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Fail to setup");
        }
        int rowCount = 0;
        
        while( jTable1.getRowCount() < count){
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{});
        }
        int max = 0;
        for(Member m: data.getMembers()) {
            if( max < m.getSsn().length()) max = m.getSsn().length();
            
            TableColumn column = null;
        
            for (int i = 0; i < 8; i++) {
            column = jTable1.getColumnModel().getColumn(i);
            if (column.getWidth() < max) {
                column.setPreferredWidth(max); //third column is bigger
            } 
            else {
                
                column.setPreferredWidth(25);
            }
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            }
            
            jTable1.setValueAt(m.getSsn(), rowCount, 0);
            jTable1.setValueAt(m.getSsn(), rowCount, 1);
            jTable1.setValueAt(m.getName(), rowCount, 2);
            jTable1.setValueAt(m.getAddress(), rowCount, 3);
            jTable1.setValueAt(m.getPhone(), rowCount, 4);
            jTable1.setValueAt(m.getActivityInfo().getActivity(), rowCount, 5);
            jTable1.setValueAt(m.getActivityInfo().getStatus(), rowCount, 6);
            jTable1.setValueAt(m.getActivityInfo().getTeam(), rowCount, 7);
            rowCount ++;
        }     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ssn", "Name", "Address", "Phone", "Activity", "Contender", "Category"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ShowMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowMember sM = new ShowMember();
                sM.setTitle("Members");
                sM.setVisible(true);
                
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
