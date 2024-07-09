package pacifico.mvm.trailblaze.model.ids;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ReactionCommentId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id", nullable = false)
	private long userId;

	@Column(name = "comment_id", nullable = false)
	private long commentId;
	
	public ReactionCommentId() {

	}

	public ReactionCommentId(long userId, long commentId) {
		this.userId = userId;
		this.commentId = commentId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, commentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReactionCommentId other = (ReactionCommentId) obj;
		return userId == other.userId && commentId == other.commentId;
	}

}
