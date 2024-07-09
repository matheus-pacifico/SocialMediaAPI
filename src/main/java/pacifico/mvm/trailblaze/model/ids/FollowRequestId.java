package pacifico.mvm.trailblaze.model.ids;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FollowRequestId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "requester_id", nullable = false)
	private long requesterId;

	@Column(name = "receiver_id", nullable = false)
	private long receiverId;

	public FollowRequestId() {
		
	}

	public FollowRequestId(long requesterId, long receiverId) {
		this.requesterId = requesterId;
		this.receiverId = receiverId;
	}

	public long getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(long requesterId) {
		this.requesterId = requesterId;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(requesterId, receiverId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FollowRequestId other = (FollowRequestId) obj;
		return requesterId == other.requesterId && receiverId == other.receiverId;
	}

}
