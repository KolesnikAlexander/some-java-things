package program.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alex60070
 */
public class Link implements Serializable {
    static final long serialVersionUID = 100;
    private String name;
    private List<Line> lines;

    public Link() {
        lines = new LinkedList<>();
    }

    public void addLine(Line line){
        lines.add(line);
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "Link(\"" + name +"\")"+ lines;
    }
}
