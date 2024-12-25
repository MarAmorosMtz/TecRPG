package mar.tecrpg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import mar.tecrpg.attaks.Movimiento;
import mar.tecrpg.clases.Personaje;

import java.io.IOException;
import java.util.List;

public class mainController {

    Personaje personaje;

    List<Movimiento>  movimientos;

    int numeroenfrentamiento;

    @FXML
    Label stats, enfrentamiento;
    @FXML
    StackPane stack;

    accionesController controller;

    @FXML
    public void initialize() throws IOException {
        numeroenfrentamiento = 1;
        enfrentamiento.setText("Enfrentamiento "+numeroenfrentamiento);
        cargarVista("/acciones.fxml");
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
    }
}
