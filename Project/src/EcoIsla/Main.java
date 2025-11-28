package EcoIsla;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        SistemaReservas sistema = new SistemaReservas();
        sistema.cargarDatos();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ventana.fxml")); 
        Parent root = loader.load();

        Controller controller = loader.getController();
        controller.setSistema(sistema);

        primaryStage.setTitle("EcoIsla Viajes");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}