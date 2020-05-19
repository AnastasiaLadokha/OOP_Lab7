package ua.stu.file;

import ua.stu.store.ProductStore;
import ua.stu.store.WoodDirectory;

import javax.swing.*;
import java.io.*;

public class OpenAndSave{
    public static void save(WoodDirectory woodDirectory, ProductStore productStore) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFileChooser dialog = new JFileChooser();
        dialog.setDialogTitle("Виберіть файли для збереження");
        dialog.setApproveButtonText("Зберегти");
        dialog.showOpenDialog(null);
        File f = dialog.getSelectedFile();
        if(f != null){
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(f);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(woodDirectory);
                objectOutputStream.writeObject(productStore);
                objectOutputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Object[] open() throws Exception{
        JFileChooser dialog = new JFileChooser();
        dialog.setDialogTitle("Виберіть файл для відкриття");
        dialog.setApproveButtonText("Відкрити");
        dialog.showOpenDialog(null);
        File f = dialog.getSelectedFile();
        if(f != null){
            Object[] obj = new Object[2];
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj[0] = ois.readObject();
            obj[1] = ois.readObject();
            ois.close();
            return obj;
        }else return null;
    }


}
