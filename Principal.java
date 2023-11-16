public class Principal {
    public static void main(String[] args) {

        Ventana miVentana = new Ventana("Mi Ventana", 1300, 700);
        Thread hiloVentana = new Thread(miVentana);

        Label imagenTortuga = new Label(0, 350, 300, 300, "tortuga.png");
        Label imagenConejo = new Label(0, 050, 300, 300, "conejo.png");

        miVentana.añadirLabel(imagenTortuga);
        miVentana.añadirLabel(imagenConejo);

        Animal tortuga = new Animal(imagenTortuga,5000,"Tortuga");
        Animal conejo = new Animal(imagenConejo,1000,"Conejo");

        Thread hiloTortuga = new Thread(tortuga);
        Thread hiloConejo = new Thread(conejo);

        hiloVentana.start();

        hiloTortuga.start();
        hiloConejo.start();
    }
}
