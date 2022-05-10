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

    private List<TypeDTO> typeDTOS;

    public TypesController() {
        this.typeDTOS = new ArrayList<TypeDTO>();
        this.typeDTOS.add(new TypeDTO(1, "Electronic"));
        this.typeDTOS.add(new TypeDTO(2, "Food"));
    }

    @RequestMapping(value = "/types", method = RequestMethod.POST)
    public ResponseEntity<?> createType(@RequestBody TypeDTO typeDTO) {
        ApplicationError applicationError = new ApplicationError("400", "Error");
        try {
            this.typeDTOS.add(typeDTO);
            return ResponseEntity.ok(typeDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        }
    }

    @RequestMapping(value = "/types/{state}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTypes(@PathVariable("state") Boolean state) {
        if (state) {
            return ResponseEntity.ok(typeDTOS);
        } else {
            ApplicationError applicationError = new ApplicationError("400", "Error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        }

    }
}
