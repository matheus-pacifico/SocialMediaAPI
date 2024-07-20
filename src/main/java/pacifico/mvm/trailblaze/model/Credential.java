package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(schema = "users")
public class Credential implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonIgnore
	@Column(columnDefinition = "BIGINT DEFAULT users.c_next_id()", insertable = false, updatable = false)
	private long id;
	
	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = false)
	private String password;
	
	@Column(columnDefinition = "BOOLEAN DEFAULT FALSE", insertable = false, nullable = false)
	private boolean isEmailVerified;
	
	@JsonIncludeProperties({"username", "name"})
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private User user;
	
	public Credential() {
		
	}
	
	public Credential(long id, String email, String password, User user) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.user = user;
	}
	
	public Credential(long id, String email, String password, boolean isEmailVerified, User user) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.isEmailVerified = isEmailVerified;
		this.user = user;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
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
		Credential other = (Credential) obj;
		return Objects.equals(id, other.id);
	}

}
