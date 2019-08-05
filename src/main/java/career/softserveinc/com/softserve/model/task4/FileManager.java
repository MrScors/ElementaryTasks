
package main.java.career.softserveinc.com.softserve.model.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileManager {

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

    //C:\MrScors\Args.txt test

    int countNumberOfSubstrings(String wanted) throws IOException {
        int result = 0;
        String str = readFile().toString();
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

    void changeSubstringsToAnotherInFile(String oldOne, String newOne) throws IOException {
        writeToFile(changeSubstringsToAnother(oldOne, newOne));
    }

    private String changeSubstringsToAnother(String oldOne, String newOne) throws IOException {
        int oldInCharsCounter = 0;
        int newInCharsCounter = 0;
        int fileContentCounter = 0;
        char[] oldInChars = oldOne.toCharArray();
        char[] newInChars = newOne.toCharArray();
        char[] fileContentAsChars = readFile().toString().toCharArray();
        List<Character> fileContent = new ArrayList<>();
        for (char fileContentAsChar : fileContentAsChars) {
            fileContent.add(fileContentAsChar);
        }

        do{
            if(oldInCharsCounter == oldInChars.length) break;
            if(oldInChars[oldInCharsCounter]==fileContent.get(fileContentCounter++)) oldInCharsCounter++;
            else break;
        }while (true);
        if(oldInCharsCounter == oldInChars.length);

        String str = readFile().toString();
        do{
            if(str.contains(oldOne)) {
                str = str.replaceAll(oldOne, newOne);
            } else break;
        }while(true);
        return str;
    }

    private void writeToFile(String str) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filePath);
        fileOut.write(str.getBytes());
        fileOut.close();
    }

}
