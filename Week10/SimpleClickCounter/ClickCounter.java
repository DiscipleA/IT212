import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ClickCounter extends JFrame {
    private JLabel label;
    private JButton button;

    private int count = 0;

    public ClickCounter() {
        setTitle("My Click Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
    

        label = new JLabel("Number of clicks: 0");
        button = new JButton("Click me!");
        
        add(label);
        add(button);

        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                label.setText("Number of clicks: " + count);
            }
        });
    }

    // ---------- Helper methods for testing ----------

    public int getCount() {
        return count;
    }

    public String getLabelText() {
        return label.getText();
    }

    public void simulateButtonClick() {
        button.doClick();
    }

    public static void main(String[] args) {
        new ClickCounter();
    }

}
