package mar.tecrpg.Enemies;

import mar.tecrpg.attaks.Movimiento;

public class Enemigo {
    private int hp, evasion, defensa, xp;
    private String nombre, sprite;

    public Enemigo(String nombre, int hp, int evasion, int defensa, int xp, String sprite){
        this.nombre = nombre;
        this.hp = hp;
        this.evasion = evasion;
        this.defensa = defensa;
        this.xp = xp;
        this.sprite = sprite;
    }

    private int getHp(){ return hp; }

    private int getEvasion(){ return evasion; }

    private int getDefensa(){ return defensa; }

    private int getXp(){ return xp; }

    private String getNombre(){ return nombre; }

    private String getSprite(){ return sprite; }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public boolean takeDamage(Movimiento mov){
        return true;
    }

    public void dealDamage(){}

}
