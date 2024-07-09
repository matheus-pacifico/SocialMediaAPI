package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(schema = "places", uniqueConstraints = @UniqueConstraint(name = "user_place", columnNames = {"user_id", "place_id"}))
public class Rate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "BIGINT DEFAULT places.r_next_id()", insertable = false, updatable = false)
	private long id;
	
	@Min(1)
	@Max(10)
	@Column(nullable = false)
	private byte rating;
    
	@Column(length = 400)
	private String comment;
    
	@Column(columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
	private boolean userWerePresent;
    
	@Min(0)	
	@Column(columnDefinition = "BIGINT DEFAULT 0", insertable = false)
	private long likes;	
	
	@Min(0)	
	@Column(columnDefinition = "BIGINT DEFAULT 0", insertable = false)
	private long dislikes;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
    
	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, nullable = false)
	private long createdAt;
    
	@JsonIgnoreProperties(value = {"rates", "posts"}, allowSetters = true)
	@ManyToOne(optional = false)
	@JoinColumn(name = "place_id")
	private Place place;
    
	public Rate() {
		
	}

	public Rate(long id, byte rating, String comment, boolean userWerePresent,
			User user, Place place) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.userWerePresent = userWerePresent;
		this.user = user;
		this.place = place;
	}

	public Rate(long id, byte rating, String comment, boolean userWerePresent,
			User user, Place place, long createdAt) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.userWerePresent = userWerePresent;
		this.user = user;
		this.place = place;
		this.createdAt = createdAt;
	}
	
	public Rate(long id, byte rating, String comment, boolean userWerePresent, long likes,
			long dislikes, User user, Place place) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.userWerePresent = userWerePresent;
		this.likes = likes;
		this.dislikes = dislikes;
		this.user = user;
		this.place = place;
	}

	public Rate(long id, byte rating, String comment, boolean userWerePresent, long likes,
			long dislikes, User user, Place place, long createdAt) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.userWerePresent = userWerePresent;
		this.likes = likes;
		this.dislikes = dislikes;
		this.user = user;
		this.place = place;
		this.createdAt = createdAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isUserWerePresent() {
		return userWerePresent;
	}

	public void setUserWerePresent(boolean userWerePresent) {
		this.userWerePresent = userWerePresent;
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
		Rate other = (Rate) obj;
		return Objects.equals(id, other.id);
	}
    
}
