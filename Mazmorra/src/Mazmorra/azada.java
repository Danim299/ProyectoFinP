
package Mazmorra;
public class azada {
    private int ataque;
    private int durabilidad;
    private String nombre="Azada de hierro";
    public int getAtaque() {
        return ataque;
    }
    public int getDurabilidad() {
        return durabilidad;
    }
    public azada(int ataque, int durabilidad) {
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
