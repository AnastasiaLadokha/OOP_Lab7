package ua.stu.test;

import ua.stu.model.Wood;
import ua.stu.store.WoodDirectory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestStoreObject {
    public static void main(String[] args) {
        WoodDirectory woodDirectory = new WoodDirectory();
        woodDirectory.add(new Wood(4, "Дуб", 1f));
        File f = new File("woodDirectory.object");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(f);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(woodDirectory);
            objectOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
