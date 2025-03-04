package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "posts")
@JsonInclude(content = Include.NON_NULL)
public class PostList extends AbstractEntityList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "BIGINT DEFAULT posts.pl_next_id()", insertable = false, updatable = false)
	private long id;
	
	@JsonIgnoreProperties({"user"})
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			schema = "posts",
			name="SAVED_POST_LIST_POST",
			joinColumns = @JoinColumn(name="post_list_id", columnDefinition = "BIGINT"),
			inverseJoinColumns = {   
					@JoinColumn(name = "saved_by_id", referencedColumnName = "saved_by_id"),
					@JoinColumn(name = "post_id", referencedColumnName = "post_id")
			}
	)
	private Set<SavedPost> savedPosts = new HashSet<>();

	public PostList() {
		super();
	}

	public PostList(long id, String name, Privacy privacy, User creator) {
		super(name, privacy, creator);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<SavedPost> getSavedPosts() {
		return savedPosts;
	}

	public void setSavedPosts(Set<SavedPost> savedPosts) {
		this.savedPosts = savedPosts;
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
		PostList other = (PostList) obj;
		return id == other.id;
	}

}
