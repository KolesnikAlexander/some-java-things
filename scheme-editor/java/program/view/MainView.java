package program.view;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import program.entity.Line;
import program.Main;
import program.controller.MainController;
import program.model.MainModel;

import java.util.LinkedList;
import java.util.List;

import static program.Settings.*;

/**
 * Created by alex60070
 */
public class MainView {
    public static javafx.scene.shape.Line possibleLine;
    public static List<javafx.scene.shape.Line> graphLines = new LinkedList<>();

    public static void drawLine(Line line) {
        javafx.scene.shape.Line graphicLine = new javafx.scene.shape.
                Line(line.getStartX(),
                line.getStartY(),
                line.getEndX(),
                line.getEndY());
        graphicLine.setStroke(LINE_COLOR);
        graphicLine.setStrokeWidth(LINE_WIDTH);
        graphicLine.setOnMouseClicked(new MainController().lineClickController);
        graphicLine.setOnMouseMoved(new MainController().lineMoveController);
        Main.root.getChildren().add(graphicLine);
        graphLines.add(graphicLine);
    }

    public static void mouseMoveView(MouseEvent event) {
        Line line = MainModel.line;
        if (line == null) {
            return;
        }

        Main.root.getChildren().remove(possibleLine);

        possibleLine = new javafx.scene.shape.Line(
                line.getStartX(),
                line.getStartY(),
                event.getSceneX(),
                event.getSceneY());
        possibleLine.setStroke(POSSIBLE_LINE_COLOR);
        possibleLine.setStrokeWidth(LINE_WIDTH);
        possibleLine.setOnMouseClicked(new MainController().lineClickController);
        possibleLine.setOnMouseMoved(new MainController().lineMoveController);

        Main.root.getChildren().add(possibleLine);
    }

    public static void showLinkName(String name, double x, double y){
        Label label = new Label(name);
        label.setTranslateX(x);
        label.setTranslateY(y);
        label.setTextFill(TEXT_COLOR);
        Main.root.getChildren().add(label);

    }

   // public static void
}
