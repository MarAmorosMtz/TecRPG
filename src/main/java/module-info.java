module mar.tecrpg {
    requires javafx.controls;
    requires javafx.fxml;


    opens mar.tecrpg to javafx.fxml;
    exports mar.tecrpg;
}