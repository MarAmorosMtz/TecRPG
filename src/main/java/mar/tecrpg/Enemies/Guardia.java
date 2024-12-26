package mar.tecrpg.Enemies;

import mar.tecrpg.attaks.CredencialJoven;

public class Guardia extends  Enemigo{
    public Guardia(){
        super("Guardia", 25,5, 5, 40, "src/main/resources/media/guardia1.jpg" );
        CredencialJoven credencialJoven = new CredencialJoven();
        addMov(credencialJoven);
    }
}
