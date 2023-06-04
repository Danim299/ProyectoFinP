package Mazmorra;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Mazmorra.Movimiento.TestPane;

public class main {

    public static void main(String[] args) {
        dungeon1 d = new dungeon1();
        final ImageIcon icon = new ImageIcon("./Mazmorra/img/Anubis.png");
        final ImageIcon personaje = new ImageIcon("./Mazmorra/img/personaje.png");
        final ImageIcon azaTun = new ImageIcon("./Mazmorra/img/tunicaAzada.png");
        final ImageIcon pensar = new ImageIcon("./Mazmorra/img/pensar.gif");
        final ImageIcon hablar = new ImageIcon("./Mazmorra/img/hablar2.gif");
        final ImageIcon espada = new ImageIcon("./Mazmorra/img/espada.png");
        final ImageIcon enemigo1 = new ImageIcon("./Mazmorra/img/enemigo1.png");
        final ImageIcon personajeCorrer = new ImageIcon("./Mazmorra/img/personajeCorrer.gif");
        final ImageIcon yayo = new ImageIcon("./Mazmorra/img/yayo.png");
        ArrayList obJugador = new ArrayList();
        int espa=1;
        String[] botonesInicio = {"Nos preparamos?"};
        String[] botonesA = {"Ir hacia la puerta"};
        String[] botonesB = {"Ir a la herreria", "Continuar con el viaje"};
        String[] botonesC = {"Levantarse"};
        String[] botonesD = {"Coger la espada", "Dejar la espada"};
        String[] botonesE = {"Luchar", "Huir"};
        String[] botonesF = {"Continuar"};
        String[] botonesG = {"Ayudar al yayo","Continuar"};
        String[] botones = {"Vamos!","Mejor no"};
        
        
        int listo = JOptionPane.showOptionDialog(null, "Te levantas por la mañana y te encuentras con una misteriosa carta en la cual te citan para acudir a Dunstaffnage\nPero no todo son buenas noticias, porque para llegar hasta allí necesitas atravesar 3 mazmorras", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, personaje, botonesInicio, null);

        listo = JOptionPane.showOptionDialog(null, "Buscas por casa y lo único que encuentras es una vieja túnica y una azada", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, azaTun, botonesA, null);
        tunica tu = new tunica();
        azada az = new azada(3, 10);
        espada es = new espada(7, 10);
        obJugador.add(tu);
        obJugador.add(az);
        listo = JOptionPane.showOptionDialog(null, "Al salir de casa te das cuenta de que tu tio el herrero podría tener algo para ti", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, pensar, botonesB, null);
        
        if (listo==0){
             listo = JOptionPane.showOptionDialog(null, "Llegas y mantienes una larga conversacion con tu tio contando la situación acompañado por un café solo con hielo y una crema de orujo", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, hablar, botonesC, null);
             espa = JOptionPane.showOptionDialog(null, "Resulta que tu tío te da una espada con unas runas talladas", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, espada, botonesD, null);
                if(espa==0){
                    obJugador.add(es);
                }
            }

        Movimiento m = new Movimiento();
        try{
            Thread.sleep(1000);
        }catch(Exception e){};

        System.out.println();
            while(m.getPasar()) {
                System.out.println();
            }
            
            System.out.println(m.getFinalX()+" y "+ m.getFinalY());
        
            
        listo = JOptionPane.showOptionDialog(null, "De camino al castillo te adentras en la primera mazmorra:  "+d.getNombre()+"\nTienes todo el equipo listo?", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, icon, botones, botones);
        
            if (listo==0){
                int opc1 = JOptionPane.showOptionDialog(null, "Al seguir hacia delante te encuentras con el jefe de la mazmorra", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo1, botonesE, botonesE);
                if(opc1==0){
                    if(espa==0){
                        es.setDurabilidad(es.getDurabilidad()-1);
                        int opc2 = JOptionPane.showOptionDialog(null, "Blandes tu espada y le asestas un golpe para acabar con él\n(La durabilidad de tu espada baja 2 puntos)\nDurabilidad = "+es.getDurabilidad(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo1, botonesF, botonesF);
                        opc2 = JOptionPane.showOptionDialog(null, "Sales de la mazmorra y continuas tranquilamente tu camino", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, personajeCorrer, botonesF, botonesF);
                        opc2 = JOptionPane.showOptionDialog(null, "Llegas a una pequeña aldea y resulta que al jefe de la aldea se le ha roto la azada\nquieres ayudarle con la tuya?(perderás durabilidad)", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, personajeCorrer, botonesG, botonesG);
                        if(opc2==0){
                            az.setDurabilidad(az.getDurabilidad()-1);
                            opc2 = JOptionPane.showOptionDialog(null, "El jefe tiene una sonrisa de oreja a oreja, pero no te da nada a cambio\nDurabilidad = "+az.getDurabilidad(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, yayo, botonesF, botonesF);
                        }
                    }else if(espa==1){
                        az.setDurabilidad(az.getDurabilidad()-2);
                        int opc2 = JOptionPane.showOptionDialog(null, "Golpeas con todas tus fuerzas al jefe con la azada\n(La durabilidad de tu azada baja 2 puntos)\nDurabilidad = "+az.getDurabilidad(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo1, botonesF, botonesF);
                        opc2 = JOptionPane.showOptionDialog(null, "Sales de la mazmorra y continuas tranquilamente tu camino", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, personajeCorrer, botonesF, botonesF);
                        opc2 = JOptionPane.showOptionDialog(null, "Llegas a una pequeña aldea y resulta que al jefe de la aldea se le ha roto la azada\nquieres ayudarle con la tuya?(perderás durabilidad)", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, personajeCorrer, botonesG, botonesG);
                        if(opc2==0){
                            az.setDurabilidad(az.getDurabilidad()-1);
                            opc2 = JOptionPane.showOptionDialog(null, "El jefe tiene una sonrisa de oreja a oreja, pero no te da nada a cambio\nDurabilidad = "+az.getDurabilidad(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, yayo, botonesF, botonesF);
                        }
                        int opc3 = JOptionPane.showOptionDialog(null, "Golpeas con todas tus fuerzas al jefe con la azada\n(La durabilidad de tu azada baja 2 puntos)\nDurabilidad = "+az.getDurabilidad(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo1, botonesF, botonesF);
                    }
                }else if (opc1 == 1){
                    finJuego1();
                }
            }else if (listo==1){
                System.out.println("Bueno aquí esperaré...");
            }
    }
    public static void finJuego(){
        JOptionPane.showMessageDialog(null, "Te han matado ☠", "FIN", 0);
    }
    public static void finJuego1(){
        JOptionPane.showMessageDialog(null, "Has intentado huir y te han matado ☠", "FIN", 0);
    }
}
