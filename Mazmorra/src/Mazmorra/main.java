package Mazmorra;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        dungeon1 d = new dungeon1();
        final ImageIcon icon = new ImageIcon("./img/Anubis.png");
        ArrayList obJugador;
        String[] botones = {"Vamos!","Mejor no"};
        
        int listo = JOptionPane.showOptionDialog(null, "Estás apunto de adentrarte en "+d.getNombre()+"\nTienes todo el equipo listo?", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, icon, botones, botones);
        if (listo==0){
            System.out.println("Vamos a ello");
            JFrame f=new JFrame("Dungeon");
            f.setBounds(10,10,300,200);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }else if (listo==1){
            System.out.println("Bueno aquí esperaré...");
        }
    }
    
}
