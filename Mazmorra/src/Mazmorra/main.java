package Mazmorra;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        dungeon1 d = new dungeon1();
        final ImageIcon icon = new ImageIcon("./img/Anubis.png");
        final ImageIcon personaje = new ImageIcon("./img/personaje.png");
        final ImageIcon azaTun = new ImageIcon("./img/tunicaAzada.png");
        final ImageIcon pensar = new ImageIcon("./img/pensar.gif");
        ArrayList obJugador;
        String[] botonesInicio = {"Nos preparamos?"};
        String[] botonesA = {"Continuamos hacia la puerta"};
        String[] botonesB = {"Ir a la herreria", "Continuar con el viaje"};
        String[] botones = {"Vamos!","Mejor no"};
        
        
        int listo = JOptionPane.showOptionDialog(null, "Te levantas por la mañana y te encuentras con una misteriosa carta en la cual te citan para acudir a OldCastle\nPero no todo son buenas noticias, porque para llegar hasta allí necesitas atravesar 3 mazmorras", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, personaje, botonesInicio, null);

        listo = JOptionPane.showOptionDialog(null, "Buscas por casa y lo único que encuentras es una vieja túnica y una azada", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, azaTun, botonesA, null);
        
        listo = JOptionPane.showOptionDialog(null, "Al salir de casa te das cuenta de que tu tio el herreo podría tener algo para ti", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, pensar, botonesB, null);
        
        if (listo==0){
             listo = JOptionPane.showOptionDialog(null, "Llegas y mantienes una larga conversacion con tu tio contando la situación acompañado por un café solo con hielo y una crema de orujo", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, pensar, botonesB, null);
        }else if (listo==1){
        
        }
        
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
