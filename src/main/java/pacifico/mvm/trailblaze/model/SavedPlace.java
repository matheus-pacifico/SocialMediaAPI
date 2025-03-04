package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.ids.SavedPlaceId;

@Entity
@Table(schema = "users")
public class SavedPlace  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SavedPlaceId id;
	
	@JsonIncludeProperties({"username", "name", "photoPath"})
	@ManyToOne
	@MapsId("savedByUserId")
	@JoinColumn(name = "saved_by_id")
	private User user;

	@JsonIgnoreProperties({"rates", "posts"})
	@ManyToOne
	@MapsId("placeId")    
	@JoinColumn(name = "place_id")
	private Place place;
    
	@JsonIgnoreProperties({"savedPlaces"})
	@ManyToMany(mappedBy = "savedPlaces")
	private Set<PlaceList> placeLists;

	public SavedPlace() {
		
	}

	public SavedPlace(SavedPlaceId id, User user, Place place) {
		this.id = id;
		this.user = user;
		this.place = place;
	}

	public SavedPlaceId getId() {
		return id;
	}

	public void setId(SavedPlaceId id) {
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

	public Set<PlaceList> getPlaceLists() {
		return placeLists;
	}

	public void setPlaceLists(Set<PlaceList> placeLists) {
		this.placeLists = placeLists;
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
		SavedPlace other = (SavedPlace) obj;
		return Objects.equals(id, other.id);
	}
    
}
