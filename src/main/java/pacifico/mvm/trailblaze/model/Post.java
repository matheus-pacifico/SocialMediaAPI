package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(schema = "posts", indexes = @Index(name = "idx_post_code", columnList = "postCode", unique = true))
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BIGINT DEFAULT posts.p_next_id()", insertable = false, updatable = false)
	private long id;
	
	@Column(nullable = false)
	private String postCode;
	
	@JsonIgnoreProperties(value = {"description", "posts", "postCount"}, allowSetters = true)	
	@ManyToOne(optional = false)
	@JoinColumn(name = "profile_id", nullable = false, updatable = false)
	private Profile profile;
	
	@Column(length = 600)
	private String caption;
	
	@Min(0)	
	@Column(columnDefinition = "BIGINT DEFAULT 0", insertable = false)
	private long likeCount;
	
	@Min(0)
	@Column(columnDefinition = "BIGINT DEFAULT 0", insertable = false)
	private long commentCount;
	
	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, nullable = false, updatable = false)
	private long createdAt;
	
	@Column(columnDefinition = "BOOLEAN DEFAULT FALSE", insertable = false, nullable = false)
	private boolean isArchived;

	@ManyToOne
	@JoinColumn(name = "place_id")
	private Place place;
    
	@JsonIgnoreProperties(value = {"post"}, allowSetters = true)
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Media> medias = new HashSet<>();
	
	@JsonIgnoreProperties(value = {"post"}, allowSetters = true)
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;
	
	@JsonIgnore
	@OneToMany(mappedBy = "post")
	private List<PostLike> postLikes = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "posts")
	private Set<Hashtag> hashtags;

	public Post() {
	
	}

	public Post(long id, String postCode, Profile profile, String caption, long likeCount, long commentCount, long createdAt, boolean isArchived,
			Place place) {
		this.id = id;
		this.postCode = postCode;
		this.profile = profile;
		this.caption = caption;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
		this.createdAt = createdAt;
		this.isArchived = isArchived;
		this.place = place;
		this.medias = null;
	}

	public Post(long id, String postCode, Profile profile, String caption, long likeCount, long commentCount, long createdAt, boolean isArchived,
			Place place, Set<Media> medias) {
		this.id = id;
		this.postCode = postCode;
		this.profile = profile;
		this.caption = caption;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
		this.createdAt = createdAt;
		this.isArchived = isArchived;
		this.place = place;
		this.medias = medias;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<PostLike> getPostLikes() {
		return postLikes;
	}

	public void setPostLikes(List<PostLike> postLikes) {
		this.postLikes = postLikes;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	public Set<Media> getMedias() {
		return medias;
	}

	public void setMedias(Set<Media> medias) {
		this.medias = medias;
	}

	public Set<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(Set<Hashtag> hashtags) {
		this.hashtags = hashtags;
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
		Post other = (Post) obj;
		return id == other.id;
	}
    
}
