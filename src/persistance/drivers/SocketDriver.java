package persistance.drivers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import interfaces.IDriver;

public class SocketDriver implements IDriver<String> {
    private Socket socket;

    private String destination = null;

    public SocketDriver(String destination) {
        this.destination = destination;
        try {
            socket = new Socket("127.0.0.1", 5005);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findById(String id) {
        OutputStream os;
        try {
            os = socket.getOutputStream();
            os.write(id.getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(String id, String data) {
        System.out.println("UPDATING " + id + " WITH DATA: " + data);
        OutputStream os;
        try {
            os = socket.getOutputStream();
            os.write(data.getBytes());
            os.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public String insert(String data) {
        System.out.println("INSERTING NEW ITEM WITH DATA: " + data);
        try {
            OutputStream os = socket.getOutputStream();
            os.write(data.getBytes());
            os.write("\\n".getBytes());
            os.close();
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) {
        System.out.println("DELETING " + id);
        OutputStream os;
        try {
            os = socket.getOutputStream();
            os.write(id.getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public String[] findAll(String query) {
        System.out.println("SEARCHING FOR " + query);
        OutputStream os;
        try {
            os = socket.getOutputStream();
            os.write(query.getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> rows = new ArrayList<String>(0);
        return (String[]) rows.toArray(new String[0]);
    }

}
