package pacifico.mvm.trailblaze.model.ids;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ReactionRateId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "rate_id", nullable = false)
    private long rateId;
	
	public ReactionRateId() {
			
	}

	public ReactionRateId(long userId, long rateId) {
		this.userId = userId;
		this.rateId = rateId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRateId() {
		return rateId;
	}

	public void setRateId(long rateId) {
		this.rateId = rateId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, rateId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReactionRateId other = (ReactionRateId) obj;
		return userId == other.userId && rateId == other.rateId;
	}

}
