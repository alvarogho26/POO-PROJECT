package controller;

import java.io.IOException;

import EcoIsla.Cliente;
import EcoIsla.SistemaReservas;
import EcoIsla.Venta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;


public class ControllerComprarAsientos {

    private SistemaReservas sistema;
    private int idEmbarcacion;
    private int horario;
    private String[] asientosSeleccionados = new String[25]; 
    private int contadorSeleccionados = 0;
    private ToggleButton[][] matrizBotones;

    @FXML
    private ImageView OlaBackground;

    @FXML
    private ImageView Icono;

    @FXML
    private Button ButtonComprar;

    @FXML
    private Label LabelIngreseSuNombre;

    @FXML
    private Label LabelPrecios;

    @FXML
    private Label LabelTitleAsientos;

    @FXML
    private TextField TextFieldNombre;

    @FXML
    private ToggleButton buttonA1;

    @FXML
    private ToggleButton buttonA2;

    @FXML
    private ToggleButton buttonA3;

    @FXML
    private ToggleButton buttonA4;

    @FXML
    private ToggleButton buttonA5;

    @FXML
    private ToggleButton buttonB1;

    @FXML
    private ToggleButton buttonB2;

    @FXML
    private ToggleButton buttonB3;

    @FXML
    private ToggleButton buttonB4;

    @FXML
    private ToggleButton buttonB5;

    @FXML
    private ToggleButton buttonC1;

    @FXML
    private ToggleButton buttonC2;

    @FXML
    private ToggleButton buttonC3;

    @FXML
    private ToggleButton buttonC4;

    @FXML
    private ToggleButton buttonC5;

    @FXML
    private ToggleButton buttonD1;

    @FXML
    private ToggleButton buttonD2;

    @FXML
    private ToggleButton buttonD3;

    @FXML
    private ToggleButton buttonD4;

    @FXML
    private ToggleButton buttonD5;

    @FXML
    private ToggleButton buttonE1;

    @FXML
    private ToggleButton buttonE2;

    @FXML
    private ToggleButton buttonE3;

    @FXML
    private ToggleButton buttonE4;

    @FXML
    private ToggleButton buttonE5;

    @FXML
    void ActionA1(ActionEvent event) {
        gestionarClick(buttonA1);
    }

    @FXML
    void ActionA2(ActionEvent event) {
        gestionarClick(buttonA2);
    }

    @FXML
    void ActionA3(ActionEvent event) {
        gestionarClick(buttonA3);
    }

    @FXML
    void ActionA4(ActionEvent event) {
        gestionarClick(buttonA4);
    }

    @FXML
    void ActionA5(ActionEvent event) {
        gestionarClick(buttonA5);
    }

    @FXML
    void ActionB1(ActionEvent event) {
        gestionarClick(buttonB1);
    }

    @FXML
    void ActionB2(ActionEvent event) {
        gestionarClick(buttonB2);
    }

    @FXML
    void ActionB3(ActionEvent event) {
        gestionarClick(buttonB3);
    }

    @FXML
    void ActionB4(ActionEvent event) {
        gestionarClick(buttonB4);
    }

    @FXML
    void ActionB5(ActionEvent event) {
        gestionarClick(buttonB5);
    }

    @FXML
    void ActionC1(ActionEvent event) {
        gestionarClick(buttonC1);
    }

    @FXML
    void ActionC2(ActionEvent event) {
        gestionarClick(buttonC2);
    }

    @FXML
    void ActionC3(ActionEvent event) {
        gestionarClick(buttonC3);
    }

    @FXML
    void ActionC4(ActionEvent event) {
        gestionarClick(buttonC4);
    }

    @FXML
    void ActionC5(ActionEvent event) {
        gestionarClick(buttonC5);
    }

    @FXML
    void ActionD1(ActionEvent event) {
        gestionarClick(buttonD1);
    }

    @FXML
    void ActionD2(ActionEvent event) {
        gestionarClick(buttonD2);
    }

    @FXML
    void ActionD3(ActionEvent event) {
        gestionarClick(buttonD3);
    }

    @FXML
    void ActionD4(ActionEvent event) {
        gestionarClick(buttonD4);
    }

    @FXML
    void ActionD5(ActionEvent event) {
        gestionarClick(buttonD5);
    }

    @FXML
    void ActionE1(ActionEvent event) {
        gestionarClick(buttonE1);
    }

    @FXML
    void ActionE2(ActionEvent event) {
        gestionarClick(buttonE2);
    }

    @FXML
    void ActionE3(ActionEvent event) {
        gestionarClick(buttonE3);
    }

    @FXML
    void ActionE4(ActionEvent event) {
        gestionarClick(buttonE4);
    }

    @FXML
    void ActionE5(ActionEvent event) {
        gestionarClick(buttonE5);
    }


    @FXML
    void ActionVolver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VentanaViajes.fxml")); 
            Parent root = loader.load();

            ControllerViajes controller = loader.getController();
            controller.setSistema(this.sistema);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al regresar a la ventana anterior.");
        }
    }

    @FXML
    void ActionComprar(ActionEvent event) {

        String nombre = TextFieldNombre.getText().trim();
        if (nombre.isEmpty()) {
            mostrarAlerta("Falta Nombre", "Por favor ingrese su nombre.");
            return;
        }

        if (contadorSeleccionados == 0) {
            mostrarAlerta("Sin asientos", "Por favor, seleccione mínimo un asiento.");
            return;
        }

        String[] asientosParaVender = new String[contadorSeleccionados];
        int idx = 0;
        for (String s : asientosSeleccionados) {
            if (s != null) {
                asientosParaVender[idx] = s;
                idx++;
            }
        }

        Cliente cliente = new Cliente(nombre);
        boolean exito = sistema.venderPasajes(idEmbarcacion, horario, asientosParaVender, cliente);

        if (exito) {
            String nombreBarco = sistema.getEmbarcaciones()[idEmbarcacion].getNombre();
            EcoIsla.Venta ventaTemp = new EcoIsla.Venta(cliente, nombreBarco, idEmbarcacion, horario, asientosParaVender);
            String texto = ventaTemp.resumenVenta();
            abrirVentanaResumen(event, texto);
        }

        
    }

    private void mostrarAlerta(String titulo, String contenido){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public void cargarDatosReserva(SistemaReservas sistema, int idEmbarcacion, int horario){
        this.sistema = sistema;
        this.idEmbarcacion = idEmbarcacion;
        this.horario = horario;

        matrizBotones = new ToggleButton[][]{
            {buttonA1, buttonA2, buttonA3, buttonA4, buttonA5},
            {buttonB1, buttonB2, buttonB3, buttonB4, buttonB5},
            {buttonC1, buttonC2, buttonC3, buttonC4, buttonC5},
            {buttonD1, buttonD2, buttonD3, buttonD4, buttonD5},
            {buttonE1, buttonE2, buttonE3, buttonE4, buttonE5}
        };

        pintarOcupados();
    }

    private void pintarOcupados(){
        int[][] ocupacion = sistema.obtenerMatriz(idEmbarcacion, horario);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (ocupacion[i][j] == 1) {
                    matrizBotones[i][j].setDisable(true);
                    matrizBotones[i][j].setStyle("-fx-background-color: #ffcccc; -fx-opacity: 1;");
                    matrizBotones[i][j].setSelected(false);
                } else {
                    matrizBotones[i][j].setDisable(false);
                    matrizBotones[i][j].setStyle("");
                }
            }
        }
    }

    private void gestionarClick(ToggleButton btn) {
        String etiqueta = btn.getText(); 

        if (btn.isSelected()) {
            for (int i = 0; i < asientosSeleccionados.length; i++) {
                if (asientosSeleccionados[i] == null) {
                    asientosSeleccionados[i] = etiqueta;
                    contadorSeleccionados++;
                    btn.setStyle("-fx-background-color: green;");
                    break;
                }
            }
        } else {
            for (int i = 0; i < asientosSeleccionados.length; i++) {
                if (asientosSeleccionados[i] != null && asientosSeleccionados[i].equals(etiqueta)) {
                    asientosSeleccionados[i] = null;
                    contadorSeleccionados--;
                    break;
                }
            }
            btn.setStyle("");
        }
    }

    private void abrirVentanaResumen(ActionEvent event, String resumen) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VentanaResumenVenta.fxml")); // Asegúrate que el nombre coincida
            Parent root = loader.load();

            ControllerResumenVenta controller = loader.getController();
            
            controller.setDatos(this.sistema, resumen);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la ventana de Resumen.");
        }
    }
}
