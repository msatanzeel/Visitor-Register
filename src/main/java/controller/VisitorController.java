package controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.entities.Visitor;
import repository.models.GenericAPIResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class VisitorController {

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GenericAPIResponse addVisitor(Model model, @RequestBody Visitor visitor) {
        System.out.println("The visitor information is as follows: " + visitor);
        GenericAPIResponse<Visitor> response = new GenericAPIResponse<>();
        response.setStatus("success");
        response.setMessage("visitor has been added successfully");
        response.setData(visitor);
        return response;
    }

    public String updateVisitor(Model model, @RequestBody Visitor visitor) {
        return "";
    }

}
