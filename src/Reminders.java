
import java.awt.Image;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;
import javax.swing.ImageIcon;


public class Reminders extends java.awt.Frame {

    public Reminders() {
        initComponents();
    }
    private String emailid;

    private void initComponents() {

        panel1 = new java.awt.Panel();
        update = new java.awt.Button();
        profile = new java.awt.Button();
        doc = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasktable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timetxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        task = new javax.swing.JTextArea();
        schedule = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setName("Reminders");
        setResizable(false);
        setTitle("Reminders");
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

        tasktable.setFont(new java.awt.Font("Dialog", 0, 13));
        tasktable.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {"Time", "Mediciine"}) {
            Class[] types = new Class [] {java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean [] {false, false};
            @Override
            public Class getColumnClass(int columnIndex) {return types [columnIndex];}
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        jScrollPane1.setViewportView(tasktable);

        panel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 460, 160);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Schedulde New Reminder");
        panel1.add(jLabel1);
        jLabel1.setBounds(160, 260, 190, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Medicine");
        panel1.add(jLabel2);
        jLabel2.setBounds(290, 310, 130, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Time (hh:mm 24H)");
        panel1.add(jLabel4);
        jLabel4.setBounds(70, 310, 160, 30);

        timetxt.setFont(new java.awt.Font("Dialog", 1, 15));
        timetxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel1.add(timetxt);
        timetxt.setBounds(80, 350, 140, 30);

        task.setColumns(20);
        task.setFont(new java.awt.Font("Dialog", 1, 15));
        task.setLineWrap(true);
        task.setRows(5);
        task.setWrapStyleWord(true);
        jScrollPane2.setViewportView(task);

        panel1.add(jScrollPane2);
        jScrollPane2.setBounds(280, 350, 170, 110);

        schedule.setFont(new java.awt.Font("Dialog", 1, 14));
        schedule.setText("Schedulde");
        schedule.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleActionPerformed(evt);
            }
        });
        panel1.add(schedule);
        schedule.setBounds(90, 410, 110, 40);

        delete.setFont(new java.awt.Font("Dialog", 1, 13));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        panel1.add(delete);
        delete.setBounds(410, 240, 73, 23);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 13));
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("(Select the row to delete)");
        panel1.add(jLabel3);
        jLabel3.setBounds(270, 240, 140, 20);

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

    private void docActionPerformed(java.awt.event.ActionEvent evt) {
        doc document = new doc();
        document.setVisible(true);
        document.setDoc(emailid);
        dispose();
    }

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {
        edit edit_prof = new edit();
        edit_prof.setVisible(true);
        edit_prof.setedit(emailid);
        dispose();
    }

    private void scheduleActionPerformed(java.awt.event.ActionEvent evt) {
        try
        {    
            SortedMap<String,String> st = new TreeMap<String,String>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
            String query="";
            DefaultTableModel model = (DefaultTableModel) tasktable.getModel();
            if(model.getRowCount()==0)
            {
                String[] row = new String[2];
                row[0] = timetxt.getText();
                row[1] = task.getText();
                model.addRow(row);
                query = query+timetxt.getText()+"-"+task.getText()+";" ;
            }
            else
            {
                for(int i=0; i<model.getRowCount(); i++)
                {
                    String timet = model.getValueAt(i, 0).toString();
                    String medt = model.getValueAt(i, 1).toString();
                    st.put(timet, medt);
                }
                int row_count=model.getRowCount();
                for(int i=0;i<row_count; i++)
                {
                    model.removeRow(0);
                }
                st.put(timetxt.getText(), task.getText());
                Set s = st.entrySet();
                Iterator i = s.iterator();
                while(i.hasNext())
                {
                    Map.Entry m = (Map.Entry)i.next();
                    String key = (String)m.getKey();
                    String value = (String)m.getValue();
                    String[] row = new String[2];
                    row[0] = key;
                    row[1] = value;
                    model.addRow(row);
                    query = query+key+"-"+value+";" ;
                }          
            }
            PreparedStatement stat = (PreparedStatement) con.prepareStatement("Update user_data set reminders=? where email_id=?");
            stat.setString(1, query);
            stat.setString(2, emailid);
            stat.executeUpdate();
            Login1.t2.interrupt();
            execreminder exec = new execreminder();
            exec.email_id = emailid;
            Login1.t2 = new Thread(exec);
            Login1.t2.start();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        try
        {
            DefaultTableModel model = (DefaultTableModel) tasktable.getModel();
            int[] rows = tasktable.getSelectedRows();
            for(int i=0; i<rows.length; i++)
            {
                model.removeRow(rows[i]-i);
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
            String query="";
            for(int i=0; i<model.getRowCount(); i++)
            {
                String timet = model.getValueAt(i, 0).toString();
                String medt = model.getValueAt(i, 1).toString();
                query = query+timet+"-"+medt+";";
            }
            PreparedStatement stat = (PreparedStatement) con.prepareStatement("Update user_data set reminders=? where email_id=?");
            stat.setString(1, query);
            stat.setString(2, emailid);
            stat.executeUpdate();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
        }
        
    }
    
    public void setreminder(String email_id)
    {
        emailid = email_id;
        String rem="";
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
                PreparedStatement st = (PreparedStatement) con.prepareStatement("Select* from user_data where email_id=?");
                st.setString(1, email_id);
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
                    rem = rs.getString("reminders");
                }    
                con.close();
                String rem_time="";
                String med="";
                if(rem==null){}
                else
                {
                    int i,j;
                    boolean condition=false;
                    for(i=0;i<rem.length(); i++)
                    {
                        for(j=i; i<rem.length();j++)
                        {
                            if(rem.charAt(j)=='-')
                            {
                                rem_time = rem.substring(i,j);
                                break;
                            }
                            if(rem.charAt(j)==';')
                            {
                                med = rem.substring(i, j);
                                condition=true;
                                break;
                            }
                        }
                        if(condition)
                        {
                            DefaultTableModel model = (DefaultTableModel) tasktable.getModel();
                            String[] row = new String[2];
                            row[0] = rem_time;
                            row[1] = med;
                            model.addRow(row);
                        }
                        i=j;
                        condition=false;
                    }
                }
            }
            catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reminders().setVisible(true);
            }
        });
    }


    // Variables declaration
    private javax.swing.JButton delete;
    private java.awt.Button doc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel panel1;
    private java.awt.Button profile;
    private javax.swing.JButton schedule;
    private javax.swing.JTextArea task;
    private javax.swing.JTable tasktable;
    private javax.swing.JTextField timetxt;
    private java.awt.Button update;
    // End of variables declaration
}
