package pacifico.mvm.trailblaze.model.reports;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.User;

@Entity
@Table(schema = "reports")
public final class UserReport extends AbstractReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BIGINT DEFAULT reports.ur_next_id()", insertable = false, updatable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "reported_user_id", nullable = false, updatable = false)
	private User reportedUser;
	
	public UserReport() {
		super();
	}

	public UserReport(long id, String description, long reportedAt, ReportReason reportReason, User user, User reportedUser) {
		super(description, reportedAt, reportReason, user);
		this.id = id;
		this.reportedUser = reportedUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getReportedUser() {
		return reportedUser;
	}

	public void setReportedUser(User reportedUser) {
		this.reportedUser = reportedUser;
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
		UserReport other = (UserReport) obj;
		return id == other.id;
	}

}
