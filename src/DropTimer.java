import java.awt.event.ActionEvent;
public class DropTimer extends javax.swing.AbstractAction {
    public DropTimer(TetrisUI t, int timerDelay) {//number of the  second  that move the shape down
        super();
        this.t = t;
        new javax.swing.Timer(timerDelay, this).start();
    }
    public void actionPerformed(ActionEvent e) {//move the shape down and paint it again
       t.moveCurrentShapeDown();
       t.repaint();
    }
    private TetrisUI t;
}
