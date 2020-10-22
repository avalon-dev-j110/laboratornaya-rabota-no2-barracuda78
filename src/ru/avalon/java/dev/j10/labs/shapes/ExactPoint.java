package ru.avalon.java.dev.j10.labs.shapes;

import java.math.BigDecimal;

public class ExactPoint implements Point{
    private float x;
    private float y;
    
    public ExactPoint(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public float getX() {
        return x;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getY() {
        return y;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //setters

    @Override
    public void setX(float x) {
        this.x = x;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setY(float y) {
        this.y = y;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        BigDecimal dbX = new BigDecimal(x).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal dbY = new BigDecimal(y).setScale(2, BigDecimal.ROUND_HALF_UP);
        return "x ~= " + dbX + ", y ~= " + dbY;
    }
     
}
