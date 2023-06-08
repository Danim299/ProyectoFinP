package Mazmorra;

public class espada {
    private int ataque;
    private int durabilidad;
    private String nombre = "Espada Runica";
    public int getAtaque() {
        return ataque;
    }
    public int getDurabilidad() {
        return durabilidad;
    }
    public espada(int ataque, int durabilidad) {
        this.ataque = ataque;
        this.durabilidad = durabilidad;
    }
    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }
    public String getNombre() {
        return nombre;
    }
     
}
