package org.lotzy.sample.multidb.db1.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Title: User class
 * Description: JPA Entity for user, careful, table with name "user" might give you problems, that's why is named tbl_user
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@Entity
@Table(name="tbl_user")
public class User {

	@Id
	private Long userId;

	private String name;

	private String surname;

	private Date createdAt;

	private Date updatedAt;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", surname=" + surname + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
