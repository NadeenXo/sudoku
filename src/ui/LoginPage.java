/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logic.*;

/**
 *
 * @author Radwa
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
        setTitle("SUDOKU");
        ImageIcon image = new ImageIcon("C:\\Users\\nadee\\Desktop\\TheBigProject\\src\\com\\SProject\\logo.png");
        this.setIconImage(image.getImage()); //change icon of frame
    }

    // start  validation method ______________________
    public static User user;
    private String email;
    private String password;

    public void validation() {
        email = mail.getText();
        password = pass.getText();

        user = Information.check(email, password);

        if (email.equals("") && password.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter email and password");
        } else if (!password.equals("") && email.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter  email ");
        } else if (!email.equals("") && password.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter password ");
        } else {

            if (password.length() < 8) {
                JOptionPane.showMessageDialog(this, "password length must have at least 8 character !!");

            } else {
                if (user == null) {
                    JOptionPane.showMessageDialog(this, "User does not exist");
                } else {
                    JOptionPane.showMessageDialog(this, "Welcome");
                    HomePage h = new HomePage(user);
                    h.setVisible(true);
                    h.pack();

                    setVisible(false);
                    pack();

                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        sign_in = new javax.swing.JButton();
        sign_up = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(74, 89, 126));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign In ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 220, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 130, 60));

        mail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 310, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Password ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 140, 70));

        pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 310, 30));

        sign_in.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sign_in.setForeground(new java.awt.Color(55, 75, 133));
        sign_in.setText("sign in ");
        sign_in.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sign_inMouseClicked(evt);
            }
        });
        sign_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_inActionPerformed(evt);
            }
        });
        jPanel1.add(sign_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 170, 60));

        sign_up.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sign_up.setForeground(new java.awt.Color(255, 255, 255));
        sign_up.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sign_up.setText("No account? << Sign Up >>");
        sign_up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sign_upMouseClicked(evt);
            }
        });
        jPanel1.add(sign_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 290, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 600, 520));

        setSize(new java.awt.Dimension(670, 635));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sign_inMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sign_inMouseClicked

        validation();


    }//GEN-LAST:event_sign_inMouseClicked

    private void sign_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_inActionPerformed
        // TODO add your handling code here:
        /* if (evt.getSource()== sign_in && user != null){
            HomePage h = new HomePage();
        }*/

    }//GEN-LAST:event_sign_inActionPerformed

    private void sign_upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sign_upMouseClicked
        // TODO add your handling code here:
        SignupPage su = new SignupPage();
        su.setVisible(true);
        su.pack();
        dispose();


    }//GEN-LAST:event_sign_upMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mail;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton sign_in;
    private javax.swing.JLabel sign_up;
    // End of variables declaration//GEN-END:variables
}
