package interfaces;

import java.util.List;

/**
 * IStorageAdapter is responsible for I/O operations for catalogs.
 * It must be implemented for the persistent storage ex. local file system or
 * any database technology.
 */
public interface IStorageAdapter {

    /**
     * Saves all items in storage.
     * 
     * @param content String of comma separated attributes of items including in
     *                multiple lines.
     */
    public void saveAll(String content);

    /**
     * Saves data related to item with given id.
     * 
     * @param id   id of item
     * @param data string of comma separated attributes of item.
     */
    public void save(int id, String data);

    /**
     * loads all items in a {@code List} object.
     * 
     * @return
     */
    public List loadAll();

    /**
     * Returns single item from catalog.
     * 
     * @param id id of item
     * @return raw string of comma separated attributes of item.
     */
    public String load(int id);

    /**
     * Deletes single item from catalog.
     * 
     * @param id id of item
     */
    public void delete(int id);

}
