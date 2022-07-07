/**
 * Rect.java
 * @version 1.0.0
 * @author Amy Estep
 */


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Rectangle is a shape that can be drawn to the screen, either filled with
 * colour or opaque.
 */
public class Rect extends ClosedShape {

    private int width;
    private int height;

    /**
     * Creates a rectangle object
     * @param insertionTime The time in milliseconds since the start of the program after which the shape is inserted
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param colour The line colour or fill colour.
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param isFilled True if the rectangle is filled with colour, false if
     * opaque.
     */
    public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;

    }

    /**
     * Method to convert a rectangle to a string.
     * @return result string containing information about Rect object
     */
    @Override
    public String toString() {
        String result = "This is a rectangle\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * Draws the rectangle on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillRect(x, y, width, height);
        } else {
            g.strokeRect(x, y, width, height);
        }
    }

    /**
     * @return WIDTH the width of the rectangle
     */
    @Override
    public int getWidth() {
        return width;
    }
    
    /**
     * @return HEIGHT the height of the rectangle
     */
    @Override
    public int getHeight() {
        return height;
    }
}
