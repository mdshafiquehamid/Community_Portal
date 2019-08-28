package org.websparrow.bean;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description Experiences class is for the model bean for Experiences.
 */
public class Experiences extends Entity {
	private String experience_company;
	private String experience_position;
	private String duration;
	private String experience_country;
	private String experience_description;
	
	public String getExperience_company() {
		return experience_company;
	}
	public void setExperience_company(String experience_company) {
		this.experience_company = experience_company;
	}
	public String getExperience_position() {
		return experience_position;
	}
	public void setExperience_position(String experience_position) {
		this.experience_position = experience_position;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getExperience_country() {
		return experience_country;
	}
	public void setExperience_country(String experience_country) {
		this.experience_country = experience_country;
	}
	public String getExperience_description() {
		return experience_description;
	}
	public void setExperience_description(String experience_description) {
		this.experience_description = experience_description;
	}
}
