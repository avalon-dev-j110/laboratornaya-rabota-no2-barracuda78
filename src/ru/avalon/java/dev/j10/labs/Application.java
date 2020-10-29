package ru.avalon.java.dev.j10.labs;

import java.util.Arrays;
import ru.avalon.java.dev.j10.labs.shapes.AreaComparator;
import ru.avalon.java.dev.j10.labs.shapes.Circle;
import ru.avalon.java.dev.j10.labs.shapes.ConsoleHelper;
import ru.avalon.java.dev.j10.labs.shapes.ExactPoint;
import ru.avalon.java.dev.j10.labs.shapes.Rectangle;
import ru.avalon.java.dev.j10.labs.shapes.Shape;
import ru.avalon.java.dev.j10.labs.shapes.Triangle;
import ru.avalon.java.dev.j10.labs.shapes.WrongShapeCreationException;

public class Application {

//Доработайте пакет ru.avalon.java.dev.j10.labs.shapes так, чтобы
//Класс Circle содержал методы, возвращающие площадь фигуры и длину окружности.
//Класс Rectangle содержал методы, возвращающие площадь фигуры и периметр четырехугольника.
//Класс Triangle содержал методы, возвращающие площадь фигуры и периметр треугольника.
//В классе ru.avalon.java.dev.j10.labs.Application:
//Проинициализировать переменную 'shapes' массивом содержащим 10 произвольных фигур. Массив должен содержать экземпляры классов Circle, Rectangle и Triangle.
//Найти в массиве 'shapes' фигуру с максимальной площадью. Для поиска фигуры необходимо создать статический метод.
    
    public static void main(String[] args) {
        /*
         * TODO: Выполнить действия над массивом 'shapes'
         *
         * 1. Проинициализировать переменную 'shapes' массивом
         *    содержащим 10 произвольных фигур. Массив должен
         *    содержать экземпляры классов Circle, Rectangle
         *    и Triangle.
         *
         * 2. Найти в массиве 'shapes' фигуру с максимальной
         *    площадью. Для поиска фигуры необходимо создать
         *    статический метод в текущем классе (Application).
         */
        
        Shape[] shapes = new Shape[10];
        
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = new ShapeFactory().getRandomShape();
        }
        
        //поскольку массив заполнялся псевдорандомно, в нем могло не оказаться какой-либо из фигур. Поэтому нужна
        //проверка условия задачи, что в массиве обязательно присутствует хотя бы один Circle, один Rectangle и один Triangle
        //с помощью счетчиков:
        int countCircles = 0;
        int countRectangles = 0;
        int countTriangles = 0;
        
        for(Shape shape : shapes){
            if(shape instanceof Circle)
                countCircles++;
            else if(shape instanceof Rectangle)
                countRectangles++;
            else if(shape instanceof Triangle)
                countTriangles++;
        }
        
        //если хотя бы один ииз счетчиков равен нулю - тогда в первые три ячейки массива записываются три разные фигуры:
        if(countCircles == 0 || countRectangles == 0 || countTriangles == 0){
           try{
           shapes[0] = new Circle(new ExactPoint(0.0f, 0.0f), 1.0f);
           shapes[1] = new Rectangle(new ExactPoint(0.0f, 0.0f), new ExactPoint(1.0f, 2.0f));
           shapes[2] = new Triangle(new ExactPoint(0.0f, 0.0f), new ExactPoint(2.0f, 3.0f), new ExactPoint(4.0f, 0.0f));
           }
           catch(WrongShapeCreationException e){
                ConsoleHelper.writeMessage(e.getMessage());
           }
        }
        
        //нахождение и получение из массива фигуры с наибольшим объемом:
        
        Shape maxAreaShape = getMaxAreaShape(shapes);   
        
        
        ///////////////////////////////Проверка работоспособности программы:///////////////////////////////////////////////
        
        //вывод массива фигур в консоль:
        for(Shape sh : shapes){
            ConsoleHelper.writeMessage(sh.toString());
        }
        //вывод в консоль фигуры с амксимальной площадью:
        ConsoleHelper.writeMessage("\nФигура с максимальной площадью:\n" + maxAreaShape.toString());
        
    }
    
    public static Shape getMaxAreaShape(Shape[] shapes){
        Arrays.sort(shapes, new AreaComparator());
        return shapes[shapes.length - 1];
    }
}
