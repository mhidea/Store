package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import interfaces.IStorageAdapter;

public class LocalFileStorageAdapter implements IStorageAdapter {
    private File file;

    public LocalFileStorageAdapter(String filePath) throws IOException {
        file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<String> loadAll() {
        List<String> l = new LinkedList<String>();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                l.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public void saveAll(String content) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            out.write(content.getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String load(int id) {
        String row = null;
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (s.startsWith(id + ",")) {
                    row = s;
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return row;
    }

    @Override
    public void save(int id, String data) {
        // TODO Auto-generated method stub

    }

}
