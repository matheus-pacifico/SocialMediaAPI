package pacifico.mvm.trailblaze.model;

import java.io.Serializable;
import java.net.URI;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "users")
public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BIGINT DEFAULT users.n_next_id()", insertable = false, updatable = false)
	private long id;
	
	@Column(nullable = false, updatable = false, length = 160)
	private String content;
	
	@Column(columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
	private boolean read;

	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, updatable = false)
	private long createdAt;

	@Column(columnDefinition = "VARCHAR(512)")
	private URI uri;
	
	private String additionalResource;
	
	@Column(nullable = false, updatable = false, length = 29)
	@Enumerated(EnumType.STRING)
	private NotificationType notificationType;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User recipient;

	public Notification() {
		
	}

	public Notification(long id, String content, boolean read, long createdAt, URI uri, String additionalResource,
			NotificationType notificationType, User recipient) {
		this.id = id;
		this.content = content;
		this.read = read;
		this.createdAt = createdAt;
		this.uri = uri;
		this.additionalResource = additionalResource;
		this.notificationType = notificationType;
		this.recipient = recipient;
	}

	public Notification(long id, String content, boolean read, long createdAt, String additionalResource,
			NotificationType notificationType, User recipient) {
		this.id = id;
		this.content = content;
		this.read = read;
		this.createdAt = createdAt;
		this.additionalResource = additionalResource;
		this.notificationType = notificationType;
		this.recipient = recipient;
	}

	public Notification(long id, String content, boolean read, long createdAt, URI uri,
			NotificationType notificationType, User recipient) {
		this.id = id;
		this.content = content;
		this.read = read;
		this.createdAt = createdAt;
		this.uri = uri;
		this.notificationType = notificationType;
		this.recipient = recipient;
	}

	public Notification(long id, String content, boolean read, long createdAt, NotificationType notificationType,
			User recipient) {
		this.id = id;
		this.content = content;
		this.read = read;
		this.createdAt = createdAt;
		this.notificationType = notificationType;
		this.recipient = recipient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	public String getAdditionalResource() {
		return additionalResource;
	}

	public void setAdditionalResource(String additionalResource) {
		this.additionalResource = additionalResource;
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
		Notification other = (Notification) obj;
		return Objects.equals(id, other.id);
	}
	
}