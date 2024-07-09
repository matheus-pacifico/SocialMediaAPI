package pacifico.mvm.trailblaze.model.ids;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SavedPlaceId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "saved_by_id", nullable = false)
	private long savedByUserId;

	@Column(name = "place_id", nullable = false)
	private long placeId;
	
	public SavedPlaceId() {
		
	}

	public SavedPlaceId(long savedByUserId, long placeId) {
		this.savedByUserId = savedByUserId;
		this.placeId = placeId;
	}

	public long getSavedByUserId() {
		return savedByUserId;
	}

	public void setSavedByUserId(long savedByUserId) {
		this.savedByUserId = savedByUserId;
	}

	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(savedByUserId, placeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavedPlaceId other = (SavedPlaceId) obj;
		return savedByUserId == other.savedByUserId && placeId == other.placeId;
	}

}
