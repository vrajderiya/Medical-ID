import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class execreminder extends javax.swing.JFrame implements Runnable {
    public String email_id;
    private boolean interrupt = false;
    @Override
    public void run()
    {
        exec();
    }

    public void exec()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root@123");
            PreparedStatement st = (PreparedStatement) con.prepareStatement("Select* from user_data where email_id=?");
            st.setString(1,email_id);
            ResultSet rs = st.executeQuery();
            String rem = null;
            if(rs.next())
            {
                rem = rs.getString("reminders");
            }
            con.close();
            if(rem == null){ return;}
            ArrayList<String> time = new ArrayList<String>();
            ArrayList<String> med = new ArrayList<String>();
            for(int i=0; i<rem.length(); i++)
            {
                int j;
                for(j=i; j<rem.length(); j++)
                {
                    if(rem.charAt(j)=='-')
                    {
                        time.add(rem.substring(i,j));
                        break;
                    }
                    if(rem.charAt(j)==';')
                    {
                        med.add(rem.substring(i,j));
                        break;
                    }
                }
                i=j;
            }
            SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");
            String  current_date = timeformat.format(Calendar.getInstance().getTime());
            outer:
            for(int i=0; i<time.size();i++)
            {
                if(current_date.compareTo(time.get(i)) > 0)
                {
                }
                else
                {
                    while(current_date.compareTo(time.get(i)) < 0)
                    {
                        if(Thread.interrupted() || interrupt){
                            break outer;
                        }
                        Thread.sleep(1000);
                        current_date = timeformat.format(Calendar.getInstance().getTime());
                    }
                    String msg = time.get(i)+": "+med.get(i);
                    JOptionPane.showMessageDialog(this,msg);
                }
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
                e.printStackTrace();
        } catch (InterruptedException ex) {
            interrupt = true;
        }
        
    }
    
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new execreminder().setVisible(true);
//            }
//        });
//    }
    
}
