package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mar.tecrpg.Enemies.Enemigo;
import mar.tecrpg.clases.Personaje;

import java.io.IOException;
import java.util.Random;

public class accionesController {

    @FXML
    Button btn;

    private StackPane stackPane;

    private Personaje personaje;
    private Enemigo enemigo;

    private Label label;

    private Label enemyStats, characterStats;

    private int numero;

    Random random = new Random();

    ataquesController controller;

    mainController controlPrincipal;

    public void setStackPane(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public void setPersonaje(Personaje personaje){
        this.personaje = personaje;
    }

    public void setEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
    }

    public void setLabel(Label label){
        this.label = label;
    }

    public void setEnemyStats(Label label){ this.enemyStats = label; }

    public void setCharacterStats(Label label){ this.characterStats = label; }

    public void setNumero(int numero){
        this.numero = numero;
    }

    @FXML
    private void atacar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ataques.fxml"));
        Parent nuevaVista = loader.load();
        controller = loader.getController();
        controller.setStackPane(stackPane);
        controller.setPersonaje(personaje);
        controller.setCharacterStats(characterStats);
        controller.setEnemyStats(enemyStats);
        controller.setEnemigo(enemigo);
        controller.setNumero(numero);
        controller.setEnfrentamiento(label);
        controller.setControlPrincipal(controlPrincipal);
        stackPane.getChildren().setAll(nuevaVista);
    }

    @FXML
    private void huir() throws IOException {
        int enemyEvasion = enemigo.getEvasion();
        int playerEvasion = personaje.getEvasion();
        int n;

        if (enemyEvasion < playerEvasion) {
            n = 1;
        } else {
            n = random.nextInt(2) + 1;
        }

        if (n == 1) {
            numero++;
            label.setText("Enfrentamiento " + numero);
            System.out.println("huiste");

            // Actualizar enemigo en el controlador principal
            controlPrincipal.setNumero(numero);
            controlPrincipal.updateEnemy();

            // Actualizar la referencia del nuevo enemigo en este controlador
            this.enemigo = controlPrincipal.enemy;
        } else {
            int damage = personaje.takeDamage(enemigo.dealDamage());
            System.out.println("no huiste.");
            if (damage == 0) {
                System.out.println("El ataque falló");
            } else {
                System.out.println("El enemigo te hizo " + damage + " de daño.");
                updateCharacterStats();
            }
        }
    }


    private void updateCharacterStats() throws IOException {
        String stat = "Lvl: "+personaje.getNivel()+"     HP: "+personaje.getHp()+"     Exp: "+personaje.getExp();
        characterStats.setText(stat);
        if(personaje.getHp() <= 0){
            FXMLLoader fxmlLoader = new FXMLLoader(firstController.class.getResource("/gameOver.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setMaximized(false);
            stage.setResizable(false);
            Stage stg = (Stage) btn.getScene().getWindow();
            stg.close();
            stage.show();
        }
    }

    public void setControlPrincipal(mainController control){
        this.controlPrincipal = control;
    }


}
