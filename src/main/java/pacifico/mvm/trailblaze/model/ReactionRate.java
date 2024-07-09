package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.ids.ReactionRateId;

@Entity
@Table(schema = "places")
public class ReactionRate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ReactionRateId id;

	@ManyToOne
	@MapsId("rateId")
	@JoinColumn(name = "rate_id")
	private Rate rate;

	@JsonIgnore
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@Column(length = 7)
	@Enumerated(EnumType.STRING)
	private React react;

	public ReactionRate() {

	}

	public ReactionRate(ReactionRateId id, Rate rate, User user, React react) {
		this.id = id;
		this.rate = rate;
		this.user = user;
		this.react = react;
	}

	public ReactionRateId getId() {
		return id;
	}

	public void setId(ReactionRateId id) {
		this.id = id;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public React getReact() {
		return react;
	}

	public void setReact(React react) {
		this.react = react;
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
		ReactionRate other = (ReactionRate) obj;
		return Objects.equals(id, other.id);
	}

}
