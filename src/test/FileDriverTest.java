package test;

import persistance.drivers.FileDriver;

public class FileDriverTest {
    public static void main(String[] args) {
        FileDriver fd = new FileDriver("ss");
        String id = fd.insert("man");
        System.out.println(id);
        System.out.println(fd.findById("2"));
        fd.update("2", "hiiii");
        System.out.println(fd.findById("2"));
        fd.delete("2");
        System.out.println(fd.findById("2"));

    }

}
