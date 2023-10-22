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
        jbReturnToMainMenu = new JButton("返回主菜单");
        userManagement.login();
    }



    /**
     * 普通用户登录后的菜单
     */
    public static void menuUser(User user){
        JFrame frame = new JFrame("主菜单");
        JLabel jLabel = new JLabel("欢迎来到图书销售平台");

        JButton jbUserManage = new JButton("个人信息管理");
        JButton jbBooksManage = new JButton("图书管理");
        JButton jbQuit= new JButton("退出");

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
     * 管理员登录后的菜单
     */
    public static void menuAdmin(User user){
        JFrame frame = new JFrame("主菜单");
        JLabel jLabel = new JLabel("欢迎来到图书销售平台");

        JButton jbUserManage = new JButton("用户管理");
        JButton jbBooksManage = new JButton("图书管理");
        JButton jbBooksTransactionManage = new JButton("图书交易管理");
        JButton jbQuit= new JButton("退出系统");


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
        JButton jbChangePassword = new JButton("修改当前密码");
        JButton jbTopUp = new JButton("充值");
        JButton jbQueryBalance = new JButton("查询余额");
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
            JLabel jLabel = new JLabel("个人信息管理");
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
            JLabel jLabel = new JLabel("用户管理");
            JButton jbUserAdded = new JButton("用户添加");
            JButton jbUserChange = new JButton("用户修改");
            JButton jbUserDelete = new JButton("用户删除");
            JButton jbQueryUserInformationById = new JButton("用账号查询用户信息");
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
        JFrame jFrame = new JFrame("图书管理");
        JLabel jLabel = new JLabel("图书管理");
        jFrame.add(jLabel);
        if ("1".equals(user.getType())) {
            JButton jbPublishedBooks = new JButton("发布图书");
            JButton jbBuyBooks = new JButton("购买图书");
            JButton jbOrderInquiry = new JButton("订单查询");
            jbPublishedBooks.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    booksManagement.input();
                }
            });

            jbBuyBooks.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //购买图书
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
            JButton jbBookInformationModification = new JButton("图书信息修改");
            JButton jbDeleteBookInformation	= new JButton("图书信息删除");
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
        JButton jbBookInformationQuery = new JButton("图书信息查询");
        JButton jbBookInformationDisplay=new JButton("图书信息显示");

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
        JFrame jFrame = new JFrame("图书交易管理");
        JLabel jLabel = new JLabel("图书交易管理");
        JButton jButton1 = new JButton("图书买卖信息查询");
        JButton jButton2 = new JButton("用户买卖信息查询");
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
