import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



/**
 * Singleton that manages controls and interaction to model/view
 */
public class Controller extends JPanel implements ActionListener {
    private static Controller singleInstance = null;

    View view;
    Model model;

    // For now just use constant dimensions
    private final int FRAME_X = 1000;
    private final int FRAME_Y = 1000;

    private javax.swing.Timer ticker;

    private Controller(View view, Model model){
        this.view = view;
        this.model = model;

        addKeyListener(new TAdapter());
    }

    public static Controller getController(View view, Model model){
        if(singleInstance != null){
            return singleInstance;
        }
        return new Controller(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
        }
    }
}