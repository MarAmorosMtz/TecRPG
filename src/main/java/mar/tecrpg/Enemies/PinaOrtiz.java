package mar.tecrpg.Enemies;

import mar.tecrpg.attaks.Reprobaste;

public class PinaOrtiz extends Enemigo{
    public PinaOrtiz(){
        super("Piña", 100, 20, 20, 100, "src/main/resources/media/pinia.jpg");
        Reprobaste reprobaste = new Reprobaste();
        addMov(reprobaste);
    }
}
