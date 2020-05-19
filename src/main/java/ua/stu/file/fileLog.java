package ua.stu.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class fileLog {
    public static String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Log.txt"));
            String s;
            while ((s = bufferedReader.readLine()) != null){
                stringBuilder.append(s);
                stringBuilder.append("\n");
            }
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void writeLog(String string){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter("Log.txt", true));
            bufferedWriter.write(string);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
