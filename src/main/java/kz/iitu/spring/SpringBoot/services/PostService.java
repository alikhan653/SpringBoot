package kz.iitu.spring.SpringBoot.services;

import kz.iitu.spring.SpringBoot.entities.Posts;
import kz.iitu.spring.SpringBoot.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Posts> getAllPosts(){
        return postRepository.findAll();
    }

    public void addPost(Posts post){
        postRepository.save(post);
    }

    public Posts getPost(Long id){
        Optional<Posts> opt = postRepository.findById(id);
        return opt.orElse(new Posts(0L, "NO TITLE", "NO CONTENT", null));
    }

    public void savePost(Posts post){
        postRepository.save(post);
    }
    public void deletePost(Posts post){
        postRepository.delete(post);
    }

}
