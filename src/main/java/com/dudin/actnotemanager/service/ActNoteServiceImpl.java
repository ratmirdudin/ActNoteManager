package com.dudin.actnotemanager.service;

import com.dudin.actnotemanager.model.ActNote;
import com.dudin.actnotemanager.model.MyLocalDate;
import com.dudin.actnotemanager.repository.ActNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActNoteServiceImpl implements ActNoteService {
    private final ActNoteRepository repository;

    @Autowired
    public ActNoteServiceImpl(ActNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ActNote> listAll() {
        return repository.findAll();
    }

    @Override
    public void save(ActNote actNote) {

        actNote.setDateOfChange(new MyLocalDate().getMyLocalDate());
        if (actNote.isFlagStatusOfNewborn()) {
            actNote.setStatusOfNewborn("Брошенный ребенок / Мать умерла");
        } else {
            actNote.setStatusOfNewborn("Нормально");
        }

        repository.save(actNote);
    }

    @Override
    public ActNote get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
