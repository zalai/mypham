package form;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class AbstractForm {

	private String searchParam;
	private long resultSize;
	private int page = 1;

	public long getResultSize() {
		return resultSize;
	}

	public void setResultSize(long resultSize) {
		this.resultSize = resultSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String convertMapToQuery(MultiValueMap<String, String> params) {

		UriComponents uriCompenents = UriComponentsBuilder.newInstance().queryParams(params).build().encode();
		return uriCompenents.toUriString();
	}

	public String getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(MultiValueMap<String, String> params) {
		
		this.searchParam = convertMapToQuery(params);
	}
}
