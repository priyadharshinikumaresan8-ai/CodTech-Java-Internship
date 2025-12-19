import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- File Handling Utility ---");
            System.out.println("1. Write to file");
            System.out.println("2. Read file");
            System.out.println("3. Modify file (Append)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    writeFile();
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    modifyFile();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void writeFile() {
        try {
            FileWriter fw = new FileWriter("data.txt");
            System.out.print("Enter text to write into file: ");
            String data = sc.nextLine();
            fw.write(data);
            fw.close();
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    static void readFile() {
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("\nFile Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    static void modifyFile() {
        try {
            FileWriter fw = new FileWriter("data.txt", true);
            System.out.print("Enter text to append: ");
            String data = sc.nextLine();
            fw.write("\n" + data);
            fw.close();
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file.");
        }
    }
}
