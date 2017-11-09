package program;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import program.controller.AddLinkController;

import java.io.IOException;

/**
 * Created by alex60070
 */
public class Stages {

    public static Stage addLinkStage;
    public static Scene addLinkScene;

public static void runAddLinkStage() {
    Parent root;
    try {
        root = FXMLLoader.load(new Stages().getClass().getClassLoader().getResource("res/addLink.fxml"));
        addLinkStage = new Stage();
        addLinkStage.setTitle("Set name");

        addLinkStage.setOnCloseRequest(AddLinkController.onStageClose());

        addLinkScene = new Scene(root);

        addLinkStage.setScene(addLinkScene);
        addLinkStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
