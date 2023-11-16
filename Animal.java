public class Animal implements Runnable {
    private static final Object cerrojo = new Object();
    private int x;
    private int y;
    private int seg;
    private int id;
    private static int contador = 1;
    Label imagen;
    String nombre;

    // Constructor para inicializar el animal
    public Animal(Label imagen, int seg, String nombre, int id) {
        this.imagen = imagen;
        this.seg = seg;
        this.nombre = nombre;
        this.id = id;
        x = imagen.getXLabel();
        y = imagen.getYLabel();
    }

    @Override
public void run() {
    // 'synchronized' se utiliza para asegurar que solo un hilo acceda a este bloque de código a la vez.
    // El objeto 'cerrojo' es el monitor que controla el acceso.
    synchronized (cerrojo) {
        // 'while' se utiliza para mantener a los animales esperando su turno.
        // El animal solo procederá si su 'id' coincide con el 'contador' global.
        while (id != contador) {
            try {
                // 'cerrojo.wait()' hace que el hilo actual espere hasta que otro hilo invoque 'notifyAll()'
                // sobre el mismo objeto. Esto se usa para pausar el hilo hasta que sea su turno.
                cerrojo.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Mensaje indicando el inicio de la carrera para este animal.
        System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + nombre + " empieza la carrera.");
        for (int i = 0; i < 10; i++) {
            try {
                // 'Thread.sleep(seg)' pausa el hilo durante un tiempo determinado, simulando el movimiento del animal.
                Thread.sleep(seg);
                x += 100; // Mover el animal horizontalmente
                // Actualizar la posición de la imagen en la ventana.
                imagen.setBounds(x, y, 300, 300);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Mensaje indicando la posición actual en la carrera.
            System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + nombre + " va por la posición " + (i + 1) + " de la carrera.");
        }
        // Mensaje indicando que el animal ha llegado a la meta.
        System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + this.nombre + " llego a la meta.");
        contador++; // Incrementar el contador para permitir que el siguiente animal comience.
        // 'cerrojo.notifyAll()' despierta a todos los hilos que están esperando sobre este objeto.
        // Se utiliza para indicar que el siguiente animal puede comenzar su carrera.
        cerrojo.notifyAll();
    }
}

}
