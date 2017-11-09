package program.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import program.Settings;
import program.entity.Link;
import program.model.MainModel;
import program.view.MainView;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static program.Settings.LINKS_FILE_PATH;
import static program.model.MainModel.leftClickModel;
import static program.Settings.SCHEME_IMG_PATH;

/**
 * Created by alex60070
 */
public class MainController implements Initializable{
    @FXML
    ImageView bgrImg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //InputStream img = getClass().getResourceAsStream(SCHEME_IMG_PATH);
        InputStream img = null;
        try {
            img = new FileInputStream(SCHEME_IMG_PATH);
        } catch (FileNotFoundException e) {
            System.out.println("Image file not found (scheme.png)");
            System.exit(0);
        }
        bgrImg.setImage(new Image(img));
    }

    @FXML
    public void clickController(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY))
            leftClickModel(mouseEvent);

    }

    @FXML
    public void mouseMoveController(MouseEvent mouseEvent) {
        MainView.mouseMoveView(mouseEvent);
    }

    public static void initKeyControllers(Scene scene){
        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                enterReleasedController();
            }
        });
    }

    @FXML
    public void saveClick(MouseEvent mouseEvent) {
        createFile();
        try {
            FileOutputStream out = new FileOutputStream(LINKS_FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(MainModel.links);
            oos.flush();
        } catch (Exception e) {
            System.out.println("Problem serializing: " + e);
        }
        System.out.println("Links serialized");
        //deserialize();
    }

    private void deserialize() {
        List<Link> links = null;
        try {
            FileInputStream in = new FileInputStream(LINKS_FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(in);
            links = (List<Link>) (ois.readObject());
        } catch (Exception e) {
            System.out.println("Problem deserializing: " + e);
        }

        System.out.println("DESERIALIZED: " + links);
    }

    private void createFile() {
        File f = new File(Settings.LINKS_FILE_PATH);
        if (!f.exists()) {
            PrintWriter out = null;
            try {
                out = new PrintWriter(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }

    private static void enterReleasedController() {
        MainModel.spaceReleasedModel();
        //System.out.println("EnterReleasedController: "+MainModel.links);
    }

    public EventHandler<MouseEvent> lineClickController = event -> clickController(event);
    public EventHandler<MouseEvent> lineMoveController = event -> mouseMoveController(event);

}
