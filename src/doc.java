import com.mysql.cj.jdbc.Blob;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

public class doc extends java.awt.Frame {

    public doc() {
        initComponents();
    }
    private String emailid;

    private void initComponents() {
        panel1 = new java.awt.Panel();
        update = new java.awt.Button();
        profile = new java.awt.Button();
        reminder = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        doctable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        view = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selected = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        select = new javax.swing.JButton();
        upload = new javax.swing.JButton();
        msg = new javax.swing.JLabel();

        setName("Documents");
        setTitle("Documents");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(192, 205, 250));
        panel1.setName("pro"); 
        panel1.setLayout(null);

        update.setBackground(new java.awt.Color(192, 205, 250));
        update.setFont(new java.awt.Font("Dialog", 1, 14));
        update.setLabel("Edit Profile");
        update.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        panel1.add(update);
        update.setBounds(180, 0, 90, 40);

        profile.setBackground(new java.awt.Color(192, 205, 250));
        profile.setFont(new java.awt.Font("Dialog", 1, 14));
        profile.setLabel("Profile");
        profile.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        panel1.add(profile);
        profile.setBounds(0, 0, 90, 40);

        reminder.setBackground(new java.awt.Color(192, 205, 250));
        reminder.setFont(new java.awt.Font("Dialog", 1, 14));
        reminder.setLabel("Reminders");
        reminder.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminderActionPerformed(evt);
            }
        });
        panel1.add(reminder);
        reminder.setBounds(90, 0, 90, 40);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        doctable.setFont(new java.awt.Font("Dialog", 0, 14));
        doctable.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {"Documents"}) {
            boolean[] canEdit = new boolean [] {false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        doctable.setRowHeight(24);
        jScrollPane1.setViewportView(doctable);

        panel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 90, 460, 140);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select a file to view or Delete");
        panel1.add(jLabel1);
        jLabel1.setBounds(320, 240, 160, 16);

        delete.setFont(new java.awt.Font("Dialog", 1, 14));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        panel1.add(delete);
        delete.setBounds(300, 280, 80, 27);

        view.setFont(new java.awt.Font("Dialog", 1, 14));
        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        panel1.add(view);
        view.setBounds(120, 280, 80, 27);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Upload New Document");
        panel1.add(jLabel2);
        jLabel2.setBounds(170, 350, 160, 19);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Name:");
        panel1.add(jLabel3);
        jLabel3.setBounds(10, 390, 50, 19);

        selected.setFont(new java.awt.Font("Dialog", 0, 12));
        panel1.add(selected);
        selected.setBounds(250, 390, 150, 22);

        name.setFont(new java.awt.Font("Dialog", 0, 12));
        panel1.add(name);
        name.setBounds(60, 390, 160, 22);

        select.setFont(new java.awt.Font("Dialog", 1, 14));
        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        panel1.add(select);
        select.setBounds(410, 390, 80, 20);

        upload.setFont(new java.awt.Font("Dialog", 1, 14));
        upload.setText("Upload");
        upload.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });
        panel1.add(upload);
        upload.setBounds(210, 430, 90, 27);

        msg.setFont(new java.awt.Font("Dialog", 1, 14));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel1.add(msg);
        msg.setBounds(150, 460, 220, 30);

        add(panel1, java.awt.BorderLayout.CENTER);

        ImageIcon icon = new ImageIcon("E:\\Fahad\\Sem 3\\Awt Practice\\JavaApplication1\\src\\Images\\logo.png");
        Image img = icon.getImage();
        setIconImage(img);
        setSize(new java.awt.Dimension(514, 537));
        setLocationRelativeTo(null);
    }

    private void exitForm(java.awt.event.WindowEvent evt) {                          
        System.exit(0);
    }

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {
        Profile view_prof = new Profile();
        view_prof.setVisible(true);
        view_prof.email_id = emailid;
        view_prof.setprof();
        dispose();
    }

    private void reminderActionPerformed(java.awt.event.ActionEvent evt) {
        Reminders rem = new Reminders();
        rem.setVisible(true);
        rem.setreminder(emailid);
        dispose();
    }

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {
        edit edit_prof = new edit();
        edit_prof.setVisible(true);
        edit_prof.setedit(emailid);
        dispose();
    }

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) doctable.getModel();
        if(model.getRowCount()==5)
        {
            msg.setForeground(Color.red);
            msg.setText("Max.5 Doc(s) can be uploaded");
        }
        else{
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
                InputStream is = new FileInputStream(f);
                int n = model.getRowCount() + 1;
                PreparedStatement st = (PreparedStatement) con.prepareStatement("Update user_data set doc"+n+"=?, name"+n+"=? where email_id=?");
                st.setBlob(1, is);
                st.setString(2, name.getText());
                st.setString(3,emailid);
                int x = st.executeUpdate();
                System.out.println(x);
                System.out.println("Update user_data set doc"+n+"=?, name"+n+"=? where email_id=?");
                if(x>0){
                    msg.setForeground(Color.GREEN);
                    msg.setText("Document Uploaded Successfully");
                }
                String[] namedb = new String[1];
                namedb[0] = name.getText();
                model.addRow(namedb);
                con.close();
            }
            catch(SQLException | ClassNotFoundException | FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser choose = new JFileChooser();
        choose.showOpenDialog(null);
        f = choose.getSelectedFile();
        filename = f.getAbsolutePath();
        selected.setText(filename);
    }

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
            DefaultTableModel model = (DefaultTableModel) doctable.getModel();
            int n = (doctable.getSelectedRow()) + 1;
            PreparedStatement st = (PreparedStatement) con.prepareStatement("Select* from user_data where email_id=?");
            st.setString(1,emailid);
            ResultSet rs = st.executeQuery();
            JFrame f1 = new JFrame();
            f1.setSize(700, 800);
            f1.setTitle(model.getValueAt(n-1, 0).toString());
            ImageIcon icon1 = new ImageIcon("E:\\Fahad\\Sem 3\\Awt Practice\\JavaApplication1\\src\\Images\\logo.png");
            Image img = icon1.getImage();
            f1.setIconImage(img);
            JLabel l1 = new JLabel();
            l1.setHorizontalAlignment(JLabel.CENTER);
            byte[] photo = null;
            while(rs.next()){
                String q = "doc"+n;
                photo = rs.getBytes(q);
            }
            JScrollPane sp = new JScrollPane(l1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            ImageIcon icon = new ImageIcon(photo);
            l1.setIcon(icon);
            f1.add(sp);
            f1.setVisible(true);
            f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            con.close();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
                DefaultTableModel model = (DefaultTableModel) doctable.getModel();
                int n = doctable.getSelectedRow();
                System.out.println(n);
                int no_of_rows = model.getRowCount();
                int t, j;
                for(t=n+2; t<=no_of_rows; t++){
                    j = t-1;
                    PreparedStatement st = (PreparedStatement) con.prepareStatement("Select* from user_data where email_id=?");
                    st.setString(1, emailid);
                    Blob img = null;
                    String nam = null;
                    ResultSet rs = st.executeQuery();
                    while(rs.next()){
                        img = (Blob) rs.getBlob("doc"+t);
                        nam = rs.getString("name"+t);
                    }
                    st = con.prepareStatement("Update user_data set name"+j+"=?, doc"+j+"=? where email_id=?");
                    st.setString(1, nam);
                    st.setBlob(2, img);
                    st.setString(3, emailid);
                    st.executeUpdate();
                }
                j = t-1;
                PreparedStatement st = (PreparedStatement) con.prepareStatement("Update user_data set name"+j+"=?, doc"+j+"=? where email_id=?");
                st.setString(1, null);
                st.setString(2,null);
                st.setString(3,emailid);
                st.executeUpdate();
                model.removeRow(n);
                con.close();
            }
            catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doc().setVisible(true);
            }
        });
    }

    public void setDoc(String email_id)
    {
        emailid = email_id;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
            PreparedStatement st = (PreparedStatement) con.prepareStatement("Select* from user_data where email_id=?");
            st.setString(1, email_id);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                DefaultTableModel model = (DefaultTableModel) doctable.getModel();
                String[] namedb = new String[1];
                for(int i=1;i<=5;i++)
                {
                    if(rs.getString("name"+i) == null)break;
                    namedb[0] = rs.getString("name"+i);
                    model.addRow(namedb);
                }
            }
            con.close();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }   
    
    // Variables declaration
    private javax.swing.JButton delete;
    private javax.swing.JTable doctable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel msg;
    private javax.swing.JTextField name;
    private java.awt.Panel panel1;
    private java.awt.Button profile;
    private java.awt.Button reminder;
    private javax.swing.JButton select;
    private javax.swing.JTextField selected;
    private java.awt.Button update;
    private javax.swing.JButton upload;
    private javax.swing.JButton view;
    // End of variables declaration
    String filename;
    File f;
}
