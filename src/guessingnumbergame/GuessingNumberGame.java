
package guessingnumbergame;

//package guessingnumbergame;

/**
 *
 * @author Rawan
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 
public class GuessingNumberGame {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPasswordField firstPassword;
   int password=0;
   int rounds=0;
   


   public GuessingNumberGame(){
      prepareGUI();
   }
   public static void main(String[] args){
      GuessingNumberGame  swingControlDemo = new GuessingNumberGame();      
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Guessing Number Game - Rawan");
      mainFrame.setSize(400,600);
      mainFrame.setLayout(new GridLayout(5, 1));
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });   
      
      firstPassword = new JPasswordField("",JPasswordField.CENTER);
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      
 
      mainFrame.add(headerLabel);
      mainFrame.add(firstPassword);
      
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
      
      headerLabel.setText("User 1: Enter your password"); 

      //resources folder should be inside SWING folder.
      JButton okButton = new JButton("OK");        
      JButton javaButton = new JButton("Submit");
      JButton cancelButton = new JButton("Cancel");
      cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);   

      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           
            if(password==0)
            {
                password=Integer.parseInt(String.valueOf(firstPassword.getPassword()));
                headerLabel.setText("User 2: Guess what's User1's password");
                
                firstPassword.setText("");
                statusLabel.setText("");
            }
            else
            {
                rounds=rounds+1;
                
                statusLabel.setText(String.valueOf(firstPassword.getPassword()));
                if(Integer.parseInt(String.valueOf(firstPassword.getPassword()))==password)
                {
                  statusLabel.setText("You Win");
                  headerLabel.setText("User 1: Enter your password"); 
                  firstPassword.setText("");
                  password=0;
                  rounds=0;
                }
                else if(Integer.parseInt(String.valueOf(firstPassword.getPassword()))>password)
                {
                  statusLabel.setText("The secret number is smaller!");   
                  firstPassword.setText("");
                  gameover(rounds);
                }
                else if(Integer.parseInt(String.valueOf(firstPassword.getPassword()))<password)
                {
                  statusLabel.setText("The secret number is bigger!");   
                  firstPassword.setText("");
                  gameover(rounds);
                }
            }
         }          
      });

      controlPanel.add(okButton);    
      mainFrame.setVisible(true); 
   }
    
   private void gameover(int x){
       if(rounds==6)
       {
           headerLabel.setText("User 1: Enter your password"); 
           statusLabel.setText("User 1 Won");
           firstPassword.setText("");
           password=0;
           rounds=0;
       }
   }
}
