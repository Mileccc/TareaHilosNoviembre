public class Animal implements Runnable {
    private static final Object cerrojo = new Object();
    private int x;
    private int y;
    private int seg;
    private int id;
    private static int contador = 1;
    Label imagen;
    String nombre;

    public Animal(Label imagen, int seg, String nombre, int id) {
        this.imagen = imagen;
        this.seg = seg;
        this.nombre = nombre;
        this.id = id;
        x = imagen.getXLabel();
        y = imagen.getYLabel();
    }

    public void run() {
        synchronized (cerrojo) {
            while (id != contador) {
                try {
                    cerrojo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + nombre + " empieza la carrera.");
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(seg);
                    x += 100;
                    imagen.setBounds(x, y, 300, 300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + nombre + " va por la posición "
                        + (i + 1) + " de la carrera.");
            }
            System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + this.nombre + " llego a la meta.");
            contador++;
            cerrojo.notifyAll();
        }

    }

}
