package ru.job4j.dreamjob.persistence;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
@Repository
public class CandidateStore {

    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Junior Java Job", "one", "05.03.2022"));
        candidates.put(2, new Candidate(2, "Middle Java Job", "two", "06.03.2022"));
        candidates.put(3, new Candidate(3, "Senior Java Job", "three", "07.03.2022"));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        candidates.put(candidate.getId(), candidate);
    }

    public Object findById(int id) {
        return candidates.get(id);
    }

    public void update(Candidate candidate) {
        candidates.put(candidate.getId(), candidate);
    }

    public void create(Candidate candidate) {
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate getById(Integer candidateId) {
        return candidates.get(candidateId);
    }

    public Candidate get(int id) {
        return candidates.get(id);
    }
}