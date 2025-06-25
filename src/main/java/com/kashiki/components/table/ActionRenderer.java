/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kashiki.components.table;

import static com.kashiki.components.table.ImageIconDesign.createDeleteIcon;
import static com.kashiki.components.table.ImageIconDesign.createEditIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author kashiki
 */
public class ActionRenderer extends JPanel implements TableCellRenderer {

    private final JButton editButton;
    private final JButton deleteButton;

    public ActionRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setOpaque(true);

        editButton = new JButton(createEditIcon());
        editButton.setPreferredSize(new Dimension(30, 30));
        editButton.setBackground(new Color(52, 144, 220));
        editButton.setForeground(Color.WHITE);
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setFocusPainted(false);

        deleteButton = new JButton(createDeleteIcon());
        deleteButton.setPreferredSize(new Dimension(30, 30));
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBorder(BorderFactory.createEmptyBorder());
        deleteButton.setFocusPainted(false);

        add(editButton);
        add(deleteButton);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getBackground());
        }
        return this;
    }

}
