/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kashiki.components.table;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author kashiki
 */
public class ImageIconDesign {

    public static ImageIcon createEditIcon() {
        int size = 16;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Desenhar o lápis
        // Corpo do lápis
        g2d.drawLine(3, 13, 10, 6);
        // Ponta do lápis
        g2d.drawLine(10, 6, 13, 3);
        // Papel/linha sendo editada
        g2d.drawLine(2, 14, 6, 14);
        g2d.drawLine(1, 15, 4, 15);

        g2d.dispose();
        return new ImageIcon(image);
    }

    public static ImageIcon createDeleteIcon() {
        int size = 16;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Desenhar a lixeira
        // Tampa da lixeira
        g2d.drawLine(3, 4, 13, 4);
        g2d.drawLine(5, 2, 11, 2);
        g2d.drawLine(6, 2, 6, 4);
        g2d.drawLine(10, 2, 10, 4);

        // Corpo da lixeira
        g2d.drawLine(4, 4, 4, 13);
        g2d.drawLine(4, 13, 12, 13);
        g2d.drawLine(12, 13, 12, 4);

        // Linhas internas
        g2d.drawLine(6, 6, 6, 11);
        g2d.drawLine(8, 6, 8, 11);
        g2d.drawLine(10, 6, 10, 11);

        g2d.dispose();
        return new ImageIcon(image);
    }
}
