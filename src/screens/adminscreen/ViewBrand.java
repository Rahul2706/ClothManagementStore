/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.adminscreen;

import Operations.CommonOperations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.To.BrandInfoTO;
import model.To.CategoryInfoTO;
import model.dao.BrandInfoDAO;
import model.dao.CategoryInfoDAO;

/**
 *
 * @author Rahul khurana
 */
public class ViewBrand extends javax.swing.JInternalFrame {

    private List<BrandInfoTO> brand;
    private JPopupMenu popup;
    private int srow;

    public ViewBrand() {
        initComponents();
        bindTableDetails();
        preparePopupMenu();
        srow = -1;
    }

    private void preparePopupMenu() {
        popup = new JPopupMenu();
        JMenuItem delete_item = new JMenuItem("Delete This Record");
        JMenuItem edit_item = new JMenuItem("Edit This Record");
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/photos/edits.png"));
            edit_item.setIcon(icon);
        } catch (Exception ex) {
        }
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/photos/Delete.png"));
            delete_item.setIcon(icon);
        } catch (Exception ex) {
        }

        popup.add(delete_item);
        popup.add(edit_item);
        delete_item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delete_record();
            }
        });
        edit_item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                edit_record();
            }
        });

    }

    public void delete_record() {
        if (srow != -1 && brand != null && srow < brand.size()) {
            BrandInfoTO record = brand.get(srow);
            if (record != null) {
                int result = JOptionPane.showConfirmDialog(this, "Are You Sure To Removed This Record?", "Message From Admin", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    BrandInfoDAO action = new BrandInfoDAO();
                    String message = "";
                    if (action.deleteRecord(record.getBrandid())) {
                        message = "Record is Removed From System Database";
                    } else {
                        message = "Deletion Failure Due To " + action.getError_message();
                        bindTableDetails();
                    }
                    JOptionPane.showMessageDialog(this, message);
                }
            }
        }

        srow = -1;
    }

    public void edit_record() {
        if (srow != -1 && brand != null && srow < brand.size()) {
            BrandInfoTO record = brand.get(srow);
            if (record != null) {
                CommonOperations.showInternalFrame(getDesktopPane(), new AddNewBrand(record));
                dispose();

            }

        }
        srow = -1;
    }

    public void bindTableDetails() {
        brand = new BrandInfoDAO().getAllRecord();
        String[] col_name = {"BrandID ", "Brand Name"};
        Object[][] records = null;
        if (brand != null && brand.size() > 0) {
            records = new Object[brand.size()][col_name.length];
            int index = 0;
            for (BrandInfoTO bt : brand) {
                records[index] = new Object[]{bt.getBrandid(), bt.getBrandname()};
                index++;
            }
        } else {
            records = new Object[1][col_name.length];
            records[0] = new Object[]{"No Record ", "No Record"};
        }
        DefaultTableModel model
                = new DefaultTableModel(records, col_name) {

                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
        tableBrand.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBrand = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("ViewAssignedBrands");

        btnRefresh.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnRefresh.setText("Refresh Details");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tableBrand.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBrandMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBrand);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        bindTableDetails();

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tableBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBrandMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            //System.out.println("Right Clicked");
            int row_point = tableBrand.rowAtPoint(evt.getPoint());
            tableBrand.getSelectionModel().setSelectionInterval(row_point, row_point);
            popup.show(tableBrand, evt.getX(), evt.getY());
            //System.out.println(tableCategory.getSelectedRow());
            srow = tableBrand.getSelectedRow();
        }
    }//GEN-LAST:event_tableBrandMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBrand;
    // End of variables declaration//GEN-END:variables
}
