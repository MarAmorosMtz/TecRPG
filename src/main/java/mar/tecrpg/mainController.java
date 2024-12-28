package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import mar.tecrpg.Enemies.Enemigo;
import mar.tecrpg.Enemies.Guardia;
import mar.tecrpg.Enemies.PinaOrtiz;
import mar.tecrpg.attaks.Movimiento;
import mar.tecrpg.clases.Personaje;

import java.io.IOException;
import java.util.List;

public class mainController {

    Personaje personaje;
    Enemigo enemy;

    List<Movimiento>  movimientos;

    int numeroenfrentamiento;

    @FXML
    Label stats, enfrentamiento, enemyStats;
    @FXML
    StackPane stack;
    @FXML
    ImageView enemyImage;

    mainController controlPrincipal;

    accionesController controller;

    infoController controlInfo;

    @FXML
    public void initialize() throws IOException {
        if (numeroenfrentamiento == 0){
            numeroenfrentamiento = 1;
        }
        enfrentamiento.setText("Enfrentamiento "+numeroenfrentamiento);

        cargarVista("/acciones.fxml");

        enemy = new Guardia();
        enemyImage.setFitHeight(350);
        enemyImage.setFitWidth(350);
        enemyImage.setPreserveRatio(true);
        String imageUrl = "file:" + enemy.getSprite();
        enemyImage.setImage(new Image(imageUrl));

        String stat = enemy.getNombre() + "     HP: " + enemy.getHp() + "     Def: " + enemy.getDefensa() + "     Evasion: " + enemy.getEvasion();
        enemyStats.setText(stat);

    }

    public void cargarVista(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent nuevaVista = loader.load();
        controller = loader.getController();
        stack.getChildren().setAll(nuevaVista);
    }

    public void setPersonaje(Personaje personaje){
        this.personaje = personaje;
        movimientos = personaje.getMoves();

        String stat = "Lvl: "+personaje.getNivel()+"     HP: "+personaje.getHp()+"     Exp: "+personaje.getExp();
        stats.setText(stat);

        controller.setStackPane(stack);
        controller.setPersonaje(personaje);
        controller.setNumero(numeroenfrentamiento);
        controller.setLabel(enfrentamiento);
        controller.setEnemigo(enemy);
        controller.setCharacterStats(stats);
        controller.setEnemyStats(enemyStats);
    }

    public  void setNumero(int numero){
        this.numeroenfrentamiento = numero;
    }

    public void updateEnemy() {
        if (numeroenfrentamiento % 5 == 0){
            // random boss
            this.enemy = new PinaOrtiz();
        }else{
            // random mob
            this.enemy = new Guardia();
        }
        enemyImage.setFitHeight(350);
        enemyImage.setFitWidth(350);
        enemyImage.setPreserveRatio(true);
        String imageUrl = "file:" + enemy.getSprite();
        enemyImage.setImage(new Image(imageUrl));
        String stat = enemy.getNombre() + "     HP: " + enemy.getHp() + "     Def: " + enemy.getDefensa() + "     Evasion: " + enemy.getEvasion();
        enemyStats.setText(stat);

        if (controller != null) {
            controller.setEnemigo(enemy);
        }
    }


    public void setControlPrincipal(mainController control){
        this.controlPrincipal = control;
        controller.setControlPrincipal(controlPrincipal);
    }

    public void setControlInfo(infoController control){
        this.controlInfo = control;
    }

    public void setInfo(String str){
        controlInfo.addInfo(str);
    }
}
