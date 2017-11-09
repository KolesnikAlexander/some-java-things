package program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import program.controller.MainController;

public class Main extends Application {
    public static Pane root;
    public static Scene mainScene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("/res/main.fxml"));

        primaryStage.setTitle("Scheme editor");
        primaryStage.setResizable(false);

        Scene scene = new Scene(root, 850, 650);

        MainController.initKeyControllers(scene);

        primaryStage.setScene(scene);
        primaryStage.show();

        mainScene = primaryStage.getScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
