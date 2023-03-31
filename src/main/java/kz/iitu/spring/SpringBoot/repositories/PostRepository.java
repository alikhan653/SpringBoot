package kz.iitu.spring.SpringBoot.repositories;

import jakarta.transaction.Transactional;
import kz.iitu.spring.SpringBoot.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Posts, Long> {



}
