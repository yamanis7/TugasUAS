import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel inpnama;
    private JLabel inpnim;
    private JLabel inpipk;
    private JLabel inpmatkul;
    private JButton btnfoto;

    public datamhs() {
        setContentPane(panel);
        setTitle("Data Mahasiswa");
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnfoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

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

                mhs = addDatabase(nama, nim, ipk, matkul);

                //submitted subm = new submitted();
                //subm.show();
                //dispose();
            }

            public dbmhs mhs;
            private dbmhs addDatabase(String nama, String nim, String ipk, String matkul) {
                dbmhs mhs = null;
                final String url = "jdbc:mysql://localhost/MahasiswaDB?serverTimezone=UTC";
                final String username ="root";
                final String password = "";

                try {
                    Connection conn = DriverManager.getConnection(url, username, password);

                    Statement statement = conn.createStatement();
                    String sql = "INSERT INTO users (nama, nim, ipk, matkul)" +
                            "VALUES (?, ?, ? ,?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, nama);
                    preparedStatement.setString(2, nim);
                    preparedStatement.setString(3, ipk);
                    preparedStatement.setString(4, matkul);

                    int addRows = preparedStatement.executeUpdate();
                    if (addRows > 0) {
                        mhs = new dbmhs();
                        mhs.nama = nama;
                        mhs.nim = nim;
                        mhs.ipk = ipk;
                        mhs.matkul = matkul;
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
