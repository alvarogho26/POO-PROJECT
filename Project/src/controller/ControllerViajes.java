package controller;


import EcoIsla.Embarcacion;
import EcoIsla.SistemaReservas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerViajes {


    private SistemaReservas sistema;

    public void setSistema(SistemaReservas sistema){
        this.sistema = sistema;
        inicializarDatos(); 
    }

    private void inicializarDatos(){

        for (Embarcacion e : sistema.getEmbarcaciones()){
            if (e != null){
                ComboBoxEmbarcaciones.getItems().add(e.getNombre());
            }
        }

        ComboBoxHorarios.getItems().addAll("Matutino", "Mediodia", "Vespertino");
    }

    @FXML
    private Button ButtonVerAsientos;

    @FXML
    private ComboBox<String> ComboBoxEmbarcaciones;

    @FXML
    private ComboBox<String> ComboBoxHorarios;

    @FXML
    private Label LabelEmbarcacion;

    @FXML
    private Label LabelHorario;

    @FXML
    private Label LabelSelecciona;
    
    @FXML
    private Label LabelTitleViajes;

    @FXML
    void ActionComboBoxEmbarcaciones(ActionEvent event) {
    }

    @FXML
    void ActionComboBoxHorarios(ActionEvent event) {
    }

    @FXML
    void ActionVerASientos(ActionEvent event) {

        String nombreBarco = ComboBoxEmbarcaciones.getValue();
        String nombreHorario = ComboBoxHorarios.getValue();
        int idEmbarcacion = sistema.buscarEmbarcacion(nombreBarco);

        int idHorario = -1;
        switch (nombreHorario){
            case "Matutino": idHorario = 0; break;
            case "Mediodia": idHorario = 1; break;
            case "Vespertino": idHorario = 2; break;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VentanaAsientosComprar.fxml"));
            Parent root = loader.load();
            ControllerComprarAsientos controller = loader.getController();

            controller.cargarDatosReserva(this.sistema, idEmbarcacion, idHorario);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error al cargar ventana");
        }
    }

}