package mar.tecrpg.clases;

import mar.tecrpg.attaks.RamAttak;

public class IngeSistemas extends Personaje{
    public IngeSistemas(){
        super(15, 4, 4, 12, 8, 6);
        RamAttak ramAttak = new RamAttak();
        addMov(ramAttak);
    }
}
