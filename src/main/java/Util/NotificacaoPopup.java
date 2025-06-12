/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author kashiki
 */
public class NotificacaoPopup extends Component {

    public void showMessage(String titulo, String message, int tipo) {
        JOptionPane.showMessageDialog(this, message, titulo, tipo);
    }
}
