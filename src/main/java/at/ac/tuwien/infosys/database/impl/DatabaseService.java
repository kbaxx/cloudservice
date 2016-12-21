package at.ac.tuwien.infosys.database.impl;

import at.ac.tuwien.infosys.database.IDatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Kevin Bachmann on 11/11/2016.
 */
@Service
@Slf4j
public class DatabaseService implements IDatabaseService {

    @Autowired
    private RedisService redisService;

    public void delete(String key){
        redisService.deleteKey(key);
    }

    public Set<String> getKeys(){
        return redisService.getKeys();
    }

    public String getValue(String key){
        return redisService.getValue(key);
    }

    public void setValue(String key, String value){
        redisService.setValue(key, value);
    }

    public Map<String, String> getAll(){
        return redisService.getAll();
    }
}
