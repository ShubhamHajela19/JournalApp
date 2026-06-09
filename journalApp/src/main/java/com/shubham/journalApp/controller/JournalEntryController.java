package com.shubham.journalApp.controller;

import com.shubham.journalApp.entity.JournalEntry;
import com.shubham.journalApp.service.JournalEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private final JournalEntryService journalEntryService;

    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @GetMapping
    public List<JournalEntry> getGetAll() {    //localhost:8080/journal GET
        return journalEntryService.getAllEntries();
    }
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){ //localhost:8080/journal POST
        return journalEntryService.saveEntry(myEntry);
    }
    @GetMapping("/id/{myId}")
    public Optional<JournalEntry> getJournalEntryById(@PathVariable String myId){
        return journalEntryService.getEntryById(myId);
    }
    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable String myId){
        return journalEntryService.deleteEntryById(myId);
    }
    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable String id, @RequestBody JournalEntry myEntry){
        return journalEntryService.updateEntryById(id, myEntry);
    }
}
