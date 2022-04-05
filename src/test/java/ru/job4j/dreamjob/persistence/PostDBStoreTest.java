package ru.job4j.dreamjob.persistence;

import org.junit.jupiter.api.Test;
import ru.job4j.dream.model.Post;
import ru.job4j.dreamjob.Main;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PostDBStoreTest {

    @Test
    public void whenCreatePost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post(0, "Java Job");
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenFindAll() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post(0, "Java Job");
        List<Post> list = store.findAll();
        store.add(post);
        List<Post> listTest = store.findAll();
        assertThat((listTest.size() - list.size()), is(1));
    }

    @Test
    void whenUpdatePost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post(0, "Java Job");
        store.add(post);
        Post updatePost = new Post(post.getId(), "Job4j_dreamJob");
        store.update(updatePost);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is("Job4j_dreamJob"));
    }
}