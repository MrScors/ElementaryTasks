
package main.java.career.softserveinc.com.softserve.model.task4;

import java.io.*;

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
        str = str.replaceAll("\\s+","");
        do{
            if(str.contains(wanted)) {
                str = str.substring(str.indexOf(wanted)+wanted.length());
                result++;
            } else break;
        }while(true);

        return result;
    }

    void changeSubstringsToAnother(String oldOne, String newOne) throws IOException {
        // input the (modified) file content to the StringBuffer "input"
        String str = readFile().toString();
        do{
            if(str.contains(oldOne)) {
                str = str.replaceAll(oldOne, newOne);
            } else break;
        }while(true);

        // write the new string with the replaced line OVER the same file
        FileOutputStream fileOut = new FileOutputStream(filePath);
        fileOut.write(str.getBytes());
        fileOut.close();

    }

}
