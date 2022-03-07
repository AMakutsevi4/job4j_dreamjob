package ru.job4j.dreamjob.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dreamjob.store.CandidateStore;

public class CandidateController {
    private final CandidateStore store = CandidateStore.instOf();

    @GetMapping("/candidates")
    public String candidates(Model model) {
        model.addAttribute("candidates", store.findAll());
        return "candidates";
    }

    @GetMapping("/addCandidate")
    public String addCandidate(Model model) {
        model.addAttribute("Candidate", new Candidate(0, "Заполните поле"));
        return "addCandidate";
    }
}
