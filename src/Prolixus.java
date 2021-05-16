import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Prolixus extends JFrame {
    public Prolixus() throws IOException {
        String currentPath = new java.io.File(".").getCanonicalPath();
        String modelPath = currentPath + "\\Models\\Model.ser";

        View view = View.getView();
        Model model = Model.getModel(modelPath); // Just generate a
        // new  model every time
        Controller controller = Controller.getController(view, model);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame ex = new Prolixus();
                ex.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
