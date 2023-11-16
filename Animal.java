public class Animal implements Runnable {
    private int x;
    private int y;
    private int seg;
    Label imagen;
    String nombre;

    public Animal(Label imagen, int seg, String nombre){
        this.imagen = imagen;
        this.seg = seg;
        this.nombre = nombre;
        x = imagen.getXLabel();
        y = imagen.getYLabel();
    }


    public void run(){
        System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + nombre + " empieza la carrera.");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(seg);
                x += 100;
                imagen.setBounds(x, y, 300, 300);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + nombre + " va por la posición "+ (i+1) + " de la carrera.");
        }
        System.out.println(((nombre.equals("Conejo")) ? "El " : "La ") + this.nombre + " llego a la meta.");

    }

}
