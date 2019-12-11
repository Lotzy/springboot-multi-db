package org.lotzy.sample.multidb.db2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Title: Video class
 * Description: JPA Entity for Videos
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@Entity
@Table(name="video")
public class Video {

	@Id
	private Long videoId;

	private String title;

	private Integer bitrate;

	private Integer length;

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getBitrate() {
		return bitrate;
	}

	public void setBitrate(Integer bitrate) {
		this.bitrate = bitrate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", bitrate=" + bitrate + ", length=" + length + "]";
	}


}
