import java.io.*;

public class Model implements java.io.Serializable {
    private static Model singleInstance = null;
    String modelPath;
    public boolean currentlySaving = false;
    Dungeon dungeon;

    /**
     * Finds whether a new file must be made
     *
     * @param path The path to the file
     * @return Boolean whether the file is new or not -> true=new
     */
    private boolean isNewFile(String path) {
        try {
            System.out.println("Making new file...");
            File file = new File(path);
            File fileParent = file.getParentFile();
            if (!file.exists()) {
                if (fileParent.mkdirs()) {
                    System.out.println("Made all the directories");
                }
                if (file.createNewFile()) {
                    System.out.println("Making new file...");
                }
                return true;
            }
            return false;
        } catch (IOException e) {
            System.out.println("ERROR on path " + path);
            e.printStackTrace();
        }
        return false; // an error would've happened, but keep this for the
        // compiler
    }

    private Model(String path) {
        boolean newFile = isNewFile(path);
        if (newFile) {
            // generate a new dungeon
            dungeon = new Dungeon();
        } else {
            // load in the model
            try {
                FileInputStream fileIn = new FileInputStream(path);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                singleInstance = (Model) in.readObject();

                in.close();
                fileIn.close();
            } catch (IOException | ClassNotFoundException e) {
                // should be impossible since we already checked if its a new
                // file
                e.printStackTrace();
            }
        }
    }

    public static Model getModel(String path) {
        if (singleInstance == null) {
            singleInstance = new Model(path);
        }
        return singleInstance;
    }

    public void saveModel() {
        // TODO: Consider moving this to the controller instead because its
        //  probably what will be calling this
        currentlySaving = true;
        try {
            FileOutputStream fileOut = new FileOutputStream(this.modelPath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(singleInstance);

            out.close();
            fileOut.close();
            System.out.println("Saved data to " + modelPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentlySaving = false;
    }

    public void tick() {
        /// Do all the requested movements
    }
}

abstract class Entity {
    public Entity(long xPos, long yPos, double angle) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.angle = angle;
    }

    // In the unit of pixels
    long xPos;
    long yPos;
    double angle;
}

class Item extends Entity {
    public Item dropItem(long roomNumber) {
        return this;
    }

    private Item(long xPos, long yPos, double angle) {
        super(xPos, yPos, angle);
    }
}

class Projectile extends Entity {
    public Projectile(long xPos, long yPos, double angle) {
        super(xPos, yPos, angle);
    }
}

abstract class Being extends Entity {
    public Being(long xPos, long yPos, double angle) {
        super(xPos, yPos, angle);
    }
}

class Player extends Being {
    public Player(long xPos, long yPos, double angle) {
        super(xPos, yPos, angle);
    }
}

class Mob extends Being {
    public Mob(long xPos, long yPos, double angle) {
        super(xPos, yPos, angle);
    }
}

class Room {
    long identifier;
    Entity[] entities;
}

class DungeonLayer {
    Room[] Rooms;

    public void Expand() {

    }
}

class Dungeon {
    private static Dungeon singleInstance = null;
    /**
     * Contains the entire map
     */
    DungeonLayer[] DungeonLayer;

    public void Expand() {

    }
}
