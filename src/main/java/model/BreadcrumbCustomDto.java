package model;

import enums.BreadcrumbI;	

public class BreadcrumbCustomDto implements BreadcrumbI{

	
	public BreadcrumbCustomDto(String label, String url) {
		this.label = label;
		this.url = url;
	}

	public BreadcrumbCustomDto(String label) {
		this.label = label;
	}

	private String label;
	private String url;

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
}
