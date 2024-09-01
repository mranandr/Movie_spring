package com.movie.service;

import com.movie.entity.TicketModel;
import com.movie.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired(required=true)
    private TicketRepository ticketRepository;

    public TicketModel createTicket(TicketModel ticket) {
        return ticketRepository.save(ticket);
    }

    // Get a ticket by ID
    public Optional<TicketModel> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    // Get all tickets
    public List<TicketModel> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Update an existing ticket
    public TicketModel updateTicket(int id, TicketModel ticketDetails) {
        TicketModel ticket = ticketRepository.findById((long) id).orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setMovie(ticketDetails.getMovie());
        ticket.setSeatNo(ticketDetails.getSeatNo());
        ticket.setRow(ticketDetails.getRow());
        ticket.setLocation(ticketDetails.getLocation());
        ticket.setTheaterName(ticketDetails.getTheaterName());
        ticket.setTime(ticketDetails.getTime());

        return ticketRepository.save(ticket);
    }

    // Delete a ticket
    public void deleteTicket(Long id) {
        TicketModel ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticketRepository.delete(ticket);
    }
}
