package com.javaInterview.pojo;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * <h1>Java Project Body Building  <br/>
 * </h1>
 * 
 * <p>
 * Domain entity. Simple POJO.<br/>
 * Hashes is POJO which defines the encryption type of the 
 * posted string.
 * </p>
 *
 * @author Daniyal Saeed
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hashes  {
	
	private String strings;
	private String md5;
	private String sha1;
	private String sha256;
	private String sha512;
	
	
	public Hashes() {}
	
	
	public String getStrings() {
		return strings;
	}
	public void setStrings(String strings) {
		this.strings = strings;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getSha1() {
		return sha1;
	}
	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}
	public String getSha256() {
		return sha256;
	}
	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}
	public String getSha512() {
		return sha512;
	}
	public void setSha512(String sha512) {
		this.sha512 = sha512;
	}
	public Hashes(String strings, String md5, String sha1, String sha256, String sha512) {
		super();
		this.strings = strings;
		this.md5 = md5;
		this.sha1 = sha1;
		this.sha256 = sha256;
		this.sha512 = sha512;
	}
	@Override
	public String toString() {
		return "Hashes [strings=" + strings + ", md5=" + md5 + ", sha1=" + sha1 + ", sha256=" + sha256 + ", sha512="
				+ sha512 + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((md5 == null) ? 0 : md5.hashCode());
		result = prime * result + ((sha1 == null) ? 0 : sha1.hashCode());
		result = prime * result + ((sha256 == null) ? 0 : sha256.hashCode());
		result = prime * result + ((sha512 == null) ? 0 : sha512.hashCode());
		result = prime * result + ((strings == null) ? 0 : strings.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hashes other = (Hashes) obj;
		if (md5 == null) {
			if (other.md5 != null)
				return false;
		} else if (!md5.equals(other.md5))
			return false;
		if (sha1 == null) {
			if (other.sha1 != null)
				return false;
		} else if (!sha1.equals(other.sha1))
			return false;
		if (sha256 == null) {
			if (other.sha256 != null)
				return false;
		} else if (!sha256.equals(other.sha256))
			return false;
		if (sha512 == null) {
			if (other.sha512 != null)
				return false;
		} else if (!sha512.equals(other.sha512))
			return false;
		if (strings == null) {
			if (other.strings != null)
				return false;
		} else if (!strings.equals(other.strings))
			return false;
		return true;
	}
	
	
	
   
    
}