package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import mar.tecrpg.clases.Personaje;

import java.io.IOException;
import java.util.Random;

public class accionesController {

    @FXML
    Button btn;

    private StackPane stackPane;

    private Personaje personaje;

    private Label label;

    private int numero;

    Random random = new Random();

    ataquesController controller;

    public void setStackPane(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public void setPersonaje(Personaje personaje){
        this.personaje = personaje;
    }

    public void setLabel(Label label){
        this.label = label;
    }

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
        stackPane.getChildren().setAll(nuevaVista);
    }

    @FXML
    private void huir() throws IOException{

        int dexEnemigo = 6; //enemigo.getDestreza();
        int dexPlayer = personaje.getDestreza();
        int n;

        if(dexEnemigo < dexPlayer){
            n = 1;
        }else{
            n = random.nextInt(2) + 1;
        }

        if(n == 1){
            numero++;
            label.setText("Enfrentamiento "+numero);
            System.out.println("huiste");
        }else {
            System.out.println("no huiste");
        }

    }


}
