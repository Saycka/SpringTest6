package ru.manyatkin.SpringTest6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.manyatkin.SpringTest6.entity.Note;
import ru.manyatkin.SpringTest6.repository.NoteRepository;
import ru.manyatkin.SpringTest6.service.NoteService;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository repository;

    @Autowired
    public void setProductRepository(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Note getNoteById(Integer id) {
        return repository.findNoteById(id);
    }

    @Override
    public void saveNote(Note note) {
        repository.save(note);
    }

    @Override
    public void updateNote(Integer id, String message, boolean done) {
        Note updated = repository.findNoteById(id);
        updated.setDone(done);
        updated.setMessage(message);
        repository.save(updated);
    }

    @Override
    public void deleteNote(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Note> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Note> findAllByOrderByDateAsc() {
        return repository.findAllByOrderByDateAsc();
    }

    @Override
    public List<Note> findAllByOrderByDateDesc() {
        return repository.findAllByOrderByDateDesc();
    }


}
