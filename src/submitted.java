import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;

public class submitted extends JFrame {
    private JPanel panel2;
    private JLabel inpnama;
    private JLabel inpnim;
    private JLabel inpipk;
    private JLabel inpmatkul;
    private JLabel inppoto;

    public void getData(String nama, String nim, String ipk, String matkul, String paspoto) {
        inpnama.setText(nama);
        inpnim.setText(nim);
        inpipk.setText(ipk);
        inpmatkul.setText(matkul);
        ImageIcon Paspoto = new ImageIcon(new ImageIcon(paspoto).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
        inppoto.setIcon(Paspoto);
    }

    public submitted() {
        setContentPane(panel2);
        setTitle("Data Mahasiswa");
        setSize(500, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        submitted result = new submitted();
    }
}
