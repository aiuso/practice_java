import javax.swing.*;

public class GUI extends JFrame{

    public static void main(String[] args) {
         new GUI();
         }

    private JPanel panel; // To reference a panel
    private JLabel messageLabel; // To reference a label
    private JTextField kiloTextField; // To reference a text field
    private JButton calcButton; // To reference a button
    private final int WINDOW_WIDTH = 1000; // Window width
    private final int WINDOW_HEIGHT = 600;// Window height


    public GUI() {

        setTitle("Testing");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildPanel();
        add(panel);


        setVisible(true);
    }

    private void buildPanel() {
        messageLabel = new JLabel ("Instructions");
        calcButton = new JButton("Text");

        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(calcButton);

    }
}
