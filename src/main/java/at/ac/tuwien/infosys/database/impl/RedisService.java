package at.ac.tuwien.infosys.database.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Kevin Bachmann on 27/10/2016.
 */
@Service
@Slf4j
public class RedisService {

    private Jedis connection = null;

    @Value("${cloud.redis.port}")
    private int port;
    @Value("${cloud.redis.host}")
    private String redisHost;

    /**
     * Starts an embedded redis server on construction of this bean.
     * @throws IOException if something happens with the port or the creation of the server
     */
    @PostConstruct
    private void startRedis() throws IOException {
        // open the connection with the server
        createConnection();
    }

    /**
     * Stops the embedded redis server when this bean is destroyed.
     */
    @PreDestroy
    private void stopRedis() {
        closeConnection();
    }

    private Jedis createConnection(){
        log.info("Connection attempt to "+redisHost+":"+port);
        connection = new Jedis(redisHost, port);
        //check whether server is running or not
        log.info("Server is running: " + connection.ping());
        return connection;
    }

    private void closeConnection(){
        connection.close();
        connection = null;
        log.info("DB Connection closed");
    }


    /**
     * #########################################################################################################
     * #########################################################################################################
     */


    public String getValue(String key){
        return connection.get(key);
    }

    public Set<String> getKeys(){
        return connection.keys("*");
    }

    public Map<String, String> getAll(){
        Set<String> keys = getKeys();
        Map<String, String> map = new HashMap<String, String>();
        for(String key : keys){
            map.put(key, connection.get(key));
        }
        return map;
    }

    public void setValue(String key, String value){
        connection.set(key, value);
    }

    public void deleteKey(String key){
        connection.del(key);
    }
}
