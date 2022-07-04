import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class datamhs extends JFrame {
    private JTextField tfnama;
    private JTextField tfnim;
    private JTextField tfmatkul;
    private JButton btnsubmit;
    private JPanel panel;
    private JTextField tfipk;
    private JLabel inpnama;
    private JLabel inpnim;
    private JLabel inpipk;
    private JLabel inpmatkul;

    public datamhs() {
        setContentPane(panel);
        setTitle("Data Mahasiswa");
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = tfnama.getText();
                String nim = tfnim.getText();
                String ipk = tfipk.getText();
                String matkul = tfmatkul.getText();
                inpnama.setText(nama);
                inpnim.setText(nim);
                inpipk.setText(ipk);
                inpmatkul.setText(matkul);
            }
        });
    }

    public static void main(String[] args) {
        datamhs result = new datamhs();

    }
}
