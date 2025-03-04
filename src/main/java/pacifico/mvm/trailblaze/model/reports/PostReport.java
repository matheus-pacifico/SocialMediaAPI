package pacifico.mvm.trailblaze.model.reports;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pacifico.mvm.trailblaze.model.Post;
import pacifico.mvm.trailblaze.model.User;

@Entity
@Table(schema = "reports")
public final class PostReport extends AbstractReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "BIGINT DEFAULT reports.pr_next_id()", insertable = false, updatable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "post_id", columnDefinition = "BIGINT", updatable = false, nullable = false)
	private Post post;

	public PostReport() {
		super();
	}

	public PostReport(long id, String description, long reportedAt, ReportReason reportReason, User user, Post post) {
		super(description, reportedAt, reportReason, user);
		this.id = id;
		this.post = post;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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
		PostReport other = (PostReport) obj;
		return id == other.id;
	}

}
