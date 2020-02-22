
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {    
        //SET UP GUI
        LSGUI myGui = new LSGUI();
        myGui.pack();
        myGui.setSize(500, 200);
        myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGui.setVisible(true);
        

    }
}
