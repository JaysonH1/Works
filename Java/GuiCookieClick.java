
package guifinalgame;
import java.awt.*;
import java.util.EventObject;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.text.DecimalFormat;
/**
 *
 * @author JiaH
 */

class Term extends WindowAdapter //X to close
{
    public void windowClosing(WindowEvent e)   
    {   
        System.exit(0);  
    } 
}

class Mainframe extends JFrame  implements ActionListener
{
      public JLabel label=new JLabel ("Tracking Mouse");
      private JButton button=new JButton();
      private JButton powerup1=new JButton();
      private JButton powerup2=new JButton();
      private static double  clickcount=0;
    double x=.1;
    
    double powercount=0;
    int counter=1;
     JLabel clicktext = new JLabel("Points "+ clickcount);
     Timer timer;
    public Mainframe()
    {
        Toolkit  tk = Toolkit.getDefaultToolkit();  
        Dimension  d = tk.getScreenSize();  
        int  screenWidth = d . width;  
        int  screenHeight = d . height;  
         setSize( 500,700 ); 
        setLocation(screenWidth/6 ,0);
       
        addWindowListener (new Term()); 
        
        Container pane = getContentPane();
       
        JPanel topPanel = new JPanel();
        topPanel.add(Toppanel());
        topPanel.add(clicktext);
         topPanel.add(label);
        pane.add(topPanel, BorderLayout.NORTH);
         
          JPanel clickerpanel = new JPanel(); 
          clickerpanel.add(Button());
          pane.add(clickerpanel, BorderLayout.SOUTH);
     //add(label);
     JPanel poweruppanel=new JPanel();
     
     
     
     
     button.addActionListener(this);
      // powerup1.addActionListener(this);
       // powerup2.addActionListener(this);
        JButton  redButton = new JButton("red"); 
       // add(redButton);
       // poweruppanel.add(redButton, "Center" );
 poweruppanel.add(Powerup());
 //pane.add(poweruppanel,BorderLayout.WEST);
Buttons();
powerup1.addActionListener(this);
powerup2.addActionListener(this);
//repaint();
showpoint();
    }
    
    JComponent Toppanel() 
    {
         JPanel top = new JPanel();
         JLabel header = new JLabel("Welcome to the Clicker Game ");
         top.add(header);
         //add(clicktext);
        return top;
    }
    JComponent Button() 
    {
         ImageIcon circle = new ImageIcon(getClass().getResource("cook.png"));
        button=new JButton(circle);
        button.setMargin(new Insets(0, 0, 0, 0)); 
   button.setBackground( Color.black);//bg color
   //button.setBorder(null);//no boarder
        
   return button;
    }
    
    JComponent Powerup()
    {
        
        ImageIcon two = new ImageIcon(getClass().getResource("circle.png"));
     powerup1=new JButton(two);
     
       // add(powerup1);
        return powerup1;
    }
    
    public void Buttons()
    {
        Container pane = getContentPane();
        JPanel poweruppanel=new JPanel();
      
         powerup1 = new JButton("red"); 
      
       poweruppanel.add(powerup1 );
       //pane.add(poweruppanel,"East");
       powerup2 = new JButton("blue"); 
       poweruppanel.add(powerup2 );
       pane.add(poweruppanel,"Center");
      //  add(redButton);
        /*
        ImageIcon two = new ImageIcon(getClass().getResource("circle.png"));
     powerup1=new JButton(two);
     
       // add(powerup1);
        */
        
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        Object source=evt.getSource();
        JPanel top = new JPanel();
        // JLabel header = new JLabel("Welcome "+ clickcount, JLabel.CENTER);
         //top.add(header);
        if(source==powerup1&&clickcount>10)
        {
            //clickcount-=5;
            x+=100;
           
           label.setText("x is "+ x);
           
          
             clicktext.setText("Points "+ clickcount);
          // repaint();
        }
        if(source==powerup2&&clickcount>10*counter)
        {
            //int counter=1;
            clickcount-=counter*5;
            //counter++;
            x+=.100;
           
              if (counter==1)
              {
                  time();
                 // powercount=1;
              }
              label.setText("x is "+new DecimalFormat("#0.0").format(x));
           // label.setText(new DecimalFormat("#0.00").format(x));
          //  clicktext.setText("Points "+ clickcount);
        //powercount=1;
        counter++;
            /*
 ActionListener action = new ActionListener()
        {   
           
            public void actionPerformed(ActionEvent event)
            {
               
                 
                label.setText("x is "+ x);
                clickcount+=x;
                clicktext.setText("Points "+ clickcount);
            }
          // displayTimer.start();
        //   label.setText("x is "+ x);
            // clicktext.setText("Points "+ clickcount);
          // repaint();
        };timer = new Timer(5000, action);
        timer.setInitialDelay(0);
        timer.start();
         
//timer.stop();
*/
        }
         if(source==button)
        {
           // clickcount=5;
            clickcount+=1;
           // Toppanel() ;
         clicktext.setText("Points "+ new DecimalFormat("#0.0").format(clickcount));
             //clicktext.setText("Points "+ clickcount);
            //showpoint();
            
        }
        
    }
    public void time()
    {
        ActionListener action = new ActionListener()
        {   
           
            public void actionPerformed(ActionEvent event)
            {
               
                 
                //label.setText("x is "+ x);
                clickcount+=x;
               // clicktext.setText("Points "+ clickcount);
            }
          // displayTimer.start();
        //   label.setText("x is "+ x);
            // clicktext.setText("Points "+ clickcount);
          // repaint();
        };timer = new Timer(1000, action);
        timer.setInitialDelay(0);
        timer.start();
    }
        public void showpoint()
    {
        ActionListener action = new ActionListener()
        {   
           
            public void actionPerformed(ActionEvent event)
            {
               
                 
                label.setText("x is "+new DecimalFormat("#0.0").format(x));
                //clickcount+=x;
               clicktext.setText("Points "+ new DecimalFormat("#0.0").format(clickcount));
            }
          // displayTimer.start();
        //   label.setText("x is "+ x);
            // clicktext.setText("Points "+ clickcount);
          // repaint();
        };timer = new Timer(1000, action);
        timer.setInitialDelay(0);
        timer.start();
    }
    
    
    
}
public class Guifinalgame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame output=new Mainframe();
        output.setVisible(true);
        
    }
    
}
