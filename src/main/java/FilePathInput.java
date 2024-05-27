import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FilePathInput {
    private String filePath;

    public FileReader getFile() {
        Scanner scanner = new Scanner(System.in);
        boolean fileFound = false;
        while (!fileFound) {
            System.out.print("Введите путь к файлу 'tickets.json': ");
            try {
                filePath = scanner.nextLine();
                File file = new File(filePath);
                if (file.exists()) {
                    fileFound = true;
                    return new FileReader(file);
                } else {
                    System.out.println("Файл не найден по указанному пути.");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
