package mar.tecrpg.clases;

import mar.tecrpg.attaks.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class Personaje {
    private int nivel, inteligencia, fuerza, destreza, fe, vitalidad, exp, hp, expmax, evasion, defensa;

    private List<Movimiento> movimientos = new ArrayList<>();

    public Personaje(int inteligencia, int fuerza, int fe, int vitalidad, int evasion, int defensa){
        nivel = 1;
        exp = 0;
        expmax = 25;
        hp = vitalidad * 2;
        this.inteligencia = inteligencia;
        this.fuerza = fuerza;
        //this.destreza = destreza;
        this.fe = fe;
        this.vitalidad = vitalidad;
        this.evasion = evasion;
        this.defensa = defensa;
    }

    public void addMov(Movimiento movimiento){
        if(movimientos.size() <= 3){
            movimientos.add(movimiento);
        }
    }

    public List<Movimiento> getMoves(){
        return movimientos;
    }

    public int getNivel(){ return nivel;  }

    public int getInteligencia(){ return inteligencia;  }

    public int getFuerza(){ return fuerza; }

    public int getEvasion(){ return evasion; }

    public int getDefensa(){ return defensa; }

    public int getDestreza(){ return destreza; }

    public int getFe(){ return fe; }

    public int getVitalidad(){ return vitalidad; }

    public int getExp(){ return exp; }

    public int getHp(){ return hp; }

    public void setInteligencia(int inteligencia){ this.inteligencia = inteligencia; }

    public void setFuerza(int fuerza){ this.fuerza = fuerza; }

    public void setEvasion(int evasion){ this.evasion = evasion; }

    public void setDefensa(int defensa){ this.defensa = defensa; }

    public void setDestreza(int destreza){ this.destreza = destreza; }

    public void setFe(int fe){ this.fe = fe; }

    public void setVitalidad(int vitalidad){ this.vitalidad = vitalidad; }

    public void setExp(int exp){ this.exp = exp; }

    public void setHP(int hp){ this.hp = hp; }

    public void dealDamage(int id){}

    public void takeDamage(){}

    public void levelUp(){
        nivel++;
        setExp(0);
        expmax += 10;
        if(nivel < 20){
            vitalidad += 3;
        }else{
            vitalidad += 1;
        }
        hp = vitalidad * 2;
    }

    public void expUp(int exp){
        int temp = this.exp + exp;
        if((temp) >= expmax){
            temp -= expmax;
        }
        levelUp();
        setExp(temp);
    }

}
