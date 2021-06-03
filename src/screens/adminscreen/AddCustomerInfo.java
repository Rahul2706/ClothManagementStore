/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.adminscreen;

import Operations.CommonOperations;
import Operations.Validations;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.To.CustomerInfoTO;
import model.dao.CustomerInfoDAO;

/**
 *
 * @author Rahul khurana
 */
public class AddCustomerInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddCustomerInfo
     */
    public AddCustomerInfo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jcbUserName = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAssigned = new javax.swing.JButton();
        jtfCustomerName = new javax.swing.JTextField();
        jtfAddress = new javax.swing.JTextField();
        jtfContactNo = new javax.swing.JTextField();
        fdpEntryDate = new controls.FutureDatePanel();
        lblCustomerNameError = new javax.swing.JLabel();
        lblContactNoError = new javax.swing.JLabel();
        lblAddressError = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Customer Details");

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel3.setText("User Name :-");

        jcbUserName.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jcbUserName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbUserNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel4.setText("Customer Name :-");

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel5.setText("Contact No. :-");

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel6.setText("Entry Date");

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel7.setText("Address :-");

        btnAssigned.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnAssigned.setText("Assign Customer Details");
        btnAssigned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignedActionPerformed(evt);
            }
        });

        jtfCustomerName.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jtfCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCustomerNameActionPerformed(evt);
            }
        });

        jtfAddress.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jtfAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAddressActionPerformed(evt);
            }
        });

        jtfContactNo.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jtfContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfContactNoActionPerformed(evt);
            }
        });

        lblCustomerNameError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Error.png"))); // NOI18N

        lblContactNoError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Error.png"))); // NOI18N

        lblAddressError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Error.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnAssigned, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcbUserName, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfCustomerName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfContactNo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fdpEntryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jtfAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustomerNameError)
                            .addComponent(lblContactNoError)
                            .addComponent(lblAddressError))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCustomerName)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblCustomerNameError)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfContactNo, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblContactNoError)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblAddressError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fdpEntryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnAssigned, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbUserNameActionPerformed

    private void btnAssignedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignedActionPerformed
        String message = "";
        boolean allvalid = true;
        if (jcbUserName.getSelectedIndex() == 0) {
            message += "Please Chosse Your UserName\n\n ";
            allvalid = false;
        }
        String CustomerName = jtfCustomerName.getText().trim();
        if (Validations.isEmpty(CustomerName)) {
            message += "Please Enter Some Value In Customer Name Box\n\n";
            lblCustomerNameError.setVisible(true);
            lblCustomerNameError.setToolTipText("Please Enter Some Value In Customer Name Box");
            allvalid = false;
        }
        String ContactNo = jtfContactNo.getText().trim();
        if (Validations.isEmpty(ContactNo)) {
            message += "Please Enter Some Value In Contact No. Box\n\n";
            lblContactNoError.setVisible(true);
            lblContactNoError.setToolTipText("Please Enter Some Value In Contact NO. Box");
            allvalid = false;
        }
        String Address = jtfAddress.getText().trim();
        if (Validations.isEmpty(Address)) {
            message += "Please Enter Some Value In Address Box\n\n";
            lblAddressError.setVisible(true);
            lblAddressError.setToolTipText("Please Enter Some Value In Address Box");
            allvalid = false;
        }
        Date Entrydate = fdpEntryDate.getSelectedDate();
        if ( Entrydate == null) {
            message += "Please Choose Any Entry Date\n\n";
            allvalid = false;
        }

        if (allvalid) {
            CustomerInfoTO record = new CustomerInfoTO();
            CustomerInfoTO cit = (CustomerInfoTO) jcbUserName.getSelectedItem();
            record.setUsername(cit.getUsername());
            record.setCustomername(CustomerName);
            record.setContactno(ContactNo);
            record.setAddress(Address);
            record.setEntrydate(Entrydate);
            CustomerInfoDAO action = new CustomerInfoDAO();
            if (btnAssigned.getText().contains("Assign")) {
                if (action.insertRecord(record)) {
                    message = "Customer Details is Assigned";
                } else {
                    message = "Insertion Failure" + action.getError_message();
                    allvalid = false;
                }
            } else if (btnAssigned.getText().contains("Update")) {

                if (action.updateRecord(record)) {
                    message = " ClothStock information is Updation";

                } else {
                    message = "Updation Failure Due To : " + action.getError_message();
                }
                CommonOperations.showInternalFrame(getDesktopPane(), new ViewCustomerInfo());
                dispose();
            } else {
                message = "Invalid Operation";
            }

        }

        if (allvalid) {
            JOptionPane.showMessageDialog(this, message);
        } else {
            JOptionPane.showMessageDialog(this, message, "Some Failure", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAssignedActionPerformed

    private void jtfCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCustomerNameActionPerformed

    private void jtfAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAddressActionPerformed

    private void jtfContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfContactNoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssigned;
    private controls.FutureDatePanel fdpEntryDate;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox jcbUserName;
    private javax.swing.JTextField jtfAddress;
    private javax.swing.JTextField jtfContactNo;
    private javax.swing.JTextField jtfCustomerName;
    private javax.swing.JLabel lblAddressError;
    private javax.swing.JLabel lblContactNoError;
    private javax.swing.JLabel lblCustomerNameError;
    // End of variables declaration//GEN-END:variables
}
