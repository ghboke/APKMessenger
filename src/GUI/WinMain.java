package GUI;

import ToolUtil.SignUtil;
import com.sun.deploy.panel.JreTableModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class WinMain {
    private JFrame win;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private JTextField Edit_FilePath;
    private JTextField Edit_AppName;
    private JTextField Edit_PackageName;
    private JTextField Edit_VersionName;
    private JTextField Edit_Version;
    private JTextField Edit_MD5;
    private JTextField Edit_PEInfo;
    private JButton Btn_ll;
    private JButton Btn_AppName;
    private JButton Btn_PackageName;
    private JButton Btn_VersionName;
    private JButton Btn_Version;
    private JButton Btn_MD5;
    private JButton Btn_PEInfo;
    private JComboBox jComboBox_lang;
    private Thread ThreadMain;
    private ApkinfotoUI apkinfotoUI;
    private JTabbedPane jTabbedPane;
    private JPanel jPanel_Main;
    private JPanel jPanel_Permissions;
    private JPanel jPanel_Sign;
    private JPanel jPanel_Otherinfo;
    private JTable jTable_Permissions;
    private JTable jTable_Sign;
    private JTable jTable_Otherinfo;
    private final Color WRITE = new Color(16777215);

    public void CreatWin() {
        setUI();
        win = new JFrame("APK Messenger v3.0");
        win.setSize(586, 277);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        win.setResizable(false);
        win.setLayout(null);
        win.getContentPane().setBackground(WRITE);
        //创建菜单
        MenuBar menuBar = new MenuBar();
        Menu menu_1 = new Menu("软件");
        Menu menu_2 = new Menu("文件");
        Menu menu_3 = new Menu("工具");
        Menu menu_4 = new Menu("帮助");


        //软件菜单
        MenuItem menuItem_1_1 = new MenuItem("软件设置");
        MenuItem menuItem_1_2 = new MenuItem("生成分析报告");
        menu_1.add(menuItem_1_1);
        menu_1.add(menuItem_1_2);
        //另存为菜单
        Menu menu_2_1 = new Menu("另存为");
        MenuItem menuItem_2_1 = new MenuItem("文件名另存");
        MenuItem menuItem_2_2 = new MenuItem("自定义另存");
        MenuItem menuItem_2_3 = new MenuItem("软件名称-版本号另存");
        MenuItem menuItem_2_4 = new MenuItem("包名另存");
        menu_2_1.add(menuItem_2_1);
        menu_2_1.add(menuItem_2_2);
        menu_2_1.add(menuItem_2_3);
        menu_2_1.add(menuItem_2_4);
        //工具菜单
        Menu menu_3_1 = new Menu("在线查询");
        MenuItem menuItem_3_1 = new MenuItem("Google Play");
        MenuItem menuItem_3_2 = new MenuItem("酷安");
        MenuItem menuItem_3_3 = new MenuItem("PP助手");
        MenuItem menuItem_3_4 = new MenuItem("豌豆荚");
        menu_3_1.add(menuItem_3_1);
        menu_3_1.add(menuItem_3_2);
        menu_3_1.add(menuItem_3_3);
        menu_3_1.add(menuItem_3_4);
        //帮助菜单
        MenuItem menuItem_4_1 = new MenuItem("关于软件");
        MenuItem menuItem_4_2 = new MenuItem("软件主页");
        MenuItem menuItem_4_3 = new MenuItem("常见问题");
        menu_4.add(menuItem_4_1);
        menu_4.add(menuItem_4_2);
        menu_4.add(menuItem_4_3);
        //设置菜单
        menuBar.add(menu_1);
        menuBar.add(menu_2);
        menu_2.add(menu_2_1);
        menuBar.add(menu_3);
        menu_3.add(menu_3_1);
        menuBar.add(menu_4);
        win.setMenuBar(menuBar);
        //图标图片框
        JLabel IcoBox = new JLabel();

        IcoBox.setBounds(8, 24, 152, 152);
        IcoBox.setBorder(BorderFactory.createLineBorder(Color.black));
        ImageIcon andico = new ImageIcon(getClass().getResource("andico.png"));
        IcoBox.setHorizontalAlignment(JLabel.CENTER);//图片居中
        IcoBox.setIcon(andico);
        win.add(IcoBox);
        label1 = DrowLable("文件路径：", 168, 16, 56, 24);
        label2 = DrowLable("应用名：", 168, 48, 56, 24);
        label3 = DrowLable("包名：", 168, 75, 56, 24);
        label4 = DrowLable("版本名：", 168, 104, 56, 24);
        label5 = DrowLable("文件MD5：", 168, 136, 56, 24);
        label6 = DrowLable("加固类型：", 168, 168, 56, 24);
        label7 = DrowLable("版本号：", 377, 104, 45, 24);
        label8 = DrowLable("展开》》》", 500, 200, 64, 24);
        label8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label8.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (win.getHeight() == 535) {
                    label8.setText("展开》》》");
                    win.setSize(586, 277);
                } else {
                    label8.setText("收起《《《");
                    win.setSize(586, 535);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        //语言选择下拉列表
        jComboBox_lang = new JComboBox();
        jComboBox_lang.setBounds(232, 49, 72, 20);
        jComboBox_lang.addItem("默认");
        //编辑框绘制
        Edit_FilePath = DrowEdit("", 232, 16, 256, 24);
        Edit_AppName = DrowEdit("", 312, 48, 176, 24);
        Edit_PackageName = DrowEdit("", 232, 75, 256, 24);
        Edit_VersionName = DrowEdit("", 232, 104, 64, 24);
        Edit_Version = DrowEdit("", 424, 104, 64, 24);
        Edit_MD5 = DrowEdit("", 232, 136, 256, 24);
        Edit_PEInfo = DrowEdit("", 232, 168, 256, 24);
        //绘制按钮
        Btn_ll = DrowBtn("浏览", 497, 16, 72, 24);
        Btn_AppName = DrowBtn("复制", 497, 46, 72, 24);
        Btn_PackageName = DrowBtn("复制", 497, 74, 72, 24);
        Btn_VersionName = DrowBtn("复制", 301, 104, 72, 24);
        Btn_Version = DrowBtn("复制", 497, 104, 72, 24);
        Btn_MD5 = DrowBtn("复制", 497, 136, 72, 24);
        Btn_PEInfo = DrowBtn("复制", 497, 168, 72, 24);
        //事件绑定
        Btn_ll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("安卓apk文件", "apk");
                fileChooser.addChoosableFileFilter(fileNameExtensionFilter);
                fileChooser.setFileFilter(fileNameExtensionFilter);
                fileChooser.showOpenDialog(win.getContentPane());
            }
        });
        JCheckBox top = new JCheckBox("窗口顶置");
        top.setBounds(8, 200, 96, 24);
        top.setBackground(WRITE);
        top.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                win.setAlwaysOnTop(top.isSelected());//窗口顶置
            }
        });
        top.setFocusable(false);

        //绘制详细信息的面板
        jPanel_Main = new JPanel();
        jPanel_Permissions = new JPanel();
        jPanel_Permissions.setOpaque(false);


        jPanel_Sign = new JPanel();
        jPanel_Sign.setBackground(WRITE);
        jPanel_Otherinfo = new JPanel();
        jPanel_Otherinfo.setBackground(WRITE);
        jTabbedPane = new JTabbedPane();
        jTabbedPane.setBackground(WRITE);
        jPanel_Main.setBounds(8, 232, 560, 248);
        jPanel_Main.setBackground(WRITE);
        jTabbedPane.setBounds(8, 0, 550, 240);
        jPanel_Main.setLayout(null);
        jPanel_Main.add(jTabbedPane);
        jTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);


        //权限表

        String[] jTable_Permissions_colname = {"编号", "英文名", "权限名称", "权限注释"};
        jTable_Permissions = new JTable(null, jTable_Permissions_colname);
        //禁止表格编辑
        DefaultTableModel jTable_PermissionsTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable_Permissions.setGridColor(WRITE);

        JScrollPane jScrollPane_Permissions=new JScrollPane(jTable_Permissions);//拖动面板
       jScrollPane_Permissions.setBorder(BorderFactory.createLineBorder(WRITE));
        jTable_Permissions.getTableHeader().setReorderingAllowed(false);//禁止拖动

        jPanel_Permissions.setLayout(new BorderLayout());
      // jScrollPane_Permissions.setOpaque(false);
        jScrollPane_Permissions.setBackground(WRITE);
        jPanel_Permissions.add(jScrollPane_Permissions, BorderLayout.CENTER);

        jTable_PermissionsTableModel.setDataVector(null, jTable_Permissions_colname);
        jTable_Permissions.setModel(jTable_PermissionsTableModel);
        jTable_Permissions.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_Permissions.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable_Permissions.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable_Permissions.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTable_Permissions.getColumnModel().getColumn(3).setPreferredWidth(400);
        //签名表
        String[] jTable_Sign_colname = {"项目名称", "项目内容"};
        jTable_Sign = new JTable(null, jTable_Sign_colname);
        //禁止表格编辑
        DefaultTableModel jTable_SignTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable_Sign.setGridColor(WRITE);
        jTable_Sign.getTableHeader().setReorderingAllowed(false);//禁止拖动
        jPanel_Sign.setLayout(new BorderLayout());
        JTableHeader jTableHeaderSign = jTable_Sign.getTableHeader();
        jPanel_Sign.add(jTableHeaderSign, BorderLayout.NORTH);//添加表头
        jPanel_Sign.add(jTable_Sign, BorderLayout.CENTER);
        jTable_SignTableModel.setDataVector(null, jTable_Sign_colname);
        jTable_Sign.setModel(jTable_SignTableModel);
        //其他信息表
        String[] jTable_Other_colname = {"项目名称", "项目内容", "注释"};
        jTable_Otherinfo = new JTable(null, jTable_Other_colname);
        //禁止表格编辑
        DefaultTableModel jTable_OtherTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable_Otherinfo.setGridColor(WRITE);
        jTable_Otherinfo.getTableHeader().setReorderingAllowed(false);//禁止拖动
        jPanel_Otherinfo.setLayout(new BorderLayout());
        JTableHeader jTableHeaderOther = jTable_Otherinfo.getTableHeader();
        jPanel_Otherinfo.add(jTableHeaderOther, BorderLayout.NORTH);//添加表头
        jPanel_Otherinfo.add(jTable_Otherinfo, BorderLayout.CENTER);
        jTable_OtherTableModel.setDataVector(null, jTable_Other_colname);
        jTable_Otherinfo.setModel(jTable_OtherTableModel);


        jTabbedPane.addTab("权限信息", jPanel_Permissions);
        jTabbedPane.addTab("签名信息", jPanel_Sign);
        jTabbedPane.addTab("其他信息", jPanel_Otherinfo);
        //添加组件
        addobj(Edit_AppName, Edit_FilePath, Edit_MD5, Edit_PackageName, Edit_PEInfo, Edit_Version, Edit_VersionName);
        addobj(label1, label2, label3, label4, label5, label6, label7, label8);
        addobj(Btn_AppName, Btn_ll, Btn_MD5, Btn_PackageName, Btn_PEInfo, Btn_Version, Btn_VersionName, jComboBox_lang, top);
        addobj(jPanel_Main);
        addDropTarget(win.getContentPane());
        addDropTarget(Edit_AppName);
        addDropTarget(Edit_FilePath);
        addDropTarget(Edit_MD5);
        addDropTarget(Edit_PackageName);
        addDropTarget(Edit_PEInfo);
        addDropTarget(Edit_Version);
        addDropTarget(Edit_VersionName);


        addDropTarget(IcoBox);
        win.setVisible(true);
        apkinfotoUI = new ApkinfotoUI(Edit_FilePath, Edit_AppName, Edit_PackageName, Edit_VersionName, Edit_Version, Edit_MD5
                , Edit_PEInfo, jComboBox_lang, IcoBox,jTable_Permissions,jTable_Sign,jTable_Otherinfo);
    }

    private void addDropTarget(Component obj) {
        DropTarget dropTarget = CreatdropTarget();
        obj.setDropTarget(dropTarget);

    }

    private DropTarget CreatdropTarget() {
        DropTargetAdapter dropTargetAdapter = new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent dtde) {
                try {
                    if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor))//如果拖入的文件格式受支持
                    {
                        //只能单一拖放
                        dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);//接收拖拽来的数据
                        List<File> list = (List<File>) (dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor));
                        //获取文件后缀名
                        String FileName = list.get(0).getAbsolutePath();
                        String prefix = FileName.substring(FileName.lastIndexOf(".") + 1).toLowerCase();
                        if (prefix.equals("apk")) {

                            ThreadMain = new Thread(new Runnable() {
                                @Override
                                public void run() {


                                     apkinfotoUI.OpenApkFile(FileName);
                                }
                            });
                            ThreadMain.start();

                        }


                        dtde.dropComplete(true);//指示拖拽操作已完成
                    } else {
                        dtde.rejectDrop();//否则拒绝拖拽来的数据
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        DropTarget dropTarget = new DropTarget(win, dropTargetAdapter);
        return dropTarget;
    }


    private void addobj(Object... objs) {
        for (Object obj : objs) {
            win.add((Component) obj);
        }

    }

    private Label DrowLable(String str, int x, int y, int w, int h) {
        Label lab = new Label(str);
        lab.setBounds(x, y, w, h);
        return lab;
    }

    private JTextField DrowEdit(String str, int x, int y, int w, int h) {
        JTextField Edit = new JTextField(str);
        Edit.setBounds(x, y, w, h);
        return Edit;
    }

    private JButton DrowBtn(String str, int x, int y, int w, int h) {
        JButton Btn = new JButton(str);
        Btn.setBounds(x, y, w, h);
        return Btn;
    }


    private void setUI() {
        String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            UIManager.setLookAndFeel(windows);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
