package io.manojlearns.NoteTaking.repositories;

import io.manojlearns.NoteTaking.models.Note;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {

    public Optional<Note> findById(Integer id);

    public List<Note> findByPinnedTrue();

    public List<Note> findByPinnedFalse();


}
