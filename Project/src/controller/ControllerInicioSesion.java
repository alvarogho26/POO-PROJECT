package controller;

import java.io.IOException;

import EcoIsla.Admin;
import EcoIsla.SistemaReservas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerInicioSesion {

    private SistemaReservas sistema;
    private Admin admin = new Admin("admin", "roblos");

    public void setSistema(SistemaReservas sistema) {
        this.sistema = sistema;
    }

    @FXML
    private Button ButtonIniciarSesion;

    @FXML
    private Button ButtonVolver;

    @FXML
    private Label LAbelContraseña;

    @FXML
    private Label LabelTitleInicioSesion;

    @FXML
    private Label LabelUsuario;

    @FXML
    private PasswordField PasswordFieldAdminContraseña;

    @FXML
    private TextField TextfieldAdminNombre;

    @FXML
    void ActionIniciarSesion(ActionEvent event) {
        String usuario = TextfieldAdminNombre.getText();
        String password = PasswordFieldAdminContraseña.getText();

        if (admin.iniciarSesion(usuario, password)) {
            irAZonaAdmin(event);
        } else {
            mostrarAlerta("No se pudo ingresar", "Nombre de usuario o contraseña incorrectos.");
        }

    }

    @FXML
    void ActionVolver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ventana.fxml")); 
            Parent root = loader.load();

            Controller controller = loader.getController();
            controller.setSistema(this.sistema);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar ventana.");
        }
    }

    private void irAZonaAdmin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VentanaReporte.fxml"));
            Parent root = loader.load();

            ControllerReporte controller = loader.getController();

            controller.setSistema(this.sistema);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar ventana");
        }
    }
    
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

}
