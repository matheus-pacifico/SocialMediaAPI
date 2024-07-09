package pacifico.mvm.trailblaze.model.ids;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PostLikeId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", nullable = false)
	private long userId;

	@Column(name = "post_id", nullable = false)
	private long postId;

	public PostLikeId() {
		
	}

	public PostLikeId(long userId, long postId) {
		this.userId = userId;
		this.postId = postId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, postId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostLikeId other = (PostLikeId) obj;
		return userId == other.userId && postId == other.postId;
	}

}
