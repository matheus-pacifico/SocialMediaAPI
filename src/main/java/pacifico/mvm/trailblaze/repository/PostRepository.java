package pacifico.mvm.trailblaze.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pacifico.mvm.trailblaze.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    
    @Query(value = "SELECT postData FROM posts.find_by_post_code(:postCode)", nativeQuery = true)
    public Optional<String> findByPostCode(@Param("postCode") String postCode);
    
}
