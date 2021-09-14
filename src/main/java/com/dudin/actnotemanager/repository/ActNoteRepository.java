package com.dudin.actnotemanager.repository;

import com.dudin.actnotemanager.model.ActNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActNoteRepository extends JpaRepository<ActNote, Long> {

}
