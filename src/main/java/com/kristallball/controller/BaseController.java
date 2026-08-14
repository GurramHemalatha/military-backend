package com.kristallball.controller;

import com.kristallball.entity.Base;
import com.kristallball.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bases")
@CrossOrigin(origins = {"http://localhost:5173", "https://military-frontend-six.vercel.app"})
public class BaseController {

    private final BaseService baseService;

    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public ResponseEntity<List<Base>> getAllBases() {
        return ResponseEntity.ok(baseService.getAllBases());
    }

    @PostMapping
    public ResponseEntity<Base> createBase(@RequestBody Base base) {
        Base savedBase = baseService.saveBase(base);
        return new ResponseEntity<>(savedBase, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBase(@PathVariable Long id) {
        baseService.deleteBase(id);
        return ResponseEntity.noContent().build();
    }
}