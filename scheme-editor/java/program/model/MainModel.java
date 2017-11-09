package program.model;

import javafx.scene.input.MouseEvent;
import program.Stages;
import program.entity.Line;
import program.entity.Link;
import program.Main;
import program.view.MainView;
import program.controller.AddLinkController;

import java.util.LinkedList;
import java.util.List;

import static program.view.MainView.possibleLine;

/**
 * Created by alex60070
 */
public class MainModel {

    public static Line line;
    public static Link link;
    public static List<Link> links = new LinkedList<>();

    public static void leftClickModel(MouseEvent mouseEvent) {
        if (line == null){
            line = new Line();
            line.setStartX(mouseEvent.getSceneX());
            line.setStartY(mouseEvent.getSceneY());
        }
        else {
            if (link == null)
                link = new Link();

            line.setEndX(mouseEvent.getSceneX());
            line.setEndY(mouseEvent.getSceneY());

            MainView.drawLine(line);

            link.addLine(line);
            line = null;
        }
    }
    public static void spaceReleasedModel(){
        if (link != null){
            Main.root.getChildren().remove(possibleLine);
            possibleLine = null;
            line = null;
            Stages.runAddLinkStage();
        }
        else
            reset();
    }

    private static void reset() {
        line = null;
        link = null;
        Main.root.getChildren().remove(possibleLine);
        possibleLine = null;
    }
}
