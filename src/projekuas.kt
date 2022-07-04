import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.sql.DriverManager
import javax.swing.*

class datamhs : JFrame() {
    private val tfnama: JTextField? = null
    private val tfnim: JTextField? = null
    private val tfmatkul: JTextField? = null
    private val btnsubmit: JButton? = null
    private val panel: JPanel? = null
    private val tfipk: JTextField? = null
    private val inpnama: JLabel? = null
    private val inpnim: JLabel? = null
    private val inpipk: JLabel? = null
    private val inpmatkul: JLabel? = null
    private val btnfoto: JButton? = null

    init {
        contentPane = panel
        title = "Data Mahasiswa"
        setSize(500, 300)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
        btnfoto!!.addActionListener { }
        btnsubmit!!.addActionListener(object : ActionListener {
            override fun actionPerformed(e: ActionEvent) {
                val nama = tfnama!!.text
                val nim = tfnim!!.text
                val ipk = tfipk!!.text
                val matkul = tfmatkul!!.text
                inpnama!!.text = nama
                inpnim!!.text = nim
                inpipk!!.text = ipk
                inpmatkul!!.text = matkul
                mhs = addDatabase(nama, nim, ipk, matkul)

                //submitted subm = new submitted();
                //subm.show();
                //dispose();
            }

            var mhs: dbmhs? = null
            private fun addDatabase(nama: String, nim: String, ipk: String, matkul: String): dbmhs? {
                var mhs: dbmhs? = null
                val url = "jdbc:mysql://localhost/MahasiswaDB?serverTimezone=UTC"
                val username = "root"
                val password = ""
                try {
                    val conn = DriverManager.getConnection(url, username, password)
                    val statement = conn.createStatement()
                    val sql = "INSERT INTO users (nama, nim, ipk, matkul)" +
                            "VALUES (?, ?, ? ,?)"
                    val preparedStatement = conn.prepareStatement(sql)
                    preparedStatement.setString(1, nama)
                    preparedStatement.setString(2, nim)
                    preparedStatement.setString(3, ipk)
                    preparedStatement.setString(4, matkul)
                    val addRows = preparedStatement.executeUpdate()
                    if (addRows > 0) {
                        mhs = dbmhs()
                        mhs!!.nama = nama
                        mhs!!.nim = nim
                        mhs!!.ipk = ipk
                        mhs!!.matkul = matkul
                    }
                    statement.close()
                    conn.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return mhs
            }
        })
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = datamhs()
        }
    }
}