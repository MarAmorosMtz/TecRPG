package mar.tecrpg.attaks;

public class Volovan extends Movimiento{
    public Volovan(){
        super("Volovan", 0, 0, 100, 10);
        setDescripcion("Nombre: "+getNombre()+"     Cura: "+ getHeal() +"     Presicion: "+getAcurate());
        setIcon("src/main/resources/media/donVolo.jpg");
    }
}
