package Listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * ʵ��������ʾ����
 */
public class JTextFieldHintListener implements FocusListener {

    private String hintText;
    private JTextField textField;


    public JTextFieldHintListener(JTextField jTextField,String hintText) {
        this.hintText = hintText;
        this.textField =jTextField;
        jTextField.setText(hintText);
        jTextField.setForeground(Color.GRAY);
    }

    /**
     * ��ȡ����ʱ,�����ʾ����
     * @param e �����¼�
     */
    @Override
    public void focusGained(FocusEvent e) {
        String temp = textField.getText();
        if (temp.equals(hintText)){
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    /**
     * ʧȥ����ʱ,û����������,��ʾ��ʾ����
     * @param e
     */
    @Override
    public void focusLost(FocusEvent e) {
        String temp = textField.getText();
        if ("".equals(temp)){
            textField.setText(hintText);
            textField.setForeground(Color.GRAY);
        }
    }
}
