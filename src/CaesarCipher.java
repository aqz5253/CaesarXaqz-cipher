import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

public class CaesarCipher extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextArea t1,t2;
    JTextField t3;
    JButton b1,b2;
    public CaesarCipher()
    {
        l1=new JLabel("Enter text");
        l1.setBounds(10,10,100,30);
        add(l1);

        l2=new JLabel("Result");
        l2.setBounds(10,160,100,30);
        add(l2);


        l3=new JLabel("Key");
        l3.setBounds(350,10,100,30);
        add(l3);

        t1=new JTextArea();
        t1.setBounds(10,50,300,100);
        add(t1);


        t2=new JTextArea();
        t2.setBounds(10,190,300,100);
        add(t2);


        t3=new JTextField();
        t3.setBounds(350,50,100,30);
        add(t3);

        b1=new JButton("Encrypt");
        b1.setBounds(50,310,100,30);
        add(b1);


        b2=new JButton("Decrypt");
        b2.setBounds(165,310,100,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    static String Encrypt(String text,int shiftKey)
    {
        int x=1;

        String cipherText="";
        for(int i=0;i<text.length();i++)
        {
            if(x>shiftKey)
                x=1;
            if(Character.isUpperCase(text.charAt(i)))
            {
                char c=(char)(((int)text.charAt(i)+x-65)%26+65);
                String s= Character.toString(c);
                cipherText+=s;
                x++;
            }
            else if(text.charAt(i)==' ')
                cipherText+=" ";
            else {
                char c = (char) (((int) text.charAt(i) + x - 97) % 26 + 97);
                String s = Character.toString(c);
                cipherText += s;
                x++;
            }
        }

        return cipherText;

    }
    static String Decrypt(String cipherText,int shiftKey)
    {
        String text="";

        int x=1;

        for(int i=0;i<cipherText.length();i++)
        {
            if(x>shiftKey)
                x=1;
            if(Character.isUpperCase(cipherText.charAt(i)))
            {
                char c=(char)(((int)cipherText.charAt(i)+(26-x)-65)%26+65);
                String s= Character.toString(c);
                text+=s;
                x++;
            }
            else if(cipherText.charAt(i)==' ')
                text+=" ";
            else {
                char c = (char) (((int) cipherText.charAt(i) +(26-x)-97) % 26 + 97);
                String s = Character.toString(c);
                text += s;
                x++;
            }
        }

        return text;
    }

    public void actionPerformed(ActionEvent ae) {
        String a = t1.getText();
        int k = Integer.parseInt(t3.getText());

        if (ae.getSource() == b1) {

            t2.setText(Encrypt(a, k));
        }

        if (ae.getSource() == b2) {
            t2.setText(Decrypt(a, k));
        }
    }
    public static void main(String args[])
    {
        new CaesarCipher();
    }
}
