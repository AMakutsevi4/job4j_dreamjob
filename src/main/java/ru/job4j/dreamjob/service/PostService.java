package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Post;
import ru.job4j.dreamjob.persistence.PostDBStore;

import java.util.Collection;

@Service
public class PostService {

    private final PostDBStore store;

    public PostService(PostDBStore store) {
        this.store = store;
    }

    public Collection<Post> findAll() {
        return store.findAll();
    }

    public void add(Post post) {
        store.add(post);
    }

    public Object findById(int id) {
        for (Post post : findAll()) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public void update(Post post) {
        store.update(post);
    }

    public void create(Post post) {
        store.add(post);
    }
}
