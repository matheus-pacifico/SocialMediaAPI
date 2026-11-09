package pacifico.mvm.trailblaze.model.ids;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserPlaceClassificationId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", columnDefinition = "BIGINT", nullable = false)
	private long userId;

	@Column(name = "place_id", columnDefinition = "BIGINT", nullable = false)
	private long placeId;

	public UserPlaceClassificationId() {
	}

	public UserPlaceClassificationId(long userId, long placeId) {
		this.userId = userId;
		this.placeId = placeId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, placeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPlaceClassificationId other = (UserPlaceClassificationId) obj;
		return userId == other.userId && placeId == other.placeId;
	}

}

