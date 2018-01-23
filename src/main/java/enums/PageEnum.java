package enums;

public enum PageEnum implements BreadcrumbI {

	TRANG_CHU("Trang chủ", "/index");
	String label;
	String url;

	private PageEnum(String label, String url) {
		this.label = label;
		this.url = url;
	}

	public String getLabel() {
		return label;
	}

	public String getUrl() {
		return url;
	}

}
