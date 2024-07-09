package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.ids.PostLikeId;

@Entity
@Table(schema = "posts")
public class PostLike implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PostLikeId id;
    
	@JsonIgnoreProperties({"id", "followers", "followeds"})
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@JsonIgnoreProperties({"profile", "reactionsPost"})
	@ManyToOne
	@MapsId("postId")
	@JoinColumn(name = "post_id")
	private Post post;

	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, updatable = false)
	private long likedAt;

	public PostLike() {
	
	}

	public PostLike(User user, Post post, long likedAt) {
		this.id = new PostLikeId(user.getId(), post.getId());
		this.user = user;
		this.post = post;
		this.likedAt = likedAt;
	}

	public PostLike(PostLikeId id, User user, Post post, long likedAt) {
		this.id = id;
		this.user = user;
		this.post = post;
		this.likedAt = likedAt;
	}

	public PostLikeId getId() {
		return id;
	}

	public void setId(PostLikeId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostLike other = (PostLike) obj;
		return id == other.id;
	}
    
}
