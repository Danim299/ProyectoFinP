package Mazmorra;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Mazmorra.Movimiento.TestPane;

public class main {

    public static void main(String[] args) {
        dungeon1 d = new dungeon1();
        dungeon2 dg2 = new dungeon2();
        dungeon3 d3 = new dungeon3();
        final ImageIcon icon = new ImageIcon("./Mazmorra/img/Anubis.png");
        final ImageIcon personaje = new ImageIcon("./Mazmorra/img/personaje.png");
        final ImageIcon azaTun = new ImageIcon("./Mazmorra/img/tunicaAzada.png");
        final ImageIcon pensar = new ImageIcon("./Mazmorra/img/pensar.gif");
        final ImageIcon hablar = new ImageIcon("./Mazmorra/img/hablar2.gif");
        final ImageIcon espada = new ImageIcon("./Mazmorra/img/espada.png");
        final ImageIcon enemigo1 = new ImageIcon("./Mazmorra/img/enemigo1.png");
        final ImageIcon enemigo2 = new ImageIcon("./Mazmorra/img/enemigo2.png");
        final ImageIcon templo = new ImageIcon("./Mazmorra/img/templo.png");
        final ImageIcon ruinas = new ImageIcon("./Mazmorra/img/ruinas.png");
        final ImageIcon enemigo3 = new ImageIcon("./Mazmorra/img/mikey.png");
        final ImageIcon castillo = new ImageIcon("./Mazmorra/img/castillo.png");
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
        String[] botonesFin = {"FIN"};
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
                        int opc3 = JOptionPane.showOptionDialog(null, "Sales de la aldea y te topas con la siguiente mazmorra: "+dg2.getNombre(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, templo, botonesE, botonesE);
                        if(opc3==0){
                            es.setDurabilidad(es.getDurabilidad()-1);
                            int opc4 = JOptionPane.showOptionDialog(null, "Comienzas andar por dentro de la mazmorra y te encuentras a su jefe, Hotaru Haganezuka", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo2, botonesE, botonesE);
                            if(opc4==0){
                                opc4 = JOptionPane.showOptionDialog(null, "Sacas tu espada, comienza una batalla intensa y larga, pero que consigues superar\nDurabilidad = "+es.getDurabilidad(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo2, botonesF, botonesF);
                                opc4 = JOptionPane.showOptionDialog(null, "Sales de la mazmorra y continuas tu camino hacia el castillo", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, personajeCorrer, botonesF, botonesF);
                                
                                int opc5 = JOptionPane.showOptionDialog(null, "Sales del templo, descansas en un pequeño campamento cercano y continuas al día siguiente hacia la siguiente mazmorra: "+d3.getNombre(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, ruinas, botonesE, botonesE);
                                if(opc5==0){
                                    es.setDurabilidad(es.getDurabilidad()-1);
                                    opc5 = JOptionPane.showOptionDialog(null, "Caminas y caminas sobre las ruinas hasta que te topas con el jefe, Manjiro Sano", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo3, botonesF, botonesF);
                                    opc5 = JOptionPane.showOptionDialog(null, "Sacas tu espada y combates contra mikey, le abates y continuas hacia el castillo", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo3, botonesF, botonesF);
                                    JOptionPane.showOptionDialog(null,"Has llegado al castillo de Dunstaffnage\naqui concluye tu aventura llena de riesgos","Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, castillo, botonesFin, botonesFin);
                                }
                                else if(opc5==1){
                                    finJuego1();
                                }
                            }
                            else if(opc4==1){
                                finJuego();
                            }
                        }else if(opc3==1){
                            finJuego();
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
                        int opc3 = JOptionPane.showOptionDialog(null, "Sales de la aldea y te topas con la siguiente mazmorra: "+dg2.getNombre(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, templo, botonesE, botonesE);
                        if(opc3==0){
                            az.setDurabilidad(az.getDurabilidad()-2);
                            int opc4 = JOptionPane.showOptionDialog(null, "Comienzas andar por dentro de la mazmorra y te encuentras a su jefe, Hotaru Haganezuka", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo2, botonesE, botonesE);
                            if(opc4==0){
                                opc4 = JOptionPane.showOptionDialog(null, "Sacas tu azada, comienza una batalla intensa y larga, pero que consigues superar a duras penas\nDurabilidad = "+az.getDurabilidad(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo2, botonesF, botonesF);
                                opc4 = JOptionPane.showOptionDialog(null, "Sales de la mazmorra y continuas tu camino hacia el castillo", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, personajeCorrer, botonesF, botonesF);
                                
                                int opc5 = JOptionPane.showOptionDialog(null, "Sales del templo, descansas en un pequeño campamento cercano y continuas al día siguiente hacia la siguiente mazmorra: "+d3.getNombre(), "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, ruinas, botonesE, botonesE);
                                if(opc5==0){
                                    opc5 = JOptionPane.showOptionDialog(null, "Caminas y caminas sobre las ruinas hasta que te topas con el jefe, Manjiro Sano", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo3, botonesF, botonesF);
                                    opc5 = JOptionPane.showOptionDialog(null, "Peleas hasta quedarte sin aliento, por lo que mikey te asesta una patada con todas sus fuerzas...", "Dungeon", JOptionPane.INFORMATION_MESSAGE, 0, enemigo3, botonesF, botonesF);
                                    finJuego();
                                }
                                else if(opc5==1){
                                    finJuego1();
                                }
                            }
                            else if(opc4==1){
                                finJuego1();
                            }
                        }else if(opc3==1){
                            finJuego1();
                        }
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
