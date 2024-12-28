package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mar.tecrpg.clases.GymBro;
import mar.tecrpg.clases.IngeSistemas;
import mar.tecrpg.clases.Personaje;

import java.io.IOException;

public class clasesController {

    @FXML
    Button btn;

    private Personaje personaje;

    infoController controlInfo;

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
        // Cargar y mostrar main.fxml
        FXMLLoader mainLoader = new FXMLLoader(firstController.class.getResource("/main.fxml"));
        Scene mainScene = new Scene(mainLoader.load());
        Stage mainStage = new Stage();
        mainStage.setScene(mainScene);
        mainStage.setMaximized(false);
        mainStage.setResizable(false);

        mainStage.centerOnScreen();

        mainController controller = mainLoader.getController();
        controller.setPersonaje(personaje);
        controller.setControlPrincipal(controller);


        FXMLLoader infoLoader = new FXMLLoader(firstController.class.getResource("/info.fxml"));
        Scene infoScene = new Scene(infoLoader.load());
        Stage infoStage = new Stage(StageStyle.UTILITY);
        infoStage.setScene(infoScene);
        infoStage.setResizable(false);
        infoStage.setTitle("Información");

        controlInfo = infoLoader.getController();
        controller.setControlInfo(controlInfo);


        infoStage.setX(mainStage.getX() + mainScene.getWidth() + 10);
        infoStage.setY(mainStage.getY() - 20);

        // Cerrar la ventana actual
        Stage currentStage = (Stage) btn.getScene().getWindow();
        currentStage.close();

        // Mostrar ambas ventanas
        mainStage.show();
        infoStage.show();
    }


}
