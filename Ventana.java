import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana implements Runnable {
    private JFrame ventana;
    private JPanel panel;

    // Constructor para inicializar y configurar la ventana y el panel
    public Ventana(String titulo, int ancho, int alto) {
        ventana = new JFrame(titulo);
        ventana.setSize(ancho, alto);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        ventana.setContentPane(panel);
        panel.setLayout(null);

        // Añadir imagen de fondo
        JLabel fondo = new JLabel(new ImageIcon("ImagenPista.png"));
        fondo.setBounds(0, 0, ancho, alto);
        panel.add(fondo);
        panel.setComponentZOrder(fondo, panel.getComponentCount() - 1);

        ventana.setLocationRelativeTo(null);
    }

    // Método para añadir etiquetas con imágenes al panel
    public void añadirLabel(Label imagen) {
        panel.add(imagen);
        panel.setComponentZOrder(imagen, 0);
    }

    @Override
    public void run() {
        ventana.setVisible(true); // Hacer visible la ventana
    }
}
