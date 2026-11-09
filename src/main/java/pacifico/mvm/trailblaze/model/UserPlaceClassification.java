package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.ids.UserPlaceClassificationId;

@Entity
@Table(schema = "users")
public class UserPlaceClassification implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserPlaceClassificationId id;

	@JsonIgnoreProperties(value = {"placeClassifications"})
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@JsonIgnoreProperties({"rates"})
	@ManyToOne
	@MapsId("placeId")
	@JoinColumn(name = "place_id")
	private Place place;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private PlaceClassification classification;

	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, nullable = false, updatable = false)
	private long createdAt;

	public UserPlaceClassification() {
	}

	public UserPlaceClassification(UserPlaceClassificationId id, User user, Place place, PlaceClassification classification) {
		this.id = id;
		this.user = user;
		this.place = place;
		this.classification = classification;
	}

	public UserPlaceClassification(UserPlaceClassificationId id, User user, Place place, PlaceClassification classification, long createdAt) {
		this.id = id;
		this.user = user;
		this.place = place;
		this.classification = classification;
		this.createdAt = createdAt;
	}

	public UserPlaceClassificationId getId() {
		return id;
	}

	public void setId(UserPlaceClassificationId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public PlaceClassification getClassify() {
		return classification;
	}

	public void setClassify(PlaceClassification classification) {
		this.classification = classification;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
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
		UserPlaceClassification other = (UserPlaceClassification) obj;
		return Objects.equals(id, other.id);
	}

}

