public class Animal implements Runnable {
    private int x;
    private int y;
    private int seg;
    Label imagen;
    String nombre;

    // Constructor de Animal
    public Animal(Label imagen, int seg, String nombre) {
        this.imagen = imagen;
        this.seg = seg;
        this.nombre = nombre;
        x = imagen.getXLabel(); // Inicializar posición x
        y = imagen.getYLabel(); // Inicializar posición y
    }

    @Override
    public void run() {
        // Mensaje de inicio
        System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + nombre + " empieza la carrera.");

        // Bucle para mover el animal 10 veces
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(seg); // Esperar una cantidad de tiempo
                x += 100; // Mover el animal horizontalmente
                imagen.setBounds(x, y, 300, 300); // Actualizar la posición de la imagen
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Mensaje de progreso
            System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + nombre + " va por la posición " + (i + 1) + " de la carrera.");
        }
        // Mensaje de finalización
        System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + this.nombre + " llego a la meta.");
    }
}
