import java.util.Vector;
import java.awt.Graphics;
public class Well {
    private TetrisUI tetrisUI;
    private static final int NUMBER_OF_FULL_LINES_BLINKS = 10;
    private static final int FULL_LINES_BLINK_DELAY = 100;
    private java.util.Vector<Cube>  cubesInWell;
    private   int numberOfRows;
    private int numberOfColumns;
   public boolean isGameOver(){//the game is end
              for(Cube currentCube: cubesInWell){
                    if(currentCube.getY()  == numberOfRows  - 4){
                              System.out.println(" GAME OVER");
                             return false;
                    }
    }
              return true;
      }
        public Well(TetrisUI t, int numOfRows, int numOfColumns){
            // create well with  number of rows and columns
        cubesInWell = new Vector<Cube>();
        tetrisUI = t;
        if (numOfRows <=0 || numOfColumns <= 0){
            this. numberOfRows = 20;
            this.numberOfColumns = 10;
        } else {
            this. numberOfRows = numOfRows;
            this.numberOfColumns = numOfColumns;
        }
    }
    public Well(TetrisUI t) {
        this(t, 20, 10);
    }
    public void draw(Graphics g, int blockWidth, int blockHeight){
        //create well with black color
        for(Cube c : cubesInWell){
            c.draw(g, blockWidth, blockHeight);
        }
    }
    public boolean isPositionAvailable(int x, int y){
        //check if the x and y are available
        if(x<0 || x>=numberOfColumns || y<0 || y>= numberOfRows)
        return false;
        for(Cube currentCube : cubesInWell ) {
            if(currentCube.getX()==x && currentCube.getY()==y)
                return false;
        }
        return true;
      }
   public void addcubes(Cube [] c){
       //add cubes in the well
   if(isGameOver()){
       for(int i=0;i<c.length;i++){
           cubesInWell.addElement(c[i]);}
       eliminateFullRows();}         
   }
   private void eliminateFullRows(){
       //remove the full rows
   int [] numCubesInRow = new int [ numberOfRows] ;
   for( int count : numCubesInRow){
   count=0 ;}
   for (Cube currentCube : cubesInWell){
       numCubesInRow[currentCube.getY()]++;
   }
   java.util.Vector<Cube> cubesInFullRows=new java.util.Vector<Cube>();
   for (Cube currentCube : cubesInWell){
       if(numCubesInRow[currentCube.getY()]==numberOfColumns)
         cubesInFullRows.addElement(currentCube);
           }
   for(Cube currentFullCube : cubesInFullRows)
             cubesInWell.remove(currentFullCube);
      animateFullRows(cubesInWell);
    dropAboveFullRows(numCubesInRow);
}
   //when there is full rows remove it with song "full line.wav:
      private void animateFullRows(Vector <Cube> cubesInFullRows) { 
        try {
            java.applet.Applet.newAudioClip(new java.io.File("fullLine.wav").toURI().toURL()).play();
        } catch (java.net.MalformedURLException e) {
            // this should never happen!
            javax.swing.JOptionPane.showMessageDialog(null, "Unable to open sound file!");
        }
        for(int blinks = 0; blinks < NUMBER_OF_FULL_LINES_BLINKS; blinks++){
            for(Cube c : cubesInFullRows) {
                c.setDark(!c.isDark());
            }
            tetrisUI.paintImmediately(0,0, tetrisUI.getWidth(), tetrisUI.getHeight());
            try {
                Thread.sleep(FULL_LINES_BLINK_DELAY);
            } catch(InterruptedException e) {
                // do nothing
            }
        }
    }
private void dropAboveFullRows(int [] numCubesInRow){
    //drop all the cubes above the full rows
int numFullBelow =0;
int [] numRowsToDrop = new int [ numberOfRows];
for(int i=0;i< numberOfRows;i++){
    numRowsToDrop[i]=numFullBelow;
if(numCubesInRow[i]==numberOfColumns)
    numFullBelow++;
}
for (Cube currentCube : cubesInWell)
    currentCube.moveRelative(0, -numRowsToDrop[currentCube.getY()]);
 }
 public String toString2(Cube[] g) {
     // change the informations about the cubes into string
     for(int i= numberOfRows-1;i>=0;i--)
      {
         for(int j=0;j<numberOfColumns;j++)
         {
             if((chekShape(j,i,g)) || (checkWell(j,i,cubesInWell)))
               System.out.print(" X ");
             else
               System.out.print(" . ");
         }
                  System.out.println("|");//down line in matrix
     }
        return " ";
 } 
  public boolean chekShape(int i,int j,Cube[] g) {
    for (int x=0;x<g.length;x++)
        if (g[x].getX()==i && (g[x].getY()==j))
            return true;
                return false;
   }
     public boolean checkWell(int i,int j,java.util.Vector<Cube>  cubesInWell) {
                for (Cube d:cubesInWell)
                    if (d.getX()==i && (d.getY()==j))
                       return true;
                        return false;
   }
        public int getNumColoms(){
            //get number of the well's width
          return this.numberOfColumns;  }
        public int getNumRows(){
            //get number of the well's height
          return this. numberOfRows;}
}