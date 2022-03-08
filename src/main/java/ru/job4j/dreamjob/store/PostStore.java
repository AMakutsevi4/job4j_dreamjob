package ru.job4j.dreamjob.store;

import ru.job4j.dream.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostStore {

    private static final PostStore INST = new PostStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private int size = 4;

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "one", "05.03.2022"));
        posts.put(2, new Post(2, "Middle Java Job", "two", "06.03.2022"));
        posts.put(3, new Post(3, "Senior Java Job", "three", "07.03.2022"));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        posts.put(size++, post);
    }
}