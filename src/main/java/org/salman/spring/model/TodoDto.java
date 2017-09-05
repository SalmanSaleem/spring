package org.salman.spring.model;

import java.io.Serializable;

public class TodoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private java.sql.Date creationTime;
	private String description;
	private java.sql.Date modificationTime;
	private String title;
	private long version;

	public TodoDto() {
		// TODO Auto-generated constructor stub
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

}
