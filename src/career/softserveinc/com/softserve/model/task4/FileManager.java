
package career.softserveinc.com.softserve.model.task4;

import java.io.*;
import java.util.Scanner;


public class FileManager {

    private String filePath;

    FileManager(String filePath) {
        this.filePath = filePath;
    }

    StringBuilder readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader file = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = file.readLine()) != null) {
            sb.append(line);
            sb.append('\n');
        }
        return sb;
    }

    int countNumberOfSubstrings(String wanted) throws FileNotFoundException {
        int result = 0;
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            result += line.length() - line.replace(wanted, "").length();
        }
        sc.close();
        return result / wanted.length();
    }

    void changeSubstringsToAnother(String oldOne, String newOne) throws IOException {
        // input the (modified) file content to the StringBuffer "input"
        BufferedReader file = new BufferedReader(new FileReader(filePath));
        StringBuilder inputBuffer = new StringBuilder();
        String line;

        while ((line = file.readLine()) != null) {
            line = line.replaceAll(oldOne, newOne);
            inputBuffer.append(line);
            inputBuffer.append('\n');
        }
        file.close();

        // write the new string with the replaced line OVER the same file
        FileOutputStream fileOut = new FileOutputStream(filePath);
        fileOut.write(inputBuffer.toString().getBytes());
        fileOut.close();

    }

    public static boolean checkFilePath(String filePath) {
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            sc.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("This filepath is invalid, enter another one");
            return false;
        }
    }

}
