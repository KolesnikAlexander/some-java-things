package program.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;
import program.Main;
import program.Stages;
import program.model.MainModel;
import program.view.MainView;
import java.util.LinkedList;
import static program.model.MainModel.link;
import static program.model.MainModel.links;

/**
 * Created by alex60070
 */
public class AddLinkController {
    @FXML
    TextField nameField;

    @FXML
    public void okClick(MouseEvent event){
        if (nameField.getText().trim().length() <= 0) // all whitespaces
            return;
        addNameToLink();
        showLinkName();
        links.add(link);
        link = null;
        Stages.addLinkStage.close();
        MainView.graphLines = new LinkedList<>();
    }

    private void showLinkName() {
        double x = link.getLines().get(0).getStartX();
        double y = link.getLines().get(0).getStartY();
        MainView.showLinkName(nameField.getText(), x, y);
    }

    private void addNameToLink() {
        link.setName(nameField.getText());
    }

    @FXML
    public void cancelClick(MouseEvent event){
        cancel();
    }
    public static EventHandler<WindowEvent> onStageClose(){
        return new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                cancel();
            }
        };
    }

    public static void cancel(){
        ((Pane)Main.mainScene.getRoot()).getChildren()
                .removeAll(MainView.graphLines);
        Stages.addLinkStage.close();

        link = null;
    }

}
