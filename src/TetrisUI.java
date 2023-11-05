import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
public class TetrisUI  extends JPanel implements KeyListener{

    public void moveCurrentShapeRight(){ // move all cubes the shape to the right side
     currentShape.moveRight();}
    public void moveCurrentLefth(){  // move all the cubes shape to the left side
     currentShape.moveLeft();}
     
    public void rotateCurrentShape() { // rotate all the shape
         currentShape.moveRotate();
    }

    public TetrisUI(){  
        w = new Well(this);
         currentShape=createRandomShape();
        this.setBackground(java.awt.Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);
       new DropTimer(this, 2000); // go down automaticlly every 2000ms
 }
      protected void  paintComponent(Graphics g) {
        super.paintComponent(g);
        Rectangle bounds = getBounds();
        int blockWidth = bounds.width / w.getNumColoms();
        int blockHeight = bounds.height / w.getNumRows();

        currentShape.draw(g, blockWidth, blockHeight);
        w.draw(g, blockWidth, blockHeight);
    }

      public void moveCurrentShapeDown(){ //move all cubes in the shape down
          currentShape.moveDown();          //move down
          if(!currentShape.CanMoveDown()){      // if reached bottom
              currentShape.moveDown();          // called to force shape to add cubes to well
          if(w.isGameOver())
              currentShape=createRandomShape();   // replace shape with new one
          }
      }

    public void dropCurrentShape(){// move the shape until the end of the column
          currentShape.moveDrop();
                    if(w.isGameOver())
          currentShape=createRandomShape();
    }

      private Shape createRandomShape(){ // create new shape 
      int rand=(int)(Math.random() * 7.0);

    {  if (rand==0)
          return new Lshape(w.getNumColoms()/2,w.getNumRows()-1,w);
      else if(rand==1)
            return new Zshape(w.getNumColoms()/2,w.getNumRows()-1,w);
      else if(rand==2)
            return new Sshape(w.getNumColoms()/2,w.getNumRows()-1,w);
      else if(rand==3)
            return new Jshape(w.getNumColoms()/2,w.getNumRows()-1,w);
      else if(rand==4)
            return new Squareshape(w.getNumColoms()/2,w.getNumRows()-1,w);
      else if(rand==5)
            return new Barshape(w.getNumColoms()/2,w.getNumRows()-1,w);
      else
            return new Plusshape(w.getNumColoms()/2,w.getNumRows()-1,w); 
    }
      }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:    // up arrow
                rotateCurrentShape();
                repaint();
                break;
            case KeyEvent.VK_DOWN:    // down arrow
                moveCurrentShapeDown();
                repaint();
                break;
            case KeyEvent.VK_LEFT:    // left arrow
                moveCurrentLefth();
                repaint();
                break;
            case KeyEvent.VK_RIGHT:    // right arrow
                moveCurrentShapeRight();
                repaint();
                break;
            case KeyEvent.VK_SPACE:    // space
                dropCurrentShape();
                repaint();
                break;
        }
    }
   /** Handle the key typed (i.e. pressed and then released) event */
   public void keyTyped(KeyEvent e) {
        // do nothing
    }
    /** Handle the key released event */
    public void keyReleased(KeyEvent e) {
        // do nothing
    }
     private  Shape currentShape;
     private  Well w;

}

