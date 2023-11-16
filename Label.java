import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel {
    private int xLabel;
    private int yLabel;

    // Constructor para inicializar y configurar la etiqueta
    public Label(int xLabel, int yLabel, int anchoLabel, int altoLabel, String ruta) {
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        setBounds(xLabel, yLabel, anchoLabel, altoLabel);
        setIcon(new ImageIcon(ruta));
    }

    // Métodos getter para obtener la posición de la etiqueta
    public int getXLabel() {
        return this.xLabel;
    }

    public int getYLabel() {
        return this.yLabel;
    }
}
