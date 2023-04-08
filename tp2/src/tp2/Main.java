/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp5_2;

import java.sql.Connection;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @direktor Hp
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    boolean isFilm = true;
    String filenamefilm = null;
    String filenamedirektor = null;
    byte[] film_image = null;
    byte[] direktor_image = null;

    dbConnection dbcon = new dbConnection();

    public Main() {
        initComponents();
        populateTabelfilm();
        PanelLogin.setVisible(true);
        Paneldirektor.setVisible(false);
        Panelfilm.setVisible(false);
        PanelAdddirektor.setVisible(false);
        PanelAddfilm.setVisible(false);

    }

    public void populateTabelfilm() {

        dbConnection myq = new dbConnection();
        ArrayList<Film> list = myq.getItemListFilm();
        String[] columnName = { "No", "Judul", "Genre", "Poster" };
        Object[][] rows = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getNama();
            rows[i][2] = list.get(i).getGenre();

            if (list.get(i).getImage() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
                        .getScaledInstance(120, 150, Image.SCALE_SMOOTH));

                rows[i][3] = image;
            } else {
                rows[i][3] = null;
            }

        }

        // set tabel
        theModel model = new theModel(rows, columnName);
        tbl_film.setModel(model);
        tbl_film.setRowHeight(200);
        tbl_film.getColumnModel().getColumn(3).setPreferredWidth(200);

        // Membuat tabel align center

        ((DefaultTableCellRenderer) tbl_film.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int columnIndex = 0; columnIndex < model.getColumnCount() - 1; columnIndex++) {
            tbl_film.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }

    }

    public void populateTabeldirektor() {

        dbConnection myq = new dbConnection();
        ArrayList<Direktor> list = myq.getItemListDirektor();
        String[] columnName = { "No", "Nama", "Jumlah Film", "Email", "Photo" };
        Object[][] rows = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getNama();
            rows[i][2] = list.get(i).getJumlah();
            rows[i][3] = list.get(i).getEmail();

            if (list.get(i).getImage() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
                        .getScaledInstance(120, 150, Image.SCALE_SMOOTH));

                rows[i][4] = image;
            } else {
                rows[i][4] = null;
            }

        }

        // set tabel
        theModel model = new theModel(rows, columnName);
        tbl_direktor.setModel(model);
        tbl_direktor.setRowHeight(200);
        tbl_direktor.getColumnModel().getColumn(4).setPreferredWidth(150);

        // Membuat tabel align center

        ((DefaultTableCellRenderer) tbl_direktor.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int columnIndex = 0; columnIndex < model.getColumnCount() - 1; columnIndex++) {
            tbl_direktor.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }

    }

    public void populateTabelUser() {

        dbConnection myq = new dbConnection();
        ArrayList<User> list = myq.getItemListUser();
        String[] columnName = { "No", "Username", "Password" };
        Object[][] rows = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getUsername();
            rows[i][2] = list.get(i).getPassword();

        }

        // set tabel
        theModel model = new theModel(rows, columnName);
        tbl_user.setModel(model);
        tbl_user.setRowHeight(200);
        tbl_user.getColumnModel().getColumn(4).setPreferredWidth(150);

        // Membuat tabel align center

        ((DefaultTableCellRenderer) tbl_user.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int columnIndex = 0; columnIndex < model.getColumnCount() - 1; columnIndex++) {
            tbl_user.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLogin = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        tf_password = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        Panelfilm = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_film = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_film = new javax.swing.JButton();
        btn_direktor = new javax.swing.JButton();
        btn_deletefilm = new javax.swing.JButton();
        btn_updatefilm = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Paneldirektor = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_direktor = new javax.swing.JTable();
        btn_direktor1 = new javax.swing.JButton();
        btn_film1 = new javax.swing.JButton();
        btn_add1 = new javax.swing.JButton();
        btn_updatedirektor = new javax.swing.JButton();
        btn_deletedirektor = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        PanelAddfilm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_genrefilm = new javax.swing.JTextField();
        tf_namafilm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        up_imagefilm = new javax.swing.JButton();
        btn_addfilm = new javax.swing.JButton();
        lbl_imagefilm = new javax.swing.JLabel();
        PanelAdddirektor = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tf_jumlahfilm = new javax.swing.JTextField();
        tf_namadirektor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        up_imagedirektor = new javax.swing.JButton();
        btn_adddirektor = new javax.swing.JButton();
        lbl_imagedirektor = new javax.swing.JLabel();
        tf_Email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setText("Login");

        jLabel11.setText("Username   :");

        jLabel12.setText("Password  :");

        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });

        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });

        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLoginLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_password, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(tf_username)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLoginLayout.createSequentialGroup()
                                .addComponent(btn_login)
                                .addGap(40, 40, 40)))))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel10)
                .addGap(71, 71, 71)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(btn_login)
                .addContainerGap(303, Short.MAX_VALUE))
        );

        tbl_film.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_film.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_filmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_film);

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_film.setText("film");
        btn_film.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filmActionPerformed(evt);
            }
        });

        btn_direktor.setText("direktor");
        btn_direktor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_direktorActionPerformed(evt);
            }
        });

        btn_deletefilm.setText("Delete");
        btn_deletefilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletefilmActionPerformed(evt);
            }
        });

        btn_updatefilm.setText("Update");
        btn_updatefilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updatefilmActionPerformed(evt);
            }
        });

        btn_logout.setBackground(java.awt.Color.black);
        btn_logout.setForeground(java.awt.Color.white);
        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setText("FILM");

        javax.swing.GroupLayout PanelfilmLayout = new javax.swing.GroupLayout(Panelfilm);
        Panelfilm.setLayout(PanelfilmLayout);
        PanelfilmLayout.setHorizontalGroup(
            PanelfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelfilmLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(PanelfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_direktor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_film, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelfilmLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(PanelfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelfilmLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelfilmLayout.createSequentialGroup()
                        .addComponent(btn_updatefilm, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(btn_deletefilm, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelfilmLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(318, 318, 318))))
        );
        PanelfilmLayout.setVerticalGroup(
            PanelfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelfilmLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_film, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_direktor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(PanelfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_updatefilm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deletefilm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        tbl_direktor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_direktor);

        btn_direktor1.setText("direktor");
        btn_direktor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_direktor1ActionPerformed(evt);
            }
        });

        btn_film1.setText("film");
        btn_film1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_film1ActionPerformed(evt);
            }
        });

        btn_add1.setText("Add");
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });

        btn_updatedirektor.setText("Update");
        btn_updatedirektor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updatedirektorActionPerformed(evt);
            }
        });

        btn_deletedirektor.setText("Delete");
        btn_deletedirektor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletedirektorActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setText("DIREKTOR");

        javax.swing.GroupLayout PaneldirektorLayout = new javax.swing.GroupLayout(Paneldirektor);
        Paneldirektor.setLayout(PaneldirektorLayout);
        PaneldirektorLayout.setHorizontalGroup(
            PaneldirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneldirektorLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(PaneldirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaneldirektorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PaneldirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PaneldirektorLayout.createSequentialGroup()
                                .addComponent(btn_film1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PaneldirektorLayout.createSequentialGroup()
                                .addComponent(btn_direktor1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                                .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneldirektorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_updatedirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btn_deletedirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );
        PaneldirektorLayout.setVerticalGroup(
            PaneldirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneldirektorLayout.createSequentialGroup()
                .addGroup(PaneldirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaneldirektorLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btn_film1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PaneldirektorLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel14)))
                .addGap(21, 21, 21)
                .addGroup(PaneldirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_direktor1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(PaneldirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_updatedirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deletedirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(690, Short.MAX_VALUE))
        );

        PanelAddfilm.setPreferredSize(new java.awt.Dimension(740, 633));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Add Record film Baru");

        jLabel2.setText("Judul film   :");

        jLabel3.setText("Genre film :");

        jLabel4.setText("Poster        :");

        up_imagefilm.setText("Load");
        up_imagefilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_imagefilmActionPerformed(evt);
            }
        });

        btn_addfilm.setText("Add film");
        btn_addfilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addfilmActionPerformed(evt);
            }
        });

        lbl_imagefilm.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PanelAddfilmLayout = new javax.swing.GroupLayout(PanelAddfilm);
        PanelAddfilm.setLayout(PanelAddfilmLayout);
        PanelAddfilmLayout.setHorizontalGroup(
            PanelAddfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAddfilmLayout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addGroup(PanelAddfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(PanelAddfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_namafilm, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_genrefilm, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAddfilmLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbl_imagefilm, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(up_imagefilm)))
                .addGap(176, 176, 176))
            .addGroup(PanelAddfilmLayout.createSequentialGroup()
                .addGroup(PanelAddfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAddfilmLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAddfilmLayout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(btn_addfilm, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelAddfilmLayout.setVerticalGroup(
            PanelAddfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddfilmLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(PanelAddfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_namafilm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(PanelAddfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_genrefilm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(PanelAddfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAddfilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(up_imagefilm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(lbl_imagefilm, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btn_addfilm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelAdddirektor.setPreferredSize(new java.awt.Dimension(740, 633));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Add Record direktor Baru");

        jLabel6.setText("Nama direktor :");

        jLabel7.setText("Jumlah film  :");

        jLabel8.setText("Photo         :   ");

        up_imagedirektor.setText("Load");
        up_imagedirektor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_imagedirektorActionPerformed(evt);
            }
        });

        btn_adddirektor.setText("Add direktor");
        btn_adddirektor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adddirektorActionPerformed(evt);
            }
        });

        jLabel9.setText("Email           :");

        javax.swing.GroupLayout PanelAdddirektorLayout = new javax.swing.GroupLayout(PanelAdddirektor);
        PanelAdddirektor.setLayout(PanelAdddirektorLayout);
        PanelAdddirektorLayout.setHorizontalGroup(
            PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                .addGroup(PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(btn_adddirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAdddirektorLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(112, 112, 112)
                        .addComponent(lbl_imagedirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(up_imagedirektor))
                    .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                        .addGroup(PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(42, 42, 42)
                        .addGroup(PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_namadirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_jumlahfilm, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(176, 176, 176))
        );
        PanelAdddirektorLayout.setVerticalGroup(
            PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_namadirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_jumlahfilm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(lbl_imagedirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                        .addGroup(PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(PanelAdddirektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(80, 80, 80)
                                .addComponent(up_imagedirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelAdddirektorLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btn_adddirektor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelfilm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Paneldirektor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(PanelAddfilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelAdddirektor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panelfilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 654, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Paneldirektor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(PanelAddfilm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(656, 656, 656)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelAdddirektor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_passwordActionPerformed


    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db_tp5", "root", "");
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, tf_username.getText());
            pst.setString(2, tf_password.getText());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Jika username dan password benar, tampilkan pesan berhasil login
                JOptionPane.showMessageDialog(this, "Berhasil login!");
                // Lakukan operasi yang diinginkan setelah login berhasil
                // Contoh: tampilkan panel yang sebelumnya tersembunyi
                Panelfilm.setVisible(true);
                PanelLogin.setVisible(false);
                populateTabelUser();
            } else {
                // Jika username atau password salah, tampilkan pesan error
                JOptionPane.showMessageDialog(this, "Username atau password salah!");
            }

            rs.close();
            pst.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PanelLogin.setVisible(true);
    }

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Lakukan operasi yang diinginkan setelah logout berhasil
            // Contoh: sembunyikan panel yang sebelumnya ditampilkan saat login
            Panelfilm.setVisible(false);
            // Kosongkan username dan password
            tf_username.setText("");
            tf_password.setText("");
        }

        PanelLogin.setVisible(true);
    }
    

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        Panelfilm.setVisible(false);
        Paneldirektor.setVisible(false);
        PanelAdddirektor.setVisible(false);
        PanelAddfilm.setVisible(true);
        PanelLogin.setVisible(false);
    }// GEN-LAST:event_btn_addActionPerformed

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_add1ActionPerformed
        // TODO add your handling code here:
        Panelfilm.setVisible(false);
        PanelLogin.setVisible(false);
        Paneldirektor.setVisible(false);
        PanelAdddirektor.setVisible(true);
        PanelAddfilm.setVisible(false);
    }// GEN-LAST:event_btn_add1ActionPerformed

    private void btn_direktorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_direktorActionPerformed
        // TODO add your handling code here:
        Panelfilm.setVisible(false);
        Paneldirektor.setVisible(true);
        PanelLogin.setVisible(false);
        populateTabeldirektor();
    }// GEN-LAST:event_btn_direktorActionPerformed

    private void btn_filmActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_filmActionPerformed
        // TODO add your handling code here:
        Panelfilm.setVisible(true);
        PanelLogin.setVisible(false);
        Paneldirektor.setVisible(false);
        PanelAdddirektor.setVisible(false);
        PanelAddfilm.setVisible(false);
        populateTabelfilm();
    }// GEN-LAST:event_btn_filmActionPerformed

    private void btn_direktor1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_direktor1ActionPerformed
        // TODO add your handling code here:
        PanelLogin.setVisible(false);
        Panelfilm.setVisible(false);
        Paneldirektor.setVisible(true);
        PanelAdddirektor.setVisible(false);
        PanelAddfilm.setVisible(false);
        populateTabeldirektor();
    }// GEN-LAST:event_btn_direktor1ActionPerformed

    private void btn_film1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_film1ActionPerformed
        // TODO add your handling code here:
        PanelLogin.setVisible(false);
        Panelfilm.setVisible(true);
        Paneldirektor.setVisible(false);
        PanelAdddirektor.setVisible(false);
        PanelAddfilm.setVisible(false);
        populateTabelfilm();
    }// GEN-LAST:event_btn_film1ActionPerformed

    private void btn_updatedirektorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_updatedirektorActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_updatedirektorActionPerformed

    private void btn_deletedirektorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_deletedirektorActionPerformed
        // TODO add your handling code here:
        
    }// GEN-LAST:event_btn_deletedirektorActionPerformed

    private void btn_deletefilmActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_deletefilmActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_deletefilmActionPerformed

    private void btn_updatefilmActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_updatefilmActionPerformed
        // TODO add your handling code here:

    }// GEN-LAST:event_btn_updatefilmActionPerformed

    private void btn_addfilmActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_addfilmActionPerformed
        // TODO add your handling code here:

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db_tp5", "root", "");
            String sql = "insert into film (nama, genre, `image`) values (?, ?, ?) ";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, tf_namafilm.getText());
            pst.setString(2, tf_genrefilm.getText());
            pst.setBytes(3, film_image);

            pst.execute();
            pst.close();

        } catch (Exception e) {

        }

        // String nama = tf_namafilm.getText();
        // String genre = tf_genrefilm.getText();
        //
        // dbcon.Query("insert into mahasiswa (nama, genre, `image`) values
        // (\""+nama+"\","+genre+", "+person_image+")");

        PanelAddfilm.setVisible(false);
        populateTabelfilm();
        Panelfilm.setVisible(true);
        PanelLogin.setVisible(false);

    }// GEN-LAST:event_btn_addfilmActionPerformed

    private void up_imagefilmActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_up_imagefilmActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        filenamefilm = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filenamefilm).getImage()
                .getScaledInstance(lbl_imagefilm.getWidth(), lbl_imagefilm.getHeight(), Image.SCALE_DEFAULT));
        lbl_imagefilm.setIcon(imageIcon);
        try {

            File image = new File(filenamefilm);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[10000];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum);
            }
            film_image = bos.toByteArray();
        }

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }// GEN-LAST:event_up_imagefilmActionPerformed

    private void up_imagedirektorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_up_imagedirektorActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        filenamedirektor = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filenamedirektor).getImage()
                .getScaledInstance(lbl_imagedirektor.getWidth(), lbl_imagedirektor.getHeight(), Image.SCALE_DEFAULT));
        lbl_imagedirektor.setIcon(imageIcon);
        try {

            File image = new File(filenamedirektor);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[10000];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum);
            }
            direktor_image = bos.toByteArray();
        }

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }// GEN-LAST:event_up_imagedirektorActionPerformed

    private void btn_adddirektorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_adddirektorActionPerformed
        // TODO add your handling code here:
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db_tp5", "root", "");
            String sql = "insert into direktor (nama, jumlah_film, email, `image`) values (?, ?, ?, ?) ";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, tf_namadirektor.getText());
            pst.setInt(2, Integer.parseInt(tf_jumlahfilm.getText()));
            pst.setString(3, tf_Email.getText());
            pst.setBytes(4, direktor_image);

            pst.execute();
            pst.close();

        } catch (Exception e) {

        }

        // String nama = tf_namafilm.getText();
        // String genre = tf_genrefilm.getText();
        //
        // dbcon.Query("insert into mahasiswa (nama, genre, `image`) values
        // (\""+nama+"\","+genre+", "+person_image+")");

        PanelAdddirektor.setVisible(false);
        populateTabeldirektor();
        Paneldirektor.setVisible(true);
        PanelLogin.setVisible(false);
    }// GEN-LAST:event_btn_adddirektorActionPerformed

    private void tbl_filmMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_filmMouseClicked
        // TODO add your handling code here:
        // Get Selected Data

    }

    private void tbl_userMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_filmMouseClicked
        // TODO add your handling code here:
        // Get Selected Data

    }// GEN-LAST:event_tbl_filmMouseClicked

    private void btn_addfilm1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_addfilm1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_addfilm1ActionPerformed

    private void tf_namafilm1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tf_namafilm1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tf_namafilm1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAdddirektor;
    private javax.swing.JPanel PanelAddfilm;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JPanel Paneldirektor;
    private javax.swing.JPanel Panelfilm;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add1;
    private javax.swing.JButton btn_adddirektor;
    private javax.swing.JButton btn_addfilm;
    private javax.swing.JButton btn_deletedirektor;
    private javax.swing.JButton btn_deletefilm;
    private javax.swing.JButton btn_direktor;
    private javax.swing.JButton btn_direktor1;
    private javax.swing.JButton btn_film;
    private javax.swing.JButton btn_film1;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_updatedirektor;
    private javax.swing.JButton btn_updatefilm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_imagedirektor;
    private javax.swing.JLabel lbl_imagefilm;
    private javax.swing.JTable tbl_direktor;
    private javax.swing.JTable tbl_film;
    private javax.swing.JTextField tf_Email;
    private javax.swing.JTextField tf_genrefilm;
    private javax.swing.JTextField tf_jumlahfilm;
    private javax.swing.JTextField tf_namadirektor;
    private javax.swing.JTextField tf_namafilm;
    private javax.swing.JTextField tf_password;
    private javax.swing.JTextField tf_username;
    private javax.swing.JButton up_imagedirektor;
    private javax.swing.JButton up_imagefilm;
    // End of variables declaration//GEN-END:variables
}
