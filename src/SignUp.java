import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

public class SignUp extends java.awt.Frame {


    public SignUp() {
        initComponents();
    }

    private void initComponents() {

        panel1 = new java.awt.Panel();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        label10 = new java.awt.Label();
        label12 = new java.awt.Label();
        label13 = new java.awt.Label();
        first_name = new java.awt.TextField();
        middle_name = new java.awt.TextField();
        last_name = new java.awt.TextField();
        dob = new java.awt.TextField();
        CheckboxGroup cbg = new CheckboxGroup();
        male = new java.awt.Checkbox("Male",cbg,false);
        female = new java.awt.Checkbox("Female",cbg,false);
        blood_group = new java.awt.Choice();
        city = new java.awt.TextField();
        mob_no = new java.awt.TextField();
        mail = new java.awt.TextField();
        password = new java.awt.TextField();
        sign = new java.awt.Button();
        label1 = new java.awt.Label();
        label11 = new java.awt.Label();
        hide = new java.awt.Button();

        setName("SignUp");
        setResizable(false);
        setTitle("SignUp");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(192, 205, 250));
        panel1.setLayout(null);

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setFont(new java.awt.Font("Dialog", 1, 36));
        label2.setText("SignUp");
        panel1.add(label2);
        label2.setBounds(230, 0, 130, 70);

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setFont(new java.awt.Font("Dialog", 1, 13));
        label3.setText("Middle Name");
        panel1.add(label3);
        label3.setBounds(90, 170, 82, 20);

        label4.setAlignment(java.awt.Label.CENTER);
        label4.setFont(new java.awt.Font("Dialog", 1, 13));
        label4.setText("First Name");
        panel1.add(label4);
        label4.setBounds(90, 130, 70, 20);

        label5.setAlignment(java.awt.Label.CENTER);
        label5.setFont(new java.awt.Font("Dialog", 1, 13));
        label5.setText("Last Name");
        panel1.add(label5);
        label5.setBounds(90, 210, 70, 22);

        label6.setAlignment(java.awt.Label.CENTER);
        label6.setFont(new java.awt.Font("Dialog", 1, 13));
        label6.setText("DOB (YYYY-MM-DD)");
        panel1.add(label6);
        label6.setBounds(90, 250, 120, 20);

        label7.setAlignment(java.awt.Label.CENTER);
        label7.setFont(new java.awt.Font("Dialog", 1, 13));
        label7.setText("Gender");
        panel1.add(label7);
        label7.setBounds(90, 290, 50, 20);

        label8.setAlignment(java.awt.Label.CENTER);
        label8.setFont(new java.awt.Font("Dialog", 1, 13));
        label8.setText("Blood Group");
        panel1.add(label8);
        label8.setBounds(90, 330, 82, 22);

        label9.setAlignment(java.awt.Label.CENTER);
        label9.setFont(new java.awt.Font("Dialog", 1, 13));
        label9.setText("City");
        panel1.add(label9);
        label9.setBounds(90, 370, 30, 22);

        label10.setAlignment(java.awt.Label.CENTER);
        label10.setFont(new java.awt.Font("Dialog", 1, 13));
        label10.setText("Mobile Number");
        panel1.add(label10);
        label10.setBounds(90, 410, 100, 22);

        label12.setAlignment(java.awt.Label.CENTER);
        label12.setFont(new java.awt.Font("Dialog", 1, 13));
        label12.setText("Email");
        panel1.add(label12);
        label12.setBounds(90, 450, 38, 22);

        label13.setAlignment(java.awt.Label.CENTER);
        label13.setFont(new java.awt.Font("Dialog", 1, 13));
        label13.setText("Password");
        panel1.add(label13);
        label13.setBounds(90, 490, 60, 22);
        panel1.add(first_name);
        first_name.setBounds(310, 130, 190, 20);
        panel1.add(middle_name);
        middle_name.setBounds(310, 170, 190, 20);
        panel1.add(last_name);
        last_name.setBounds(310, 210, 190, 20);
        panel1.add(dob);
        dob.setBounds(310, 250, 190, 20);

        male.setFont(new java.awt.Font("Dialog", 1, 13));
        male.setLabel("Male");
        panel1.add(male);
        male.setBounds(310, 290, 50, 22);

        female.setFont(new java.awt.Font("Dialog", 1, 13));
        female.setLabel("Female");
        panel1.add(female);
        female.setBounds(400, 290, 70, 22);

        blood_group.add("");
        blood_group.add("O+");
        blood_group.add("O-");
        blood_group.add("A+");
        blood_group.add("A-");
        blood_group.add("B+");
        blood_group.add("B-");
        blood_group.add("AB+");
        blood_group.add("AB-");
        panel1.add(blood_group);
        blood_group.setBounds(310, 330, 70, 20);
        panel1.add(city);
        city.setBounds(310, 370, 190, 20);

        mob_no.setColumns(10);
        panel1.add(mob_no);
        mob_no.setBounds(310, 410, 190, 20);
        panel1.add(mail);
        mail.setBounds(310, 450, 190, 20);

        password.setEchoChar('*');
        password.setFont(new java.awt.Font("Dialog", 1, 14));
        panel1.add(password);
        password.setBounds(310, 490, 190, 23);

        sign.setFont(new java.awt.Font("Dialog", 1, 24));
        sign.setLabel("SignUp");
        sign.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signActionPerformed(evt);
            }
        });
        panel1.add(sign);
        sign.setBounds(240, 550, 130, 40);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 1, 12));
        label1.setText("All Fields are necessary");
        panel1.add(label1);
        label1.setBounds(210, 80, 170, 20);

        label11.setAlignment(java.awt.Label.CENTER);
        label11.setForeground(new java.awt.Color(255, 0, 0));
        panel1.add(label11);
        label11.setBounds(210, 600, 190, 20);

        hide.setFont(new java.awt.Font("Dialog", 1, 12));
        hide.setLabel("Unhide");
        hide.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideActionPerformed(evt);
            }
        });
        panel1.add(hide);
        hide.setBounds(520, 490, 57, 24);

        add(panel1, java.awt.BorderLayout.CENTER);
        
        ImageIcon icon = new ImageIcon("E:\\Fahad\\Sem 3\\Awt Practice\\JavaApplication1\\src\\Images\\logo.png");
        Image img = icon.getImage();
        setIconImage(img);
        setSize(new java.awt.Dimension(614, 664));
        setLocationRelativeTo(null);
    }                       

    private void exitForm(java.awt.event.WindowEvent evt) {
        dispose();
    }

    private void signActionPerformed(java.awt.event.ActionEvent evt) {
        if( first_name.getText().trim().isEmpty() || last_name.getText().trim().isEmpty() || middle_name.getText().trim().isEmpty() || dob.getText().trim().isEmpty() || (male.getState() && female.getState()) || blood_group.getSelectedItem()=="" || city.getText().trim().isEmpty() || mob_no.getText().trim().isEmpty() || mail.getText().trim().isEmpty() || password.getText().trim().isEmpty())
        {
            label11.setText("Field(s) are Empty");
        }
        else
        {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
                Statement s = con.createStatement();
                PreparedStatement st = (PreparedStatement) con.prepareStatement("Select* from user_data where email_id=?");
                st.setString(1, mail.getText());
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    label11.setText("Email already registered");
                }
                else
                {
                    char gender;
                    if(male.getState()) gender='M';
                    else gender = 'F';
                    String query ="INSERT INTO user_data (email_id,phone_no,password,first_name,middle_name,last_name,dob,gender,blood_group,city) VALUES ('"+mail.getText().trim()+"','"+mob_no.getText().trim()+"','"+password.getText().trim()+"','"+first_name.getText().trim()+"','"+middle_name.getText().trim()+"','"+last_name.getText()+"','"+dob.getText().trim()+"','"+gender+"','"+blood_group.getSelectedItem()+"','"+city.getText().trim()+"')";
                    int x = s.executeUpdate(query);
                    if(x==0) label11.setText("Email Already Exist");
                    con.close();
                    dispose();
                }
            }
            catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }    
        }
    }

    private void hideActionPerformed(java.awt.event.ActionEvent evt) {
        if("Unhide".equals(hide.getLabel()))
        {
            password.setEchoChar((char)0);
            Font font1 = new Font("Dialog",Font.PLAIN,12);
            password.setFont(font1);
            hide.setLabel("Hide");
        }
        else {
            password.setEchoChar('*');
            Font font2 = new Font("Dialog", Font.BOLD, 14);
            password.setFont(font2);
            hide.setLabel("Unhide");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }


    // Variables declaration
    private java.awt.Choice blood_group;
    private java.awt.TextField city;
    private java.awt.TextField dob;
    private java.awt.Checkbox female;
    private java.awt.TextField first_name;
    private java.awt.Button hide;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.TextField last_name;
    private java.awt.TextField mail;
    private java.awt.Checkbox male;
    private java.awt.TextField middle_name;
    private java.awt.TextField mob_no;
    private java.awt.Panel panel1;
    private java.awt.TextField password;
    private java.awt.Button sign;
    // End of variables declaration
}
