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
public class VisitorController {

    @Autowired
    private VisitorService visitorServiceImpl;

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> addVisitor(Model model, @RequestBody Visitor visitor) {
        System.out.println("The visitor information is as follows: " + visitor);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Visitor information has been added successfully");
        response.put("data", visitor);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/updateVisitor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVisitor(Model model, @RequestBody Visitor visitor) {
        System.out.println("Updating the visitor information for visitor: " + visitor);
        Boolean updateSuccessful = true; //visitorServiceImpl.updateVisitor(visitor);
        Map<String, Object> response = new HashMap<>();

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



}
