package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import pacifico.mvm.trailblaze.model.reports.CommentReport;

@Entity
@Table(schema = "posts")
public class Comment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "BIGINT DEFAULT posts.c_next_id()", insertable = false, updatable = false)
	private long id;
	
	@Column(length = 500, updatable = false, nullable = false)
	private String content;
	
	@Min(0)	
	@Column(columnDefinition = "BIGINT DEFAULT 0", insertable = false)
	private long likes;
	
	@Min(0)
	@Column(columnDefinition = "BIGINT DEFAULT 0", insertable = false)
	private long dislikes;
	
	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, nullable = false, updatable = false)
	private long createdAt;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;
    
	@JsonIgnoreProperties(value = {"comments"}, allowSetters = true)
	@ManyToOne(optional = true)
	@JoinColumn(name = "post_id")
	private Post post;
	
	@JsonIgnoreProperties(value = {"comment", "user"}, allowSetters = true)
	@OneToMany(mappedBy = "comment")
	private List<ReactionComment> reactionComments = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
	private List<CommentReport> reports;    
    
	@ManyToOne
	@JoinColumn(name = "root_comment_id")
	private Comment rootComment;
	
	public Comment() {
		
	}

	public Comment(long id, String content, User user, long createdAt, Post post) {
		this.id = id;
		this.content = content;
		this.user = user;
		this.createdAt = createdAt;
		this.post = post;
		this.rootComment = null;
	}
	
	public Comment(long id, String content, User user, long createdAt, Comment rootComment) {
		this.id = id;
		this.content = content;
		this.user = user;
		this.createdAt = createdAt;
		this.post = null;
		this.rootComment = rootComment;
	}
	
	public Comment(long id, String content, long likes, long dislikes, long createdAt, User user,
			Post post) {
		this.id = id;
		this.content = content;
		this.likes = likes;
		this.dislikes = dislikes;
		this.createdAt = createdAt;
		this.user = user;
		this.post = post;
		this.rootComment = null;
	}

	public Comment(long id, String content, long likes, long dislikes, long createdAt, User user,
			Post post, Comment rootComment) {
		this.id = id;
		this.content = content;
		this.likes = likes;
		this.dislikes = dislikes;
		this.createdAt = createdAt;
		this.user = user;
		this.rootComment = rootComment;
		this.post = null;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public long getDislikes() {
		return dislikes;
	}

	public void setDislikes(long dislikes) {
		this.dislikes = dislikes;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
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

	public Comment getRootComment() {
		return rootComment;
	}

	public void setRootComment(Comment rootComment) {
		this.rootComment = rootComment;
	}

	public List<ReactionComment> getReactionComments() {
		return reactionComments;
	}

	public void setReactionComments(List<ReactionComment> reactionComments) {
		this.reactionComments = reactionComments;
	}

	public List<CommentReport> getReports() {
		return reports;
	}

	public void setReports(List<CommentReport> reports) {
		this.reports = reports;
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
		Comment other = (Comment) obj;
		return Objects.equals(id, other.id);
	}

}
