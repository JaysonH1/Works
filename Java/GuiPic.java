/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guijavaswing6p2;
import java.awt.*;

import javax.swing.*;

class Welcome extends JPanel
{
public void paintComponent(Graphics g)  //1st window content 
{
    super.paintComponent(g);
   Toolkit  tk = Toolkit.getDefaultToolkit();  
        Dimension  d = tk.getScreenSize();  
        int  screenWidth = d . width;  
        int  screenHeight = d . height;  
     g.setColor(Color.red);
    g.drawString ("Welcome to Huang's", screenWidth/5, screenHeight/9); 
    Font  f1 = new Font ("Helvetica", Font.BOLD, 20); 
    g.setFont(f1);
     g.setColor(Color.blue);
    g.drawString ("Windows",screenWidth/5, screenHeight/7); 
   }
}
class Triangle extends JPanel
{
public void paintComponent(Graphics g) 
{
    super.paintComponent(g);
    Polygon p=new Polygon();
    g.setColor(Color.black);
    int  thickness = 4;             
        p.addPoint( 0   , 50); // top trapa
        p.addPoint( 50 , 0   );
         p.addPoint( 150 ,0);
         p.addPoint( 200 , 50  );
        g.drawPolygon(p);
    g.fillPolygon(p);
    //Color  c1 = new Color (160, 82, 45); 
    Color  c1 = new Color (210, 105, 30); 
    g.setColor(c1 );
     g.fillRect(25,50,150,100); //outsde box
     Color  c2 = new Color (160, 82, 45); 
     g.setColor(c2 );
    g.fillRect(85,100,30,50); //inside box
     g.setColor(Color.black);
     for (int i=1; i <= thickness-1; i++)
      {
          g.drawRect(85-i,100-i,30,50); 
      }    
     g.setColor(Color.black);
      for (int i=1; i <= thickness; i++)
      {
          g.drawRect(25-i,50-i,150,100); // outside blk brd
      }
// Color  c2 = new Color (222, 105, 30); 
   // g.setColor(c2 );
     //g.fillRect(25,50,150,100); 
}
}
class Drawframe extends JFrame // 1st window dimension 
{
    public Drawframe ()
    {
        setTitle("Project 6.2");
        Toolkit  tk = Toolkit.getDefaultToolkit();  
        Dimension  d = tk.getScreenSize();  
        int  screenWidth = d . width;  
        int  screenHeight = d . height;  
        setSize(screenWidth / 2, screenHeight /4 ); 
        setLocation(screenWidth/4 ,0);
       // setSize(500,500);
        Container contentPane=getContentPane();
        contentPane.add(new Welcome());
    }
}
class Drawframe2 extends JFrame //2nd window dimension
{
    public Drawframe2 ()
    {
        setTitle("Project 6.2");
        Toolkit  tk = Toolkit.getDefaultToolkit();  
        Dimension  d = tk.getScreenSize();  
        int  screenWidth = d . width;  
        int  screenHeight = d . height;  
        setSize(screenWidth / 3, screenHeight /3 ); 
        setLocation(screenWidth / 3, screenHeight / 4);
       // setSize(500,500);
        Container contentPane=getContentPane();
        contentPane.add(new Triangle());
    }
}
public class Guijavaswing6p2 {
    
    public static void main(String[] args) {
        JFrame output=new Drawframe();
        JFrame output2=new Drawframe2();
       output.setVisible(true);//set to show
      output2.setVisible(true);
    }
    
}
