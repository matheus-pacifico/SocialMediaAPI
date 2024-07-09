package pacifico.mvm.trailblaze.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntityList implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 42, nullable = false)
	protected String name;
	
	@Column(columnDefinition = "varchar(8) default 'PRIVATE'", nullable = false)
	@Enumerated(EnumType.STRING)
	protected Privacy privacy;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "creator_id")
	protected User creator;

	public AbstractEntityList() {
		
	}

	public AbstractEntityList(String name, Privacy privacy, User creator) {
		this.name = name;
		this.privacy = privacy;
		this.creator = creator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);
	
}
