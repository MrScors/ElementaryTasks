
package main.java.career.softserveinc.com.softserve.model.task4;

import java.io.*;

class FileManager {

    private String filePath;
    private BufferedReader fileReader;
    private FileOutputStream fileWriter;

    FileManager(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.fileReader = new BufferedReader(new FileReader(filePath));
        this.fileWriter = new FileOutputStream(filePath);
    }

    FileManager(String filePath, BufferedReader fileReader) throws FileNotFoundException {
        this.fileReader = fileReader;
        this.fileWriter = new FileOutputStream(filePath);
    }

    FileManager(BufferedReader fileReader, FileOutputStream fileWriter) throws FileNotFoundException {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }


    String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = fileReader.readLine()) != null) {
            sb.append(line);
            sb.append('\n');
        }
        return sb.toString().substring(0, sb.length()-1);
    }

    //C:\MrScors\Args.txt test

    int countNumberOfSubstrings(String wanted) throws IOException {
        int result = 0;
        String str = readFile();
        wanted = wanted.replaceAll("\\s+","");
        str = str.replaceAll("\\s+","");
        do{
            if(str.contains(wanted)) {
                str = str.substring(str.indexOf(wanted)+wanted.length());
                result++;
            } else break;
        }while(true);

        return result;
    }

    String changeSubstringsToAnotherInFile(String oldOne, String newOne) throws IOException {
        String str = readFile();
        str = str.replaceAll(oldOne, newOne);
        str = str.replaceAll(oldOne.replaceAll(" ", "\n"),
                newOne.replaceAll(" ", "\n"));
        str = str.replaceAll(oldOne.replaceAll(" ", "\t"),
                newOne.replaceAll(" ", "\t"));
        writeToFile(str);
        return str;
    }

    private void writeToFile(String str) throws IOException {
        fileWriter.write(str.getBytes());
        fileWriter.close();
    }

}
