package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Haroun
 */
public class PiSquadEsprit extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root3 = FXMLLoader.load(getClass().getResource("/bemyguest/gui/Login.fxml"));
        Scene scene3 = new Scene(root3);
        scene3.getStylesheets().add("/bemyguset/resource/style.css");
        stage.setScene(scene3);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
