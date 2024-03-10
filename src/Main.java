import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i++;
            System.out.println("Укажите путь к файлу:");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if ((fileExists == false) || (isDirectory == true)) {
                System.out.println("Файл не существует или указанный путь является путём к папке, а не к файлу!");
                continue;
            } else {
                System.out.println("Путь указан верно!");
                System.out.println("Это файл номер: "+i);
                break;
            }
        }
    }
}
