package Management;

import Actors.Books;
import Actors.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * @author wwss
 */
public class Menus {

    static Books b2;
    static UserManagement userManagement;
    static BooksManagement  booksManagement;
    static TransactionManagement transactionManager;
    static JButton jbReturnToMainMenu;

    public static void go(){
        userManagement = new UserManagement();
        booksManagement = new BooksManagement();
        jbReturnToMainMenu = new JButton("�������˵�");
        userManagement.login();
    }



    /**
     * ��ͨ�û���¼��Ĳ˵�
     */
    public static void menuUser(User user){
        JFrame frame = new JFrame("���˵�");
        JLabel jLabel = new JLabel("��ӭ����ͼ������ƽ̨");

        JButton jbUserManage = new JButton("������Ϣ����");
        JButton jbBooksManage = new JButton("ͼ�����");
        JButton jbQuit= new JButton("�˳�");

        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.add(jLabel);
        frame.add(jbUserManage);
        frame.add(jbBooksManage);
        frame.add(jbQuit);
        frame.setVisible(true);
        frame.pack();

        jbUserManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1(user);
            }
        });
        jbBooksManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2(user);
            }
        });
        jbQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING) );
            }
        });
    }

    /**
     * ����Ա��¼��Ĳ˵�
     */
    public static void menuAdmin(User user){
        JFrame frame = new JFrame("���˵�");
        JLabel jLabel = new JLabel("��ӭ����ͼ������ƽ̨");

        JButton jbUserManage = new JButton("�û�����");
        JButton jbBooksManage = new JButton("ͼ�����");
        JButton jbBooksTransactionManage = new JButton("ͼ�齻�׹���");
        JButton jbQuit= new JButton("�˳�ϵͳ");


        frame.add(jLabel);
        frame.add(jbUserManage);
        frame.add(jbBooksManage);
        frame.add(jbBooksTransactionManage);
        frame.add( jbQuit);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);

        jbUserManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1(user);
            }
        });
        jbBooksManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2(user);
            }
        });
        jbBooksTransactionManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu3(user,b2);
            }
        });
        jbQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING) );
            }
        });
    }

    static void menu1(User user) {
        System.out.println("menu1");
        JButton jbChangePassword = new JButton("�޸ĵ�ǰ����");
        JButton jbTopUp = new JButton("��ֵ");
        JButton jbQueryBalance = new JButton("��ѯ���");
        jbChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userManagement.changePassword(user);
            }
        });
        jbTopUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userManagement.topUp(user);
            }
        });
        jbQueryBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userManagement.balanceEnquiry(user);
            }
        });

        if ("1".equals(user.getType())){
            JFrame jFrame = new JFrame();
            JLabel jLabel = new JLabel("������Ϣ����");
            jFrame.add(jLabel);
            jFrame.add(jbChangePassword);
            jFrame.add(jbTopUp);
            jFrame.add(jbQueryBalance);
            jFrame.add(jbReturnToMainMenu);
            jbReturnToMainMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.dispatchEvent(new WindowEvent(jFrame,WindowEvent.WINDOW_CLOSING) );
                }
            });
            jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
            jFrame.setVisible(true);
            jFrame.pack();

        }
        else if ("2".equals(user.getType())) {
            JFrame jFrame = new JFrame();
            JLabel jLabel = new JLabel("�û�����");
            JButton jbUserAdded = new JButton("�û����");
            JButton jbUserChange = new JButton("�û��޸�");
            JButton jbUserDelete = new JButton("�û�ɾ��");
            JButton jbQueryUserInformationById = new JButton("���˺Ų�ѯ�û���Ϣ");
            jbUserAdded.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    userManagement.input();
                }
            });
            jbUserChange.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    userManagement.update();
                }
            });
            jbUserDelete.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    userManagement.delete();
                }
            });
            jbQueryUserInformationById.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    userManagement.query();
                }
            });
            jbReturnToMainMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.dispatchEvent(new WindowEvent(jFrame,WindowEvent.WINDOW_CLOSING) );
                }
            });
            jFrame.add(jLabel);
            jFrame.add(jbUserAdded);
            jFrame.add(jbUserChange);
            jFrame.add(jbUserDelete);
            jFrame.add(jbQueryUserInformationById);
            jFrame.add(jbChangePassword);
            jFrame.add(jbTopUp);
            jFrame.add(jbQueryBalance);
            jFrame.add(jbReturnToMainMenu);
            jbReturnToMainMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.dispatchEvent(new WindowEvent(jFrame,WindowEvent.WINDOW_CLOSING) );
                }
            });
            jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
            jFrame.setVisible(true);
            jFrame.pack();
            //jFrame.setResizable(false);
        }
    }
    static void menu2(User user) {
        TransactionManagement tm = new TransactionManagement(user,b2);
        System.out.println("menu2");
        JFrame jFrame = new JFrame("ͼ�����");
        JLabel jLabel = new JLabel("ͼ�����");
        jFrame.add(jLabel);
        if ("1".equals(user.getType())) {
            JButton jbPublishedBooks = new JButton("����ͼ��");
            JButton jbBuyBooks = new JButton("����ͼ��");
            JButton jbOrderInquiry = new JButton("������ѯ");
            jbPublishedBooks.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    booksManagement.input();
                }
            });

            jbBuyBooks.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //����ͼ��
                    tm.buyBook(user);
                }
            });

            jbOrderInquiry.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tm.query();
                }
            });
            jFrame.add(jbPublishedBooks);
            jFrame.add(jbBuyBooks);
            jFrame.add(jbOrderInquiry);
        }
        else if ("2".equals(user.getType())) {
            JButton jbBookInformationModification = new JButton("ͼ����Ϣ�޸�");
            JButton jbDeleteBookInformation	= new JButton("ͼ����Ϣɾ��");
            jbBookInformationModification.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    booksManagement.update();
                }
            });
            jbDeleteBookInformation.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    booksManagement.delete();
                }
            });
            jFrame.add(jbBookInformationModification);
            jFrame.add(jbDeleteBookInformation);
        }
        JButton jbBookInformationQuery = new JButton("ͼ����Ϣ��ѯ");
        JButton jbBookInformationDisplay=new JButton("ͼ����Ϣ��ʾ");

        jbBookInformationQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                booksManagement.query();
            }
        });
        jbBookInformationDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                booksManagement.secondHandbooksDisplay();
            }
        });
        jFrame.add(jbBookInformationQuery);
        jFrame.add(jbBookInformationDisplay);
        jFrame.add(jbReturnToMainMenu);
        jbReturnToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispatchEvent(new WindowEvent(jFrame,WindowEvent.WINDOW_CLOSING) );
            }
        });
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        jFrame.setVisible(true);
        jFrame.pack();
    }


    static void menu3(User user, Books b2) {
        TransactionManagement c = new TransactionManagement(user,b2);
        JFrame jFrame = new JFrame("ͼ�齻�׹���");
        JLabel jLabel = new JLabel("ͼ�齻�׹���");
        JButton jButton1 = new JButton("ͼ��������Ϣ��ѯ");
        JButton jButton2 = new JButton("�û�������Ϣ��ѯ");
        jFrame.add(jLabel);
        jFrame.add(jButton1);
        jFrame.add(jButton2);
        jFrame.add(jbReturnToMainMenu);
        jbReturnToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispatchEvent(new WindowEvent(jFrame,WindowEvent.WINDOW_CLOSING) );
            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.circulationDisplay();
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.dQuery();
            }
        });
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        jFrame.setVisible(true);
        jFrame.pack();
    }
}
