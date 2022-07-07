/**
 * ReadShapeFile.java
 * This class reads a shape file, e.g ExampleShapes.txt,
 * ExampleShapesStill.txt, and TwoRedCircles.txt
 * @version 1.0.0
 * @author Amy Estep
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.paint.Color;

public class ReadShapeFile {
    
    /**
     * takes the line of the file and creates a Circle object using the contents of current line of the file
     * @param in the scanner of the current line of the file
     * @return circleObj The created Circle object
     */
    public static Circle readCircleFile(Scanner in) {
        String data = in.nextLine();
        String[] splitData = data.split(" ");
        Color circleColour = Color.rgb(Integer.parseInt(splitData[7]), Integer.parseInt(splitData[8]), Integer.parseInt(splitData[9]));
        Circle circleObj = new Circle(Integer.parseInt(splitData[10]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]),
                Integer.parseInt(splitData[3]), Integer.parseInt(splitData[4]), Integer.parseInt(splitData[6]), circleColour,
                Boolean.valueOf(splitData[5]));
        return circleObj;
    }
    
    /**
     * takes the line of the file and creates a Oval object using the contents of current line of the file
     * @param in the scanner of the current line of the file
     * @return ovalObj The created Oval object
     */
    public static Oval readOvalFile(Scanner in) {
        String data = in.nextLine();
        String[] splitData = data.split(" ");
        Color ovalColour = Color.rgb(Integer.parseInt(splitData[8]), Integer.parseInt(splitData[9]), Integer.parseInt(splitData[10]));
        Oval ovalObj = new Oval(Integer.parseInt(splitData[11]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]),
                Integer.parseInt(splitData[3]), Integer.parseInt(splitData[4]), Integer.parseInt(splitData[6]), Integer.parseInt(splitData[7]),
                ovalColour, Boolean.valueOf(splitData[5]));
        return ovalObj;
    }
    
    /**
     * takes the line of the file and creates a Square object using the contents of current line of the file
     * @param in the scanner of the current line of the file
     * @return squareObj The created Square object
     */
    public static Square readSquareFile(Scanner in) {
        String data = in.nextLine();
        String[] splitData = data.split(" ");
        Color squareColour = Color.rgb(Integer.parseInt(splitData[7]), Integer.parseInt(splitData[8]), Integer.parseInt(splitData[9]));
        Square squareObj = new Square(Integer.parseInt(splitData[10]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]),
                Integer.parseInt(splitData[3]), Integer.parseInt(splitData[4]), Integer.parseInt(splitData[6]), squareColour,
                Boolean.valueOf(splitData[5]));
        return squareObj;
    }
    
    /**
     * takes the line of the file and creates a Rect object using the contents of current line of the file
     * @param in the scanner of the current line of the file
     * @return rectObj The created Rect object
     */
    public static Rect readRectFile(Scanner in) {
        String data = in.nextLine();
        String[] splitData = data.split(" ");
        Color rectColour = Color.rgb(Integer.parseInt(splitData[8]), Integer.parseInt(splitData[9]), Integer.parseInt(splitData[10]));
        Rect rectObj = new Rect(Integer.parseInt(splitData[11]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]),
                Integer.parseInt(splitData[3]), Integer.parseInt(splitData[4]), Integer.parseInt(splitData[6]), Integer.parseInt(splitData[7]),
                rectColour, Boolean.valueOf(splitData[5]));
        return rectObj;
    }
    
    /**
     * takes the line of the file and creates a Triangle object using the contents of current line of the file
     * @param in the scanner of the current line of the file
     * @return triObj The created Triangle object
     */
    public static Triangle readTriangleFile(Scanner in) {
        String data = in.nextLine();
        String[] splitData = data.split(" ");
        Color triColour = Color.rgb(Integer.parseInt(splitData[8]), Integer.parseInt(splitData[9]), Integer.parseInt(splitData[10]));
        Triangle triObj = new Triangle(Integer.parseInt(splitData[11]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]),
                Integer.parseInt(splitData[3]), Integer.parseInt(splitData[4]), Integer.parseInt(splitData[6]), Integer.parseInt(splitData[7]),
                triColour, Boolean.valueOf(splitData[5]));
        return triObj;
    }

    /**
     * Reads the data file used by the program and returns the constructed queue
     * of closedShape objects
     * @param in the scanner of the file
     * @return the queue represented by the data file
     */
    private static Queue<ClosedShape> readLineByLine(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
        while (in.hasNext()) {
            String data = in.nextLine();
            Scanner line = new Scanner(data);
            if (data.contains("rect")) {
                shapeQueue.enqueue(readRectFile(line));
            } else if (data.contains("square")) {
                shapeQueue.enqueue(readSquareFile(line));
            } else if (data.contains("oval")) {
                shapeQueue.enqueue(readOvalFile(line));
            } else if (data.contains("circle")) {
                shapeQueue.enqueue(readCircleFile(line));
            } else if (data.contains("triangle")) {
                shapeQueue.enqueue(readTriangleFile(line));
            }
        }

        in.close();
        return shapeQueue;
    }

    /**
     * Method to read the file and return a queue of shapes from this file. The
     * program should handle the file not found exception here and shut down the
     * program gracefully.
     * @param filename the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename) {
        File inputFile = new File(filename);
        Scanner in = new Scanner(System.in);
        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + filename);
            System.exit(0);
        }
        return ReadShapeFile.readLineByLine(in);
    }
}
