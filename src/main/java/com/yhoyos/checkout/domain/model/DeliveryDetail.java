package com.yhoyos.checkout.domain.model;

import java.util.Objects;

public class DeliveryDetail {

	private long id;
	private String status;
	private String direction;
	private long guideNumber;
	private String transportationCompany;

	public DeliveryDetail(long id, String status, String direction, long guideNumber, String transportationCompany) {
		this.id = id;
		this.status = status;
		this.direction = direction;
		this.guideNumber = guideNumber;
		this.transportationCompany = transportationCompany;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public long getGuideNumber() {
		return guideNumber;
	}

	public void setGuideNumber(long guideNumber) {
		this.guideNumber = guideNumber;
	}

	public String getTransportationCompany() {
		return transportationCompany;
	}

	public void setTransportationCompany(String transportationCompany) {
		this.transportationCompany = transportationCompany;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direction, guideNumber, id, status, transportationCompany);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryDetail other = (DeliveryDetail) obj;
		return Objects.equals(direction, other.direction) && guideNumber == other.guideNumber && id == other.id
				&& Objects.equals(status, other.status)
				&& Objects.equals(transportationCompany, other.transportationCompany);
	}
	
}
