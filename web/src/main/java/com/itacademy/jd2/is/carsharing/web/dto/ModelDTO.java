package com.itacademy.jd2.is.carsharing.web.dto;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class ModelDTO {

	private Integer id;
	@NotNull
	private Set<Integer> colorIds;
	@NotNull(message = "is requred")
	@Size(min = 1, max = 50)
	private String name;

	@NotNull
	private Integer brandId;

	private String brandName;

	private Date created;
	private Date updated;

	public Set<Integer> getColorIds() {
		return colorIds;
	}

	public void setColorIds(Set<Integer> colorIds) {
		this.colorIds = colorIds;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(final Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(final Date updated) {
		this.updated = updated;
	}
}
