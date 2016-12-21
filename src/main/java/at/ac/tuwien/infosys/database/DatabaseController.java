package at.ac.tuwien.infosys.database;


import at.ac.tuwien.infosys.database.impl.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;

/**
 * Created by Kevin Bachmann on 27/10/2016.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/db/")
public class DatabaseController {

    @Autowired
    private DatabaseService dbService;

    @PostConstruct
    public void init(){    }


    @RequestMapping(method = RequestMethod.GET, value="")
    public Map<String, String> getAll(){
        return dbService.getAll();
    }


    @RequestMapping(method = RequestMethod.GET, value="{key}")
    public String getValue(@PathVariable String key){
        return dbService.getValue(key);
    }

    @RequestMapping(method = RequestMethod.POST, value="{key}/{value}")
    public void setValue(@PathVariable String key, @PathVariable String value){
        dbService.setValue(key, value);
    }
}