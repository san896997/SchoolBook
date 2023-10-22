package Management;

import Actors.Books;
import Actors.User;
import Listeners.JTextFieldHintListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class BooksManagement {

    public void menu() {
        JFrame jFrame = new JFrame("图书管理");
        JLabel jTable = new JLabel("欢迎来到图书销售管理系统");

    }

    public List<Books> books;

    public BooksManagement() {
        this.books = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./files/Booklist.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                int i = 0;
                String[] ss = s.split(",");
                Books b = new Books();
                b.setBookNumber(ss[i]);
                b.setBookName(ss[++i]);
                b.setAuthor(ss[++i]);
                b.setPress(ss[++i]);
                b.setCount(ss[++i]);
                b.setPrice(ss[++i]);
                books.add(b);
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 向文件写入更改后的数据
     */
    private void write() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./files/Booklist.txt"));
            for (Books bb : books) {
                bw.write(bb.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 添加图书信息,修改图书信息文件
     */
    public void input() {
        JFrame jFrame = new JFrame("添加图书信息");
        JLabel[] Label = new JLabel[5];
        JTextField[] jtfInput = new JTextField[5];
        JButton jButton = new JButton("发布");
        for (int i = 0; i < 5; i++) {
            jtfInput[i] = new JTextField(15);
        }
        Label[0] = new JLabel("书号:");
        jtfInput[0].addFocusListener(new JTextFieldHintListener(jtfInput[0], "请输入要发布图书的书号"));
        Label[1] = new JLabel("书名:");
        jtfInput[1].addFocusListener(new JTextFieldHintListener(jtfInput[1], "请输入书名"));
        Label[2] = new JLabel("作者:");
        jtfInput[2].addFocusListener(new JTextFieldHintListener(jtfInput[2], "请输入作者"));
        Label[3] = new JLabel("出版社:");
        jtfInput[3].addFocusListener(new JTextFieldHintListener(jtfInput[3], "请输入出版社"));
        Label[4] = new JLabel("单价:");
        jtfInput[4].addFocusListener(new JTextFieldHintListener(jtfInput[3], "请输入单价"));
        for (int i = 0; i < 5; i++) {
            jFrame.add(Label[i]);
            jFrame.add(jtfInput[i]);
        }
        jFrame.add(jButton);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.setVisible(true);
        jFrame.pack();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Books b = new Books();
                b.setBookNumber(jtfInput[0].getText().toString());
                b.setBookName(jtfInput[1].getText().toString());
                b.setAuthor(jtfInput[2].getText().toString());
                b.setPress(jtfInput[3].getText().toString());
                b.setCount("1");
                b.setPrice(jtfInput[4].getText().toString());
                books.add(b);
                JOptionPane.showMessageDialog(jFrame,"发布成功","发布成功",JOptionPane.INFORMATION_MESSAGE);
                write();
            }
        });
    }

    /**
     * 修改图书信息，并修改图书信息文件
     */
    public void update() {
        JFrame jFrame = new JFrame("修改图书信息");
        JLabel jLabel = new JLabel("请输入要修改的书号");
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
                String bookNumber = jTextField.getText().toString();
                for (Books book : books) {
                    if (book.getBookNumber().equals(bookNumber)) {
                        JOptionPane.showMessageDialog(jFrame,"查找成功","查找成功",JOptionPane.INFORMATION_MESSAGE);
                        JFrame jFrame1 = new JFrame("更改图书信息");
                        JLabel[] label = new JLabel[5];
                        JTextField[] jtfInput = new JTextField[5];
                        JButton jButton = new JButton("确定");
                        for (int i = 0; i < label.length; i++) {
                            jtfInput[i] = new JTextField(15);
                        }
                        label[0] = new JLabel("书号：");
                        jtfInput[0].addFocusListener(new JTextFieldHintListener(jtfInput[5], "请输入新书号"));
                        label[1] = new JLabel("书名:");
                        jtfInput[1].addFocusListener(new JTextFieldHintListener(jtfInput[5], "请输入新书名"));
                        label[2] = new JLabel("作者:");
                        jtfInput[2].addFocusListener(new JTextFieldHintListener(jtfInput[5], "请输入新作者"));
                        label[3] = new JLabel("出版社:");
                        jtfInput[3].addFocusListener(new JTextFieldHintListener(jtfInput[5], "请输入新出版社"));
                        label[4] = new JLabel("单价:");
                        jtfInput[4].addFocusListener(new JTextFieldHintListener(jtfInput[5], "请输入新单价"));
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
                                if (jtfInput[0].getText() != null) {
                                    book.setBookNumber(jtfInput[0].getText().toString());
                                }
                                if (jtfInput[1].getText() != null) {
                                    book.setBookName(jtfInput[1].getText().toString());
                                }
                                if (jtfInput[2].getText() != null) {
                                    book.setAuthor(jtfInput[2].getText().toString());
                                }
                                if (jtfInput[3].getText() != null) {
                                    book.setPress(jtfInput[3].getText().toString());
                                }
                                if (jtfInput[4].getText() != null) {
                                    book.setCount(jtfInput[4].getText().toString());
                                }
                                if (jtfInput[5].getText() != null) {
                                    book.setPrice(jtfInput[5].getText().toString());
                                }
                                JOptionPane.showMessageDialog(jFrame1,"修改成功","修改成功",JOptionPane.INFORMATION_MESSAGE);
                                write();

                            }
                        });
                        //修改成功后退出
                        jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        break;
                    }
                }
            }
        });
    }

    /**
     * 删除图书信息,并修改图书信息文件
     */
    public void delete() {
        JFrame jFrame = new JFrame("删除图书信息");
        JLabel jLabel = new JLabel("书号");
        JTextField jTextField = new JTextField(15);
        jTextField.addFocusListener(new JTextFieldHintListener(jTextField, "请输入要删除的书号"));
        JButton jButton = new JButton("确定");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookNumber = jTextField.getText().toString();
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getBookNumber().equals(bookNumber)) {
                        books.remove(i);
                        JOptionPane.showMessageDialog(jFrame,"删除成功","删除成功",JOptionPane.INFORMATION_MESSAGE);
                        write();
                    }
                }
            }
        });
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.pack();
    }


    JTextArea jtaQuery;

    /**
     * 查询图书信息
     */
    public void query() {
        final int[] queryType = {0};
        JFrame jFrame = new JFrame("查询");
        JLabel jLabel = new JLabel("请选择利用什么关键词查询");
        JButton c1 = new JButton("通过书号查询");
        JButton c2 = new JButton("通过书名查询");
        JButton c3 = new JButton("通过作者查询");
        JLabel jlLabel = new JLabel();
        JTextField jTextField = new JTextField(15);
        c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryByNo();
            }
        });
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryByName();
            }
        });
        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryByAuthor();
            }
        });
        jFrame.add(jlLabel);
        jFrame.add(c1);
        jFrame.add(c2);
        jFrame.add(c3);
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.pack();
    }

    /**
     * 利用书号查询图书信息
     */
    public void queryByNo() {
        final boolean[] flag = {false};
        JFrame jFrame = new JFrame("查询图书信息");
        JLabel jLabel = new JLabel("书号");
        JTextField jTextField = new JTextField(15);
        jTextField.addFocusListener(new JTextFieldHintListener(jTextField, "请输入书号"));
        JButton jButton = new JButton("查询");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame1 = new JFrame("查询结果");
                String[][] tableData = new String[books.size()][6];
                String[] name = {"书号", "书名", "作者", "出版社", "库存", "价格"};
                int j = 0;
                for (Books value : books) {
                    if (!value.getBookNumber().equals(jTextField.getText().toString())) {
                        continue;
                    }
                    flag[0] = true;
                    tableData[j][0] = value.getBookNumber();
                    tableData[j][1] = value.getBookNumber();
                    tableData[j][2] = value.getAuthor();
                    tableData[j][3] = value.getPress();
                    tableData[j][4] = value.getCount();
                    tableData[j][5] = value.getPrice();
                    j++;
                }
                if(flag[0]){
                    JOptionPane.showMessageDialog(jFrame1,"查找成功","查找成功！",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(jFrame1,"查找失败","查找失败",JOptionPane.WARNING_MESSAGE);
                }
                JTable jTable = new JTable(tableData, name);
                Container contentPanel = jFrame1.getContentPane();
                contentPanel.add(new JScrollPane(jTable));
                jFrame1.setVisible(true);
                jFrame1.pack();
            }
        });
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    /**
     * 利用书名查询图书信息
     */
    public void queryByName() {
        final boolean[] flag = {false};
        JFrame jFrame = new JFrame("查询图书信息");
        JLabel jLabel = new JLabel("书名");
        JTextField jTextField = new JTextField(15);
        jTextField.addFocusListener(new JTextFieldHintListener(jTextField, "请输入书名"));
        JButton jButton = new JButton("查询");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame1 = new JFrame("查询结果");
                String[][] tableData = new String[books.size()][6];
                String[] name = {"书号", "书名", "作者", "出版社", "库存", "价格"};
                int j = 0;
                for (Books value : books) {
                    if (!value.getBookName().equals(jTextField.getText().toString())) {
                        continue;
                    }
                    flag[0] = true;
                    tableData[j][0] = value.getBookNumber();
                    tableData[j][1] = value.getBookNumber();
                    tableData[j][2] = value.getAuthor();
                    tableData[j][3] = value.getPress();
                    tableData[j][4] = value.getCount();
                    tableData[j][5] = value.getPrice();
                    j++;
                }
                if(flag[0]){
                    JOptionPane.showMessageDialog(jFrame1,"查找成功","查找成功！",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(jFrame1,"查找失败","查找失败",JOptionPane.WARNING_MESSAGE);
                }
                JTable jTable = new JTable(tableData, name);
                Container contentPanel = jFrame1.getContentPane();
                contentPanel.add(new JScrollPane(jTable));
                jFrame1.setVisible(true);
                jFrame1.pack();
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
     * 利用作者名查询图书信息
     */
    public void queryByAuthor() {
        final boolean[] flag = {false};
        JFrame jFrame = new JFrame("查询图书信息");
        JLabel jLabel = new JLabel("作者");
        JTextField jTextField = new JTextField(15);
        jTextField.addFocusListener(new JTextFieldHintListener(jTextField, "请输入作者"));
        JButton jButton = new JButton("查询");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame1 = new JFrame("查询结果");
                String[][] tableData = new String[books.size()][6];
                String[] name = {"书号", "书名", "作者", "出版社", "库存", "价格"};
                int j = 0;
                for (Books value : books) {
                    if (!value.getAuthor().equals(jTextField.getText().toString())) {
                        continue;
                    }
                    flag[0] = true;
                    tableData[j][0] = value.getBookNumber();
                    tableData[j][1] = value.getBookNumber();
                    tableData[j][2] = value.getAuthor();
                    tableData[j][3] = value.getPress();
                    tableData[j][4] = value.getCount();
                    tableData[j][5] = value.getPrice();
                    j++;
                }
                if(flag[0]){
                    JOptionPane.showMessageDialog(jFrame1,"查找成功","查找成功！",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(jFrame1,"查找失败","查找失败",JOptionPane.WARNING_MESSAGE);
                }
                JTable jTable = new JTable(tableData, name);
                Container contentPanel = jFrame1.getContentPane();
                contentPanel.add(new JScrollPane(jTable));
                jFrame1.setVisible(true);
                jFrame1.pack();
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
     * 将书籍全部展示
     */
    public void secondHandbooksDisplay() {
        JFrame jFrame = new JFrame("全部展示");
        String[][] tableData = new String[books.size()][6];
        String[] name = {"书号", "书名", "作者", "出版社", "库存", "价格"};
        for (int i = 0; i < books.size(); i++) {
            tableData[i][0] = books.get(i).getBookNumber();
            tableData[i][1] = books.get(i).getBookNumber();
            tableData[i][2] = books.get(i).getAuthor();
            tableData[i][3] = books.get(i).getPress();
            tableData[i][4] = books.get(i).getCount();
            tableData[i][5] = books.get(i).getPrice();
        }
        JTable jTable = new JTable(tableData, name);
        Container contentPanel = jFrame.getContentPane();
        contentPanel.add(new JScrollPane(jTable));
        jFrame.setVisible(true);
        jFrame.pack();
    }

    public List<Books> getSecondHandBooks() {
        return this.books;
    }

}


