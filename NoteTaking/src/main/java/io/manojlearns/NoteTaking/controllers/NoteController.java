package io.manojlearns.NoteTaking.controllers;

import io.manojlearns.NoteTaking.models.Note;
import io.manojlearns.NoteTaking.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/notes")
public class NoteController {

    @Autowired
    public NoteService noteService;

    @GetMapping("/")
    public ResponseEntity<List<Note>> getAll(){
        return ResponseEntity.ok(noteService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return ResponseEntity.ok(noteService.createNote(note));
    }

    @GetMapping("/pinned")
    public ResponseEntity<List<Note>> pinnedNote(){
        return ResponseEntity.ok(noteService.pinnedNote());
    }

    @GetMapping("/unpinned")
    public ResponseEntity<List<Note>> unpinnedNote(){
        return ResponseEntity.ok(noteService.unpinnedNote());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> getById(@PathVariable Integer id){
        return ResponseEntity.ok(noteService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Integer id, @RequestBody Note note){
        note.setId(id);
        return ResponseEntity.ok(noteService.updateNote(note));
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Integer id){
        noteService.deleteById(id);
    }


}
