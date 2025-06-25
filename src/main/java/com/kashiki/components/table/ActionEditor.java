/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kashiki.components.table;

import static com.kashiki.components.table.ImageIconDesign.createDeleteIcon;
import static com.kashiki.components.table.ImageIconDesign.createEditIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author kashiki
 */
public class ActionEditor extends AbstractCellEditor implements TableCellEditor {

    private JPanel panel;
    private final JButton editButton;
    private final JButton deleteButton;
    private final PropertyChangeSupport support;

    public ActionEditor() {
        support = new PropertyChangeSupport(this);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.setOpaque(true);

        editButton = new JButton(createEditIcon());
        editButton.setPreferredSize(new Dimension(30, 30));
        editButton.setBackground(new Color(52, 144, 220));
        editButton.setForeground(Color.WHITE);
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setFocusPainted(false);
        editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        deleteButton = new JButton(createDeleteIcon());
        deleteButton.setPreferredSize(new Dimension(30, 30));
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBorder(BorderFactory.createEmptyBorder());
        deleteButton.setFocusPainted(false);
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        editButton.addActionListener((ActionEvent e) -> {
            support.firePropertyChange("edit", null, null);
            fireEditingStopped();
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            int option = JOptionPane.showConfirmDialog(panel,
                    "Tem certeza que deseja excluir este registro?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                support.firePropertyChange("delete", null, null);
            }
            fireEditingStopped();
        });

        panel.add(editButton);
        panel.add(deleteButton);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        panel.setBackground(table.getSelectionBackground());

        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
