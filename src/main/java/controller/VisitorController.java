package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.entities.Visitor;
import service.VisitorService;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(value = "/visitors")
public class VisitorController {

    private VisitorService visitorServiceImpl;

    public VisitorService getVisitorServiceImpl() {
        return visitorServiceImpl;
    }

    @Autowired
    public void setVisitorServiceImpl(VisitorService visitorServiceImpl) {
        this.visitorServiceImpl = visitorServiceImpl;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> addVisitor(@RequestBody Visitor visitor) {
        Map<String, Object> response = new HashMap<>();
        System.out.println("The visitor information is as follows: " + visitor);
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
        System.out.println("Updating the visitor information for visitor: " + visitor);
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
            System.out.println("Deleting the visitor information with userId" + visitorId);
            visitorServiceImpl.deleteVisitor(Integer.valueOf(visitorId));
            response.put("message", "Visitor info has been updated successfully");
            response.put("status", HttpStatus.OK.value());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting the visitor with userId " + visitorId);
        }
    }



}
