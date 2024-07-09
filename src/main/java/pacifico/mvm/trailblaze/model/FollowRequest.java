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
import pacifico.mvm.trailblaze.model.ids.FollowRequestId;

@Entity
@Table(schema = "users")
public class FollowRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private FollowRequestId id;
    
	@JsonIgnoreProperties(value = {"id", "sentRequests", "receivedRequests"})
	@ManyToOne(optional = false)
	@MapsId("requesterId")
	@JoinColumn(name = "requester_id", nullable = false, updatable = false)
	private User requester;
    
	@JsonIgnoreProperties(value = {"id", "sentRequests", "receivedRequests"})
	@ManyToOne(optional = false)
	@MapsId("receiverId")
	@JoinColumn(name = "receiver_id", nullable = false, updatable = false)
	private User receiver;	
    
	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, nullable = false, updatable = false)
	private long requestedAt;

	public FollowRequest() {
		
	}

	public FollowRequest(FollowRequestId id, User requester, User receiver, long requestedAt) {
		this.id = id;
		this.requester = requester;
		this.receiver = receiver;
		this.requestedAt = requestedAt;
	}

	public FollowRequestId getId() {
		return id;
	}

	public void setId(FollowRequestId id) {
		this.id = id;
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public long getRequestedAt() {
		return requestedAt;
	}

	public void setRequestedAt(long requestedAt) {
		this.requestedAt = requestedAt;
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
		FollowRequest other = (FollowRequest) obj;
		return Objects.equals(id, other.id);
	}
	
}
