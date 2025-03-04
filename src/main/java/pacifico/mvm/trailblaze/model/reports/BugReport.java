package pacifico.mvm.trailblaze.model.reports;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.User;

@Entity
@Table(schema = "reports")
public class BugReport implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "BIGINT DEFAULT reports.br_next_id()", insertable = false, updatable = false)
	private long id;
	
	@Column(length=350, updatable = false, nullable = false)
	private String description;
	
	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, nullable = false, updatable = false)
	private long reportedAt;
	
	@Column(length = 14, nullable = false)
	@Enumerated(EnumType.STRING)
	private BugType bugType;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "user_id", columnDefinition = "BIGINT")
	private User user;

	public BugReport() {
	
	}

	public BugReport(long id, String description, long reportedAt, BugType bugType, User user) {
		this.id = id;
		this.description = description;
		this.reportedAt = reportedAt;
		this.bugType = bugType;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getReportedAt() {
		return reportedAt;
	}

	public void setReportedAt(long reportedAt) {
		this.reportedAt = reportedAt;
	}

	public BugType getBugType() {
		return bugType;
	}

	public void setBugType(BugType bugType) {
		this.bugType = bugType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		BugReport other = (BugReport) obj;
		return id == other.id;
	}
	
}

enum BugType {
	BROKEN_LINK,
	LOGIN,
	PAGE_NOT_FOUND,
	REGISTRATION,
	TIMEOUT,
	VISUAL,
	OTHER	
}