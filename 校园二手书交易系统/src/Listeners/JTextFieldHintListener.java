package Listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * 实现文字提示功能
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
     * 获取焦点时,清空提示内容
     * @param e 焦点事件
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
     * 失去焦点时,没用输入内容,显示提示内容
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
