import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class datamhs extends JFrame {
    private JTextField tfnama;
    private JTextField tfnim;
    private JTextField tfmatkul;
    private JButton btnsubmit;
    private JPanel panel;
    private JTextField tfipk;
    private JButton btnfoto;
    private JLabel getfoto;

    public datamhs() {
        setContentPane(panel);
        setTitle("Data Mahasiswa");
        setSize(500, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnfoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String com = e.getActionCommand();

                if (com.equals("save")) {
                    JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int r = j.showSaveDialog(null);
                    if (r == JFileChooser.APPROVE_OPTION) {
                        getfoto.setText(j.getSelectedFile().getAbsolutePath());
                    } else
                        getfoto.setText("the user cancelled the operation");
                }
                else {
                    JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int r = j.showOpenDialog(null);
                    if (r == JFileChooser.APPROVE_OPTION) {
                        getfoto.setText(j.getSelectedFile().getAbsolutePath());
                    } else
                        getfoto.setText("the user cancelled the operation");
                }
            }
        });

        btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = tfnama.getText();
                String nim = tfnim.getText();
                String ipk = tfipk.getText();
                String matkul = tfmatkul.getText();
                String paspoto = getfoto.getText();

                submitted subm = new submitted();
                subm.getData(nama, nim, ipk, matkul, paspoto);
                subm.setVisible(true);
                dispose();

                mhs = addDatabase(nama, nim, ipk, matkul, paspoto);
            }

            public dbmhs mhs;
            private dbmhs addDatabase(String nama, String nim, String ipk, String matkul, String paspoto) {
                dbmhs mhs = null;
                final String url = "jdbc:mysql://localhost/MahasiswaDB?serverTimezone=UTC";
                final String username ="root";
                final String password = "";

                try {
                    Connection conn = DriverManager.getConnection(url, username, password);

                    Statement statement = conn.createStatement();
                    String sql = "INSERT INTO users (nama, nim, ipk, matkul, foto)" +
                            "VALUES (?, ?, ? ,? ,?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, nama);
                    preparedStatement.setString(2, nim);
                    preparedStatement.setString(3, ipk);
                    preparedStatement.setString(4, matkul);
                    preparedStatement.setString(5, paspoto);

                    int addRows = preparedStatement.executeUpdate();
                    if (addRows > 0) {
                        mhs = new dbmhs();
                        mhs.nama = nama;
                        mhs.nim = nim;
                        mhs.ipk = ipk;
                        mhs.matkul = matkul;
                        mhs.foto = paspoto;
                    }

                    statement.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return mhs;
            }
        });
    }

    public static void main(String[] args) {
        datamhs result = new datamhs();
    }
}
