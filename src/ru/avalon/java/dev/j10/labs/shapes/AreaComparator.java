
package ru.avalon.java.dev.j10.labs.shapes;

import java.util.Comparator;

/**
 *
 * класс, который помогает сравнивать фигуры по их площади.
 */
public class AreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape t, Shape t1) {
        if(t.getArea() == t1.getArea())
            return 0;
        else if(t.getArea() > t1.getArea())
            return 1;
        else 
            return -1;
    }
    
}
