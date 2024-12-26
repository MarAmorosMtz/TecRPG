package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mar.tecrpg.Enemies.Enemigo;
import mar.tecrpg.attaks.Movimiento;
import mar.tecrpg.clases.Personaje;

import java.io.IOException;
import java.util.List;

public class ataquesController {

    private Personaje personaje;
    private Enemigo enemigo;

    private List<Movimiento> movimientos;

    private StackPane stackPane;

    private Label enemyStats, characterStats;

    accionesController controller;

    mainController control;

    private int numero;

    @FXML
    VBox vbox;

    public void setEnemyStats(Label label){ this.enemyStats = label; }

    public void setCharacterStats(Label label){ this.characterStats = label; }

    public void setNumero(int numero){
        this.numero = numero;
    }

    private void cargarMoves(){

        for(int i = 0; i < movimientos.size(); i++){

            HBox hBox = new HBox();
            hBox.setAlignment(javafx.geometry.Pos.CENTER);
            hBox.setSpacing(20);
            hBox.setPrefHeight(100);
            hBox.setPrefWidth(200);
            hBox.getStyleClass().add("hboxPersonaje");

            ImageView imageView = new ImageView();
            imageView.setFitHeight(70);
            imageView.setFitWidth(72);
            imageView.setPreserveRatio(true);
            String imageUrl = "file:" + movimientos.get(i).getIcon();
            imageView.setImage(new Image(imageUrl));

            Label label = new Label(movimientos.get(i).getDescripcion());
            label.setTextFill(javafx.scene.paint.Color.WHITE);
            label.setWrapText(true);
            label.setStyle("-fx-font-family: 'Baskerville Old Face'; -fx-font-size: 20;");

            Button button = new Button("Usar");
            button.setPrefHeight(40);
            button.setPrefWidth(113);
            button.setTextFill(javafx.scene.paint.Color.RED);
            button.setStyle("-fx-font-family: 'Baskerville Old Face'; -fx-font-size: 18;");
            int id = i;
            button.setOnAction(event -> {
                try {
                    attack(id);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            hBox.getChildren().addAll(imageView, label, button);

            vbox.getChildren().add(hBox);

        }

    }

    public void attack(int id) throws IOException {
        int damageDeal = enemigo.takeDamage(personaje.dealDamage(id));
        if(damageDeal == 0){
            System.out.println("Tu ataque fallo");
        }else {
            System.out.println("Tu ataque le hizo " + damageDeal + " de daño al enemigo.");
            updateEnemyStats();
        }

        int damageTaken = personaje.takeDamage(enemigo.dealDamage());
        if(damageTaken == 0){
            System.out.println("El ataque enemigo fallo");
        }else {
            System.out.println("El enemigo te hizo " + damageTaken + " de daño.");
            updateCharacterStats();
        }
        updateCharacterStats();
        updateEnemyStats();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/acciones.fxml"));
        Parent nuevaVista = loader.load();
        controller = loader.getController();
        controller.setStackPane(stackPane);
        controller.setPersonaje(personaje);
        controller.setCharacterStats(characterStats);
        controller.setEnemyStats(enemyStats);
        controller.setEnemigo(enemigo);
        controller.setNumero(numero);
        stackPane.getChildren().setAll(nuevaVista);
    }

    public void setPersonaje(Personaje personaje){
        this.personaje = personaje;
        this.movimientos = personaje.getMoves();
        cargarMoves();
    }

    public void setEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
    }

    public void setStackPane(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    private void updateCharacterStats() throws IOException {
        if(personaje.getHp() <= 0){
            FXMLLoader fxmlLoader = new FXMLLoader(firstController.class.getResource("/gameOver.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setMaximized(false);
            stage.setResizable(false);
            Stage stg = (Stage) vbox.getScene().getWindow();
            stg.close();
            stage.show();
        }
        String stat = "Lvl: "+personaje.getNivel()+"     HP: "+personaje.getHp()+"     Exp: "+personaje.getExp();
        characterStats.setText(stat);
    }

    private void updateEnemyStats() throws IOException {
        if(enemigo.getHp() <= 0){
            personaje.expUp(enemigo.getXp());
            numero++;

            FXMLLoader fxmlLoader = new FXMLLoader(firstController.class.getResource("/main.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            control = fxmlLoader.getController();
            control.setNumero(numero);
            control.setPersonaje(personaje);
            stage.setMaximized(false);
            stage.setResizable(false);
            Stage stg = (Stage) vbox.getScene().getWindow();
            stg.close();
            stage.show();

        }
        String stat = enemigo.getNombre() + "     HP: " + enemigo.getHp() + "     Def: " + enemigo.getDefensa() + "     Evasion: " + enemigo.getEvasion();
        enemyStats.setText(stat);
    }

}
