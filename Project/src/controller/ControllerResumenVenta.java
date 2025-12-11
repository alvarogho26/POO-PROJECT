package controller;

import EcoIsla.SistemaReservas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerResumenVenta {

    private SistemaReservas sistema;

    @FXML
    private ImageView OlaBackground;

    @FXML
    private ImageView Icono;

    @FXML
    private Button ButtonRegresarMenu;

    @FXML
    private ImageView Imagentick;

    @FXML
    private Label LabelResumen;

    @FXML
    private Label LabelVentaExitosa;

    public void setDatos(SistemaReservas sistema, String textoResumen) {
        this.sistema = sistema;
        LabelResumen.setText(textoResumen);
    }

    @FXML
    void ActionButtonRegresarMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ventana.fxml")); 
            Parent root = loader.load();

            Controller controllerMenu = loader.getController();
            controllerMenu.setSistema(this.sistema);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar ventana.");
        }
    }
}