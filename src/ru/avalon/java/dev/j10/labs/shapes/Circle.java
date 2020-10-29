package ru.avalon.java.dev.j10.labs.shapes;

import java.math.BigDecimal;

/**
 * Представление об окружности.
 * <p>
 * Окру́жность — замкнутая плоская кривая, которая состоит из
 * всех точек на плоскости, равноудалённых от заданной точки.
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9E%D0%BA%D1%80%D1%83%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C">Окружность</a>
 */
public class Circle implements Ellipse{
    /*
     * TODO: Реализовать класс 'Circle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
    private static Shapes shape = Shapes.CIRCLE;
    private Point center;
    private float radius;
    //private float area;
    
    public Circle(Point center, float radius) throws WrongShapeCreationException{
        this.center = center;
        this.radius = radius;
        
        //проверка ненулевого радиуса
        if(radius <= 0)
            throw new WrongShapeCreationException("Радиус окружности должен быть больше нуля.");
    }
    
    @Override
    public float getArea() {
        return (float)(Math.PI * Math.pow(radius, 2.0));
    }

    @Override
    public float getLength() {
        return 2.0f * (float)Math.PI * radius;
    }
    
    @Override
    public String toString(){
        BigDecimal dbArea = new BigDecimal(getArea()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal dbRadius = new BigDecimal(radius).setScale(2, BigDecimal.ROUND_HALF_UP);
        return shape.getTitle() + ", радиус ~= " + dbRadius + ", координаты центра ~= " + center.toString() + ", S ~=" + dbArea;
    }
    
}
