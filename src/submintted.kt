import javax.swing.*

class submitted : JFrame() {
    private val panel2: JPanel? = null
    private val inpnama: JLabel? = null
    private val inpnim: JLabel? = null
    private val inpipk: JLabel? = null
    private val inpmatkul: JLabel? = null
    private val inppoto: JLabel? = null
    fun getData(nama: String?, nim: String?, ipk: String?, matkul: String?, paspoto: String?) {
        inpnama!!.text = nama
        inpnim!!.text = nim
        inpipk!!.text = ipk
        inpmatkul!!.text = matkul
        inppoto!!.text = paspoto
    }

    init {
        contentPane = panel2
        title = "Data Mahasiswa"
        setSize(500, 300)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = submitted()
        }
    }
}