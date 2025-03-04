package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.ids.SavedPostId;

@Entity
@Table(schema = "users")
public class SavedPost implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SavedPostId id;
	
	@JsonIncludeProperties({"username", "name", "photoPath"})
	@ManyToOne
	@MapsId("savedByUserId")
	@JoinColumn(name = "saved_by_id")
	private User user;

	@JsonIncludeProperties({"id", "profile.isPublic", "medias"})
	@ManyToOne
	@MapsId("postId")
	@JoinColumn(name = "post_id")
	private Post post;
    
	@JsonIgnoreProperties({"savedPosts"})
	@ManyToMany(mappedBy = "savedPosts")
	private Set<PostList> postLists;

	public SavedPost() {
		
	}

	public SavedPost(SavedPostId id, User user, Post post) {
		this.id = id;
		this.user = user;
		this.post = post;
	}

	public SavedPostId getId() {
		return id;
	}

	public void setId(SavedPostId id) {
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

	public Set<PostList> getPostLists() {
		return postLists;
	}

	public void setPostLists(Set<PostList> postLists) {
		this.postLists = postLists;
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
		SavedPost other = (SavedPost) obj;
		return Objects.equals(id, other.id);
	}
    
}
