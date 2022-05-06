import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class Profile extends java.awt.Frame implements Runnable{
    public String email_id;
    
    @Override
    public void run()
    {
        setprof();
    }
    
    public Profile() {
        initComponents();
    }

    private void initComponents() {

        panel1 = new java.awt.Panel();
        update = new java.awt.Button();
        reminder = new java.awt.Button();
        doc = new java.awt.Button();
        label7 = new java.awt.Label();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        labelc5 = new java.awt.Label();
        label6 = new java.awt.Label();
        labelemail = new java.awt.Label();
        labelname = new java.awt.Label();
        labeldob = new java.awt.Label();
        labelg = new java.awt.Label();
        labelbg = new java.awt.Label();
        labelcity = new java.awt.Label();
        labelmob = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setName("Profile");
        setResizable(false);
        setSize(new java.awt.Dimension(514, 537));
        setTitle("Profile");
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
        reminder.setBounds(0, 0, 90, 40);

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
        doc.setBounds(90, 0, 90, 40);

        label7.setAlignment(java.awt.Label.CENTER);
        label7.setFont(new java.awt.Font("Dialog", 1, 14));
        label7.setText("Email:");
        panel1.add(label7);
        label7.setBounds(20, 430, 50, 23);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(192, 205, 250));
        label1.setFont(new java.awt.Font("Dialog", 1, 14));
        label1.setText("Name:");
        panel1.add(label1);
        label1.setBounds(20, 190, 50, 23);

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setBackground(new java.awt.Color(192, 205, 250));
        label2.setFont(new java.awt.Font("Dialog", 1, 14));
        label2.setText("Date Of Birth:");
        panel1.add(label2);
        label2.setBounds(20, 230, 100, 23);

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setBackground(new java.awt.Color(192, 205, 250));
        label3.setFont(new java.awt.Font("Dialog", 1, 14));
        label3.setText("Gender:");
        panel1.add(label3);
        label3.setBounds(20, 270, 60, 23);

        label4.setAlignment(java.awt.Label.CENTER);
        label4.setBackground(new java.awt.Color(192, 205, 250));
        label4.setFont(new java.awt.Font("Dialog", 1, 14));
        label4.setText("Blood Group:");
        panel1.add(label4);
        label4.setBounds(20, 310, 100, 23);

        labelc5.setAlignment(java.awt.Label.CENTER);
        labelc5.setBackground(new java.awt.Color(192, 205, 250));
        labelc5.setFont(new java.awt.Font("Dialog", 1, 14));
        labelc5.setText("City:");
        panel1.add(labelc5);
        labelc5.setBounds(20, 350, 40, 23);

        label6.setAlignment(java.awt.Label.CENTER);
        label6.setBackground(new java.awt.Color(192, 205, 250));
        label6.setFont(new java.awt.Font("Dialog", 1, 14));
        label6.setText("Mobile No:");
        panel1.add(label6);
        label6.setBounds(20, 390, 79, 23);

        labelemail.setFont(new java.awt.Font("Dialog", 0, 14));
        panel1.add(labelemail);
        labelemail.setBounds(190, 430, 270, 23);

        labelname.setBackground(new java.awt.Color(192, 205, 250));
        labelname.setFont(new java.awt.Font("Dialog", 0, 14));
        panel1.add(labelname);
        labelname.setBounds(190, 190, 270, 23);

        labeldob.setBackground(new java.awt.Color(192, 205, 250));
        labeldob.setFont(new java.awt.Font("Dialog", 0, 14));
        panel1.add(labeldob);
        labeldob.setBounds(190, 230, 270, 23);

        labelg.setBackground(new java.awt.Color(192, 205, 250));
        labelg.setFont(new java.awt.Font("Dialog", 0, 14));
        panel1.add(labelg);
        labelg.setBounds(190, 270, 270, 23);

        labelbg.setBackground(new java.awt.Color(192, 205, 250));
        labelbg.setFont(new java.awt.Font("Dialog", 0, 14));
        panel1.add(labelbg);
        labelbg.setBounds(190, 310, 270, 23);

        labelcity.setBackground(new java.awt.Color(192, 205, 250));
        labelcity.setFont(new java.awt.Font("Dialog", 0, 14));
        panel1.add(labelcity);
        labelcity.setBounds(190, 350, 270, 23);

        labelmob.setBackground(new java.awt.Color(192, 205, 250));
        labelmob.setFont(new java.awt.Font("Dialog", 0, 14));
        panel1.add(labelmob);
        labelmob.setBounds(190, 390, 270, 23);

        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 130, 150);

        panel1.add(jPanel1);
        jPanel1.setBounds(360, 10, 130, 150);

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

    private void reminderActionPerformed(java.awt.event.ActionEvent evt) {
        Reminders rem = new Reminders();
        rem.setVisible(true);
        rem.setreminder(email_id);
        dispose();
    }

    private void docActionPerformed(java.awt.event.ActionEvent evt) {
        doc document = new doc();
        document.setVisible(true);
        document.setDoc(email_id);
        dispose();
    }

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {
        edit edit_prof = new edit();
        edit_prof.setVisible(true);
        edit_prof.setedit(email_id);
        dispose();
    }

    public void setprof()
    {
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
                PreparedStatement st = (PreparedStatement) con.prepareStatement("Select* from user_data where email_id=?");
                st.setString(1, email_id);
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
                       labelname.setText(rs.getString("first_name")+" "+rs.getString("middle_name")+" "+rs.getString("last_name"));
                       labeldob.setText(rs.getString("dob"));
                       if(rs.getString("gender").equals("M")) labelg.setText("Male");
                       else labelg.setText("Female");
                       labelbg.setText(rs.getString("blood_group"));
                       labelcity.setText(rs.getString("city"));
                       labelmob.setText(rs.getString("phone_no"));
                       labelemail.setText(rs.getString("email_id"));
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
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }


    // Variables declaration
    private java.awt.Button doc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label labelbg;
    private java.awt.Label labelc5;
    private java.awt.Label labelcity;
    private java.awt.Label labeldob;
    private java.awt.Label labelemail;
    private java.awt.Label labelg;
    private java.awt.Label labelmob;
    private java.awt.Label labelname;
    private java.awt.Panel panel1;
    private java.awt.Button reminder;
    private java.awt.Button update;
    // End of variables declaration
    byte[] photo = null;
}
