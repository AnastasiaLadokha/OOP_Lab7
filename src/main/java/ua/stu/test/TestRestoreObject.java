package ua.stu.test;

import ua.stu.store.WoodDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestRestoreObject {
    public static void main(String[] args) {
        WoodDirectory woodDirectory = null;
        File f = new File("woodDirectory.object");
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            woodDirectory = (WoodDirectory) objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (woodDirectory != null){
            for (Object w : woodDirectory.getArr())
                System.out.println(w.toString());
        }
    }
}
