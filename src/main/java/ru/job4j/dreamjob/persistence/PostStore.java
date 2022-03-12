package ru.job4j.dreamjob.persistence;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class PostStore {

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final AtomicInteger size = new AtomicInteger(4);

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "one", "05.03.2022"));
        posts.put(2, new Post(2, "Middle Java Job", "two", "06.03.2022"));
        posts.put(3, new Post(3, "Senior Java Job", "three", "07.03.2022"));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        post.setId(size.incrementAndGet());
        posts.put(post.getId(), post);
    }

    public Object findById(int id) {
        return posts.get(id);
    }

    public void update(Post post) {
        posts.put(post.getId(), post);
    }

    public void create(Post post) {
        posts.put(post.getId(), post);
    }
}