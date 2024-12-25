package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mar.tecrpg.clases.GymBro;
import mar.tecrpg.clases.IngeSistemas;
import mar.tecrpg.clases.Personaje;

import java.io.IOException;

public class clasesController {

    @FXML
    Button btn;

    private Personaje personaje;

    @FXML
    private void Sistemas() throws IOException {
        personaje = new IngeSistemas();
        jugar();
    }

    @FXML
    private void GymBro() throws IOException {
        personaje = new GymBro();
        jugar();
    }

    private void jugar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(firstController.class.getResource("/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setResizable(false);
        Stage stg = (Stage) btn.getScene().getWindow();
        mainController controller = fxmlLoader.getController();
        controller.setPersonaje(personaje);
        stg.close();
        stage.show();
    }
}
