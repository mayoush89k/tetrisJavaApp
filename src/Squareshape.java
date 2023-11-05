import java.awt.Color;
public class Squareshape extends Shape{
        public Squareshape(int upperleftx, int upperlefty, Well w){

            super(w);
            cubes = new Cube[4];
            cubes[0] = new Cube(upperleftx, upperlefty, Color.GREEN);
            cubes[1] = new Cube(upperleftx, upperlefty-1, Color.GREEN);
            cubes[2] = new Cube(upperleftx-1, upperlefty-1, Color.GREEN);
            cubes[3] = new Cube(upperleftx-1, upperlefty, Color.GREEN);
    }    
    public void rotate0To90(){
        if(rotationstate != 0 && !w.isPositionAvailable(cubes[0].getX(), cubes[0].getY()-1)
                    && !this.isPartOfMe(cubes[0].getX(), cubes[0].getY()))
                            return;
         if(rotationstate != 0 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 0 && !w.isPositionAvailable(cubes[2].getX(), cubes[2].getY())
                    && !this.isPartOfMe(cubes[2].getX(), cubes[2].getY()))
                            return;
         if(rotationstate != 0 && !w.isPositionAvailable(cubes[3].getX(), cubes[3].getY())
                    && !this.isPartOfMe(cubes[3].getX(), cubes[3].getY()))
                            return;

        cubes[0].moveRelative(0, 0);
        cubes[1].moveRelative(0, 0);
        cubes[2].moveRelative(0,0);
        cubes[3].moveRelative(0, 0);
        rotationstate = 90;
    }
    public void rotate90To180(){

           if(rotationstate != 90 && !w.isPositionAvailable(cubes[0].getX(), cubes[0].getY()-1)
                    && !this.isPartOfMe(cubes[0].getX(), cubes[0].getY()))
                            return;
         if(rotationstate != 90 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 90 && !w.isPositionAvailable(cubes[2].getX(), cubes[2].getY())
                    && !this.isPartOfMe(cubes[2].getX(), cubes[2].getY()))
                            return;
         if(rotationstate != 90 && !w.isPositionAvailable(cubes[3].getX(), cubes[3].getY())
                    && !this.isPartOfMe(cubes[3].getX(), cubes[3].getY()))
                            return;

        cubes[0].moveRelative(0, 0);
        cubes[1].moveRelative(0, 0);
        cubes[2].moveRelative(0,0);
        cubes[3].moveRelative(0, 0);
        rotationstate = 180;
  }
        public void rotate180To270(){
           if(rotationstate != 180 && !w.isPositionAvailable(cubes[0].getX(), cubes[0].getY()-1)
                    && !this.isPartOfMe(cubes[0].getX(), cubes[0].getY()))
                            return;
         if(rotationstate != 180 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 180 && !w.isPositionAvailable(cubes[2].getX(), cubes[2].getY())
                    && !this.isPartOfMe(cubes[2].getX(), cubes[2].getY()))
                            return;
         if(rotationstate != 180 && !w.isPositionAvailable(cubes[3].getX(), cubes[3].getY())
                    && !this.isPartOfMe(cubes[3].getX(), cubes[3].getY()))
                            return;

        cubes[0].moveRelative(0, 0);
        cubes[1].moveRelative(0, 0);
        cubes[2].moveRelative(0,0);
        cubes[3].moveRelative(0, 0);
        rotationstate =270;
}
    public void rotate270To0(){
        if(rotationstate != 270 && !w.isPositionAvailable(cubes[0].getX(), cubes[0].getY()-1)
                    && !this.isPartOfMe(cubes[0].getX(), cubes[0].getY()))
                            return;
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[1].getX(), cubes[1].getY())
                    && !this.isPartOfMe(cubes[1].getX(), cubes[1].getY()))
                            return;
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[2].getX(), cubes[2].getY())
                    && !this.isPartOfMe(cubes[2].getX(), cubes[2].getY()))
                            return;
         if(rotationstate != 270 && !w.isPositionAvailable(cubes[3].getX(), cubes[3].getY())
                    && !this.isPartOfMe(cubes[3].getX(), cubes[3].getY()))
                            return;

        cubes[0].moveRelative(0, 0);
        cubes[1].moveRelative(0, 0);
        cubes[2].moveRelative(0,0);
        cubes[3].moveRelative(0, 0);
        rotationstate =0;

    }

}
