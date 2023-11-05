import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {

    public static void main(String args[]){
    	Game myGame = new Game();    	
    	myGame.addWindowListener(
            new WindowAdapter(){
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }
            }
    	);

        try {
            java.applet.Applet.newAudioClip(new java.io.File("tetris.mid").toURI().toURL()).loop();
        } catch (java.net.MalformedURLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Unable to open sound file!");
        }

        myGame.setVisible(true);
    }

    public Game(){
        super("Tetris");
        tetrisUI = new TetrisUI();
        setBounds(100, 100, 350, 700);

        getContentPane().add(tetrisUI, BorderLayout.CENTER);
        tetrisUI.requestFocusInWindow();
    }
    
    private TetrisUI tetrisUI;
}