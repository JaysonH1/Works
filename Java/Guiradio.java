
package guiradio;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import java.awt.event.WindowAdapter;

/**
 *
 * @author JiaH
 */

class CheckBoxFrame extends JFrame implements ActionListener 
{    
    private CheckBoxTestPanel panel;    
 public static JRadioButton bill;   
public static JRadioButton credit;
 private JCheckBox express;    
 private JCheckBox warp; 
 public static Font  f1 = new Font ("TimesNewRoman", Font.BOLD, 20); 
private JLabel label = new JLabel ("Payments               Options"); 
private JButton okbutton=new JButton();

private int total;

private int price=0;
private int bxc;
public CheckBoxFrame()  
{   
    setTitle("Jiajun Huang Company");
   setSize(300, 220);  
setLocation(100,100); 

JPanel buttonPanel = new JPanel(new GridLayout(4,1));        
ButtonGroup group = new ButtonGroup();   
 bill = new JRadioButton("Bill Me", true);   
credit = new JRadioButton("Credit", false); 
group.add(bill);
group.add(credit);
buttonPanel.add(bill);
buttonPanel.add(credit);

JPanel panelcheck = new JPanel(new GridLayout(4,1));   
express = new JCheckBox("Express");   
panelcheck.add(express); 
express.addActionListener(this); 
//express.addActionListener(this);
warp = new JCheckBox("Gift Warp"); 
panelcheck.add(warp); 
warp.addActionListener(this);
JPanel okpanel=new JPanel();
okbutton = new JButton("OK"); 
okpanel.add(okbutton);
okbutton.addActionListener(this); 
//warp = new JCheckBox("bbb"); 
//warp.addActionListener(this);
//
//JPanel pan1 = new JPanel();  
//bold = new JCheckBox("Bold"); 
//pan1.add(bold);   
//bold.addActionListener(this); 
//italic = new JCheckBox("Italic");   
//pan1.add(italic);   
//italic.addActionListener(this);   
//getContentPane().add(pan1, "South");  
//buttonPane2.add(panel);



bill.addActionListener(this);   
credit.addActionListener(this);   
//medium.addActionListener(this); 
//getContentPane().add(panel, "Center"); 
//Font  f1 = new Font ("TimesNewRoman", Font.BOLD, 18); 
 label.setFont(f1);
 panel = new CheckBoxTestPanel();  
getContentPane().add(label, BorderLayout.NORTH); 
  getContentPane().add(panel, "Center");
getContentPane().add(buttonPanel, "West");
getContentPane().add(panelcheck, "East");
getContentPane().add(okpanel, "South");
 addWindowListener (new Term()); 
 
 setVisible (true);
 /*
 JFrame frame5 = new JFrame("Hexagon");
 Text panel4 = new Text();
 frame5.getContentPane().add(panel4);
  
frame5.setVisible(true);
 */
}


public void actionPerformed(ActionEvent evt) 
{   
//int m = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0);  
//panel.setFont(m);  
    //int count=0;
Object source = evt.getSource();      
    if(source == credit)         
    {
        
       bxc=1;
    //repaint();
    }
    /*
if (source == express&&exc==0)
{
    f1 = new Font ("TimesNewRoman", Font.BOLD, 20);

total+=5;
exc=1;
label.setText(""+total+"  "+money);
}

*/
//total=money;
       // label.setFont(f1); 
   /*    
if (source == warp&&wac==0)
{  total+=4;
    wac=1;
label.setText(""+total+"  "+money);
}
*/
total = (express.isSelected() ? 4 : 0)  + (warp.isSelected() ? 5 : 0);  

//label.setText(""+total+"  "+bxc);
if(source == okbutton)  
{
    price+=total+28;
    /*
    JFrame frame5 = new JFrame("Hexagon");
 Text panel4 = new Text();
 frame5.getContentPane().add(panel4);
 frame5.setSize(100,222);
  frame5.setLocation(0,0);
frame5.setVisible(true);
    */
    //price+=total
    //total+=20;
  //  total+=15;
    dispose();
    createFrame() ;
    //setVisible(false);
    //dispose();
}



}


public void createFrame() 
{   

    JFrame frame = new JFrame("Jiajun Huang Company");
JPanel panel = new JPanel();
f1 = new Font ("TimesNewRoman", Font.BOLD, 12); 
label.setFont(f1);
JPanel panellabel = new JPanel(new GridLayout(10,1));
JPanel panelcredit = new JPanel();
JPanel okbutton = new JPanel();
frame.setSize(400,300);
Box b = Box.createVerticalBox();  

b.add(new JLabel("Name  "));      
b.add(new JTextField(10));     
b. add(Box.createVerticalStrut(20)); 
b.add(new JLabel("Address"));     
b.add(new JTextField(2));     
b.add(new JLabel("City"));     
b.add(new JTextField(2)); 
b.add(new JLabel("Zip"));   
b.add(new JTextField(2)); 

Box c = Box.createVerticalBox();  

c.add(new JLabel("Credit Card # "));      
c.add(new JTextField(10));     
c. add(Box.createVerticalStrut(20)); 
c.add(new JLabel("Pin# "));      
c.add(new JTextField(10));

 JButton ok=new JButton("Confirm");
panel.add(b);
panelcredit.add(c);
label.setText("Price: $20"+" Shipping "+"$8"+" MISC $"+total+" Total=$"+ price);

panellabel.add(label);
//panel.add(label);
frame.getContentPane().add( panel,"West");
if (bxc==1)
{
    frame.setSize(510,300);
    frame.getContentPane().add( panelcredit,"Center");
}
okbutton.add(ok);

frame.getContentPane().add( panellabel,"East");
frame.getContentPane().add( okbutton,"South");
frame.setVisible(true);
//addWindowListener (new Term()); 
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}

}
class CheckBoxTestPanel extends JPanel  
{    
   
  public CheckBoxTestPanel()
  {}

public void paintComponent(Graphics g)   
{     
    super.paintComponent(g);     
    Font  f1 = new Font ("TimesNewRoman", Font.BOLD, 20); 
    g.setFont(f1);
    g.drawLine (70,0,70,70);    
     
}  

}



class Term extends WindowAdapter //X to close
{
    public void windowClosing(WindowEvent e)   
    {   
        System.exit(0);  
    } 
}



public class Guiradio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         JFrame frame = new CheckBoxFrame();    
         //frame.setVisible (true);
    }
    
}
