package com.movie.controller;

import com.movie.entity.TicketModel;
import com.movie.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired(required=true)
    private TicketService ticketService;

    // Create a new ticket
    @PostMapping
    public ResponseEntity<TicketModel> createTicket(@RequestBody TicketModel ticket) {
        TicketModel savedTicket = null;
        return ResponseEntity.ok(savedTicket);
    }
    // Get a ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<TicketModel> getTicketById(@PathVariable int id) {
        Optional<TicketModel> ticket = ticketService.getTicketById((long) id);
        return ticket.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all tickets
    @GetMapping
    public List<TicketModel> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // Update an existing ticket
    @PutMapping("/{id}")
    public ResponseEntity<TicketModel> updateTicket(@PathVariable int id, @RequestBody TicketModel ticketDetails) {
        return ResponseEntity.ok(ticketService.updateTicket(id, ticketDetails));
    }

    // Delete a ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable int id) {
        ticketService.deleteTicket((long) id);
        return ResponseEntity.noContent().build();
    }
}
