package org.salman.spring.jpa.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQuery(name = "Todo.findByTitleIs", query = "SELECT t FROM Todo t WHERE t.title = 'title'")
@Table(name = "TODO")
public final class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CREATION_TIME", nullable = false)
	private java.sql.Date creationTime;

	@Column(name = "DESCRIPTION", length = 3000)
	private String description;

	@Column(name = "MODIFICATION_TIME")
	private java.sql.Date modificationTime;

	@Column(name = "TITLE", nullable = false, length = 256)
	private String title;

	@Version
	private long version;

	public Todo() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.sql.Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(java.sql.Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.sql.Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(java.sql.Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", creationTime=" + creationTime + ", description=" + description
				+ ", modificationTime=" + modificationTime + ", title=" + title + ", version=" + version + "]";
	}

	// The constructor, builder, and other methods are omitted
	
	
}