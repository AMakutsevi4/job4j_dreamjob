package ru.job4j.dreamjob.persistence;


import org.junit.jupiter.api.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dreamjob.Main;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CandidateDbStoreTest {

    @Test
    public void whenCreateCandidate() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate = new Candidate(0, "Alexandr");
        store.add(candidate);
        Candidate candidateInDb = store.findById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenFindAllCandidate() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate = new Candidate(0, "Alexandr");
        List<Candidate> list = store.findAll();
        store.add(candidate);
        List<Candidate> listTest = store.findAll();
        assertThat((listTest.size() - list.size()), is(1));
    }

    @Test
    void whenUpdateCandidate() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate = new Candidate(0, "Alexandr");
        store.add(candidate);
        Candidate updateCandidate = new Candidate(candidate.getId(), "Alexandr little junior");
        store.update(updateCandidate);
        Candidate postInDb = store.findById(candidate.getId());
        assertThat(postInDb.getName(), is("Alexandr little junior"));
    }
}