/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiform;

import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Matthew Kogo 
 */
public class myForm extends JFrame implements ActionListener {
    // declare controls 
    JLabel lblFirstNum,lblsecNum,lblResult;
    JTextField txtFirstNum,txtSecNum,txtResult;
    JButton btnAdd,btnClear,btnExit;
    JPanel panel1;
    TitledBorder border;
   
    // constructor - it creates the UI
    myForm(){       
        // create Jframe and adjust properties
        JFrame frame = new JFrame();
        Font myFont = new Font("Times New Roman",Font.PLAIN,12);
        frame.setFont(myFont);
        
        lblFirstNum = new JLabel("First Number :"); 
        lblFirstNum.setFont(myFont);        
        
        lblsecNum = new JLabel("Second Number:" );
        lblsecNum.setFont(myFont);
        
        lblResult = new JLabel("Results:" ); 
        lblResult.setFont(myFont);
         
        
        txtFirstNum = new JTextField();
        txtSecNum = new JTextField();
        txtResult = new JTextField();
        
        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit"); 
        
        // set position of each control x,y, and width and height
        
        lblFirstNum.setBounds(35,30,200,30);
        lblsecNum.setBounds(20,70,200,30);
        lblResult.setBounds(65,120,200,30);
        
        txtFirstNum.setBounds(120,30,250,30);
        txtSecNum.setBounds(120,70,250,30);
        txtResult.setBounds(120,120,250,30);
        
        
        btnAdd.setBounds(120,155,80,25);
        btnClear.setBounds(210,155,80,25);
        btnExit.setBounds(335,220,80,25);
       
        // set bg color for buttons
        btnAdd.setOpaque(true);
        btnAdd.setBackground(Color.WHITE);
        
        
        btnClear.setOpaque(true);
        btnClear.setBackground(Color.WHITE);
        
        btnExit.setOpaque(true);
        btnExit.setBackground(Color.WHITE);
        
        // change cursor for buttons on hover event
        
        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // event listeners for buttons using lambda exp
        
        btnAdd.addActionListener((ActionEvent e) -> {
            String first =  txtFirstNum.getText(); 
            String second =  txtSecNum.getText(); 
            
            double firstnum = 0;
            double secnum = 0;
            double result;
            
            try {
                 Double.parseDouble(first) ;   
                 firstnum = Double.parseDouble(first);
                 Integer.parseInt(second) ; 
                 secnum =  Double.parseDouble(second);
            } catch(Exception ex){
                // show alert if either of the textfields is not a number, then stop execution
                JOptionPane.showMessageDialog(null, "Please Enter Numeric Characters Only","Error!",JOptionPane.ERROR_MESSAGE);
                return;
            }             
             // add the two numbers
             result = firstnum  + secnum;   
             
             // assign value of addition to result textfield 
             txtResult.setText(String.valueOf(result));
            
        });
         // clear textfields
         btnClear.addActionListener((ActionEvent e) -> {
            txtFirstNum.setText("");
            txtSecNum.setText("");
            txtResult.setText("");
             
        });
         // exit on click 
         btnExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
         
        // create border component for re-use
        border = new TitledBorder("Number Addition");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.BLUE);
        border.setTitleFont(myFont);
        panel1 = new JPanel();
        panel1.setBorder(border);
        
        panel1.setSize(400,190);
        panel1.setBounds(20,20,400,190);
        panel1.setLayout(null);
        
        // add these controls to panel
        panel1.add(lblFirstNum);
        panel1.add(lblsecNum);
        panel1.add(lblResult);
       
        panel1.add(txtFirstNum);
        panel1.add(txtSecNum);
        panel1.add(txtResult);
        
        panel1.add(btnAdd);
        panel1.add(btnClear);       
        
        // create color for re-use using RGB ratio 
        Color c = new Color(236,233,216);
        
        // add panel and exit button on frame
        frame.add(panel1);
        frame.add(btnExit); 
        
        frame.setSize(450,260);
        
        // change background of JFrame and JPANEL
        frame.getContentPane().setBackground(c);
        panel1.setBackground(c);
        
        frame.setLayout(null);
        
        // remove action bar
        frame.setUndecorated(true);        
        
        // create new color for border 
        Color cb = new Color(222,224,252);
        
        // set border for Jframe
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(5,5, 5, 5, cb));       
        
        
        // set on close event action - exit when closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // try to  Set UI to current settings
        try {            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
              
        }  
        // ensure it appears at centre of screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
 
}
