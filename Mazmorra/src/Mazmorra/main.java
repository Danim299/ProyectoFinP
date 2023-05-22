package Mazmorra;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        dungeon1 d = new dungeon1();
        final ImageIcon icon = new ImageIcon("./img/Anubis.png");
        final ImageIcon personaje = new ImageIcon("./img/personaje.png");
        ArrayList obJugador;
        String[] botonesInicio = {"Nos preparamos?"};
        String[] botonesA = {"Seguimos"};    
        String[] botones = {"Vamos!","Mejor no"};
        
        
        int listo = JOptionPane.showOptionDialog(null, "Te levantas por la mañana y te encuentras con una misteriosa carta en la cual te citan para acudir a OldCastle\nPero no todo son buenas noticias, porque para llegar hasta allí necesitas atravesar 3 mazmorras", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, personaje, botonesInicio, null);

        listo = JOptionPane.showOptionDialog(null, "Buscar por casa y lo único que encuentras es una túnica vieja y una azada", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, icon, botonesA, null);

        listo = JOptionPane.showOptionDialog(null, "Estás apunto de adentrarte en "+d.getNombre()+"\nTienes todo el equipo listo?", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, icon, botones, botones);
       
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
