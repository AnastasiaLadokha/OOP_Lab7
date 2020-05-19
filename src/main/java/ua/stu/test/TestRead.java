package ua.stu.test;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestRead {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        JFileChooser dialog = new JFileChooser();
        dialog.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f != null)
                    return f.isDirectory() || f.toString().endsWith(".txt");
                return false;
            }
            @Override
            public String getDescription() {
                return "файли типу .txt";
            }
        });
        dialog.showOpenDialog(null);
        File f = dialog.getSelectedFile();
        if(f != null){
            System.out.println(f.getName());
            System.out.println(f.getAbsolutePath());
        }
        BufferedReader reader = null;
        if (f != null);{
            try {
                reader = new BufferedReader(new FileReader(f));
                String s;
                while ((s = reader.readLine()) != null)
                    System.out.println(s);
                reader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
