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

    init {
        contentPane = panel
        title = "Data Mahasiswa"
        setSize(500, 300)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
        btnsubmit!!.addActionListener {
            val nama = tfnama!!.text
            val nim = tfnim!!.text
            val ipk = tfipk!!.text
            val matkul = tfmatkul!!.text
            inpnama!!.text = nama
            inpnim!!.text = nim
            inpipk!!.text = ipk
            inpmatkul!!.text = matkul
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = datamhs()
        }
    }
}