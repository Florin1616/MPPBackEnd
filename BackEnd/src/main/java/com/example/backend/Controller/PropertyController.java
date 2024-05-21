package com.example.backend.Controller;

import com.example.backend.Model.Property;
import com.example.backend.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getProperty(@PathVariable int id) {
        return propertyService.getProperty(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Property createProperty(@RequestBody Property newProperty) {
        return propertyService.addProperty(newProperty);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable int id, @RequestBody Property updatedProperty) {
        try {
            return propertyService.getProperty(id)
                    .map(property -> {
                        property.setPerson(updatedProperty.getPerson());
                        property.setPropertyType(updatedProperty.getPropertyType());
                        property.setPropertyAddress(updatedProperty.getPropertyAddress());
                        property.setPropertyValue(updatedProperty.getPropertyValue());
                        return ResponseEntity.ok(propertyService.updateProperty(property));
                    })
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            // Log the exception
            System.out.println("Error updating property: " + e.getMessage());
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable int id) {
        propertyService.getProperty(id)
                .ifPresent(property -> propertyService.deleteProperty(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/person/{personId}")
    public List<Property> getPropertiesByPerson(@PathVariable int personId) {
        return propertyService.getPropertiesByPerson(personId);
    }
}