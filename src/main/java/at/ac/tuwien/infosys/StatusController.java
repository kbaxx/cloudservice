package at.ac.tuwien.infosys;


import at.ac.tuwien.infosys.database.impl.RedisService;
import at.ac.tuwien.infosys.fogactioncontrol.IFogActionControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by Kevin Bachmann on 27/10/2016.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class StatusController {

    @Autowired
    private RedisService redisService;

    /**
     * requests the status of the Service
     *
     * @return a String with HTML code for the display of availability
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getPage(){
        String html = "<html><head></head><body style='background: gray; text-align: center; color: white'>" +
                "<h1>"+ "Cloud DB Status-Page</h1>";
        for (Map.Entry<String,String> entry : redisService.getAll().entrySet()) {
            html += "<p>"+entry.getKey()+": "+entry.getValue()+"</p>";
        }
        return html;
    }
}



