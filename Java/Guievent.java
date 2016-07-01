
package guievent;
import java.awt.*;
import java.util.EventObject;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author JiaH
 */



    class ButtonPanel extends JPanel  implements ActionListener 
    {
    private JButton yellowButton;  
    private JButton blueButton;  
    private JButton redButton;
    private JButton buttoncircle;
    private JButton buttonline;
    private JButton buttonrect;
    private int screenHeight;
    private JButton buttonhex;
    private int  screenWidth;
        public ButtonPanel()
        {
            Toolkit  tk = Toolkit.getDefaultToolkit();  
        Dimension  d = tk.getScreenSize();  
         screenWidth = d . width;  
          screenHeight = d . height;  
            ImageIcon circle = new ImageIcon(getClass().getResource("circle.png"));
             //JButton
             buttoncircle = new JButton(circle);
            add(buttoncircle);
            ImageIcon line = new ImageIcon(getClass().getResource("line.png"));
             buttonline = new JButton(line);
            add(buttonline);
            ImageIcon rect = new ImageIcon(getClass().getResource("rect.png"));
              buttonrect = new JButton(rect);
            add(buttonrect);
            ImageIcon hex = new ImageIcon(getClass().getResource("hex.png"));
            buttonhex = new JButton(hex);
            add(buttonhex);
   //button.setMargin(new Insets(0, 0, 0, 0)); 
   //button.setBackground( Color.black);//bg color
   //button.setBorder(null);//no boarder
   
           
            buttoncircle.addActionListener(this);
            buttonline.addActionListener(this);
             buttonrect.addActionListener(this);
             buttonhex.addActionListener(this);
              //Now add the buttons to the panel   
           
              
        }
        public void paintComponent(Graphics g)  //1st window content 
{
    super.paintComponent(g);
   Toolkit  tk = Toolkit.getDefaultToolkit();  
        Dimension  d = tk.getScreenSize();  
        //int  screenWidth = d . width;  
       // int  screenHeight = d . height;  
       Color  c1 = new Color (210, 105, 30); 
     g.setColor(c1);
      Font  f1 = new Font ("Helvetica", Font.BOLD, 20); 
    g.setFont(f1);
    g.drawString ("Welcome to Graphics", screenWidth/6, screenHeight/9); 
    
   }
        public void actionPerformed(ActionEvent evt) 
        {
            Object source = evt.getSource();  
            if (source == buttoncircle)
          {
              
 //JFrame newFrame = new Triangle();
 
//newFrame.setVisible(true);//yelloButton is data field   color = Color.yellow;
JFrame frame2 = new JFrame("Circle");
 //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Circle panel = new Circle ();
frame2.getContentPane().add(panel);
frame2.setSize(screenHeight/2, screenWidth/4); 
frame2.setLocation(screenWidth/8 ,screenWidth/8);
frame2.setVisible(true);
            }
if (source == buttonrect)
{
    JFrame frame3 = new JFrame("Rectangle");
 //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Rect panel2 = new Rect ();
frame3.getContentPane().add(panel2);
frame3.setSize(screenHeight/2, screenWidth/4); 
frame3.setLocation(screenWidth/2 ,screenWidth/8);
frame3.setVisible(true);
}
if (source == buttonline)
{
    JFrame frame4 = new JFrame("Line");
 //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Line panel3 = new Line ();
frame4.getContentPane().add(panel3);
frame4.setSize(screenHeight/2, screenWidth/4); 
frame4.setLocation(screenWidth/2 ,screenWidth/4);
frame4.setVisible(true);
}
if (source == buttonhex)
{
    JFrame frame5 = new JFrame("Hexagon");
 //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Hex panel4 = new Hex ();
frame5.getContentPane().add(panel4);
frame5.setSize(screenHeight/2, screenWidth/4); 
frame5.setVisible(true);
}

        }
        
    }

class Term extends WindowAdapter //X to close
{
    public void windowClosing(WindowEvent e)   
    {   
        System.exit(0);  
    } 
}



class Circle extends JPanel
{
public void paintComponent(Graphics g) 
{
    super.paintComponent(g);
    Polygon p=new Polygon();
    g.setColor(Color.black);   
    //p.addPoint( 0   , 120 );
       // p.addPoint( 120 , 0   );
       // p.addPoint( 220 ,120  );    
   // g.drawPolygon(p);
    //g.fillPolygon(p);
   g.drawOval(25, 25, 120, 120);
    }
}

class Hex extends JPanel
{
public void paintComponent(Graphics g) 
{
    super.paintComponent(g);
    Polygon p=new Polygon();
    g.setColor(Color.black);   
    p.addPoint( 100   , 45 );
       p.addPoint( 60 , 80   );
        p.addPoint( 60 ,120  );  
        p.addPoint( 100 ,150 ); 
        p.addPoint( 140 ,120  ); 
        p.addPoint( 140 ,80  ); 
    g.drawPolygon(p);
    //g.fillPolygon(p);
   
    }
}


class Rect extends JPanel
{
public void paintComponent(Graphics g) 
{
    super.paintComponent(g);
   g.setColor(Color.black);   
    
   g.drawRect(25,50,150,100);
    
}
}
class Line extends JPanel
{
public void paintComponent(Graphics g) 
{
    super.paintComponent(g);
   g.setColor(Color.black);   
    
   g.drawLine(25,50,150,100);
    
}
}

class Drawframe extends JFrame
{
    public Drawframe ()
    {
        setTitle("Project 7.2.1");
        Toolkit  tk = Toolkit.getDefaultToolkit();  
        Dimension  d = tk.getScreenSize();  
        int  screenWidth = d . width;  
        int  screenHeight = d . height;  
        setSize(screenWidth / 2, screenHeight /4 ); 
        setLocation(screenWidth/4 ,0);
       // setSize(500,500);
        Container contentPane=getContentPane();
        //contentPane.add(new Welcome());
        contentPane.add(new ButtonPanel());
       // contentPane.add(new Triangle());
        addWindowListener (new Term()); 
        
    }
}
public class Guievent 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame output=new Drawframe();
       
       output.setVisible(true);
//output2.setVisible(true);//set to show // TODO code application logic here
    }
    
}
