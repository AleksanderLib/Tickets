import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FilePathInput {
    private  String filePath;

    public FileReader getFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу 'tickets.json': ");
        try {
            filePath = scanner.nextLine();
            return new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не найден по указанному пути.");
            return null;
        }
    }
}

