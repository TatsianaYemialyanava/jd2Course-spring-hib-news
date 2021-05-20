package by.htp.les04.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class News implements Serializable {
	private static final long serialVersionUID = -6457546508943071215L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="title")
	private String title;

	@Column(name="brief")
	private String brief;

	@Column(name="content")
	private String content;

	@Column(name="date")
	private LocalDateTime date;

	@Column(name="status")
	private String status;

	public News() {}

	public News(int id, String title,  String brief) {
		super();
		this.setId(id);
		this.title = title;
		this.setBrief(brief);
	}

	public News(int id, String title,  String brief, String content, LocalDateTime date) {
		super();
		this.setId(id);
		this.title = title;
		this.setBrief(brief);
		this.setContent(content);
		this.setDate(date);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String formattedDateTime = date.format(formatter);
		return formattedDateTime;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		News other = (News) obj;
		if (id != other.id) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {	
		return "id: " + this.id + "\n" +
				"title:" + this.title + "\n" +
				"brief:" + this.brief + "\n" +
				"content: " + this.content + "\n" + 
				"date: " + this.date + "\n" + 
				"status: " + this.status;
	}
}
