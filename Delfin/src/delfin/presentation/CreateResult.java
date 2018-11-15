package delfin.presentation;

import delfin.data.*;
import delfin.logic.*;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;


/**
 *
 * @author Celina Dencker & Martin Frederiksen
 */
public class CreateResult extends javax.swing.JFrame {

    DataAccessor dam = null;
    DataAccessor dar = null;
    List<Member> members = null;
    
    /**
     * Creates new form CreateResult
     */
    public CreateResult() {
        initComponents();
        
        try {
            dam = new DataAccessorMember(new DBConnector());
            dar = new DataAccessorResult(new DBConnector());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Setup fail!");
        }
        
        messageLabel.setText("");
        members = (List<Member>)(Object)dam.getAll();
        
        ssnComboBox.removeAllItems();
        for(Member m : members)
            ssnComboBox.addItem(m.getSsn());
        
        disciplinComboBox.removeAllItems();
        
        for(DisciplinEnum status: DisciplinEnum.values())
            disciplinComboBox.addItem(status.toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ssnLabel = new javax.swing.JLabel();
        dayTextField = new javax.swing.JTextField();
        timeTextField = new javax.swing.JTextField();
        placementTextField = new javax.swing.JTextField();
        eventTextField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        placementLabel = new javax.swing.JLabel();
        eventLabel = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        monthTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();
        ssnComboBox = new javax.swing.JComboBox<>();
        eventLabel1 = new javax.swing.JLabel();
        disciplinComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Results");

        ssnLabel.setText("SSN:");

        dayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayTextFieldActionPerformed(evt);
            }
        });

        timeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeTextFieldActionPerformed(evt);
            }
        });

        placementTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placementTextFieldActionPerformed(evt);
            }
        });

        eventTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventTextFieldActionPerformed(evt);
            }
        });

        dateLabel.setText("Date:");

        timeLabel.setText("Time:");

        placementLabel.setText("Placement:");

        eventLabel.setText("Event:");

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        monthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthTextFieldActionPerformed(evt);
            }
        });

        yearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTextFieldActionPerformed(evt);
            }
        });

        messageLabel.setText("jLabel1");

        ssnComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        eventLabel1.setText("Disciplin");

        disciplinComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        disciplinComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disciplinComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(messageLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ssnLabel)
                                        .addComponent(dateLabel)
                                        .addComponent(timeLabel)
                                        .addComponent(eventLabel))
                                    .addGap(36, 36, 36))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(placementLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eventLabel1)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disciplinComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(placementTextField)
                            .addComponent(eventTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(timeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearTextField))
                            .addComponent(ssnComboBox, 0, 255, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ssnLabel)
                    .addComponent(ssnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateLabel)
                    .addComponent(dayTextField)
                    .addComponent(monthTextField)
                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placementLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disciplinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventLabel1))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(messageLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayTextFieldActionPerformed

    private void timeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeTextFieldActionPerformed
                                              
    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        try {
            if(dayTextField.getText().length() != 2 || Pattern.matches("[a-zA-Z]+", dayTextField.getText())) {
                showErrorMessage("Please type a valid day with two digits");
            }
            else if(Integer.parseInt(dayTextField.getText()) > 31 && 0 > Integer.parseInt(dayTextField.getText())) {
                showErrorMessage("Please type a valid day between 1 and 31");
            }
            else if(monthTextField.getText().length() != 2 || Pattern.matches("[a-zA-Z]+", monthTextField.getText())) {
                showErrorMessage("Please type a valid month with two digits");
            }
            else if(Integer.parseInt(monthTextField.getText()) > 12 && 0 > Integer.parseInt(monthTextField.getText())) {
                showErrorMessage("Please type a valid month between 12 and 1");
            }
            else{
                Result result = new Result(ssnComboBox.getSelectedItem().toString(), LocalDate.of(Integer.parseInt(yearTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(dayTextField.getText())), Double.parseDouble(timeTextField.getText()), Integer.parseInt(placementTextField.getText()), eventTextField.getText(), DisciplinEnum.valueOf(disciplinComboBox.getSelectedItem().toString()), new Member(null,null,null,null,null));
                dar.create(result);
                messageLabel.setText("<html><font color='green'>Member is created successfully!</font></html>");
            }
        } catch(Exception ex) {
            showErrorMessage(ex.getMessage());        
        }  
    }//GEN-LAST:event_createButtonActionPerformed
   
    private void placementTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placementTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placementTextFieldActionPerformed

    private void eventTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventTextFieldActionPerformed

    private void monthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthTextFieldActionPerformed

    private void yearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearTextFieldActionPerformed

    private void disciplinComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disciplinComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disciplinComboBoxActionPerformed
    
    private void showErrorMessage(String message) {
        messageLabel.setText("<html><font color='red'>"+ message + "</font></html>");
    }
    
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
            java.util.logging.Logger.getLogger(CreateResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dayTextField;
    private javax.swing.JComboBox<String> disciplinComboBox;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JLabel eventLabel1;
    private javax.swing.JTextField eventTextField;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField monthTextField;
    private javax.swing.JLabel placementLabel;
    private javax.swing.JTextField placementTextField;
    private javax.swing.JComboBox<String> ssnComboBox;
    private javax.swing.JLabel ssnLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeTextField;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
