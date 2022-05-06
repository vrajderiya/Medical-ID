import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;


public class edit extends java.awt.Frame {

    public edit() {
        initComponents();
    }

    private String emailid;

    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        profile = new java.awt.Button();
        reminder = new java.awt.Button();
        doc = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        first_name = new javax.swing.JTextField();
        middle_name = new javax.swing.JTextField();
        last_name = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        mob = new javax.swing.JTextField();
        female = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        show = new javax.swing.JRadioButton();
        save = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        upload = new javax.swing.JButton();
        selected = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setTitle("Edit Profile");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(192, 205, 250));
        panel1.setName("pro");
        panel1.setLayout(null);

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

        doc.setBackground(new java.awt.Color(192, 205, 250));
        doc.setFont(new java.awt.Font("Dialog", 1, 14));
        doc.setLabel("Documents");
        doc.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docActionPerformed(evt);
            }
        });
        panel1.add(doc);
        doc.setBounds(180, 0, 90, 40);

        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 130, 150);

        panel1.add(jPanel1);
        jPanel1.setBounds(360, 10, 130, 150);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("DOB (YYYY-MM-DD):");
        panel1.add(jLabel2);
        jLabel2.setBounds(20, 270, 150, 20);

        email.setEditable(false);
        email.setFont(new java.awt.Font("Dialog", 0, 13));
        panel1.add(email);
        email.setBounds(200, 390, 220, 20);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("First Name:");
        panel1.add(jLabel3);
        jLabel3.setBounds(20, 180, 90, 20);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Middle Name:");
        panel1.add(jLabel4);
        jLabel4.setBounds(20, 210, 100, 20);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Last Name:");
        panel1.add(jLabel5);
        jLabel5.setBounds(20, 240, 90, 20);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Gender:");
        panel1.add(jLabel6);
        jLabel6.setBounds(20, 300, 90, 20);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Password:");
        panel1.add(jLabel7);
        jLabel7.setBounds(20, 420, 90, 20);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("City:");
        panel1.add(jLabel8);
        jLabel8.setBounds(20, 330, 90, 20);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Mobile No:");
        panel1.add(jLabel9);
        jLabel9.setBounds(20, 360, 90, 20);

        first_name.setFont(new java.awt.Font("Dialog", 0, 13));
        panel1.add(first_name);
        first_name.setBounds(200, 180, 220, 20);

        middle_name.setFont(new java.awt.Font("Dialog", 0, 13));
        panel1.add(middle_name);
        middle_name.setBounds(200, 210, 220, 20);

        last_name.setFont(new java.awt.Font("Dialog", 0, 13));
        panel1.add(last_name);
        last_name.setBounds(200, 240, 220, 20);

        dob.setFont(new java.awt.Font("Dialog", 0, 13));
        panel1.add(dob);
        dob.setBounds(200, 270, 220, 20);

        city.setFont(new java.awt.Font("Dialog", 0, 13));
        panel1.add(city);
        city.setBounds(200, 330, 220, 20);

        mob.setFont(new java.awt.Font("Dialog", 0, 13));
        panel1.add(mob);
        mob.setBounds(200, 360, 220, 20);

        female.setBackground(new java.awt.Color(192, 205, 250));
        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Dialog", 0, 13));
        female.setText("Female");
        panel1.add(female);
        female.setBounds(300, 300, 80, 20);

        male.setBackground(new java.awt.Color(192, 205, 250));
        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Dialog", 0, 13));
        male.setText("Male");
        panel1.add(male);
        male.setBounds(200, 300, 80, 20);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Email:");
        panel1.add(jLabel10);
        jLabel10.setBounds(20, 390, 90, 20);

        show.setBackground(new java.awt.Color(192, 205, 250));
        show.setFont(new java.awt.Font("Dialog", 1, 13));
        show.setText("Show");
        show.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        panel1.add(show);
        show.setBounds(430, 420, 60, 20);

        save.setFont(new java.awt.Font("Dialog", 1, 14));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        panel1.add(save);
        save.setBounds(220, 460, 70, 27);

        pass.setFont(new java.awt.Font("Tahoma", 1, 14));
        pass.setEchoChar('*');
        panel1.add(pass);
        pass.setBounds(200, 420, 220, 23);

        upload.setFont(new java.awt.Font("Dialog", 1, 13));
        upload.setText("Upload");
        upload.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });
        panel1.add(upload);
        upload.setBounds(270, 100, 80, 30);

        selected.setFont(new java.awt.Font("Dialog", 0, 13));
        panel1.add(selected);
        selected.setBounds(200, 140, 150, 24);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 13));
        jLabel11.setForeground(new java.awt.Color(51, 153, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel1.add(jLabel11);
        jLabel11.setBounds(290, 464, 200, 20);

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

    private void docActionPerformed(java.awt.event.ActionEvent evt) {
        doc document = new doc();
        document.setVisible(true);
        document.setDoc(emailid);
        dispose();
    }

    private void showActionPerformed(java.awt.event.ActionEvent evt) {
        if(show.isSelected())
        {
            Font font1 = new Font("Dialog",Font.PLAIN,13);
            pass.setFont(font1);
            pass.setEchoChar((char)0);
        }
        else
        {
            Font font1 = new Font("Tahoma",Font.BOLD,14);
            pass.setFont(font1);
            pass.setEchoChar('*');
        }
    }

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
                String dbimg;
                if(selected.getText().isEmpty())
                {
                    dbimg = "";
                }
                else dbimg = "profile_pic=?, ";
                PreparedStatement st = (PreparedStatement) con.prepareStatement("Update user_data set first_name=?, middle_name=?, last_name=?, dob=?, gender=?, city=?, " +dbimg+ "password=?, phone_no=? where email_id=?");
                st.setString(1, first_name.getText());
                st.setString(2, middle_name.getText());
                st.setString(3, last_name.getText());
                st.setString(4, dob.getText());
                if(male.isSelected()) st.setString(5,"M");
                else st.setString(5, "F");
                st.setString(6, city.getText());
                if(selected.getText().isEmpty())
                {
                    st.setString(7, pass.getText());
                    st.setString(8, mob.getText());
                    st.setString(9, emailid);
                }
                else
                {
                    File f = new File(filename);
                    InputStream is = new FileInputStream(f);
                    st.setBlob(7, is);
                    st.setString(8, pass.getText());
                    st.setString(9, mob.getText());
                    st.setString(10, emailid);
                }
                int x = st.executeUpdate();
                if(x>0) 
                {
                    jLabel11.setForeground(Color.GREEN);
                    jLabel11.setText("Saved Successfully");
                }
                con.close();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            catch (MysqlDataTruncation e)
            {
                jLabel11.setForeground(Color.red);
                jLabel11.setText("Image size too large. Size<60kb");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
    }

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser choose = new JFileChooser();
        choose.showOpenDialog(null);
        f = choose.getSelectedFile();
        ImageIcon img = new ImageIcon(f.toString());
        Image im = img.getImage();
        Image myimg = im.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newicon = new ImageIcon(myimg);
        jLabel1.setIcon(newicon);
        filename = f.getAbsolutePath();
        selected.setText(f.toString());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edit().setVisible(true);
            }
        });
    }

    public void setedit(String email_id)
    {
        emailid = email_id;
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
                PreparedStatement st = (PreparedStatement) con.prepareStatement("Select* from user_data where email_id=?");
                st.setString(1, email_id);
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
                       first_name.setText(rs.getString("first_name"));
                       middle_name.setText(rs.getString("middle_name"));
                       last_name.setText(rs.getString("last_name"));
                       dob.setText(rs.getString("dob"));
                       if(rs.getString("gender").equals("M")) male.setSelected(true);
                       else female.setSelected(true);
                       city.setText(rs.getString("city"));
                       mob.setText(rs.getString("phone_no"));
                       email.setText(rs.getString("email_id"));
                       pass.setText(rs.getString("password"));
                       if(rs.getString("profile_pic")==null)
                       {
                           ImageIcon img = new ImageIcon("E:\\Fahad\\Sem 3\\Awt Practice\\JavaApplication1\\src\\Images\\Images.png");
                           Image im = img.getImage();
                           Image myimg = im.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                           ImageIcon newicon = new ImageIcon(myimg);
                           jLabel1.setIcon(newicon);
                       }
                       else
                       {
                           photo = rs.getBytes("profile_pic");
                           ImageIcon icon = new ImageIcon(photo);
                           Image img = icon.getImage();
                           Image newimg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                           ImageIcon newIcon = new ImageIcon(newimg);
                           jLabel1.setIcon(newIcon);
                       }       
                }
                con.close();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
    }

    // Variables declaration
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField city;
    private javax.swing.JTextField dob;
    private java.awt.Button doc;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField first_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField last_name;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField middle_name;
    private javax.swing.JTextField mob;
    private java.awt.Panel panel1;
    private javax.swing.JPasswordField pass;
    private java.awt.Button profile;
    private java.awt.Button reminder;
    private javax.swing.JButton save;
    private javax.swing.JTextField selected;
    private javax.swing.JRadioButton show;
    private javax.swing.JButton upload;
    // End of variables declaration

    byte[] photo = null;
    String filename;
    File f;
}
