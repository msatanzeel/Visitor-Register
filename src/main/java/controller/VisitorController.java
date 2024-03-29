package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.entities.Visitor;
import service.VisitorService;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/visitors")
public class VisitorController {

    private static final Logger logger = LogManager.getLogger();
    private VisitorService visitorServiceImpl;

    public VisitorService getVisitorServiceImpl() {
        return visitorServiceImpl;
    }

    @Autowired
    public void setVisitorServiceImpl(VisitorService visitorServiceImpl) {
        this.visitorServiceImpl = visitorServiceImpl;
    }


    @GetMapping(value = "/{visitorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Map<String,Object>> getVisitor(@PathVariable("visitorId") String visitorId) {
        Map<String, Object> response = new HashMap<>();
        logger.info("Entered the get visitor controller");
        try {
            Visitor visitor = visitorServiceImpl.getVisitorById(Integer.valueOf(visitorId));
            if (visitor != null) {
                response.put("data", visitor);
                response.put("status", "success");
                return ResponseEntity.ok(response);
            }
            else {
                response.put("status", "failed");
                response.put("message", "No user exists with the given user id");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

        } catch (Exception e) {
            logger.error(e.getStackTrace());
            response.put("status", "failed");
            response.put("message", "Unable to get Visitor information");
            response.put("cause", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Map<String, Object>> addVisitor(@RequestBody Visitor visitor) {
        Map<String, Object> response = new HashMap<>();
        logger.info("The visitor information is as follows: " + visitor);
        try {
            visitorServiceImpl.addVisitor(visitor);
            response.put("status", "success");
            response.put("message", "Visitor information has been added successfully");
            response.put("data", visitor);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            response.put("status", "failed");
            response.put("message", "Unable to save Visitor information");
            response.put("cause", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping(value = "/{visitorId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVisitor(@RequestBody Visitor visitor, @PathVariable("visitorId") String visitorId) {
        logger.info("Updating the visitor information for visitor: " + visitor);
        Map<String, Object> response = new HashMap<>();

        try {
            visitor.setVisitorID(Integer.parseInt(visitorId));
            Boolean updateSuccessful = visitorServiceImpl.updateVisitor(visitor);

            if(updateSuccessful) {
                response.put("message", "Visitor info has been updated successfully");
                response.put("status", HttpStatus.OK.value());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
            else {
                response.put("status", HttpStatus.NOT_FOUND.value());
                response.put("message", "Unable to update the visitor info as no such user exists");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
            response.put("status", "failed");
            response.put("message", "Unable to save Visitor information");
            response.put("cause", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @DeleteMapping("/{visitorId}")
    public @ResponseBody ResponseEntity deleteVisitor(@PathVariable("visitorId") String visitorId) {
        try{
            Map<String, Object> response = new HashMap<>();
            logger.info("Deleting the visitor information with userId" + visitorId);
            visitorServiceImpl.deleteVisitor(Integer.valueOf(visitorId));
            response.put("message", "Visitor info has been updated successfully");
            response.put("status", HttpStatus.OK.value());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting the visitor with userId " + visitorId);
        }
    }



}
