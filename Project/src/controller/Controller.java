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

public class Controller {

    private SistemaReservas sistema; 

    public void setSistema(SistemaReservas sistema){
        this.sistema = sistema;
    }

    @FXML
    private Button ButtonIniciarSesion;

    @FXML
    private Button ButtonViajesIngresar;

    @FXML
    private ImageView ImagePortada;

    @FXML
    private Label LabelEcoIslaDesc;

    @FXML
    private Label LabelPaginprincipal;

    @FXML
    private Label LabelQueEsEcoIsla;

    @FXML
    private Label LabelTitle;

    @FXML
    void ActionIniciarSesion(ActionEvent event) {

    }

    @FXML
    void ActionVerViajes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VentanaViajes.fxml"));
            Parent root = loader.load();

            ControllerViajes controllerViajes = loader.getController();
            controllerViajes.setSistema(this.sistema);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
            System.out.println("error al cargar la ventana");
        }
    }

}
