package controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.entities.Visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class VisitorController {

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> addVisitor(Model model, @RequestBody Visitor visitor) {
        System.out.println("The visitor information is as follows: " + visitor);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Visitor information has been added successfully");
        response.put("data", visitor);
        return ResponseEntity.ok(response);
    }

    public String updateVisitor(Model model, @RequestBody Visitor visitor) {
        return "";
    }

}
