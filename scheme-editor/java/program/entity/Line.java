package program.entity;

import java.io.Serializable;

/**
 * Created by alex60070
 */
public class Line implements Serializable{
    static final long serialVersionUID = 200;
    private Double startX;
    private Double startY;
    private Double endX;
    private Double endY;

    public Double getStartX() {
        return startX;
    }

    public void setStartX(Double startX) {
        this.startX = startX;
    }

    public Double getStartY() {
        return startY;
    }

    public void setStartY(Double startY) {
        this.startY = startY;
    }

    public Double getEndX() {
        return endX;
    }

    public void setEndX(Double endX) {
        this.endX = endX;
    }

    public Double getEndY() {
        return endY;
    }

    public void setEndY(Double endY) {
        this.endY = endY;
    }

    public boolean isFull(){
        return (getStartX() != null) &&
                (getStartY()!= null) &&
                (getEndX() != null) &&
                (getEndY() != null);
    }

    @Override
    public String toString() {
        return "Line: "+startX;
    }
}
