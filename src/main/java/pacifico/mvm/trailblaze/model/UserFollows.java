package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.ids.UserFollowsId;

@Entity
@Table(schema = "users")
public class UserFollows implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UserFollowsId id;

	@JsonIgnoreProperties(value = {"id", "followeds", "followers"})
	@ManyToOne
	@MapsId("followerId")
	@JoinColumn(name = "follower_id")
	private User follower;

	@JsonIgnoreProperties(value = {"id", "followeds", "followers"})
	@ManyToOne
	@MapsId("followedId")
	@JoinColumn(name = "followed_id")
	private User followed;
	    
	@Column(columnDefinition = "BIGINT DEFAULT get_now()", name = "followed_at", insertable = false, nullable = false, updatable = false)
	private long startFollowingDate;
	
	public UserFollows() {
		
	}
	
	public UserFollows(UserFollowsId id, User follower, User followed, long startFollowingDate) {
		this.id = id;
		this.follower = follower;
		this.followed = followed;
		this.startFollowingDate = startFollowingDate;
	}
	
	public UserFollowsId getId() {
		return id;
	}

	public void setId(UserFollowsId id) {
		this.id = id;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public User getFollowed() {
		return followed;
	}

	public void setFollowed(User followed) {
		this.followed = followed;
	}
	
	public long getStartFollowingDate() {
		return startFollowingDate;
	}

	public void setStartFollowingDate(long startFollowingDate) {
		this.startFollowingDate = startFollowingDate;
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
		UserFollows other = (UserFollows) obj;
		return Objects.equals(id, other.id);
	}

}
