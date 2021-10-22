public class ManipulateAnimals {
    public static void main(String[] args) {

        Action[] array = new Action[4];     // Initialize array of 4 items as type Action

        Animal bird = new Animal();         // Create Animal Object
        bird.setName("Hawk");

        Vehicle toyota = new Vehicle();     // Create Vehicle Object
        toyota.setName("Supra");
        toyota.setAge(10);

        Animal fish = new Animal();         // Create Animal Object
        fish.setName("Walleye");

        Vehicle subaru = new Vehicle();     // Create Vehicle Object
        subaru.setName("WRX STI");
        subaru.setAge(5);

        array[0] = bird;                    // Store each item into array
        array[1] = toyota;
        array[2] = fish;
        array[3] = subaru;

        for (Action action : array           // Loop through array and invoke each method
        ) {
            action.drawObject();
            action.playSound();
            action.resizeObject();
            action.rotateObject();
            System.out.println();
        }
    }
}

class Animal implements Drawable, Rotatable, Resizable, Sounds {

    private String name;

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }


    public void drawObject() {
        System.out.println("Drawing an Animal");
    }

    public void rotateObject() {
        System.out.println("Rotating an Animal");
    }

    public void resizeObject() {
        System.out.println("Resizing an Animal");

    }

    public void playSound() {
        System.out.println("Animal sound");
    }


}

class Vehicle implements Drawable, Rotatable, Resizable, Sounds {

    private String name;
    private int age;

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return this.age;
    }

    void setAge(int age) {
        this.age = age;
    }

    public void drawObject() {
        System.out.println("Drawing a Vehicle");
    }

    public void rotateObject() {
        System.out.println("Rotating a Vehicle");
    }

    public void resizeObject() {
        System.out.println("Resizing a Vehicle");

    }

    public void playSound() {
        System.out.println("Vehicle sound");
    }

}

// Action interface is used so that vehicle and animal will have a common class to be stored in the array
interface Action {
    void drawObject();

    void rotateObject();

    void resizeObject();

    void playSound();
}


interface Drawable extends Action {
    void drawObject();
}

interface Rotatable extends Action {
    void rotateObject();
}

interface Resizable extends Action {
    void resizeObject();
}

interface Sounds extends Action {
    void playSound();
}
