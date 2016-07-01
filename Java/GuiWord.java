
/*

Added Undo and Redo Button
Improved and added new Word Finder


Word Finder
Added "Exact match" checkbox
-When checked, find button will find the exact match of user input
-When unchecked, find button will disregard cases when searching
Added Replace and Replace All.
*/




package javawordre;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.border.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.undo.UndoManager;

class Word extends JFrame implements ActionListener, MenuListener, MouseListener 
{
    private JFrame crframe = new JFrame("File Open");
    private JTextField textf = new JTextField(10);
    private JButton okbutton = new JButton("ok"),ColorApply,FontChooser=new JButton("Font"),del = new JButton("B");
    private JButton ColorPick=new JButton("ColorPick"), findNext = new JButton("Find not in"),findNextbuttononbox = new JButton("Find"); 
    private  JButton cc=new JButton("Copy"),toupper = new JButton("Upper"); 
    private JButton replaceButton2inbox = new JButton("Replace with"),replaceall = new JButton("Replace all"); 
    private JMenuItem saveItem,openItem,copyItem,pasteItem,saveas,newItem,copypop;
    private JTextPane text;
    private Style style;
    private JScrollPane scrollPane;
    private String t,s,fileostring = "o", cnpy="",findstring="",content;
    private Color c;
    private JPanel buttonpanel=new JPanel();
    JButton colors=new JButton("Colr");
    private int lock = 1,index,caretindex,cot=0,count=0,colorcount=0,hp,savebit=0;
    private Highlighter h; 
    UndoManager manager = new UndoManager();
    public static JLabel label = new JLabel("");
    public static Font f1 = new Font("TimesNewRoman", 2, 20);
    private JPopupMenu popMenu = new JPopupMenu("Edit");
    private int hcount=0;
    public static JButton replaceButton = new JButton("Word Finder"); 
    String f="";
    private JTextField from = new JTextField(8), to;   
    private int delstopnupp=0;
    JButton undoButton,redoButton; 
    JFrame about=new JFrame();
    private JCheckBox cap=new JCheckBox("Exact Match");    


    public Word() {
        this.setTitle("Text");
        Toolkit  tk = Toolkit.getDefaultToolkit();  
        Dimension  d = tk.getScreenSize();  
        int  screenWidth = d . width;  
        int  screenHeight = d . height;  
        setSize(screenWidth/2+200, screenHeight-20  ); 
      //  this.setSize(600, 400);
        this.setLocation( screenHeight/2, 0);
        this.menus();
        JPanel panel = new JPanel();
        panel.add(this.del);
        Border border = null;
        this.text = new JTextPane();
        Color  c1 = new Color (204,204,255); 
        border = BorderFactory.createMatteBorder(100, 100,0,100,c1);   
        this.style = this.text.addStyle("Bold", null);
      
        this.text.addMouseListener(this);
        this.from.addMouseListener(this);
        text.setMargin(new Insets(10,100,100,100));
        
        this.scrollPane = new JScrollPane(this.text);
        this.scrollPane.setBorder(border);
       
         copyItem.setEnabled(false);
         
     
         pasteItem.setEnabled(false);
       
        JButton Ali=new JButton(new StyledEditorKit.AlignmentAction("Alignment 12 ", 12));
       
        JButton ital=new JButton(new StyledEditorKit.ItalicAction());
        JButton bold=new JButton(new StyledEditorKit.BoldAction());
        JButton sizefont20=new JButton(new StyledEditorKit.FontSizeAction("Size 20", 20));
        JButton sizefont=new JButton(new StyledEditorKit.FontSizeAction("Size 15", 15));
        JButton paste=new JButton(new StyledEditorKit.PasteAction());
        JButton under=new JButton(new StyledEditorKit.UnderlineAction());
    
        JButton san=new JButton(new StyledEditorKit.FontFamilyAction("Mono", Font.MONOSPACED));
        JButton Serif=new JButton(new StyledEditorKit.FontFamilyAction("Sans", Font.SERIF));
          
           
        
         text.getDocument().addUndoableEditListener(manager);
          
         undoButton = new JButton("Undo");
         redoButton = new JButton("Redo");
         undoButton.addActionListener(this);
         redoButton.addActionListener(this);
         buttonpanel.add(undoButton);
         buttonpanel.add(redoButton);
         
          cc=new JButton(new StyledEditorKit.CopyAction());
        
          cc.setEnabled(false);
          cc.addActionListener(this);
          buttonpanel.add(cc);
          buttonpanel.add(paste);
       
        
          buttonpanel.add(bold);
          buttonpanel.add(ital);
          buttonpanel.add(under);
          buttonpanel.add(san);
          buttonpanel.add(Serif);
          buttonpanel.add(sizefont20);
          buttonpanel.add(sizefont);
         
           san.addActionListener(this);
           Serif.addActionListener(this);
           ColorPick.addActionListener(this);
             
         buttonpanel.add(Ali);     
    
   
         FontChooser.addActionListener(this);
    
        buttonpanel.add(replaceButton);
        buttonpanel.add(ColorPick);
   
        replaceButton2inbox .addActionListener(this);
        findNextbuttononbox.addActionListener(this);
        cap.addActionListener(this);
   
       replaceall.addActionListener(this);
   
       replaceButton.addActionListener(this);
  
       JMenuItem boldpop = new JMenuItem(new StyledEditorKit.BoldAction());
       copypop = new JMenuItem(new StyledEditorKit.CopyAction());
       JMenuItem pastepop = new JMenuItem(new StyledEditorKit.PasteAction());
       JMenuItem font12 = new JMenuItem(new StyledEditorKit.FontSizeAction("Normal Size", 12));
       boldpop.addActionListener(this);
       copypop.setEnabled(false);
       popMenu.add(copypop);
       popMenu.add(pastepop);
       popMenu.add(boldpop);
    
       popMenu.add(font12);
       scrollPane.setComponentPopupMenu(popMenu);
       text.setInheritsPopupMenu(true);

       getContentPane().add((Component) buttonpanel, "North");
       buttonpanel.setLayout(new GridLayout(2, 5,5,5)); 
       this.getContentPane().add((Component)scrollPane, "Center");
       this.getContentPane().add((Component)this.label, "South");
      
      
        
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    class FindF extends JFrame{ //find word frame
         FindF()
        {
            setSize(500,200);
            
            JPanel panel = new JPanel(); 
            JPanel capanel = new JPanel();
            capanel.add(cap);
            JPanel labelpanel = new JPanel();
           
           
            
             panel.add( findNextbuttononbox); 
              
           
            panel.add(from);
            to = new JTextField(8); 
            panel.add(replaceButton2inbox); 
            panel.add(to);
            panel.add(replaceall);
            
            
            Container contentPane = getContentPane(); 
            contentPane.add(panel, "South");
            contentPane.add(capanel, "West");
            this.addWindowListener(new Term());
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        
    }
    
    

    public void menus() { //menus
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        newItem= new JMenuItem("New");
        newItem.addActionListener(this);
        this.openItem = new JMenuItem("Open");
        this.openItem.addActionListener(this);
        this.saveas = new JMenuItem("Save As");
        this.saveas.addActionListener(this);
        this.saveItem = new JMenuItem("Save");
        this.saveItem.addActionListener(this);
        fileMenu.add(this.newItem);
        fileMenu.add(this.openItem);
        fileMenu.add(this.saveItem);
        fileMenu.add(this.saveas);
        
  
        menuBar.add(fileMenu);
        JMenu editMenu = new JMenu("Edit");
        this.copyItem = new JMenuItem("Copy");
        this.copyItem.addActionListener(this);
        this.pasteItem = new JMenuItem("Paste");
        this.pasteItem.addActionListener(this);
        JMenu format = new JMenu("Format");
        editMenu.add(this.copyItem);
        editMenu.add(this.pasteItem);
        editMenu.add(format);
        editMenu.insertSeparator(2);
        JMenuItem Bold = new JMenuItem(new StyledEditorKit.BoldAction());
        format.add(Bold);
        Bold.addActionListener(this);
        JMenuItem ital = new JMenuItem(new StyledEditorKit.ItalicAction());
        ital.addActionListener(this);
        format.add(ital);
        menuBar.add(editMenu);
        
        JMenu FontMenu = new JMenu("Font");
        JMenuItem Mono= new JMenuItem(new StyledEditorKit.FontFamilyAction("Mono Font", Font.MONOSPACED));
        FontMenu.add(Mono);
        
        Mono.addActionListener(this);
        JMenuItem da= new JMenuItem(new StyledEditorKit.FontFamilyAction("SANS_SERIF", Font.SANS_SERIF));
        FontMenu.add(da);
        
        da.addActionListener(this);
        JMenuItem serf= new JMenuItem(new StyledEditorKit.FontFamilyAction("DIALOG", Font.DIALOG));
        FontMenu.add(serf);
        
        serf.addActionListener(this);
       
        JMenuItem SERIF= new JMenuItem(new StyledEditorKit.FontFamilyAction("SERIF", Font.SERIF));
        FontMenu.add(SERIF);
        
        SERIF.addActionListener(this);
       
         menuBar.add(FontMenu);
        
         this.setJMenuBar(menuBar);
         addWindowListener (new Term()); 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        
     
     h = text.getHighlighter();
     h.removeAllHighlights();
      
     findstring=s;
     content = text.getText();
     
     
        String arg = evt.getActionCommand();
      
        
         if (arg.equals("New") ){
             String s=text.getText();
             
             t="";
             
             if(s.length()>0)
             {
                 
                  int messageType = JOptionPane.QUESTION_MESSAGE;
      String[] options = {"Save","Dont save", "Cancel"};
      int code = JOptionPane.showOptionDialog(null, 
         "Do you want to save changes", 
         "Option Dialog Box", 0, messageType, 
         null, options, "Default");
                 if (code==0)//save
                 {
                     filesave();
                     if( savebit==1)
                     {
              label.setText(t);
                     text.setText("");
                     }
                     label.setText(t);
                 }
                 
                  if (code==1)//dont save
                 {
                     
                      
                      text.setText("");
                      label.setText(t);
                 }
                  if (code==2) //cancel
                 {
                   
              label.setText(t);
                   
                 }
                 
             }
             
         }
        
        if (arg.equals("Save")) {
            
            
            if (savebit==0){
               filesave();
              label.setText(t);
             
            }
            if(savebit==1){
            Path filePath = Paths.get(t);
            String word = text.getText();
            byte[] data = word.getBytes();
            try {
                BufferedOutputStream outStream = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE));
                outStream = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.TRUNCATE_EXISTING));
                outStream.write(data);
                outStream.flush();
                outStream.close();
            }
            catch (Exception e) {
                System.out.println("Eorr" + e);
            }
        }
        }
        if (arg.equals("Open") ) {
              String s;
            JFileChooser fileChooser = new JFileChooser();
      int response = fileChooser.showOpenDialog(null);
      
      if (response == JFileChooser.APPROVE_OPTION) {
         File file = fileChooser.getSelectedFile();
         t=fileChooser.getSelectedFile().getAbsolutePath();
         BufferedReader br = null;
         StringBuffer str = new StringBuffer("");
         try {
            br = new BufferedReader(new FileReader(file));
         //   final JTextArea textArea = new JTextArea(20, 40);
         savebit=1;
          label.setText(t);
           String line;
            while ((line = br.readLine()) != null) {
                str.append(line + "\n");
            }
          String z=str.toString();
         
          text.setText(z);
           
br.close();
           
         } catch (Exception e) {
               }
   
           
        }
        
      
  
    }//open end
        
        
        
        if (arg.equals("Save As") ) {
            
          filesave();
              label.setText(t);
        
            
            
        }
        
        if (arg.equals("ColorPick") ){
            
           
            if(colorcount==1)
            {
               buttonpanel.remove(ColorApply);
               // System.exit(0);
            }
            
             Color c = JColorChooser.showDialog(null, "Choose a Color", text.getForeground());
          
           // buttonpanel.add(ColorApply);
           
            ColorApply=new JButton(new StyledEditorKit.ForegroundAction("ColorApply", c));
            //ColorPick.setFont(new Font("Dialog", Font.PLAIN, 22));
            //ColorApply.setForeground(c);
            ColorApply.setBackground(c);
             buttonpanel.add(ColorApply);
          
             colorcount=1;
          buttonpanel.revalidate();
       
          // ccont=1;
            
        }
        

          if (arg.equals("Sans") ){
              colors=new JButton(new StyledEditorKit.FontFamilyAction("Sans", Font.DIALOG));
              //text.setText(f);
           
          }
          
 
          
           if (arg.equals("Find") ){
               
                f = from.getText(); 
                
                delstopnupp=1;
               hcount=1;
            String replaceAll = content.replaceAll("\n","");
           
            if(cap.isSelected()==false){
                String toLowerCase = replaceAll.toLowerCase();
                    String toLowerCase1 = f.toLowerCase();
                    f=toLowerCase1;
               index = toLowerCase  .indexOf(f,count);
           }
           // String toLowerCase = replaceAll.toLowerCase();
            
            if(cap.isSelected()==true){
                index = replaceAll .indexOf(f,count);
           }
           
            //  index = replaceAll .indexOf(f,count);
              if(index==-1)
       {
           count=0;
           //index = content.indexOf(f, count);
            int result = JOptionPane.showConfirmDialog(this, "Find reached the end or no word is found",
                        "Error", JOptionPane.CLOSED_OPTION);
       }
                
               
                  try {
         
        // int index = content.indexOf(f, 0);
        h.addHighlight(index ,index + f.length(),DefaultHighlighter.DefaultPainter);
        //count=index+f.length();
       
        
       
         
     } catch (BadLocationException ex) {
     
    }
                   //index=text.getText().indexOf(f);
              count=index+1;
           }
           
            if (arg.equals("Replace with") ){
           if (delstopnupp==1){
                text.select(index, index+f.length());
         text.replaceSelection(to.getText());
          delstopnupp=0;
           }
           }
          boolean m=(cap.isSelected()? true: false);
          replaceall.setEnabled(m);
             if (arg.equals("Replace all") ){
             // boolean m=(cap.isSelected()? true: false);
                
              
                 String repall=text.getText();
            String replaceAll = repall.replaceAll(from.getText(), to.getText());
                 text.setText(replaceAll);
                
             }
            
           if (arg.equals("Word Finder") ){
               
              /// text.setText(f);
             // wordfind.setVisible(true);
             JFrame findf=new FindF();
         findf.setVisible(true);      

         replaceButton.setEnabled(false);
            
           
           }
           
            if (arg.equals("Undo") ){
                
              
                if (manager.canUndo()) {
          manager.undo();
        }
            }
            
              if (arg.equals("Redo") ){
                
              
                if (manager.canRedo()) {
          manager.redo();
        }
            }
            

    }

     public void filesave() {
          JFileChooser fileChooser = new JFileChooser();
          
      
      if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
         File file = fileChooser.getSelectedFile();
   
     if (file.isFile()==true)
     {
         int result = JOptionPane.showConfirmDialog(this, "The file already exists, overwrite?",
                        "Save as", JOptionPane.YES_NO_CANCEL_OPTION);
         
          if (result == JOptionPane.YES_OPTION) {
              
              t=fileChooser.getSelectedFile().getAbsolutePath();
         BufferedReader br = null;
         Path filePath = Paths.get(t);
            String word = text.getText();
            byte[] data = word.getBytes();
            try {
                BufferedOutputStream outStream = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE));
                outStream = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.TRUNCATE_EXISTING));
                outStream.write(data);
                outStream.flush();
                outStream.close();
                savebit=1;
            }
            catch (Exception e) {
                System.out.println("Eorr" + e);
            }
              
          }

          
     }
     
         if (file.exists()==false){
         t=fileChooser.getSelectedFile().getAbsolutePath();
         BufferedReader br = null;
         Path filePath = Paths.get(t);
            String word = text.getText();
            byte[] data = word.getBytes();
            try {
                BufferedOutputStream outStream = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE));
                outStream = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.TRUNCATE_EXISTING));
                outStream.write(data);
                outStream.flush();
                outStream.close();
                savebit=1;
            }
            catch (Exception e) {
                System.out.println("Eorr" + e);
            }
         }
         
     }
     }
     

    @Override
    public void menuSelected(MenuEvent evt) {
    }

    @Override
    public void menuDeselected(MenuEvent evt) {
    }

    @Override
    public void menuCanceled(MenuEvent evt) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.text)
        {
            caretindex=text.getCaretPosition();
            copyItem.setEnabled(false);
            cc.setEnabled(false);
            copypop.setEnabled(false);
            if(hcount==1){
             h.removeAllHighlights();
            }
        }
         if (e.getSource() == this.from){
             count=0;
         }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    
    {
        
        if (e.getSource() == this.text && this.text.getSelectedText() != null) {
            s = text.getSelectedText();
           
            hp = text.getSelectionStart();
           copyItem.setEnabled(true);
            cc.setEnabled(true);
             copypop.setEnabled(true);
        }
         if (e.getSource() == this.from && this.from.getSelectedText() != null) {
             count=0;
         }
        
    }

    
    
}


class Term extends WindowAdapter //X to close
{
    public void windowClosing(WindowEvent e)   
    {   
      // System.exit(0); 
        Word.replaceButton.setEnabled(true);
        
        
    } 
}
/**
 *
 * @author Jiajun H
 */
public class Javawordre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
         JFrame frame = new Word();
        frame.setVisible(true);
    }
    
}