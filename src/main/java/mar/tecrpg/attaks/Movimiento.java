package mar.tecrpg.attaks;

public class Movimiento {
    private int damageesp, damagefisico, acurate, heal;
    private String icon, descripcion, nombre;

    public Movimiento(String nombre, int damageesp, int damagefisico, int acurate, int heal){
        this.nombre = nombre;
        this.damageesp = damageesp;
        this.damagefisico = damagefisico;
        this.acurate = acurate;
        this.heal = heal;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getNombre(){ return nombre; }

    public String getIcon(){ return icon; }

    public void setIcon(String icon){ this.icon = icon; }

    public int getDamageesp(){
        return damageesp;
    }

    public int getDamagefisico(){
        return damagefisico;
    }

    public int getAcurate(){
        return acurate;
    }

    public int getHeal(){
        return heal;
    }
}
