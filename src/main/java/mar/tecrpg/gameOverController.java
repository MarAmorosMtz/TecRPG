package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class gameOverController {

    @FXML
    Button btn;

    @FXML
    private void reintentar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(firstController.class.getResource("/clase.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setResizable(false);
        Stage stg = (Stage) btn.getScene().getWindow();
        for (Window window : Window.getWindows()) {
            if (window instanceof Stage) {
                ((Stage) window).close();
            }
        }
        stg.close();
        stage.show();
    }
}
