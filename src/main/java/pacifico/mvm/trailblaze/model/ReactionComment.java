package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.ids.ReactionCommentId;

@Entity
@Table(schema = "posts")
public class ReactionComment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ReactionCommentId id;

	@JsonIgnoreProperties(value = {"reactionComments"}, allowSetters = true)
	@ManyToOne
	@MapsId("commentId")
	@JoinColumn(name = "comment_id")
	private Comment comment;

	@JsonIgnore
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@Column(length = 7)
	@Enumerated(EnumType.STRING)
	private React react;

	public ReactionComment() {

	}

	public ReactionComment(ReactionCommentId id, Comment comment, User user, React react) {
		this.id = id;
		this.comment = comment;
		this.user = user;
		this.react = react;
	}

	public ReactionCommentId getId() {
		return id;
	}

	public void setId(ReactionCommentId id) {
		this.id = id;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public React getReact() {
		return react;
	}

	public void setReact(React react) {
		this.react = react;
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
		ReactionComment other = (ReactionComment) obj;
		return Objects.equals(id, other.id);
	}

}
