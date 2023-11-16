import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana implements Runnable {
    private JFrame ventana;
    private JPanel panel;

    // Constructor de Ventana
    public Ventana(String titulo, int ancho, int alto) {
        ventana = new JFrame(titulo); // Crear la ventana
        ventana.setSize(ancho, alto); // Configurar tamaño
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar aplicación al cerrar ventana

        // Crear y configurar el panel
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        ventana.setContentPane(panel);
        panel.setLayout(null);

        // Añadir imagen de fondo
        JLabel fondo = new JLabel(new ImageIcon("ImagenPista.png"));
        fondo.setBounds(0, 0, ancho, alto);
        panel.add(fondo);
        panel.setComponentZOrder(fondo, panel.getComponentCount() - 1); // Asegurar que el fondo esté detrás de todo

        ventana.setLocationRelativeTo(null); // Centrar ventana
    }

    // Método para añadir etiquetas (imágenes de animales) al panel
    public void añadirLabel(Label imagen) {
        panel.add(imagen); // Añadir la imagen
        panel.setComponentZOrder(imagen, 0); // Poner la imagen encima en el orden de componentes
    }

    @Override
    public void run() {
        ventana.setVisible(true); // Mostrar la ventana
    }
}
