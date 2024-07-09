package pacifico.mvm.trailblaze.model.ids;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SavedPostId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "saved_by_id", nullable = false)
	private long savedByUserId;

	@Column(name = "post_id", nullable = false)
	private long postId;
	
	public SavedPostId() {
		
	}

	public SavedPostId(long savedByUserId, long postId) {
		this.savedByUserId = savedByUserId;
		this.postId = postId;
	}

	public long getSavedByUserId() {
		return savedByUserId;
	}

	public void setSavedByUserId(long savedByUserId) {
		this.savedByUserId = savedByUserId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(savedByUserId, postId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavedPostId other = (SavedPostId) obj;
		return savedByUserId == other.savedByUserId && postId == other.postId;
	}

}
