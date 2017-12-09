import java.awt.GridLayout;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sudesh
 */
public class jpanel2 extends javax.swing.JPanel {

    /**
     * Creates new form jpanel2
     */
    public jpanel2() {
        initComponents();
              CurrentDate();
    }
public void CurrentDate(){
         
        Thread clock = new Thread(){
        public void run(){
        for(;;){
        Calendar cal = new GregorianCalendar();
        String monthh = null;
        String dayy = null;
        int month =cal.get(Calendar.MONTH)+1;
        int year =cal.get(Calendar.YEAR);
        int day =cal.get(Calendar.DAY_OF_MONTH);
          if ((month) < 10)
        {
            monthh= "0" + month;
        }
          else 
          {
              monthh=""+month;
          }
          if (day < 10)
        {
            dayy= "0" + day;
        }
          else
              
          {
              dayy=""+day;
          }
        date_txt1.setText(year+"-"+monthh+"-"+dayy);
        int second =cal.get(Calendar.SECOND);
        int minute =cal.get(Calendar.MINUTE);
        int hour =cal.get(Calendar.HOUR);
        String houur = null;
        String minuute = null;
        String seconnd = null;
        
        if (hour < 10)
        {
            houur= "0" + hour;
        }
        else
        {
            houur=""+hour;
        }
         if (minute < 10)
        {
            minuute= "0" + minute;
        }
         else
         {
             minuute=""+minute;
         }
          if (second < 10)
        {
            seconnd= "0" + second;
        }
         else
          {
              seconnd =""+second;
          }
        time_txt1 .setText(houur+":"+minuute+":"+seconnd);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(login_jframe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }      
        
        
        };
        clock.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        panel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        date_txt1 = new javax.swing.JLabel();
        time_txt1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        time_txt = new javax.swing.JLabel();
        date_txt = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setMaximumSize(new java.awt.Dimension(980, 600));
        setMinimumSize(new java.awt.Dimension(980, 600));
        setLayout(null);

        panel.setMaximumSize(new java.awt.Dimension(980, 600));
        panel.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic1.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel.add(jButton1);
        jButton1.setBounds(110, 220, 228, 97);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic2.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel.add(jButton2);
        jButton2.setBounds(380, 220, 228, 97);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic3.jpg"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel.add(jButton3);
        jButton3.setBounds(650, 220, 228, 97);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patient");
        panel.add(jLabel2);
        jLabel2.setBounds(440, 10, 90, 30);

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backbutton2.jpg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel.add(jButton4);
        jButton4.setBounds(10, 10, 80, 27);

        date_txt1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        date_txt1.setForeground(new java.awt.Color(255, 255, 255));
        date_txt1.setText("Date");
        panel.add(date_txt1);
        date_txt1.setBounds(900, 20, 80, 20);

        time_txt1.setBackground(new java.awt.Color(255, 255, 255));
        time_txt1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        time_txt1.setForeground(new java.awt.Color(255, 255, 255));
        time_txt1.setText("Time");
        time_txt1.setRequestFocusEnabled(false);
        panel.add(time_txt1);
        time_txt1.setBounds(900, 0, 80, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        panel.add(jLabel1);
        jLabel1.setBounds(0, 0, 980, 600);

        add(panel);
        panel.setBounds(0, 0, 980, 600);

        time_txt.setBackground(new java.awt.Color(255, 255, 255));
        time_txt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        time_txt.setForeground(new java.awt.Color(255, 255, 255));
        time_txt.setText("Time");
        time_txt.setRequestFocusEnabled(false);
        add(time_txt);
        time_txt.setBounds(890, 10, 80, 20);

        date_txt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        date_txt.setForeground(new java.awt.Color(255, 255, 255));
        date_txt.setText("Date");
        add(date_txt);
        date_txt.setBounds(890, 30, 80, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     panel.removeAll();
     panel.setLayout(new GridLayout(1,2));
     panel.add(new outpatient_jpanel());
     panel.updateUI();    // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 panel.removeAll();
 panel.setLayout(new GridLayout(1,2));
 panel.add(new jpanel1());
 panel.updateUI();

        
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 panel.removeAll();
 panel.setLayout(new GridLayout(1,2));
 panel.add(new inpatient_jpanel());
 panel.updateUI();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      panel.removeAll();
      panel.setLayout(new GridLayout(1,2));
      panel.add(new viewpatient_jpanel());
      panel.updateUI();  
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date_txt;
    private javax.swing.JLabel date_txt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel time_txt;
    private javax.swing.JLabel time_txt1;
    // End of variables declaration//GEN-END:variables

   
}