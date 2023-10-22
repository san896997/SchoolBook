package Management;

import Actors.Books;
import Actors.Transaction;
import Actors.User;
import Listeners.JTextFieldHintListener;
import Management.BooksManagement;
import Management.UserManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


import java.text.*;
import java.util.List;

public class TransactionManagement {
    public List<Transaction> circulations;
    public List<Books> books;
    public List<User> users;
    User user;
    Books book;
    Transaction circulation;

    public TransactionManagement(User u, Books b1) {
        UserManagement um = new UserManagement();
        users = um.getUsers();
        BooksManagement bo = new BooksManagement();
        books = bo.getSecondHandBooks();
        this.circulations = new ArrayList();
        this.books = new ArrayList();
        user = u;
        book = b1;

        try {
            BufferedReader br = new BufferedReader(new FileReader("./files/Booklist.txt"));
            String s1;
            while ((s1 = br.readLine()) != null) {

                int i = 0;
                if (s1 == null) {
                    break;
                }
                String[] bss = s1.split(",");
                Books b = new Books();
                b.setBookNumber(bss[i]);
                b.setBookName(bss[++i]);
                b.setAuthor(bss[++i]);
                b.setPress(bss[++i]);
                b.setCount(bss[++i]);
                b.setPrice(bss[++i]);
                books.add(b);
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            BufferedReader cr = new BufferedReader(new FileReader("./files/Transaction_record.txt"));
            String s2;
            while ((s2 = cr.readLine()) != null) {

                int i = 0;
                if (s2 == null) {
                    break;
                }
                String[] ss = s2.split(",");
                Transaction c = new Transaction();
                c.setSerialNo(ss[i]);
                c.setId(ss[++i]);
                c.setNumber(ss[++i]);
                c.setData1(ss[++i]);
                c.setType(ss[++i]);
                c.setOrder(ss[++i]);
                circulations.add(c);
            }
            cr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void buyBook(User user) {
        int count = 0;
        JFrame jFrame = new JFrame();
        JLabel jLabel1 = new JLabel("书号");
        JTextField jTextField1 = new JTextField(15);
        jTextField1.addFocusListener(new JTextFieldHintListener(jTextField1, "请输入要购买书籍的书号"));
        JButton jButton1 = new JButton("查询"), jButton2 = new JButton("购买");
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Transaction c = new Transaction();
        System.out.println(books);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cnm");
                for (Books item : books) {
                    System.out.println("cnm2");
                    if (item.getBookNumber().equals(jTextField1.getText())) {
                        System.out.println("cnm3");
                        JOptionPane.showMessageDialog(jFrame, "书名:" + item.getBookName() + " 库存" + item.getCount(), "查询成功", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Books item : books) {
                    if (item.getBookNumber().equals(jTextField1.getText())) {
                        int count = Integer.parseInt(item.getCount());
                        if (count > 0) {
                            int balance = Integer.parseInt(user.getBalance());
                            int price = Integer.parseInt(item.getPrice());
                            if (price > balance) {
                                JOptionPane.showMessageDialog(jFrame, "用户余额不足", "购买失败", JOptionPane.WARNING_MESSAGE);
                            } else {
                                balance -= price;
                                count--;
                                user.setBalance(String.valueOf(balance));


                                item.setCount(String.valueOf(count));

                                JOptionPane.showMessageDialog(jFrame, "购买成功", "购买成功", JOptionPane.INFORMATION_MESSAGE);
                                c.setId(user.getId());
                                c.setNumber(item.getBookNumber());
                                c.setData1(d.format(date));
                                c.setType(user.getType());
                                c.setOrder("订单完成");
                                circulations.add(c);

                                try {
                                    BufferedWriter bw = new BufferedWriter(new FileWriter("./files/Transaction_record.txt"));
                                    for (Transaction uu : circulations) {
                                        count++;
                                        uu.setSerialNo(String.valueOf(count));
                                        bw.write(uu.toString());
                                        bw.newLine();
                                    }
                                    bw.close();
                                } catch (Exception ex) {
                                    // TODO Auto-generated catch block
                                    ex.printStackTrace();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(jFrame, "图书库存不足", "购买失败", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                for(User user1:users){
                    if(user1.getId().equals(user.getId())){
                        user1.setBalance(user.getBalance());
                    }
                }
                writeUsers();
                writeBooks();
            }

        });
        jFrame.add(jLabel1);
        jFrame.add(jTextField1);
        jFrame.add(jButton1);
        jFrame.add(jButton2);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.setVisible(true);
        jFrame.pack();
    }

    /**
     * 查询用户订单信息
     */
    public void query() {
        JFrame jFrame = new JFrame("查询订单信息");
        String[][] tableData = new String[circulations.size()][3];
        String[] name = {"书号", "日期", "订单状态"};
        ;
        for (User value : users) {
            if (value.getId().equals(user.getId())) {
                int j = 0;
                for (Transaction transaction : circulations) {
                    if (transaction.getId().equals(user.getId())) {
                        tableData[j][0] = transaction.getNumber();
                        tableData[j][1] = transaction.getData1();
                        tableData[j][2] = transaction.getOrder();
                        j++;
                    }
                }
            }
        }
        JTable jTable = new JTable(tableData, name);
        Container contentPanel = jFrame.getContentPane();
        contentPanel.add(new JScrollPane(jTable));
        jFrame.pack();
        jFrame.setVisible(true);
    }

    /**
     * 利用用户账号查询用户买卖信息
     */
    public void dQuery() {
        JFrame jFrame = new JFrame("用户买卖信息查询");
        JLabel jLabel = new JLabel("账号");
        JTextField jTextField = new JTextField(15);
        JButton jButton = new JButton("查询");
        jTextField.addFocusListener(new JTextFieldHintListener(jTextField, "请输入要查询的用户账号"));
        jButton.addActionListener(new ActionListener() {
            final String[][] tableData = new String[circulations.size()][5];
            final String[] name = {"用户ID", "书号", "日期", "类型", "订单状态"};
            JTable jTable;
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame1 = new JFrame();
                String id = jTextField.getText().toString();
                int j = 0;
                for (Transaction transaction : circulations) {
                    if (transaction.getId().equals(id)) {
                        tableData[j][0] = transaction.getId();
                        tableData[j][1] = transaction.getNumber();
                        tableData[j][2] = transaction.getData1();
                        tableData[j][3] = transaction.getType();
                        tableData[j][4] = transaction.getOrder();
                        j++;
                    }
                }
                jTable = new JTable(tableData, name);
                Container contentPanel = jFrame1.getContentPane();
                contentPanel.add(new JScrollPane(jTable));
                jFrame1.setVisible(true);
                jFrame1.pack();
            }
        });
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.pack();
    }

//图书买卖信息查询
    public void circulationDisplay() {
        JFrame jFrame = new JFrame("图书买卖信息查询");
        String[][] tableData = new String[circulations.size()][6];
        String[] name = {"流水号", "用户ID", "书号", "日期", "类型", "订单状态"};
        for (int i = 0; i <circulations.size(); i++) {
            tableData[i][0] = circulations.get(i).getSerialNo();
            tableData[i][1] = circulations.get(i).getId();
            tableData[i][2] = circulations.get(i).getNumber();
            tableData[i][3] = circulations.get(i).getData1();
            tableData[i][4] = circulations.get(i).getType();
            tableData[i][5] = circulations.get(i).getOrder();
        }
        JTable jTable = new JTable(tableData, name);
        Container contentPanel = jFrame.getContentPane();
        contentPanel.add(new JScrollPane(jTable));
        jFrame.setVisible(true);
        jFrame.pack();
    }
    public List<Transaction> getCirculations() {
        return this.circulations;
    }

    private void writeUsers() {
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

    private void writeBooks(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./files/Booklist.txt"));
            for (Books b : books) {
                bw.write(b.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
