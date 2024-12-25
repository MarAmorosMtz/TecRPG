package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class firstController {

    @FXML
    Button btn;

    @FXML
    private void entrar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(firstController.class.getResource("/clase.fxml"));
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