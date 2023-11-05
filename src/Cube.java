import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Cube {
    public Cube(int x, int y, Color color) {//make the cube in position x and y with color
	this.x = x;
	this.y = y;
        this.color = color;
        this.dark = false;
    }
    public boolean isDark() {
        return dark;
    }
    public void setDark(boolean dark) {
       this.dark = dark;
    }
    public void draw(Graphics g, int blockWidth, int blockHeight){
	Graphics2D g2 = (Graphics2D) g;
        int drawX = blockWidth * x;
        int drawY = g2.getDeviceConfiguration().getBounds().height - blockHeight * (y+4);
        g2.setColor(isDark() ? color.darker() : color);
        g2.draw3DRect(drawX, drawY, blockWidth-1, blockHeight-1, true);
        g2.fill3DRect(drawX, drawY, blockWidth-1, blockHeight-1, true);
    }
    private Color color;
    private boolean dark;
    public void moveRelative(int dx, int dy) {//move every cube to place that near it ... according to (x,y)
        x += dx;
        y += dy;
    }
    public int getX() {//get the cube position x
        return x;
    }
    public int getY() {//get the cube position x
        return y;
    }
    private int x;
    private int y;
}
