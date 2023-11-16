import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel{
    private int xLabel;
    private int yLabel;

    public Label(int xLabel, int yLabel, int anchoLabel,int altoLabel,String ruta){
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        setBounds(xLabel, yLabel, anchoLabel,altoLabel);
        setIcon(new ImageIcon(ruta));
    } 

    public int getXLabel(){
        return this.xLabel;
    }
    public int getYLabel(){
        return this.yLabel;
    }
}


