package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import mar.tecrpg.attaks.Movimiento;
import mar.tecrpg.clases.Personaje;

import java.util.List;

public class ataquesController {

    private Personaje personaje;

    private List<Movimiento> movimientos;

    private StackPane stackPane;

    @FXML
    VBox vbox;

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
                attack(id);
            });

            hBox.getChildren().addAll(imageView, label, button);

            vbox.getChildren().add(hBox);

        }

    }

    public void attack(int id){
        System.out.println("Physical Damage: " + movimientos.get(id).getDamagefisico());
    }

    public void setPersonaje(Personaje personaje){
        this.personaje = personaje;
        this.movimientos = personaje.getMoves();
        cargarMoves();
    }

    public void setStackPane(StackPane stackPane) {
        this.stackPane = stackPane;
    }

}
