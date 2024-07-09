package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(schema = "places", indexes = @Index(name = "lat_lon", columnList = "latitude, longitude", unique = true))
public class Place implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "BIGINT DEFAULT places.p_next_id()", insertable = false, updatable = false)
	private long id;
	
	@Min(-90) @Max(90)
	@Column(precision = 8, scale = 6, nullable = false)
	private BigDecimal latitude;

	@Min(-180) @Max(180)
	@Column(precision = 9, scale = 6, nullable = false)
	private BigDecimal longitude;
	
	@JsonIgnoreProperties({"place"})
	@OneToMany(mappedBy = "place")
	private List<Rate> rates;
	
	@JsonIgnoreProperties({"place"})
	@OneToMany(mappedBy = "place")
	private List<Post> posts;
	
	public Place() {
	
	}
	
	public Place(long id, BigDecimal latitude, BigDecimal longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
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
		Place other = (Place) obj;
		return id == other.id;
	}

}
