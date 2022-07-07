/**
 * Square.java
 * @version 1.0.0
 * @author Amy Estep
 */


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Square is a shape that can be drawn to the screen, either filled with
 * colour or opaque.
 */
public class Square extends ClosedShape {

    private int side;
    
    /**
     * Creates a square object
     * @param insertionTime The time in milliseconds since the start of the program after which the shape is inserted
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param colour The line colour or fill colour.
     * @param side The length of the sides of the square
     * @param isFilled True if the square is filled with colour, false if
     * opaque.
     */
    public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;

    }

    /**
     * Method to convert a square to a string.
     */
    @Override
    public String toString() {
        String result = "This is a square\n";
        result += super.toString();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * Draws the square on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillRect(x, y, side, side);
        } else {
            g.strokeRect(x, y, side, side);
        }
    }
    
    /**
     * @return The width of the square which is the side length (side)
     */
    @Override
    public int getWidth() {
        return side;
    }
    
    /**
     * @return The height of the square which is also side length (side)
     */
    @Override
    public int getHeight() {
        return side;
    }
}
