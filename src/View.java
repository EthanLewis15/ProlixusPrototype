import java.awt.*;

public class View {
    private static View singleInstance = null;

    Color backgroundColor = Color.BLACK;
    Color playerColor = Color.GREEN;
    Color mobColor = Color.RED;
    Color wallColor = Color.WHITE;

    private View(){
    }

    public static View getView(){
        if(singleInstance == null){
            singleInstance = new View();
        }
        return singleInstance;
    }
}
