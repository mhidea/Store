package persistance.drivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.IDriver;

public class FileDriver implements IDriver<String> {
    private File file;
    private String filesHome = "./persistanceFiles/";
    private String destination = null;

    public FileDriver(String destination) {
        this.destination = destination;
        try {
            file = new File(filesHome + destination);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());

            e.printStackTrace();
        }
    }

    public String findById(String id) {
        System.out.println("LOOKING FOR " + id);

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

            e.printStackTrace();
        }
        return row;
    }

    @Override
    public void update(String id, String data) {
        System.out.println("UPDATING " + id + " WITH DATA: " + data);
        Scanner sc;
        try {
            sc = new Scanner(file);
            // instantiating the StringBuffer class
            StringBuffer buffer = new StringBuffer();
            // Reading lines of the file and appending them to StringBuffer
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.matches(id + ",.*")) {
                    buffer.append(id + "," + data + System.lineSeparator());
                } else {
                    buffer.append(line + System.lineSeparator());
                }
            }
            String fileContents = buffer.toString();
            // closing the Scanner object
            sc.close();
            FileWriter writer = new FileWriter(file);
            writer.append(fileContents);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }

    }

    @Override
    public String insert(String data) {
        System.out.println("INSERTING NEW ITEM WITH DATA: " + data);
        Scanner sc;
        int index = 0;

        try {
            sc = new Scanner(file);
            // instantiating the StringBuffer class
            StringBuffer buffer = new StringBuffer();
            // Reading lines of the file and appending them to StringBuffer
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                buffer.append(line + System.lineSeparator());
                index = Math.max(index, Integer.parseInt(line.split(",")[0].replaceAll(" ", "")));
            }
            // closing the Scanner object
            sc.close();
            index++;
            buffer.append(index + "," + data);
            FileWriter writer = new FileWriter(file);
            writer.append(buffer);
            writer.flush();
            writer.close();
            return index + "";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public void delete(String id) {
        System.out.println("DELETING " + id);

        Scanner sc;
        try {
            sc = new Scanner(file);
            // instantiating the StringBuffer class
            StringBuffer buffer = new StringBuffer();
            // Reading lines of the file and appending them to StringBuffer
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.matches(id + ",.*")) {
                    buffer.append(line + System.lineSeparator());
                }
            }
            // closing the Scanner object
            sc.close();
            FileWriter writer = new FileWriter(file);
            writer.append(buffer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public String[] findAll(String query) {
        System.out.println("SEARCHING FOR " + query);

        List<String> rows = new ArrayList<String>(0);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (s.matches(query)) {
                    rows.add(s);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return (String[]) rows.toArray(new String[0]);
    }

}
