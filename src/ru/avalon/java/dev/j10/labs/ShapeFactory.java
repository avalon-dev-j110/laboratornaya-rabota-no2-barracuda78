
package ru.avalon.java.dev.j10.labs;

import java.util.Random;
import ru.avalon.java.dev.j10.labs.shapes.Circle;
import ru.avalon.java.dev.j10.labs.shapes.ConsoleHelper;
import ru.avalon.java.dev.j10.labs.shapes.ExactPoint;
import ru.avalon.java.dev.j10.labs.shapes.Rectangle;
import ru.avalon.java.dev.j10.labs.shapes.Shape;
import ru.avalon.java.dev.j10.labs.shapes.Shapes;
import ru.avalon.java.dev.j10.labs.shapes.Triangle;
import ru.avalon.java.dev.j10.labs.shapes.WrongShapeCreationException;

public class ShapeFactory {
    private Random r = new Random();
    private Random floatCoordinate = new Random();
    private final int i = r.nextInt(3);
    private Shapes shape;
    
    //нестатический блок для инициализации переменной ENUM shape в зависимости от случайного целого чиисла i:
    {
        if(i == 0)
            shape = Shapes.CIRCLE;
        else if(i == 1)
            shape = Shapes.RECTANGLE;
        else if(i == 2)
            shape = Shapes.TRIANGLE;
    }

    //фабрика по производству фигур:  
    public Shape getRandomShape(){
        try{
            switch(shape){
                case CIRCLE:
                    return new Circle(new ExactPoint(10*floatCoordinate.nextFloat(), 10*floatCoordinate.nextFloat()), 10*floatCoordinate.nextFloat());
                case RECTANGLE:
                    return new Rectangle(new ExactPoint(10*floatCoordinate.nextFloat(), 10*floatCoordinate.nextFloat()), new ExactPoint(10*floatCoordinate.nextFloat(), 10*floatCoordinate.nextFloat()));
                case TRIANGLE:
                    return new Triangle(new ExactPoint(10*floatCoordinate.nextFloat(), 10*floatCoordinate.nextFloat()), new ExactPoint(10*floatCoordinate.nextFloat(), 10*floatCoordinate.nextFloat()), new ExactPoint(10*floatCoordinate.nextFloat(), 10*floatCoordinate.nextFloat()));
                default:
                    return new Circle(new ExactPoint(10*floatCoordinate.nextFloat(), 10*floatCoordinate.nextFloat()), 10*floatCoordinate.nextFloat());
            }
        }
        catch(WrongShapeCreationException e){
            ConsoleHelper.writeMessage(e.getMessage());
        }
        return null;
    }
    

}
