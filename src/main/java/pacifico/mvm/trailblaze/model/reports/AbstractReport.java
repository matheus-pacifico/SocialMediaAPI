package pacifico.mvm.trailblaze.model.reports;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import pacifico.mvm.trailblaze.model.User;

@MappedSuperclass
public abstract class AbstractReport implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(length=350, nullable = false, updatable = false)
	protected String description;
	
	@Column(columnDefinition = "BIGINT DEFAULT get_now()", insertable = false, nullable = false, updatable = false)
	protected long reportedAt;
	
	@Column(length = 32, nullable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	protected ReportReason reportReason;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false, updatable = false)
	protected User user;
	
	public AbstractReport() {
		
	}

	public AbstractReport(String description, long reportedAt, ReportReason reportReason, User user) {
		this.description = description;
		this.reportedAt = reportedAt;
		this.reportReason = reportReason;
		this.user = user;
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

	public ReportReason getReportReason() {
		return reportReason;
	}

	public void setReportReason(ReportReason reportReason) {
		this.reportReason = reportReason;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);

}
