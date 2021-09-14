package com.dudin.actnotemanager.service;

import com.dudin.actnotemanager.model.ActNote;

import java.util.List;

public interface ActNoteService {
    List<ActNote> listAll();

    void save(ActNote actNote);

    ActNote get(Long id);

    void delete(Long id);

}
