
import java.awt.Color;
import javax.swing.JFrame;

public class SnakeGame {
    
    static void startGame(){
        GamePlay gamePlay = new GamePlay(); 
        JFrame frame = new JFrame();
        frame.setBounds(10,10,905,700);
        frame.setBackground(Color.DARK_GRAY);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePlay);
    } 
    public static void main(String[] args) {
        startGame();
    }
}
