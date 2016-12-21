package at.ac.tuwien.infosys.database;

import java.util.Map;
import java.util.Set;

/**
 * Created by Kevin Bachmann on 11/11/2016.
 */
public interface IDatabaseService {
    void delete(String key);
    Set<String> getKeys();
    String getValue(String key);
    void setValue(String key, String value);

    /**
     * GETTER
     */

    Map<String, String> getAll();


    /**
     * SETTER
     */

}