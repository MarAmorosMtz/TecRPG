package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class infoController {
    @FXML
    Label infoLabel;

    public void addInfo(String str){
        infoLabel.setText(infoLabel.getText() + "\n\n" + str);
    }
}
