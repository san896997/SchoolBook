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
        JFrame jFrame = new JFrame("ͼ�����");
        JLabel jTable = new JLabel("��ӭ����ͼ�����۹���ϵͳ");

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
     * ���ļ�д����ĺ������
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
     * ���ͼ����Ϣ,�޸�ͼ����Ϣ�ļ�
     */
    public void input() {
        JFrame jFrame = new JFrame("���ͼ����Ϣ");
        JLabel[] Label = new JLabel[5];
        JTextField[] jtfInput = new JTextField[5];
        JButton jButton = new JButton("����");
        for (int i = 0; i < 5; i++) {
            jtfInput[i] = new JTextField(15);
        }
        Label[0] = new JLabel("���:");
        jtfInput[0].addFocusListener(new JTextFieldHintListener(jtfInput[0], "������Ҫ����ͼ������"));
        Label[1] = new JLabel("����:");
        jtfInput[1].addFocusListener(new JTextFieldHintListener(jtfInput[1], "����������"));
        Label[2] = new JLabel("����:");
        jtfInput[2].addFocusListener(new JTextFieldHintListener(jtfInput[2], "����������"));
        Label[3] = new JLabel("������:");
        jtfInput[3].addFocusListener(new JTextFieldHintListener(jtfInput[3], "�����������"));
        Label[4] = new JLabel("����:");
        jtfInput[4].addFocusListener(new JTextFieldHintListener(jtfInput[3], "�����뵥��"));
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
                JOptionPane.showMessageDialog(jFrame,"�����ɹ�","�����ɹ�",JOptionPane.INFORMATION_MESSAGE);
                write();
            }
        });
    }

    /**
     * �޸�ͼ����Ϣ�����޸�ͼ����Ϣ�ļ�
     */
    public void update() {
        JFrame jFrame = new JFrame("�޸�ͼ����Ϣ");
        JLabel jLabel = new JLabel("������Ҫ�޸ĵ����");
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
                String bookNumber = jTextField.getText().toString();
                for (Books book : books) {
                    if (book.getBookNumber().equals(bookNumber)) {
                        JOptionPane.showMessageDialog(jFrame,"���ҳɹ�","���ҳɹ�",JOptionPane.INFORMATION_MESSAGE);
                        JFrame jFrame1 = new JFrame("����ͼ����Ϣ");
                        JLabel[] label = new JLabel[5];
                        JTextField[] jtfInput = new JTextField[5];
                        JButton jButton = new JButton("ȷ��");
                        for (int i = 0; i < label.length; i++) {
                            jtfInput[i] = new JTextField(15);
                        }
                        label[0] = new JLabel("��ţ�");
                        jtfInput[0].addFocusListener(new JTextFieldHintListener(jtfInput[5], "�����������"));
                        label[1] = new JLabel("����:");
                        jtfInput[1].addFocusListener(new JTextFieldHintListener(jtfInput[5], "������������"));
                        label[2] = new JLabel("����:");
                        jtfInput[2].addFocusListener(new JTextFieldHintListener(jtfInput[5], "������������"));
                        label[3] = new JLabel("������:");
                        jtfInput[3].addFocusListener(new JTextFieldHintListener(jtfInput[5], "�������³�����"));
                        label[4] = new JLabel("����:");
                        jtfInput[4].addFocusListener(new JTextFieldHintListener(jtfInput[5], "�������µ���"));
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
                                JOptionPane.showMessageDialog(jFrame1,"�޸ĳɹ�","�޸ĳɹ�",JOptionPane.INFORMATION_MESSAGE);
                                write();

                            }
                        });
                        //�޸ĳɹ����˳�
                        jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        break;
                    }
                }
            }
        });
    }

    /**
     * ɾ��ͼ����Ϣ,���޸�ͼ����Ϣ�ļ�
     */
    public void delete() {
        JFrame jFrame = new JFrame("ɾ��ͼ����Ϣ");
        JLabel jLabel = new JLabel("���");
        JTextField jTextField = new JTextField(15);
        jTextField.addFocusListener(new JTextFieldHintListener(jTextField, "������Ҫɾ�������"));
        JButton jButton = new JButton("ȷ��");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookNumber = jTextField.getText().toString();
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getBookNumber().equals(bookNumber)) {
                        books.remove(i);
                        JOptionPane.showMessageDialog(jFrame,"ɾ���ɹ�","ɾ���ɹ�",JOptionPane.INFORMATION_MESSAGE);
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
     * ��ѯͼ����Ϣ
     */
    public void query() {
        final int[] queryType = {0};
        JFrame jFrame = new JFrame("��ѯ");
        JLabel jLabel = new JLabel("��ѡ������ʲô�ؼ��ʲ�ѯ");
        JButton c1 = new JButton("ͨ����Ų�ѯ");
        JButton c2 = new JButton("ͨ��������ѯ");
        JButton c3 = new JButton("ͨ�����߲�ѯ");
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
     * ������Ų�ѯͼ����Ϣ
     */
    public void queryByNo() {
        final boolean[] flag = {false};
        JFrame jFrame = new JFrame("��ѯͼ����Ϣ");
        JLabel jLabel = new JLabel("���");
        JTextField jTextField = new JTextField(15);
        jTextField.addFocusListener(new JTextFieldHintListener(jTextField, "���������"));
        JButton jButton = new JButton("��ѯ");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame1 = new JFrame("��ѯ���");
                String[][] tableData = new String[books.size()][6];
                String[] name = {"���", "����", "����", "������", "���", "�۸�"};
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
                    JOptionPane.showMessageDialog(jFrame1,"���ҳɹ�","���ҳɹ���",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(jFrame1,"����ʧ��","����ʧ��",JOptionPane.WARNING_MESSAGE);
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
     * ����������ѯͼ����Ϣ
     */
    public void queryByName() {
        final boolean[] flag = {false};
        JFrame jFrame = new JFrame("��ѯͼ����Ϣ");
        JLabel jLabel = new JLabel("����");
        JTextField jTextField = new JTextField(15);
        jTextField.addFocusListener(new JTextFieldHintListener(jTextField, "����������"));
        JButton jButton = new JButton("��ѯ");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame1 = new JFrame("��ѯ���");
                String[][] tableData = new String[books.size()][6];
                String[] name = {"���", "����", "����", "������", "���", "�۸�"};
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
                    JOptionPane.showMessageDialog(jFrame1,"���ҳɹ�","���ҳɹ���",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(jFrame1,"����ʧ��","����ʧ��",JOptionPane.WARNING_MESSAGE);
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
     * ������������ѯͼ����Ϣ
     */
    public void queryByAuthor() {
        final boolean[] flag = {false};
        JFrame jFrame = new JFrame("��ѯͼ����Ϣ");
        JLabel jLabel = new JLabel("����");
        JTextField jTextField = new JTextField(15);
        jTextField.addFocusListener(new JTextFieldHintListener(jTextField, "����������"));
        JButton jButton = new JButton("��ѯ");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame1 = new JFrame("��ѯ���");
                String[][] tableData = new String[books.size()][6];
                String[] name = {"���", "����", "����", "������", "���", "�۸�"};
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
                    JOptionPane.showMessageDialog(jFrame1,"���ҳɹ�","���ҳɹ���",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(jFrame1,"����ʧ��","����ʧ��",JOptionPane.WARNING_MESSAGE);
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
     * ���鼮ȫ��չʾ
     */
    public void secondHandbooksDisplay() {
        JFrame jFrame = new JFrame("ȫ��չʾ");
        String[][] tableData = new String[books.size()][6];
        String[] name = {"���", "����", "����", "������", "���", "�۸�"};
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


