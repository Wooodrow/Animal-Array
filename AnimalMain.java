package brianmooreanimalarray;


        import com.sun.javafx.image.AlphaType;

        import java.util.Iterator;
        import java.util.Scanner;
        import java.util.ArrayList;
        import java.util.List;
        import java.lang.String;
        import java.lang.*;
        import java.io.*;
/**
 *add, edit delete different types of animals. select an animal and the corresponding characteristics will be
 * displayed(such as color, invertebrate, can swim etc)
 * the program must use an arrayList to work with these animal objects
 *
 * @author BrianMoore
 */

public class AnimalMain {
//instantiates an array called AnimalMain
    public static List<AnimalMain> animalMainList = new ArrayList<>();
//sets the attributes of the array class
    String name;
    String type;
    String location;
    Boolean supernatural;

//Lists the attributes with descriptive strings in the console for the user
    public String toString(){
        return "Name: "+ name + " Type: " + type + " Supernatural " + supernatural
                + " Location " + location;



// Getters and setters for arraylist attributes
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

        this.type = type;
    }


    public Boolean getSupernatural() {

        return supernatural;
    }


    public void setSupernatural(Boolean supernatural) {

        this.supernatural = supernatural;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;

    }
// class to hold the elements of the arrayList
    public static void createAnimals() {

//Elements of the array with predetermined attributes
        AnimalMain Cougar = new AnimalMain();
        Cougar.setName("Cougar");
        Cougar.setType("feline");
        Cougar.setSupernatural(false);
        Cougar.setLocation("North America");
        animalMainList.add(Cougar);


        AnimalMain Jaguar = new AnimalMain();
        Jaguar.setName("Jaguar");
        Jaguar.setType("feline");
        Jaguar.setSupernatural(false);
        Jaguar.setLocation("Africa");
        animalMainList.add(Jaguar);

        AnimalMain Puma = new AnimalMain();
        Puma.setName("Puma");
        Puma.setType("feline");
        Puma.setSupernatural(false);
        Puma.setLocation("South America");
        animalMainList.add(Puma);

        AnimalMain WolfSpider = new AnimalMain();
        WolfSpider.setName("Wolf Spider");
        WolfSpider.setType("Arachnid");
        WolfSpider.setSupernatural(false);
        WolfSpider.setLocation("North America");
        animalMainList.add(WolfSpider);

        AnimalMain DesertScorpion = new AnimalMain();
        DesertScorpion.setName("Desert Scorpion");
        DesertScorpion.setType("Arachnid");
        DesertScorpion.setSupernatural(false);
        DesertScorpion.setLocation("North America");
        animalMainList.add(DesertScorpion);

        AnimalMain Manticore = new AnimalMain();
        Manticore.setName("Manticore");
        Manticore.setType("Chimera");
        Manticore.setSupernatural(true);
        Manticore.setLocation("alternate reality");
        animalMainList.add(Manticore);

        AnimalMain Dragon = new AnimalMain();
        Dragon.setName("Dragon");
        Dragon.setType("Serpent");
        Dragon.setSupernatural(true);
        Dragon.setLocation("alternate reality");
        animalMainList.add(Dragon);

        AnimalMain Wolf = new AnimalMain();
        Wolf.setName("Grey Wolf");
        Wolf.setType("canine");
        Wolf.setSupernatural(false);
        Wolf.setLocation("North America");
        animalMainList.add(Wolf);

        AnimalMain Tasmanian_Devil = new AnimalMain();
        Tasmanian_Devil.setName("TasManian Devil");
        Tasmanian_Devil.setType("Marsupial");
        Tasmanian_Devil.setSupernatural(false);
        Tasmanian_Devil.setLocation("Tasmania");
        animalMainList.add(Tasmanian_Devil);
    }

    //Instantiate a scanner object
    private static Scanner userInput = new Scanner(System.in);

// main class
    public static void main(String[] args)throws IOException {


        // creates the file
       // creates a FileWriter Object

        //welcome message for the user
        System.out.println("Welcome to the Animal Array\n" +
                "Please remember to use underscores instead of spaces\n" +
                "and enter only single integers.\n" +
                "Thanks for visiting and have a wonderful time\n");
        //accesses the elements in the arrayList
        AnimalMain.createAnimals();

//while loop for continuous navigation, also provides a method for exit
        // calls the main methods and describes how to use them
        while (true) {
            System.out.println("Please type the function you would ike to use\n"+"Add\", \"Delete\"\",\n" +
                    "\"Display\", \"Quit\"");
            String input = userInput.next();
            if (input.equals("Quit")) {
                System.exit(0);
            }
            if (input.equals("Add")) {
                add();
            } else if (input.equals("Display")) {
                display();
            } else if (input.equals("Delete")) {
                 delete();
            }


        }
    }
//the main methods:
    public static void add() {
        //creates a temporary animal so that all attributes can be determined prior to write
        AnimalMain temp = new AnimalMain();
//creates a user dialogue to assist the user in the use of the program and accesses the method to add to the array

        System.out.println("Enter name: ");
        temp.name = userInput.next();
        System.out.println("What type of animal is this?");
        temp.type = userInput.next();
        System.out.println("Where is this animal located/live?(no spaces please)");
        temp.location = userInput.next();
        System.out.println("is supernatural? True/False?");
        temp.supernatural = userInput.nextBoolean();
        animalMainList.add(temp);
    }

// calls the current arrayList from memory
    public static void display()throws IOException  {
        System.out.println("\nList:");
        //loops through the array catching and displaying indexes to assist the user in deleting animals from the array
        for (int i = 0; i < animalMainList.size(); i++) {
            System.out.println(i + "-" + animalMainList.get(i));
        }

        FileWriter AnimalsArray = new FileWriter("Animal.txt");
        Writer Animal = new BufferedWriter(AnimalsArray);
        int sz = animalMainList.size();
        for (int i = 0; i < sz; i++ ){
            Animal.write(animalMainList.get(i).getName().toString() + "\n");
            Animal.write(animalMainList.get(i).getType().toString() + "\n");
            Animal.write(animalMainList.get(i).getLocation().toString() + "\n");
            Animal.write(animalMainList.get(i).getSupernatural().toString() + "\n");
        }
        Animal.flush();
        Animal.close();
    }
//allows the user to delete animals from memory by using the index of the animal object
    public static void delete(){
        System.out.println("Enter Animal Number: ");
        int animalNum = userInput.nextInt();
        animalMainList.remove(animalNum);

    }

}





