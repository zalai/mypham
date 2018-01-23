package taglid;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTaglib extends SimpleTagSupport {
	private String uri;
	private int currentPage = 1;
	private int count;
	private int max = 10;
	private int pageSize = 20;

	private String paramSearch;
	private static String previous = "Previous";
	private static String next = "Next";

	private static String ACTIVE_CLASS = "active";
	private static String DISABLED_CLASS = "disabled";
	private static int NUM = 3;

	private Writer getWriter() {
		JspWriter out = getJspContext().getOut();
		return out;
	}

	@Override
	public void doTag() throws JspException {
		Writer out = getWriter();

		int offset = (currentPage * pageSize) - pageSize;
		int totalpage = (int)Math.ceil(Double.valueOf(count)/pageSize);
		
		if (totalpage > 1) {
			try {
				out.write("<nav>");
				out.write("<ul class=\"pagination\">");

				// Show previous button
				if(currentPage == 1)
					out.write(constructLink(1, previous, DISABLED_CLASS, true));
				else
					out.write(constructLink(currentPage - 1, previous, null, false));

				int pageFrom = currentPage <= NUM ? 1 : currentPage - NUM;
				int pageTo = currentPage + NUM >= totalpage ? totalpage : currentPage + NUM;

				for (; pageFrom <= pageTo; pageFrom++) {

					if(pageFrom == currentPage)
						out.write(constructLink(currentPage, String.valueOf(currentPage), ACTIVE_CLASS, true));
					else
						out.write(constructLink(pageFrom, String.valueOf(pageFrom), null, false));
				}

				if (currentPage >= totalpage)
					out.write(constructLink(totalpage, next, DISABLED_CLASS, true));
				else
					out.write(constructLink(currentPage + 1, next, null, false));

				out.write("</ul>");
				out.write("</nav>");
			} catch (java.io.IOException ex) {
				throw new JspException("Error in Paginator tag", ex);
			}
		}
	}


	private String constructLink(int page, String text, String cssClassName, boolean disabled) {
		StringBuilder link = new StringBuilder("<li");
		if (cssClassName != null) {
			link.append(" class=\"");
			link.append(cssClassName);
			link.append("\"");
		}

		if(disabled) {

			link.append(">").append("<span>" + text + "</span></li>");
		}
		else if(paramSearch != null){

			link.append(">").append("<a href=\"" + uri + paramSearch + "&page=" + page + "\">" + text + "</a></li>");
		} else {

			link.append(">").append("<a href=\"" + uri + "?page=" + page + "\">" + text + "</a></li>");
		}

		return link.toString();
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getParamSearch() {
		return paramSearch;
	}

	public void setParamSearch(String paramSearch) {
		this.paramSearch = paramSearch;
	}

}
