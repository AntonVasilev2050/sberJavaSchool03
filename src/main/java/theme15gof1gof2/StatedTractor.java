package theme15gof1gof2;


public class StatedTractor {
    private Position position = new Position(0, 0);
    private SmartOrientation orientation = SmartOrientation.NORTH;

    public void moveForwards(){
        position = orientation.move(position);
    }

    public void turnClockwise(){
        orientation = orientation.turn();
    }
}
