/**
 * Triangle.java
 * @version 1.0.0
 * @author Amy Estep
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Triangle is a shape that can be drawn to the screen, either filled with
 * colour or opaque.
 */
public class Triangle extends ClosedShape {

    private int width;
    private int height;
    
    /**
     * Creates a Triangle object
     * @param insertionTime The time in milliseconds since the start of the program after which the shape is inserted
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param colour The line colour or fill colour.
     * @param width The width of the triangle (base)
     * @param height The height of the triangle
     * @param isFilled True if the triangle is filled with colour, false if
     * opaque.
     */
    public Triangle(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;

    }

    /**
     * Method to convert a triangle to a string.
     */
    @Override
    public String toString() {
        String result = "This is a triangle\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * Draws the triangle on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillPolygon(getXCoords(), getYCoords(), 3);
        } else {
            g.strokePolygon(getXCoords(), getYCoords(), 3);
        }
    }
    
    /**
     * gets the x coordinates for the triangles points
     * @return xCoords The x coordinates for the triangles points
     */
    public double[] getXCoords() {
        double xCoords[] = {x, (x + (width / 2)), x + width};
        return xCoords;
    }
    
    /**
     * gets the y coordinates for the triangles points
     * @return yCoords The x coordinates for the triangles points
     */
    public double[] getYCoords() {
        double yCoords[] = {y + height, y, y + height};
        return yCoords;
    }
    
    /**
     * @return The width of the triangle (base) 
     */
    @Override
    public int getWidth() {
        return width;
    }
    
    /**
     * @return The height of the triangle
     */
    @Override
    public int getHeight() {
        return height;
    }
}
