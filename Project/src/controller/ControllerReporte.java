package controller;

import EcoIsla.Admin;
import EcoIsla.SistemaReservas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.ImageView;

public class ControllerReporte {

    private SistemaReservas sistema;
    private Admin admin = new Admin("admin", "1234");

    @FXML
    private Button ButtonVolver;

    @FXML
    private TextArea LabelReporteDiario;

    public void setSistema(SistemaReservas sistema) {
        this.sistema = sistema;
        String texto = admin.verResumen(sistema);
        LabelReporteDiario.setText(texto);
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
        }
    }
}