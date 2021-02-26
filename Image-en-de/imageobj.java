import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import java.awt.Font;
//import javax.swing.text.AttributeSet.FontAttribute;

public class imageobj{

    public static void operate(int key){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File chosenFile = fileChooser.getSelectedFile();

        try{
            FileInputStream fis = new FileInputStream(chosenFile);

            byte[] data = new byte[fis.available()];
            fis.read(data);

            //data[0]= (byte)(data[0]^key);

            
            int i=0;
            for(byte b : data){
                System.out.println(b);
                data[i]= (byte)(b^key);
                i++;
            }

            //write it to Encrypt
            FileOutputStream fos = new FileOutputStream(chosenFile);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done!");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        //making the GUI 
        JFrame window = new JFrame();
        window.setTitle("Encrypt/Decrypt Images");
        window.setSize(400,400);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //button
        Font font = new Font("Roboto", Font.BOLD,15);
        JButton button = new JButton();
        button.setText("Open Images");
        button.setFont(font);

        
        //text field
        JTextField textfield = new JTextField(30);
        textfield.setFont(font);

        button.addActionListener(e->{
            System.out.println("button clicked");
            String text = textfield.getText();
            
            int to_int = Integer.parseInt(text);
            operate(to_int);
        });
        window.setLayout(new FlowLayout());   
        window.add(button);
        window.add(textfield);     
        window.setVisible(true);
    }
}