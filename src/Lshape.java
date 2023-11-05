import java.awt.Color;
public class Lshape  extends Shape{
  public Lshape(int upperleftx, int upperlefty, Well w){  //הגדרת  מערך של 4 קוביות
           super(w);
            cubes = new Cube[4];
            cubes[0] = new Cube(upperleftx, upperlefty, Color.WHITE);
            cubes[1] = new Cube(upperleftx,  upperlefty-1, Color.WHITE);
            cubes[2] = new Cube(upperleftx,  upperlefty-2, Color.WHITE);
            cubes[3] = new Cube(upperleftx+1,upperlefty-2, Color.WHITE);
          }
    public void rotate0To90(){
        if(rotationstate != 0 && !w.isPositionAvailable(cubes[0].getX()+1, cubes[0].getY()-1)
                    && !this.isPartOfMe(cubes[0].getX()+1, cubes[0].getY()-1))
                            return;
         if(rotationstate != 0 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 0 && !w.isPositionAvailable(cubes[2].getX()-1, cubes[2].getY()+1)
                    && !this.isPartOfMe(cubes[2].getX()-1, cubes[2].getY()+1))
                            return;
         if(rotationstate != 0 && !w.isPositionAvailable(cubes[3].getX()-2, cubes[3].getY())
                    && !this.isPartOfMe(cubes[3].getX()-2, cubes[3].getY()))
                            return;
      cubes[0].moveRelative(1,-1);
    cubes[1].moveRelative(0,0);
    cubes[2].moveRelative(-1,1);
    cubes[3].moveRelative(-2,0);
      rotationstate = 90;
    }
       public void rotate90To180(){

         if(rotationstate != 90 && !w.isPositionAvailable(cubes[0].getX()-1, cubes[0].getY()-1)
                    && !this.isPartOfMe(cubes[0].getX()-1, cubes[0].getY()-1))
                            return;
         if(rotationstate != 90 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 90 && !w.isPositionAvailable(cubes[2].getX()+1, cubes[2].getY()+1)
                    && !this.isPartOfMe(cubes[2].getX()+1, cubes[2].getY()+1))
                            return;
         if(rotationstate != 90 && !w.isPositionAvailable(cubes[3].getX(), cubes[3].getY()+2)
                    && !this.isPartOfMe(cubes[3].getX(), cubes[3].getY()+2))
                            return;
     cubes[0].moveRelative(-1,-1);
    cubes[1].moveRelative(0,0);
    cubes[2].moveRelative(1,1);
    cubes[3].moveRelative(0,2);
    rotationstate = 180;
    }
        public void rotate180To270(){
         if(rotationstate != 180 && !w.isPositionAvailable(cubes[0].getX()-1, cubes[0].getY()+1)
                    && !this.isPartOfMe(cubes[0].getX()-1, cubes[0].getY()+1))
                            return;
         if(rotationstate != 180 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 180 && !w.isPositionAvailable(cubes[2].getX()+1, cubes[2].getY()-1)
                    && !this.isPartOfMe(cubes[2].getX()+1, cubes[2].getY()-1))
                            return;
         if(rotationstate !=180 && !w.isPositionAvailable(cubes[3].getX()+2, cubes[3].getY())
                    && !this.isPartOfMe(cubes[3].getX()+2, cubes[3].getY()))
                            return;
      cubes[0].moveRelative(-1,1);
    cubes[1].moveRelative(0,0);
    cubes[2].moveRelative(1,-1);
    cubes[3].moveRelative(2,0);

        rotationstate = 270;
    }   
    public void rotate270To0(){
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[0].getX()+1, cubes[0].getY()+1)
                    && !this.isPartOfMe(cubes[0].getX()+1, cubes[0].getY()+1))
                            return;
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[10].getY()))
                            return;
         if(rotationstate !=270 && !w.isPositionAvailable(cubes[2].getX()-1, cubes[2].getY()-1)
                    && !this.isPartOfMe(cubes[2].getX()-1, cubes[2].getY()-1))
                            return;
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[3].getX(), cubes[3].getY()-2)
                    && !this.isPartOfMe(cubes[3].getX(), cubes[3].getY()-2))
                            return;
      cubes[0].moveRelative(1,1);
    cubes[1].moveRelative(0,0);
    cubes[2].moveRelative(-1,-1);
    cubes[3].moveRelative(0,-2);
    rotationstate = 0;
    }
}
