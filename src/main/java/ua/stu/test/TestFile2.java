package ua.stu.test;

import javax.swing.*;
import java.io.File;

public class TestFile2 {
    public static void main(String[] args) {
        JFileChooser dialog = new JFileChooser();
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setDialogTitle("Виберіть потрібні файли та папки");
        dialog.setApproveButtonText("Відкрити");
        dialog.setMultiSelectionEnabled(true);
        dialog.showOpenDialog(null);
        File[] ff = dialog.getSelectedFiles();
        if(ff != null){
            for(File f : ff)
                System.out.println(f.getAbsolutePath());
        }
    }
}
