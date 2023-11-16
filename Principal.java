public class Principal {
    public static void main(String[] args) {
        // Crear la ventana principal de la aplicación
        Ventana miVentana = new Ventana("Mi Ventana", 1300, 700);
        Thread hiloVentana = new Thread(miVentana); // Iniciar la ventana en un hilo separado

        // Crear etiquetas para las imágenes de los animales
        Label imagenTortuga = new Label(0, 350, 300, 300, "tortuga.png");
        Label imagenConejo = new Label(0, 050, 300, 300, "conejo.png");

        // Añadir las imágenes de los animales a la ventana
        miVentana.añadirLabel(imagenTortuga);
        miVentana.añadirLabel(imagenConejo);

        // Crear instancias de Animal para la tortuga y el conejo
        Animal tortuga = new Animal(imagenTortuga, 5000, "Tortuga");
        Animal conejo = new Animal(imagenConejo, 1000, "Conejo");

        // Iniciar hilos para controlar el movimiento de los animales
        Thread hiloTortuga = new Thread(tortuga);
        Thread hiloConejo = new Thread(conejo);

        // Iniciar todos los hilos
        hiloVentana.start();
        hiloTortuga.start();
        hiloConejo.start();
    }
}
