package com.shubham.journalApp.service;

import com.shubham.journalApp.entity.JournalEntry;
import com.shubham.journalApp.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;

    public JournalEntryService(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    public JournalEntry saveEntry(JournalEntry journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(String id) {
        return journalEntryRepository.findById(id);
    }

    public boolean deleteEntryById(String id) {
        if (!journalEntryRepository.existsById(id)) {
            return false;
        }
        journalEntryRepository.deleteById(id);
        return true;
    }

    public JournalEntry updateEntryById(String id, JournalEntry journalEntry) {
        journalEntry.setId(id);
        return journalEntryRepository.save(journalEntry);
    }

}
//controller --> service --> repository
