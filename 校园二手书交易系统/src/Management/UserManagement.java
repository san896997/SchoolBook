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
//从文件里读取数据
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
     * 用户信息添加
     */
    public void input() {

        JFrame jFrame = new JFrame("注册");
        JLabel[] Label = new JLabel[7];
        JTextField[] jtfInput = new JTextField[7];
        JButton jButton = new JButton("发布");
        for (int i = 0; i < 7; i++) {
            jtfInput[i] = new JTextField(15);
        }
        Label[0] = new JLabel("用户名:");
        jtfInput[0].addFocusListener(new JTextFieldHintListener(jtfInput[0], "请输入注册的账号"));
        Label[1] = new JLabel("密码:");
        jtfInput[1].addFocusListener(new JTextFieldHintListener(jtfInput[1], "请输入密码"));
        Label[2] = new JLabel("用户类型:");
        jtfInput[2].addFocusListener(new JTextFieldHintListener(jtfInput[2], "请输入账号类型"));
        Label[3] = new JLabel("姓名:");
        jtfInput[3].addFocusListener(new JTextFieldHintListener(jtfInput[3], "请输入姓名"));
        Label[4] = new JLabel("单位:");
        jtfInput[4].addFocusListener(new JTextFieldHintListener(jtfInput[4], "请输入单位"));
        Label[5] = new JLabel("电话:");
        jtfInput[5].addFocusListener(new JTextFieldHintListener(jtfInput[5], "请输入电话"));
        Label[6] = new JLabel("账户余额:");
        jtfInput[6].addFocusListener(new JTextFieldHintListener(jtfInput[6], "请输入账户余额"));
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
                JOptionPane.showMessageDialog(jFrame, "该账号已存在", "该账号已存在", JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(jFrame, "发布成功！");
                write();
            }
        });
    }

    //将信息写入文件
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
     * 用户信息修改
     */
    public void update() {
        JFrame jFrame = new JFrame("修改用户信息");
        JLabel jLabel = new JLabel("请输入要修改的账号");
        JTextField jTextField = new JTextField(15);
        JButton jButton = new JButton("确定");
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
                        JOptionPane.showMessageDialog(jFrame, "查找成功！");
                        JFrame jFrame1 = new JFrame("更改用户信息");
                        JLabel[] label = new JLabel[4];
                        JTextField[] jtfInput = new JTextField[4];
                        JButton jButton = new JButton("确定");
                        for (int i = 0; i < label.length; i++) {
                            jtfInput[i] = new JTextField(15);
                        }
                        label[0] = new JLabel("姓名：");
                        jtfInput[0].addFocusListener(new JTextFieldHintListener(jtfInput[0], "请输入新姓名"));
                        label[1] = new JLabel("单位:");
                        jtfInput[1].addFocusListener(new JTextFieldHintListener(jtfInput[1], "请输入新单位"));
                        label[2] = new JLabel("电话:");
                        jtfInput[2].addFocusListener(new JTextFieldHintListener(jtfInput[2], "请输入新电话"));
                        label[3] = new JLabel("余额:");
                        jtfInput[3].addFocusListener(new JTextFieldHintListener(jtfInput[3], "请输入用户余额"));
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
                                if (jtfInput[0].getText() != null && !"请输入新姓名".equals(jtfInput[0].getText())) {
                                    uu.setName(jtfInput[0].getText().toString());
                                }
                                if (jtfInput[1].getText() != null && !"请输入新单位".equals(jtfInput[1].getText())) {
                                    uu.setUnit(jtfInput[1].getText().toString());
                                }
                                if (jtfInput[2].getText() != null && !"请输入新电话".equals(jtfInput[2].getText())) {
                                    uu.setTelephone(jtfInput[2].getText().toString());
                                }
                                if (jtfInput[3].getText() != null && !"请输入用户余额".equals(jtfInput[3].getText())) {
                                    uu.setBalance(jtfInput[3].getText().toString());
                                }
                                JOptionPane.showMessageDialog(jFrame1, "修改成功！");
                                write();
                                //修改成功后退出
                                jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                            }
                        });
                    }
                }
            }
        });
    }

    public void delete() {
        JFrame jFrame = new JFrame("删除用户信息");
        JLabel jLabel = new JLabel("请输入要删除的账号");
        JTextField jTextField = new JTextField(15);
        JButton jButton = new JButton("确定");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookNumber = jTextField.getText().toString();
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getId().equals(bookNumber)) {
                        users.remove(i);
                        JOptionPane.showMessageDialog(jFrame, "删除成功！");
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
     * 用账号查询用户信息
     */
    public void query() {
        JFrame jFrame = new JFrame("查询");
        JLabel jLabel = new JLabel("账号:");
        JTextField jTextField = new JTextField(15);
        JButton jButton = new JButton("查询");
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
                        JOptionPane.showMessageDialog(jFrame, "查找成功！");
                        JFrame jFrame1 = new JFrame();
                        String[][] tableData = new String[1][6];
                        String[] name = {"用户ID", "用户类型", "用户姓名", "单位", "电话","余额"};
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
                JFrame jFrame = new JFrame("查询");
                JOptionPane.showMessageDialog(jFrame, "查找成功！");
                JLabel jlBalance = new JLabel("余额:");
                JTextField jtfBalance = new JTextField(15);
                JLabel jlName = new JLabel("姓名:");
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
        //修改密码
        for (User user : users) {
            if (user.getId().equals(ur.getId())) {
                JFrame jFrame = new JFrame("修改密码");
                JLabel jlPassword = new JLabel("新密码:");
                JTextField jtfPassword = new JTextField(15);
                JButton jButton = new JButton("确定");
                jtfPassword.addFocusListener(new JTextFieldHintListener(jtfPassword, "请输入要修改后的密码"));
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        user.setPassword(jtfPassword.getText());
                        JOptionPane.showMessageDialog(jFrame, "修改成功！");
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
//充值服务
        for (User user : users) {
            if (user.getId().equals(ur.getId())) {
                JFrame jFrame = new JFrame("充值服务");
                JLabel jlBalance = new JLabel("充值金额:");
                JTextField jtfBalance = new JTextField(15);
                JButton jButton = new JButton("充值");
                jtfBalance.addFocusListener(new JTextFieldHintListener(jtfBalance, "请输入要充值的金额"));
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
                        JOptionPane.showMessageDialog(jFrame, "充值成功！");
                        write();
                    }
                });
                jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
                jFrame.setVisible(true);
                jFrame.pack();
            }
        }
    }
// 登录系统
    public void login() {
        JFrame jFrame;
        //JPanel jPanelUsername;
        JLabel jLabel, jlUsername, jlPassword;
        JTextField jtfUserName, jtfPassword;
        JButton jbLogin;

        jFrame = new JFrame("登录");
        jLabel = new JLabel("欢迎进入图书销售平台");
        jlUsername = new JLabel("用户名:");
        jtfUserName = new JTextField(15);
        jlPassword = new JLabel("密码:");
        jtfPassword = new JTextField(15);
        jbLogin = new JButton("登录");
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.add(jLabel);
        jFrame.add(jlUsername);
        jFrame.add(jtfUserName);
        jFrame.add(jlPassword);
        jFrame.add(jtfPassword);
        jFrame.add(jbLogin);
        jFrame.setVisible(true);
        jFrame.pack();
        //设置界面大小不可变
        jFrame.setResizable(false);
        jtfUserName.addFocusListener(new JTextFieldHintListener(jtfUserName, "请输入用户名"));
        jtfPassword.addFocusListener(new JTextFieldHintListener(jtfPassword, "请输入密码"));
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
                        JOptionPane.showMessageDialog(jFrame, "登录成功！");
                        loginUser = u1;
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "密码错误！");
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



