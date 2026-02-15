// Barrera Correa Yolanda Michel
package edad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Edad extends JFrame implements ActionListener {

    JTextField numUno;
    JButton btnOperar;
    JPanel panel01;

    public Edad() {
        setTitle("Mayor o Menor de Edad");
        setSize(400,200);
        setDefaultCloseOperation(3);
               
        numUno = new JTextField(5);
        btnOperar = new JButton("Aceptar");
        btnOperar.addActionListener(this);
       
        panel01 = new JPanel();
       
        panel01.add(numUno);
        panel01.add(btnOperar);
       
        add(panel01);
        setVisible(true);
    }
   
    public static void main(String[] args) {
        Edad e = new Edad();        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n1 = numUno.getText();
       
        int edad = Integer.parseInt(n1);        
       
        if(edad >= 18){
            JOptionPane.showMessageDialog(null, "Eres mayor de edad");
        }else{
            JOptionPane.showMessageDialog(null, "Eres menor de edad");
        }
     }
}

