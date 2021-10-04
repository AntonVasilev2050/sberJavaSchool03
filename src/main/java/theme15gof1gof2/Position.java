package theme15gof1gof2;

public class Position  {
    int x;
    int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position changeX(int n){
        return new Position(x + n, y);
    }

    public Position changeY(int n){
        return new Position(x, y + n);
    }
}
