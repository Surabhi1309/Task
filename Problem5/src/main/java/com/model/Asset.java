package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Asset {

	@Id
	
	@Column(name = "AssetId")
	private Integer assetId;
	
	@Column(name = "SerialNo")
	private Integer serialNo;

	@Column(name = "PrNo")
	private Integer prNo;

	@Column(name = "AssetType")
	private String assetType;

	@Column(name = "AssetPrice")
	private Integer assrtPrice;

	@Column(name = "AssetLocation")
	private String assetLocation;
	
	public Asset() {
		// TODO Auto-generated constructor stub
	}

	public Asset(Integer assetId, Integer serialNo, Integer prNo, String assetType, Integer assrtPrice,
			String assetLocation) {
		super();
		this.assetId = assetId;
		this.serialNo = serialNo;
		this.prNo = prNo;
		this.assetType = assetType;
		this.assrtPrice = assrtPrice;
		this.assetLocation = assetLocation;
	}


	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getPrNo() {
		return prNo;
	}

	public void setPrNo(Integer prNo) {
		this.prNo = prNo;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public Integer getAssrtPrice() {
		return assrtPrice;
	}

	public void setAssrtPrice(Integer assrtPrice) {
		this.assrtPrice = assrtPrice;
	}

	public String getAssetLocation() {
		return assetLocation;
	}

	public void setAssetLocation(String assetLocation) {
		this.assetLocation = assetLocation;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", serialNo=" + serialNo + ", prNo=" + prNo + ", assetType="
				+ assetType + ", assrtPrice=" + assrtPrice + ", assetLocation=" + assetLocation + "]";
	}
	
	

}
