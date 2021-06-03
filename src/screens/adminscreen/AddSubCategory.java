package screens.adminscreen;

import Operations.CommonOperations;
import Operations.Validations;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.To.CategoryInfoTO;
import model.To.SubCategoryTO;
import model.dao.CategoryInfoDAO;
import model.dao.SubCategoryDAO;
import mondrian.olap.Category;

public class AddSubCategory extends javax.swing.JInternalFrame {

    
    private int subcategory_id;
    public AddSubCategory() {
        initComponents();
        
        jcbCategory.removeAllItems();
        jcbCategory.addItem("Select Any Category");
        List<CategoryInfoTO> category = new CategoryInfoDAO().getAllRecord();
        if (category != null && category.size() > 0) {
            for (CategoryInfoTO ct : category) {
                jcbCategory.addItem(ct);
            }
        }
        lblSubCategoryNameError.setVisible(false);
    }

    public AddSubCategory(int subcategory_id) {
        this();
        SubCategoryTO record = new SubCategoryDAO().getRecord(subcategory_id);
        if (record != null) {
            this.subcategory_id = subcategory_id;
            setTitle("Edit SubCategory Details ");
            btnAssign.setText("Update SubCategory Details");
            
            for (int i = 1; i < jcbCategory.getItemCount(); i++) {
                CategoryInfoTO cit = (CategoryInfoTO) jcbCategory.getItemAt(i);
                if (cit.getCategoryid().equals(record.getCategoryid())) {
                    jcbCategory.setSelectedIndex(i);
                    break;
                }
            }
            jtfSubCategoryName.setText(record.getSubcategoryname());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfSubCategoryName = new javax.swing.JTextField();
        jcbCategory = new javax.swing.JComboBox();
        btnAssign = new javax.swing.JButton();
        lblSubCategoryNameError = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add New SubCategory");

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("Enter SubCategory Name:-");

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel2.setText("Choose Category:-");

        jtfSubCategoryName.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jtfSubCategoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSubCategoryNameActionPerformed(evt);
            }
        });

        jcbCategory.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jcbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCategoryActionPerformed(evt);
            }
        });

        btnAssign.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btnAssign.setText("Add SubCategory");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        lblSubCategoryNameError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Error.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jtfSubCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSubCategoryNameError))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSubCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblSubCategoryNameError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        String message = "";
        boolean allvalid = true;
        if (jcbCategory.getSelectedIndex() == 0) {
            message += "Please Choose Any Category\n\n ";
            allvalid = false;
        }

        String SubCategoryName = jtfSubCategoryName.getText().trim();
        if (Validations.isEmpty(SubCategoryName)) {
            message += "Please Enter Some Value In SubCategoryName Box\n\n";
            lblSubCategoryNameError.setVisible(true);
            lblSubCategoryNameError.setToolTipText("Please Enter Some Value In SubCategoryName Box");
            allvalid = false;
        }
        if (allvalid) {
            SubCategoryTO record = new SubCategoryTO();
            CategoryInfoTO ct = (CategoryInfoTO) jcbCategory.getSelectedItem();
            record.setCategoryid(ct.getCategoryid());
            record.setSubcategoryname(SubCategoryName);
            SubCategoryDAO action = new SubCategoryDAO();
            if (btnAssign.getText().contains("Add")) {
                if (action.insertRecord(record)) {
                    message = "SubCategory is Added";
                } else {
                    message = "Insertion Failure" + action.getError_message();
                    allvalid = false;
                }
            } else if (btnAssign.getText().contains("Update")) {
                record.setSubcategoryid(subcategory_id);
                if (action.updateRecord(record)) {
                    message = " SubCategory information is Updation";
                    bonus_action();
                } else {
                    message = " Updation Failure Due To : " + action.getError_message();
                    allvalid = false;
                }
                CommonOperations.showInternalFrame(getDesktopPane(), new ViewSubCategory());
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
    }//GEN-LAST:event_btnAssignActionPerformed

    private void jtfSubCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSubCategoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSubCategoryNameActionPerformed

    private void jcbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCategoryActionPerformed
    private void bonus_action() {
        JInternalFrame[] all_frames = getDesktopPane().getAllFrames();
        if (all_frames != null && all_frames.length > 0) {
            for (JInternalFrame jif : all_frames) {
                if (jif instanceof ViewSubCategory) {
                    ViewSubCategory vsc = (ViewSubCategory) jif;
                    vsc.bindTableDetails();
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox jcbCategory;
    private javax.swing.JTextField jtfSubCategoryName;
    private javax.swing.JLabel lblSubCategoryNameError;
    // End of variables declaration//GEN-END:variables
}
