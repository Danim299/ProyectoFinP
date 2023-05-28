package Mazmorra;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.lang.annotation.Target;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class Movimiento{
    private boolean finalizado=true;
    private double finalX;
    private double finalY;
    private TestPane tp = null;
    private JFrame frame;
    public Movimiento(){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }
                        frame = new JFrame("Prueba");
                        tp =new TestPane();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.dispose();
                        frame.add(tp);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                }
            }); 
            thread.start();
    }
    public double getFinalX() {
        return finalX;
    }
    public double getFinalY() {
        return finalY;
    }
    public boolean getPasar(){
        return finalizado;
    }
    

    public class TestPane extends JPanel {

        private Rectangle champion;
        private Line2D path;

        private double speed = 0.2;

        private Timer timer;
        private Long startTime;

        private double targetX, targetY;
        private double startX, startY;
        private double runTime;

        public TestPane() {
            champion = new Rectangle(95, 95, 90, 90);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    timer.stop();
                    calculateChampionMovement(e.getX(), e.getY(), champion);
                    startTime = System.currentTimeMillis();
                    timer.start();

                }
            });

            timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (targetX == champion.getCenterX() && targetY == champion.getCenterY()) {
                        System.out.println("Stopped as same");
                        timer.stop();
                    }

                    long duration = System.currentTimeMillis() - startTime;
                    double progress = duration / runTime;

                    if (progress >= 1.0) {
                        System.out.println("Stopped out of time");
                        progress = 1.0;
                        timer.stop();
                    }

                    double x = (int) (startX + ((targetX - startX) * progress));
                    double y = (int) (startY + ((targetY - startY) * progress));

                    // x/y are the center points, need to adjust them so the shape
                    // moves about the center point
                    champion.setRect(x - 5, y - 5, 90, 90);
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1080, 720);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.draw(champion);
            if (path != null) {
                g2d.setColor(Color.black);
                g2d.draw(path);
            }
            g2d.dispose();
        }

        public void calculateChampionMovement(double x, double y, Rectangle champion) {

            if (x != champion.getCenterX() || y != champion.getCenterY()) {

                targetX = x;
                targetY = y;

                startX = champion.getCenterX();
                startY = champion.getCenterY();

                path = new Line2D.Double(
                                champion.getCenterX(),
                                champion.getCenterY(),
                                x, y);

                double distance = Math.sqrt(
                                (startX - targetX) * (startX - targetX)
                                + (startY - targetY) * (startY - targetY));

                runTime = distance / (double)speed;


                System.out.println(targetX);
                System.out.println(targetY);
                if(targetX>750){
                    finalizado=false;
                    tp.setVisible(false);
                    tp.remove(tp);
                    frame.dispose();
                    //System.exit(0);
                    tp.updateUI();
                    finalX = targetX;
                    finalY = targetY;
                }


            }
        }

        /*public void cordenadas (Rectangle champion){ 
            champion.getX();
            champion.getY();
        }*/
        public double getXfinal(){
            return champion.getX();
        }
        public double getYfinal(){
            return champion.getY();
        }
    }
}