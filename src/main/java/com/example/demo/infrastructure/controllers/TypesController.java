package com.example.demo.infrastructure.controllers;

import com.example.demo.shared.models.ApplicationError;
import com.example.demo.types.application.models.TypeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TypesController {

    @RequestMapping(value = "/types/{state}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTypes(@PathVariable("state") Boolean state) {
        if (state) {
            List<TypeDTO> typeDTOS = new ArrayList<>();
            typeDTOS.add(new TypeDTO(1, "Electronic"));
            typeDTOS.add(new TypeDTO(2, "Food"));
            return ResponseEntity.ok(typeDTOS);
        } else {
            ApplicationError applicationError = new ApplicationError("400", "Error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        }

    }
}
