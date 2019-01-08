package ru.manyatkin.SpringTest6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.manyatkin.SpringTest6.entity.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByOrderByDateAsc();

    List<Note> findAllByOrderByDateDesc();

    Note findNoteById(Integer id);

    void deleteById(Integer id);
}
