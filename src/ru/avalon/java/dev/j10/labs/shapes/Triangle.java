package ru.avalon.java.dev.j10.labs.shapes;

import java.math.BigDecimal;

/**
 * Представление о треугольнике.
 * <p>
 * Треуго́льник (в евклидовом пространстве) — геометрическая
 * фигура, образованная тремя отрезками, которые соединяют
 * три точки, не лежащие на одной прямой. Указанные три
 * точки называются вершинами треугольника, а отрезки —
 * сторонами треугольника. Часть плоскости, ограниченная
 * сторонами, называется внутренностью треугольника: нередко
 * треугольник рассматривается вместе со своей внутренностью
 * (например, для определения понятия площади).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A2%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Треугольник</a>
 */
public class Triangle implements Polygon {
    /*
     * TODO: Реализовать класс 'Triangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
    
    private static Shapes shape = Shapes.TRIANGLE;
    //координаты вершин задаются пользователем:
    private Point a;
    private Point b;
    private Point c;
    
    //длины сторон вычисляются из координат и инициализируются в конструкторе:
    private float ab;
    private float bc;
    private float ca;
    
    
    public Triangle(Point a, Point b, Point c) throws WrongShapeCreationException{
        this.a = a;
        this.b = b;
        this.c = c;
        
        //проверка, не яваляется ли создаваемый треугольник вырожденным, то есть не находятся ли его вершини на одной прямой:
        //проверка выполняется, равна ли сумма длин каких-либо двух сторон длине третьей стороны?
        ab = getEdgeLength(a, b);
        bc = getEdgeLength(b, c);
        ca = getEdgeLength(c, a);
        
        if(ab + bc == ca || bc + ca == ab || ab + ca == bc)
            throw new WrongShapeCreationException("Вы пытаетесь создать вырожденный треугольник.");
    }
    
    @Override
    public float getPerimeter() {
        //float ab = (float)(Math.sqrt((b.getX() - a.getX())*(b.getX() - a.getX()) + (b.getY() - a.getY())*(b.getY() - a.getY())));
        //float ab = getEdgeLength(a, b);
        //float bc = (float)(Math.sqrt((c.getX() - b.getX())*(c.getX() - b.getX()) + (c.getY() - b.getY())*(c.getY() - b.getY())));
        //float bc = getEdgeLength(b, c);
        //float ca = (float)(Math.sqrt((a.getX() - c.getX())*(a.getX() - c.getX()) + (a.getY() - c.getY())*(a.getY() - c.getY())));
        //float ca = getEdgeLength(c, a);
        
        return ab + bc + ca;
    }

    @Override
    public float getArea() {
        
        float area = ((b.getX() - a.getX()) * (c.getY() - a.getY()) - ((c.getX() - a.getX()) * (b.getY() - a.getY())))/2;
        if (area < 0)
            area *= -1.0f;
        
        return area;
    }

    //вспомогательный приватный метод для расчета длины стороны по декартовым координатам
    //по принципу дорисовывания стороны до прямоугольного треугольника и определения длины гипотенузы по теореме Пифагора.
    //АВ (с) = √((Хв-Ха)²+(Ув-Уа)²) 
    private float getEdgeLength(Point first, Point second){
        return (float)(Math.sqrt((second.getX() - first.getX())*(second.getX() - first.getX()) + (second.getY() - first.getY())*(second.getY() - first.getY())));
    }

    @Override
    public String toString(){
        BigDecimal dbArea = new BigDecimal(getArea()).setScale(2, BigDecimal.ROUND_HALF_UP);
        return shape.getTitle() + ", координаты вершины 1 ~= " + a.toString() + ", координаты вершины 2 ~= " + b.toString() + ", координаты вершины 3 ~= " + c.toString() + ", S ~= " + dbArea;
    }

}
