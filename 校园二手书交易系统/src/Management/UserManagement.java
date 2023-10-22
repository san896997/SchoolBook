package Management;

import Actors.User;
import Listeners.JTextFieldHintListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class UserManagement {

    public User ur = new User();

    public List<User> users;

    public UserManagement() {
//���ļ����ȡ����
        this.users = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./files/User.txt"));
            String s;
            while ((s = br.readLine()) != null) {

                int i = 0;
                if (s == null) {
                    break;
                }
                String ss[] = s.split(",");
                User u = new User();
                u.setId(ss[i]);
                u.setPassword(ss[++i]);
                u.setType(ss[++i]);
                u.setName(ss[++i]);
                u.setUnit(ss[++i]);
                u.setTelephone(ss[++i]);
                u.setBalance(ss[++i]);
                users.add(u);
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * �û���Ϣ���
     */
    public void input() {

        JFrame jFrame = new JFrame("ע��");
        JLabel[] Label = new JLabel[7];
        JTextField[] jtfInput = new JTextField[7];
        JButton jButton = new JButton("����");
        for (int i = 0; i < 7; i++) {
            jtfInput[i] = new JTextField(15);
        }
        Label[0] = new JLabel("�û���:");
        jtfInput[0].addFocusListener(new JTextFieldHintListener(jtfInput[0], "������ע����˺�"));
        Label[1] = new JLabel("����:");
        jtfInput[1].addFocusListener(new JTextFieldHintListener(jtfInput[1], "����������"));
        Label[2] = new JLabel("�û�����:");
        jtfInput[2].addFocusListener(new JTextFieldHintListener(jtfInput[2], "�������˺�����"));
        Label[3] = new JLabel("����:");
        jtfInput[3].addFocusListener(new JTextFieldHintListener(jtfInput[3], "����������"));
        Label[4] = new JLabel("��λ:");
        jtfInput[4].addFocusListener(new JTextFieldHintListener(jtfInput[4], "�����뵥λ"));
        Label[5] = new JLabel("�绰:");
        jtfInput[5].addFocusListener(new JTextFieldHintListener(jtfInput[5], "������绰"));
        Label[6] = new JLabel("�˻����:");
        jtfInput[6].addFocusListener(new JTextFieldHintListener(jtfInput[6], "�������˻����"));
        for (int i = 0; i < 7; i++) {
            jFrame.add(Label[i]);
            jFrame.add(jtfInput[i]);
        }
        jFrame.add(jButton);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.setVisible(true);
        jFrame.pack();

        for (User user : users) {
            if (user.getId().equals(jtfInput[0].getText().toString())) {
                JOptionPane.showMessageDialog(jFrame, "���˺��Ѵ���", "���˺��Ѵ���", JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User u = new User();
                u.setId(jtfInput[0].getText().toString());
                u.setPassword(jtfInput[1].getText().toString());
                u.setType(jtfInput[2].getText().toString());
                u.setName(jtfInput[3].getText().toString());
                u.setUnit(jtfInput[4].getText().toString());
                u.setTelephone(jtfInput[5].getText().toString());
                u.setBalance(jtfInput[6].getText().toString());
                users.add(u);
                JOptionPane.showMessageDialog(jFrame, "�����ɹ���");
                write();
            }
        });
    }

    //����Ϣд���ļ�
    private void write() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./files/User.txt"));
            for (User uu : users) {
                bw.write(uu.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * �û���Ϣ�޸�
     */
    public void update() {
        JFrame jFrame = new JFrame("�޸��û���Ϣ");
        JLabel jLabel = new JLabel("������Ҫ�޸ĵ��˺�");
        JTextField jTextField = new JTextField(15);
        JButton jButton = new JButton("ȷ��");
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.setVisible(true);
        jFrame.pack();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userid = jTextField.getText().toString();
                for (User uu : users) {
                    if (uu.getId().equals(userid)) {
                        JOptionPane.showMessageDialog(jFrame, "���ҳɹ���");
                        JFrame jFrame1 = new JFrame("�����û���Ϣ");
                        JLabel[] label = new JLabel[4];
                        JTextField[] jtfInput = new JTextField[4];
                        JButton jButton = new JButton("ȷ��");
                        for (int i = 0; i < label.length; i++) {
                            jtfInput[i] = new JTextField(15);
                        }
                        label[0] = new JLabel("������");
                        jtfInput[0].addFocusListener(new JTextFieldHintListener(jtfInput[0], "������������"));
                        label[1] = new JLabel("��λ:");
                        jtfInput[1].addFocusListener(new JTextFieldHintListener(jtfInput[1], "�������µ�λ"));
                        label[2] = new JLabel("�绰:");
                        jtfInput[2].addFocusListener(new JTextFieldHintListener(jtfInput[2], "�������µ绰"));
                        label[3] = new JLabel("���:");
                        jtfInput[3].addFocusListener(new JTextFieldHintListener(jtfInput[3], "�������û����"));
                        for (int i = 0; i < label.length; i++) {
                            jFrame1.add(label[i]);
                            jFrame1.add(jtfInput[i]);
                        }
                        jFrame1.add(jButton);
                        jFrame1.setLayout(new FlowLayout(FlowLayout.LEFT));
                        jFrame1.setVisible(true);
                        jFrame1.pack();
                        jButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (jtfInput[0].getText() != null && !"������������".equals(jtfInput[0].getText())) {
                                    uu.setName(jtfInput[0].getText().toString());
                                }
                                if (jtfInput[1].getText() != null && !"�������µ�λ".equals(jtfInput[1].getText())) {
                                    uu.setUnit(jtfInput[1].getText().toString());
                                }
                                if (jtfInput[2].getText() != null && !"�������µ绰".equals(jtfInput[2].getText())) {
                                    uu.setTelephone(jtfInput[2].getText().toString());
                                }
                                if (jtfInput[3].getText() != null && !"�������û����".equals(jtfInput[3].getText())) {
                                    uu.setBalance(jtfInput[3].getText().toString());
                                }
                                JOptionPane.showMessageDialog(jFrame1, "�޸ĳɹ���");
                                write();
                                //�޸ĳɹ����˳�
                                jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                            }
                        });
                    }
                }
            }
        });
    }

    public void delete() {
        JFrame jFrame = new JFrame("ɾ���û���Ϣ");
        JLabel jLabel = new JLabel("������Ҫɾ�����˺�");
        JTextField jTextField = new JTextField(15);
        JButton jButton = new JButton("ȷ��");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookNumber = jTextField.getText().toString();
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getId().equals(bookNumber)) {
                        users.remove(i);
                        JOptionPane.showMessageDialog(jFrame, "ɾ���ɹ���");
                        write();
                    }
                }
            }
        });
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.setVisible(true);
        jFrame.pack();
    }

    /**
     * ���˺Ų�ѯ�û���Ϣ
     */
    public void query() {
        JFrame jFrame = new JFrame("��ѯ");
        JLabel jLabel = new JLabel("�˺�:");
        JTextField jTextField = new JTextField(15);
        JButton jButton = new JButton("��ѯ");
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.pack();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = jTextField.getText().toString();
                for (User user : users) {
                    if (user.getId().equals(id)) {
                        JOptionPane.showMessageDialog(jFrame, "���ҳɹ���");
                        JFrame jFrame1 = new JFrame();
                        String[][] tableData = new String[1][6];
                        String[] name = {"�û�ID", "�û�����", "�û�����", "��λ", "�绰","���"};
                        tableData[0][0] = user.getId();
                        tableData[0][1] = user.getType();
                        tableData[0][2] = user.getName();
                        tableData[0][3] = user.getUnit();
                        tableData[0][4] = user.getTelephone();
                        tableData[0][5] = user.getBalance();
                        JTable jTable = new JTable(tableData, name);
                        Container contentPanel = jFrame1.getContentPane();
                        contentPanel.add(new JScrollPane(jTable));
                        jFrame1.setLayout(new FlowLayout(FlowLayout.LEFT));
                        jFrame1.setVisible(true);
                        jFrame1.pack();
                    }
                }
            }
        });
    }

    public void balanceEnquiry(User ur) {
        for (User user : users) {
            if (user.getId().equals(ur.getId())) {
                JFrame jFrame = new JFrame("��ѯ");
                JOptionPane.showMessageDialog(jFrame, "���ҳɹ���");
                JLabel jlBalance = new JLabel("���:");
                JTextField jtfBalance = new JTextField(15);
                JLabel jlName = new JLabel("����:");
                JTextField jtfName = new JTextField(15);
                jtfName.setText(user.getName());
                jtfBalance.setText(user.getBalance());
                jFrame.add(jlName);
                jFrame.add(jtfName);
                jFrame.add(jlBalance);
                jFrame.add(jtfBalance);
                jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
                jFrame.setVisible(true);
                jFrame.pack();
            }
        }
    }

    public void changePassword(User ur) {
        //�޸�����
        for (User user : users) {
            if (user.getId().equals(ur.getId())) {
                JFrame jFrame = new JFrame("�޸�����");
                JLabel jlPassword = new JLabel("������:");
                JTextField jtfPassword = new JTextField(15);
                JButton jButton = new JButton("ȷ��");
                jtfPassword.addFocusListener(new JTextFieldHintListener(jtfPassword, "������Ҫ�޸ĺ������"));
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        user.setPassword(jtfPassword.getText());
                        JOptionPane.showMessageDialog(jFrame, "�޸ĳɹ���");
                    }
                });
                jFrame.add(jlPassword);
                jFrame.add(jtfPassword);
                jFrame.add(jButton);
                jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
                jFrame.setVisible(true);
                jFrame.pack();
                write();
            }
        }
    }

    public void topUp(User ur) {
//��ֵ����
        for (User user : users) {
            if (user.getId().equals(ur.getId())) {
                JFrame jFrame = new JFrame("��ֵ����");
                JLabel jlBalance = new JLabel("��ֵ���:");
                JTextField jtfBalance = new JTextField(15);
                JButton jButton = new JButton("��ֵ");
                jtfBalance.addFocusListener(new JTextFieldHintListener(jtfBalance, "������Ҫ��ֵ�Ľ��"));
                jFrame.add(jlBalance);
                jFrame.add(jtfBalance);
                jFrame.add(jButton);
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String balance = jtfBalance.getText().toString();
                        int num1 = Integer.parseInt(balance);
                        int num2 = Integer.parseInt(user.getBalance());
                        int num3 = num1 + num2;
                        user.setBalance(Integer.toString(num3));
                        JOptionPane.showMessageDialog(jFrame, "��ֵ�ɹ���");
                        write();
                    }
                });
                jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
                jFrame.setVisible(true);
                jFrame.pack();
            }
        }
    }
// ��¼ϵͳ
    public void login() {
        JFrame jFrame;
        //JPanel jPanelUsername;
        JLabel jLabel, jlUsername, jlPassword;
        JTextField jtfUserName, jtfPassword;
        JButton jbLogin;

        jFrame = new JFrame("��¼");
        jLabel = new JLabel("��ӭ����ͼ������ƽ̨");
        jlUsername = new JLabel("�û���:");
        jtfUserName = new JTextField(15);
        jlPassword = new JLabel("����:");
        jtfPassword = new JTextField(15);
        jbLogin = new JButton("��¼");
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.add(jLabel);
        jFrame.add(jlUsername);
        jFrame.add(jtfUserName);
        jFrame.add(jlPassword);
        jFrame.add(jtfPassword);
        jFrame.add(jbLogin);
        jFrame.setVisible(true);
        jFrame.pack();
        //���ý����С���ɱ�
        jFrame.setResizable(false);
        jtfUserName.addFocusListener(new JTextFieldHintListener(jtfUserName, "�������û���"));
        jtfPassword.addFocusListener(new JTextFieldHintListener(jtfPassword, "����������"));
        jbLogin.addActionListener(new LoginListener(jFrame, jtfUserName, jtfPassword, jbLogin));
    }

    class LoginListener implements ActionListener {
        JFrame jFrame;
        JTextField jtfUserName, jtfPassword;
        JButton jbLogin;
        User loginUser;

        public LoginListener(JFrame jFrame, JTextField jtfUserName, JTextField jtfPassword, JButton jbLogin) {
            this.jFrame = jFrame;
            this.jtfUserName = jtfUserName;
            this.jtfPassword = jtfPassword;
            this.jbLogin = jbLogin;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ur.setId(jtfUserName.getText().toString());
            String id1 = ur.getId().replaceAll(" ", "");
            ur.setPassword(jtfPassword.getText().toString());
            String password1 = ur.getPassword().replaceAll(" ", "");
            for (User u1 : users) {
                if (u1.getId().equals(id1)) {
                    if (u1.getPassword().equals(password1)) {
                        JOptionPane.showMessageDialog(jFrame, "��¼�ɹ���");
                        loginUser = u1;
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "�������");
                        loginUser = null;
                    }
                }
            }
            if (loginUser != null) {
                if ("1".equals(loginUser.getType())) {
                    Menus.menuUser(loginUser);
                } else if ("2".equals(loginUser.getType())) {
                    Menus.menuAdmin(loginUser);
                }
            }
        }
    }

    // Scanner cin=new Scanner(System.in);

    public List<User> getUsers() {
        return this.users;
    }

}



