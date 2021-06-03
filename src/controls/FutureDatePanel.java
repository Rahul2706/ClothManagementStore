/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Rahul khurana
 */
public class FutureDatePanel extends javax.swing.JPanel {

    private GregorianCalendar gcal;

    public FutureDatePanel() {
        initComponents();
        gcal = new GregorianCalendar();
        jcbYear.removeAllItems();
        jcbYear.addItem("Year");
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        int current_year = gcal.get(Calendar.YEAR);
        for (int year = current_year; year <= current_year + 2; year++) {

            jcbYear.addItem(year);
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

        jcbYear = new javax.swing.JComboBox();
        jcbMonth = new javax.swing.JComboBox();
        jcbDate = new javax.swing.JComboBox();

        jcbYear.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jcbYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year" }));
        jcbYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbYearItemStateChanged(evt);
            }
        });

        jcbMonth.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jcbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month" }));
        jcbMonth.setToolTipText("");
        jcbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMonthItemStateChanged(evt);
            }
        });

        jcbDate.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jcbDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date" }));
        jcbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDateActionPerformed

    private void jcbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYearItemStateChanged
        MonthNames selected_month_value = null;
        if (jcbMonth.getSelectedIndex() > 0) {
            selected_month_value = (MonthNames) jcbMonth.getSelectedItem();
        }
        int selected_date_value = 0;
        if (jcbDate.getSelectedIndex() > 0) {
            selected_date_value = Integer.parseInt(jcbDate.getSelectedItem().toString());
        }
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        if (jcbYear.getSelectedIndex() > 0) {
            int selected_year = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int current_year = gcal.get(Calendar.YEAR);
            MonthNames[] months = MonthNames.values();
            int start_index = 0;
            if (selected_year == current_year) {
                start_index = gcal.get(Calendar.MONTH);
            }
            for (int index = start_index; index < months.length; index++) {
                jcbMonth.addItem(months[index]);
            }
            if (selected_month_value != null) {
                for (int index = 1; index < jcbMonth.getItemCount(); index++) {
                    MonthNames value = (MonthNames) jcbMonth.getItemAt(index);
                    if (value.ordinal() == selected_month_value.ordinal()) {
                        jcbMonth.setSelectedIndex(index);
                        break;
                    }
                }
                if (selected_date_value != 0) {
                    for (int index = 1; index < jcbDate.getItemCount(); index++) {
                        int value = Integer.parseInt(jcbDate.getItemAt(index).toString());
                        if (selected_date_value == value) {
                            jcbDate.setSelectedIndex(index);
                            break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jcbYearItemStateChanged

    private void jcbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMonthItemStateChanged
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        if (jcbMonth.getSelectedIndex() > 0 && jcbYear.getSelectedIndex() > 0) {
            int selected_year = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int current_year = gcal.get(Calendar.YEAR);
            MonthNames selected_month = (MonthNames) jcbMonth.getSelectedItem();
            int current_month = gcal.get(Calendar.MONTH);
            int end_date = selected_month.getDays();
            if (selected_year == current_year && current_month == selected_month.ordinal()) {
                end_date = gcal.get(Calendar.DATE);
            } else if (selected_month == MonthNames.February) {
                end_date = gcal.isLeapYear(selected_year) ? 29 : 28;
            }
            for (int date = 1; date <= end_date; date++) {
                jcbDate.addItem(date);
            }
        }
    }//GEN-LAST:event_jcbMonthItemStateChanged
    public Date getSelectedDate() {
        Date date_value = null;
        try {
            if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0 && jcbDate.getSelectedIndex() > 0) {
                int year = Integer.parseInt(jcbYear.getSelectedItem().toString());
                MonthNames selected_month = (MonthNames) jcbMonth.getSelectedItem();
                int month = selected_month.ordinal() + 1;
                int date = Integer.parseInt(jcbDate.getSelectedItem().toString());
                String date_string = year + "-" + month + "-" + date;
                date_value = Date.valueOf(date_string);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date_value;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jcbDate;
    private javax.swing.JComboBox jcbMonth;
    private javax.swing.JComboBox jcbYear;
    // End of variables declaration//GEN-END:variables

    public void setDate(Date date_value) {

        try {
            jcbYear.setSelectedIndex(0);
            String[] values = date_value.toString().split("-");
            int year = Integer.parseInt(values[0]);
            int month = Integer.parseInt(values[1]);
            int date = Integer.parseInt(values[2]);
            boolean set_status = false;
            for (int index = 1; index < jcbYear.getItemCount(); index++) {
                int value = Integer.parseInt(jcbYear.getItemAt(index).toString());
                if (value == year) {
                    jcbYear.setSelectedIndex(index);
                    set_status = true;
                    break;
                }
            }
            if (set_status) {
                set_status = false;
                for (int index = 1; index < jcbMonth.getItemCount(); index++) {
                    MonthNames value = (MonthNames) jcbMonth.getItemAt(index);
                    if (value.ordinal() == month - 1) {
                        jcbMonth.setSelectedIndex(index);
                        set_status = true;
                        break;
                    }
                }
                if (set_status) {
                    for (int index = 1; index < jcbDate.getItemCount(); index++) {
                        int value = Integer.parseInt(jcbDate.getItemAt(index).toString());
                        if (value == date) {
                            jcbDate.setSelectedIndex(index);
                            break;
                        }
                    }
                }
            }
        } catch (Exception ex) {

        }
    }

}
