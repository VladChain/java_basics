import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Personal Data");
        frame.setSize(400, 210);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new MainForm().getMainPanel());
        frame.setVisible(true);
    }
}
