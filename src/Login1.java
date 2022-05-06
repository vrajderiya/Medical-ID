import java.awt.Color;
import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login1 extends java.awt.Frame {
    
    public static Thread t2;
    public static Login1 log;
    
    public Login1() {
        initComponents();
    }

    private void initComponents() {
        panel1 = new java.awt.Panel();
        Login = new java.awt.Label();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        email = new java.awt.TextField();
        pass = new java.awt.TextField();
        login = new java.awt.Button();
        signup = new java.awt.Button();
        show = new java.awt.Button();

        setName("Login");
        setResizable(false);
        setTitle("Login");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(192, 205, 250));
        panel1.setName("LogIn");
        panel1.setLayout(null);

        Login.setFont(new java.awt.Font("Dialog", 1, 36));
        Login.setText("Login");
        panel1.add(Login);
        Login.setBounds(190, 20, 100, 60);

        JPanel p1 = new JPanel();
        p1.setBounds(386, 20, 100, 100);
        p1.setLayout(null);
        panel1.add(p1);
       
        JLabel jL = new JLabel();
        jL.setBounds(0, 0, 100, 100);
        ImageIcon icon = new ImageIcon("E:\\Fahad\\Sem 3\\Awt Practice\\JavaApplication1\\src\\Images\\logo.png");
        Image img = icon.getImage();
        Image myimg = img.getScaledInstance(jL.getWidth(), jL.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newicon = new ImageIcon(myimg);
        jL.setIcon(newicon);
        p1.add(jL);
        
        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 1, 14));
        label1.setText("Email");
        panel1.add(label1);
        label1.setBounds(80, 150, 40, 20);

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setFont(new java.awt.Font("Dialog", 1, 14));
        label2.setText("Password");
        panel1.add(label2);
        label2.setBounds(80, 260, 73, 20);

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setFont(new java.awt.Font("Dialog", 0, 14));
        label3.setText("Need an account?");
        panel1.add(label3);
        label3.setBounds(160, 440, 120, 23);

        label4.setAlignment(java.awt.Label.CENTER);
        label4.setForeground(new java.awt.Color(255, 0, 0));
        panel1.add(label4);
        label4.setBounds(130, 410, 230, 20);

        email.setFont(new java.awt.Font("Dialog", 0, 18));
        panel1.add(email);
        email.setBounds(80, 180, 340, 30);

        pass.setEchoChar('*');
        pass.setFont(new java.awt.Font("Dialog", 0, 18));
        panel1.add(pass);
        pass.setBounds(80, 290, 340, 30);

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setFont(new java.awt.Font("Dialog", 1, 18));
        login.setLabel("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        panel1.add(login);
        login.setBounds(180, 360, 130, 40);

        signup.setLabel("Sign Up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        panel1.add(signup);
        signup.setBounds(280, 440, 54, 24);

        show.setFont(new java.awt.Font("Dialog", 1, 12));
        show.setLabel("Show Pass");
        show.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        panel1.add(show);
        show.setBounds(330, 330, 90, 24);

        add(panel1, java.awt.BorderLayout.CENTER);
        setIconImage(img);
        setSize(new java.awt.Dimension(514, 537));
        setLocationRelativeTo(null);
    }

    private void exitForm(java.awt.event.WindowEvent evt) {                          
        System.exit(0);
    }

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {
        SignUp sign = new SignUp();
        sign.setVisible(true); 
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {
        if(email.getText().trim().isEmpty() && pass.getText().trim().isEmpty())
        {
            label4.setText("Fields are Empty");
        }
        else if(email.getText().trim().isEmpty() && !(pass.getText().trim().isEmpty()))
        {
            label4.setText("Email Field is Empty");
        }
        else if(!(email.getText().trim().isEmpty()) && pass.getText().trim().isEmpty())
        {
            label4.setText("Password Field is Empty");
        }
        else
        {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
                PreparedStatement st = (PreparedStatement) con.prepareStatement("Select* from user_data where email_id=?");
                st.setString(1, email.getText().trim());
                ResultSet rs = st.executeQuery();
                if(rs.next())
                {
                    if(pass.getText().trim().equals(rs.getString("password")))
                    {
                        Profile prof = new Profile();
                        prof.setVisible(true);
                        prof.email_id = email.getText().trim();
                        Thread t1 = new Thread(prof);
                        execreminder exec = new execreminder();
                        exec.email_id = email.getText().trim();
                        t2 = new Thread(exec);
                        t1.start();
                        t2.start();
                        dispose();
                    }
                    else label4.setText("Password Incorrect");
                }
                else label4.setText("Email not registered");
                con.close();
            }
            catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }
    }

    private void showActionPerformed(java.awt.event.ActionEvent evt) {
        if( "Show Pass".equals(show.getLabel()))
        {
            pass.setEchoChar((char)0);
            show.setLabel("Hide Pass");
        }
        else
        {
            pass.setEchoChar('*');
            show.setLabel("Show Pass");
        }
    }

    public static void main(String args[]) {
                log = new Login1();
                log.setVisible(true);
            }
    
    // Variables declaration
    private java.awt.Label Login;
    private java.awt.TextField email;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Button login;
    private java.awt.Panel panel1;
    private java.awt.TextField pass;
    private java.awt.Button show;
    private java.awt.Button signup;
    // End of variables declaration

}
