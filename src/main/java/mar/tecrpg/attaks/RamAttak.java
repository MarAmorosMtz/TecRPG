package mar.tecrpg.attaks;

public class RamAttak extends Movimiento{
    public RamAttak(){
        super("RamAttack", 10, 4, 100, 0);
        setDescripcion("Nombre: "+getNombre()+"      Daño especial: "+getDamageesp()+"      Daño fisico: "+getDamagefisico()+"      Presicion: "+getAcurate());
        setIcon("src/main/resources/media/lapfire.png");
    }
}
