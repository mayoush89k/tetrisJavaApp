import java.awt.Graphics;
  public abstract class  Shape {
    protected Cube[] cubes; // 4 cubes
    protected  Well w;                // It is place where the figure falls
    protected int rotationstate ;
    protected abstract void rotate0To90();
    protected abstract void rotate90To180();
    protected abstract void rotate180To270();
    protected abstract void rotate270To0();

     public Shape(Well w){ // when we create the shape .. put it in the well with 4 cubes
        rotationstate=0;
        cubes=new Cube [4];
        this.w=w;
    }
      public void moveLeft(){ // move all the cubes in my shape left
        move(-1,0);
    }
      public void moveRight(){// move all the cubes in my shape right
        move(1,0);
    } 
   
    public void moveDown(){//move all the cubes in my shape down
 
        int oldy = cubes[0].getY();
        move(0,-1);
        if(oldy == cubes[0].getY()){        // if previous attempt to move down failed -> reached bottom
            w.addcubes(cubes);
        }
    }
    public void moveDrop(){// drop all the cubes in my shape
        while(true){
        int oldy = cubes[0].getY();
         move(0,-1);        //moveDown();
        if(oldy == cubes[0].getY()){
            w.addcubes(cubes);
            break;
        }
    }
    }
    public void moveRotate(){     //rotate the  shape according the x and y movementthat belong to every cube
        if(rotationstate == 0){
            rotate0To90();
        }
        else
        if(rotationstate ==90){
            rotate90To180();
        }
        else
        if(rotationstate == 180){
            rotate180To270();
        }
        else
        if(rotationstate == 270){
            rotate270To0();
        }
    }
       private void move(int dx, int dy){ //move the cube in my shape according to x and y
        for(Cube currentcube : cubes){
            if(!w.isPositionAvailable(currentcube.getX()+dx, currentcube.getY()+dy)
                    && !isPartOfMe(currentcube.getX()+dx, currentcube.getY()+dy))
                return;}
                {
                for(Cube currentcube : cubes)
                   currentcube.moveRelative(dx, dy);}
    }
       public boolean isPartOfMe(int x, int y){//the position of x and y is part of my shape
        for(Cube currentcube : cubes){
            if(currentcube.getX() == x && currentcube.getY() == y)
                return true;
        }
        return false;
    }
      public Cube [] getCubes(){//return cubes of my shape
              return cubes;
            }
      /**
       *
       * @return <code>false</code> if this shape cannot move down one step. code>true</code> otherwise.
       */
       public boolean CanMoveDown(){
           for( Cube currentCube:cubes ) {            // check foer all cubes in this shape
              // if currentcube can not move one step down -> whole shape cannot move
                         if (!w.isPositionAvailable(currentCube.getX(),currentCube.getY()-1))  return false;
          }
          // if we are here all cubes of this shape can move down obne step.
        return true;
       }
       
      public void draw(Graphics g, int blockWidth, int blockHeight){//draw the well in color black
	for(Cube c : cubes) c.draw(g, blockWidth, blockHeight);
    }

}
