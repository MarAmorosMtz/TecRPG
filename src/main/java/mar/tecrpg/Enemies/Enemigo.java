package mar.tecrpg.Enemies;

import mar.tecrpg.attaks.Movimiento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemigo {

    private int hp, evasion, defensa, xp;
    private String nombre, sprite;

    private Random random = new Random();

    private List<Movimiento> movimientos = new ArrayList<>();

    public Enemigo(String nombre, int hp, int evasion, int defensa, int xp, String sprite){
        this.nombre = nombre;
        this.hp = hp;
        this.evasion = evasion;
        this.defensa = defensa;
        this.xp = xp;
        this.sprite = sprite;
    }

    public void addMov(Movimiento movimiento){
        if(movimientos.size() <= 3){
            movimientos.add(movimiento);
        }
    }

    public List<Movimiento> getMoves(){
        return movimientos;
    }

    public int getHp(){ return hp; }

    public int getEvasion(){ return evasion; }

    public int getDefensa(){ return defensa; }

    public int getXp(){ return xp; }

    public String getNombre(){ return nombre; }

    public String getSprite(){ return sprite; }

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

    public int takeDamage(Movimiento mov){
        int damagePhysical = (int)(mov.getDamagefisico() - (Double)(this.defensa * 0.2));
        int damageSpecial = (int)(mov.getDamageesp() - (Double)(this.defensa * 0.2));
        int damageTotal = damagePhysical + damageSpecial;

        if(mov.getAcurate() > this.evasion){
            this.hp -= damageTotal;
            return damageTotal;
        }
        return 0;
    }

    public Movimiento dealDamage(){
        int i = random.nextInt(movimientos.size()) ;
        return movimientos.get(i);
    }

}
