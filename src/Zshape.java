import java.awt.Color;

public class Zshape extends Shape {

      public Zshape(int upperleftx, int upperlefty, Well w){
            super(w);
        // create cubes according to the position of x and y that belong to every cube
            cubes = new Cube[4];
            cubes[0] = new Cube(upperleftx, upperlefty, Color.PINK);
            cubes[1] = new Cube(upperleftx, upperlefty-1, Color.PINK);
            cubes[2] = new Cube(upperleftx-1, upperlefty,Color.PINK);
            cubes[3] = new Cube(upperleftx+1, upperlefty-1,Color.PINK);
    }
               
    public void rotate0To90(){
        if(rotationstate != 0 && !w.isPositionAvailable(cubes[0].getX()+1, cubes[0].getY()-1)
                    && !this.isPartOfMe(cubes[0].getX()+1, cubes[0].getY()-1))
                            return;
         if(rotationstate != 0 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 0 && !w.isPositionAvailable(cubes[2].getX()+2, cubes[2].getY())
                    && !this.isPartOfMe(cubes[2].getX()+2, cubes[2].getY()))
                            return;
         if(rotationstate != 0 && !w.isPositionAvailable(cubes[3].getX()-1, cubes[3].getY()-1)
                    && !this.isPartOfMe(cubes[3].getX()-1, cubes[3].getY()-1))
                            return;

        cubes[0].moveRelative(1, -1);
        cubes[1].moveRelative(0, 0);
        cubes[2].moveRelative(+2, 0);
        cubes[3].moveRelative(-1,-1);
        rotationstate = 90;
    }

    public void rotate90To180(){

            if(rotationstate != 90 && !w.isPositionAvailable(cubes[0].getX()-1, cubes[0].getY()-1)
                    && !this.isPartOfMe(cubes[0].getX()-1, cubes[0].getY()-1))
                            return;
         if(rotationstate != 90 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 90 && !w.isPositionAvailable(cubes[2].getX(), cubes[2].getY()-2)
                    && !this.isPartOfMe(cubes[2].getX(), cubes[2].getY()-2))
                            return;
         if(rotationstate != 90 && !w.isPositionAvailable(cubes[3].getX()-1, cubes[3].getY()+1)
                    && !this.isPartOfMe(cubes[3].getX()-1, cubes[3].getY()+1))
                            return;

        cubes[0].moveRelative(-1, -1);
        cubes[1].moveRelative(0, 0);
        cubes[2].moveRelative(0, -2);
        cubes[3].moveRelative(-1, +1);
        rotationstate = 180;

  
    }
    public void rotate180To270(){
         if(rotationstate != 180 && !w.isPositionAvailable(cubes[0].getX()-1, cubes[0].getY()+1)
                    && !this.isPartOfMe(cubes[0].getX()-1, cubes[0].getY()+1))
                            return;
         if(rotationstate !=180&& !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 180 && !w.isPositionAvailable(cubes[2].getX()-2, cubes[2].getY())
                    && !this.isPartOfMe(cubes[2].getX()-2, cubes[2].getY()))
                            return;
         if(rotationstate !=180 && !w.isPositionAvailable(cubes[3].getX()+1, cubes[3].getY()+1)
                    && !this.isPartOfMe(cubes[3].getX()+1, cubes[3].getY()+1))
                            return;
        cubes[0].moveRelative(-1, 1);
        cubes[1].moveRelative(0, 0);
        cubes[2].moveRelative(-2, 0);
        cubes[3].moveRelative(1,1);
        rotationstate = 270;

   
    }
    public void rotate270To0(){
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[0].getX()+1, cubes[0].getY()+1)
                    && !this.isPartOfMe(cubes[0].getX()+1, cubes[0].getY()+1))
                            return;
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[2].getX(), cubes[2].getY()+2)
                    && !this.isPartOfMe(cubes[2].getX(), cubes[2].getY()+2))
                            return;
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[3].getX()+1, cubes[3].getY()-1)
                    && !this.isPartOfMe(cubes[3].getX()+1, cubes[3].getY()-1))
                            return;
        cubes[0].moveRelative(1, 1);
        cubes[1].moveRelative(0, 0);
        cubes[2].moveRelative(0, +2);
        cubes[3].moveRelative(+1, -1);
        rotationstate = 0;
    }

}
