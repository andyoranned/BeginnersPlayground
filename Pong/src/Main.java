import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Make window frame object with a title
        JFrame window = new JFrame("Not-Pong");

        //closes program when window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create canvas to draw on
        MyCanvas canvas = new MyCanvas();
        window.add(canvas);

        //fits window size around canvas that can't be resized
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null); //open in center of the screen


        window.setVisible(true);
    }//end main method
}//end class main

class MyCanvas extends JPanel {

    public MyCanvas(){
        //Sets window's dimension to 900x600 background black
        setPreferredSize(new Dimension(900, 600));
        setBackground(Color.BLACK);
    }


}//end MyCanvas