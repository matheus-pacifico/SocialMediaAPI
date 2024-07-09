package pacifico.mvm.trailblaze.model.ids;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserFollowsId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "follower_id", nullable = false)
	private long followerId;

	@Column(name = "followed_id", nullable = false)
	private long followedId;

	public UserFollowsId() {
		
	}

	public UserFollowsId(long followerId, long followedId) {
		this.followerId = followerId;
		this.followedId = followedId;
	}

	public long getFollowerId() {
		return followerId;
	}

	public void setFollowerId(long followerId) {
		this.followerId = followerId;
	}

	public long getFollowedId() {
		return followedId;
	}

	public void setFollowedId(long followedId) {
		this.followedId = followedId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(followerId, followedId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFollowsId other = (UserFollowsId) obj;
		return followerId == other.followerId && followedId == other.followedId;
	}

}
