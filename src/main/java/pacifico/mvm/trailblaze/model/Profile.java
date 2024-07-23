package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(schema = "users")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BIGINT DEFAULT users.p_next_id()", insertable = false, updatable = false)
	private long id;

	@Column(length = 150)
	private String description;

	@Column(columnDefinition = "BOOLEAN DEFAULT TRUE", insertable = false, nullable = false)
	private boolean isPublic;

	@JsonIgnoreProperties(value = {"profile"}, allowSetters = true)
	@OneToMany(mappedBy = "profile")
	private Set<Post> posts;

	@Min(0)
	@Column(columnDefinition = "INT DEFAULT 0", insertable = false, nullable = false)
	private int postCount;

	@JsonIgnoreProperties(value = {"profile",  "birthday", "createdAt", "followers", "followeds"}, allowSetters = true)
	@OneToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false, updatable = false)
	private User user;

	public Profile() {
		
	}

	public Profile(long id, String description, boolean isPublic, int postCount) {
		this.id = id;
		this.description = description;
		this.isPublic = isPublic;
		this.postCount = postCount;
	}

	public Profile(long id, String description, boolean isPublic, int postCount, User user) {
		this.id = id;
		this.description = description;
		this.isPublic = isPublic;
		this.postCount = postCount;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Profile other = (Profile) obj;
		return Objects.equals(id, other.id);
	}	
	
}
