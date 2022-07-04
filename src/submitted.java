import javax.swing.*;

public class submitted extends JFrame {
    private JPanel panel2;

    public submitted() {
        setContentPane(panel2);
        setTitle("Data Mahasiswa");
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        submitted result = new submitted();
    }
}
