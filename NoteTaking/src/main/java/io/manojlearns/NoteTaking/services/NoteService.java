package io.manojlearns.NoteTaking.services;

import io.manojlearns.NoteTaking.models.Note;
import io.manojlearns.NoteTaking.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    public NoteRepository noteRepository;

    public List<Note> findAll(){
        return noteRepository.findAll();
    }

    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    public Optional<Note> findById(Integer id){
        return noteRepository.findById(id);
    }

    public List<Note> pinnedNote(){
        return noteRepository.findByPinnedTrue();
    }

    public List<Note> unpinnedNote(){
        return noteRepository.findByPinnedFalse();
    }

    public Note updateNote(Note note){
        return noteRepository.save(note);
    }

    public void deleteById(Integer id){
          noteRepository.deleteById(id);
    }


}
