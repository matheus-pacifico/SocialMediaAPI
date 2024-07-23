package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;

@Entity
@Table(
		schema = "posts", 
		indexes = @Index(name = "idx_tag", columnList = "tag", unique = true),
		uniqueConstraints = @UniqueConstraint(name = "unique_post_htag", columnNames = {"post_id", "hashtag_id"})
)
public class Hashtag implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "BIGINT DEFAULT posts.h_next_id()", insertable = false, updatable = false)
	private long id;
	
	@Column(length = 30, nullable = false)
	private String tag;
	
	@Min(0)
	@Column(columnDefinition = "BIGINT DEFAULT 0")
	private int postCount;

	@ManyToMany
	@JoinTable(
			schema = "posts",
			name = "POST_HASHTAG",
			joinColumns = @JoinColumn(name = "hashtag_id"),
			inverseJoinColumns = @JoinColumn(name = "post_id"),
			indexes = {
					@Index(name = "idx_post", columnList = "post_id"),
					@Index(name = "idx_htag", columnList = "hashtag_id")
			}
	)
	private Set<Post> posts;

	public Hashtag(long id, String tag, @Min(0) int postCount, Set<Post> posts) {
		this.id = id;
		this.tag = tag;
		this.postCount = postCount;
		this.posts = posts;
	}

	public Hashtag(long id, String tag, @Min(0) int postCount) {
		this.id = id;
		this.tag = tag;
		this.postCount = postCount;
	}

	public Hashtag() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
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
		Hashtag other = (Hashtag) obj;
		return id == other.id;
	}
	
}
