public class Principal {
    public static void main(String[] args) {
        // Creación de la ventana principal
        Ventana miVentana = new Ventana("Mi Ventana", 1300, 700);
        Thread hiloVentana = new Thread(miVentana); // Ejecución de la ventana en un hilo separado

        // Creación de etiquetas para las imágenes de los animales
        Label imagenTortuga = new Label(0, 350, 300, 300, "tortuga.png");
        Label imagenConejo = new Label(0, 50, 300, 300, "conejo.png");

        // Añadir imágenes a la ventana
        miVentana.añadirLabel(imagenTortuga);
        miVentana.añadirLabel(imagenConejo);

        // Creación de objetos Animal
        Animal tortuga = new Animal(imagenTortuga, 5000, "Tortuga", 1);
        Animal conejo = new Animal(imagenConejo, 1000, "Conejo", 2);

        // Ejecución de los animales en hilos separados
        Thread hiloTortuga = new Thread(tortuga);
        Thread hiloConejo = new Thread(conejo);

        hiloVentana.start();
        hiloTortuga.start();
        hiloConejo.start();

        // Esperar a que los hilos de los animales finalicen
        try {
            hiloTortuga.join();
            hiloConejo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
