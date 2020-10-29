
package ru.avalon.java.dev.j10.labs.shapes;

public enum Shapes {
    CIRCLE ("Circle"),
    RECTANGLE ("Rectangle"),
    TRIANGLE ("Triangle");
    
   private String title;

   Shapes(String title) {
       this.title = title;
   }

   public String getTitle() {
       return title;
   }

   @Override
   public String toString() {
       return "Shape{" +
               "title='" + title + '\'' +
               '}';
   }
}
