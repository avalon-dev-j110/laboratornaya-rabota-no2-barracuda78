package ru.avalon.java.dev.j10.labs.shapes;

import java.math.BigDecimal;

/**
 * Представление о прямоугольнике.
 * <p>
 * Прямоугольник — четырехугольник, у которого все углы
 * прямые (равны 90 градусам).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Прямоугольник</a>
 */
public class Rectangle implements Polygon {
    /*
     * TODO: Реализовать класс 'Rectangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
    
    //прямоугольник создается в декартовой системе координат по двум вершинам. Основание - параллельно оси Х.
    private static Shapes shape = Shapes.RECTANGLE;
    private Point p1; //одна из четырех вершин прямоугольника
    private Point p2; //вершина, противоположная вершине p1
    private float rotation = 0;  //параметр, который используется после создания прямоугольника. Используется для поворота прямоугольника. 
    
    public Rectangle(Point p1, Point p2) throws WrongShapeCreationException{
        this.p1 = p1;
        this.p2 = p2;
        
        //проверка, не находятся ли противоположные вершины на одной оси X или Y:
        if(p1.getX() == p2.getX() || p1.getY() == p2.getY())
            throw new WrongShapeCreationException("Вы пытаетесь создать прямоугольник с нулевой площадью.");
    }
    
    @Override
    public float getPerimeter() {
        float length = p1.getX() > p2.getX() ? p1.getX() - p2.getX() : p2.getX() - p1.getX();
        float height = p1.getY() > p2.getY() ? p1.getY() - p2.getY() : p2.getY() - p1.getY();
        return length*2.0f + height*2.0f;
    }
    
    @Override
    public float getArea() {
        float length = p1.getX() > p2.getX() ? p1.getX() - p2.getX() : p2.getX() - p1.getX();
        float height = p1.getY() > p2.getY() ? p1.getY() - p2.getY() : p2.getY() - p1.getY();
        return length * height;
    }
    
    //этот метод после создания объекта фигуры вращает фигуру относительно оси, перпендикулярной плоскости фигуры, проходящей через вершину p1.
    public void rotate(float angle){
        //to be implemented.
    }
    
    @Override
    public String toString(){
        BigDecimal dbArea = new BigDecimal(getArea()).setScale(2, BigDecimal.ROUND_HALF_UP);
        return shape.getTitle() + ", координаты вершины 1 ~= " + p1.toString() + ", координаты вершины 2 ~= " + p2.toString() + ", S ~= " + dbArea;
    }
}
