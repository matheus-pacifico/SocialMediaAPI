package pacifico.mvm.trailblaze.model.reports;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.Comment;
import pacifico.mvm.trailblaze.model.User;

@Entity
@Table(schema = "reports")
public final class CommentReport extends AbstractReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BIGINT DEFAULT reports.cr_next_id()", insertable = false, updatable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "comment_id", nullable = false, updatable = false)
	private Comment comment;

	public CommentReport() {
		super();
	}
	
	public CommentReport(long id, String description, long reportedAt, ReportReason reportReason, User user, Comment comment) {
		super(description, reportedAt, reportReason, user);
		this.id = id;
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
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
		CommentReport other = (CommentReport) obj;
		return id == other.id;
	}

}
