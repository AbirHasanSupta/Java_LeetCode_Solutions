import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Car implements Serializable {
    String name;
    int model;
    transient int number;
    int seats;
    private static final long serialVersionUID = 1L;

    public Car(String name, int model, int number, int seats){
        this.name = name;
        this.model = model;
        this.number = number;
        this.seats = seats;
    }
    public String toString(){
        return String.format("Car is %s, model is %d, number is %d and the seats are %d", this.name, this.model, this.number, this.seats);
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("hello");
        Car car1 = new Car("Mazda", 12, 1, 4);
        Car car2 = new Car("Supra", 98, 2, 5);
        FileOutputStream fileOutputStream = new FileOutputStream("public.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(car1);
        objectOutputStream.writeObject(car2);

        FileInputStream fileInputStream = new FileInputStream("public.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Car car1_copy = (Car) objectInputStream.readObject();
        Car car2_copy = (Car) objectInputStream.readObject();
        System.out.println(car1_copy);
        System.out.println(car2_copy);


    }
}
