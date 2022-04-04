package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dreamjob.persistence.CandidateDbStore;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {

    private final CandidateDbStore store;

    public CandidateService(CandidateDbStore store) {
        this.store = store;
    }

    public List<Candidate> findAll() {
        return new ArrayList<>(store.findAll());
    }

    public void add(Candidate candidate) {
        store.add(candidate);
    }

    public void update(Candidate candidate) {
        store.update(candidate);
    }

    public Candidate findById(int id) {
        return store.findById(id);
    }
}
