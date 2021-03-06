package org.unidue.ub.libintel.blacklistbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


/**
 * Plain old java object holding an data of analysis to be ignored upon analysis. The
 * fields can be persisted.
 * 
 * @author Eike Spielberg
 * @version 1
 */
@Entity
public class Ignored {

	@Column(name="title_id")
    private String titleId;

    @Id
	private String identifier;
	
	private String shelfmark;

	private String type;
	
	@Column(columnDefinition = "TEXT")
	private String comment;
	
	@Column(columnDefinition = "TEXT")
    private String mab;

	@JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
	private Date date = new Date();

	@JsonFormat(pattern = "dd.MM.yyyy")
	private Date expire;

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getShelfmark() {
		return shelfmark;
	}

	public void setShelfmark(String shelfmark) {
		this.shelfmark = shelfmark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMab() {
		return mab;
	}

	public void setMab(String mab) {
		this.mab = mab;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}
}
