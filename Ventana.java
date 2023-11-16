import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana implements Runnable{
    private JFrame ventana;
    private JPanel panel;
    private JLabel imagen;

    public Ventana(String titulo, int ancho, int alto) {
        ventana = new JFrame(titulo);
        ventana.setSize(ancho, alto);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        ventana.setContentPane(panel);
        panel.setLayout(null);

        ventana.setLocationRelativeTo(null);
    }

    public void añadirLabel(Label imagen){
        
        panel.add(imagen);
    }


    public void run(){
        ventana.setVisible(true);
    }
}
