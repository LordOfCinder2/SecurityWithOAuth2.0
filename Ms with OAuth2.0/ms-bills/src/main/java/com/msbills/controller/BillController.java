package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_app_user')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_provider')")
    public ResponseEntity<Bill> postBill(@RequestBody Bill bill){
        return ResponseEntity.ok().body(service.postBill(bill));
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getBill(@RequestParam String id){
        return ResponseEntity.ok().body(service.getBill(id));
    }




}
