package mx.gob.impi.chatbot.persistence.api.model.domain;

import java.io.Serializable;

public class PageBoundaries implements Serializable {
    private static final long serialVersionUID = 1L;
	private int page;
	private int size;
	private String sortColumn;

	public PageBoundaries() {
	}
	
	public PageBoundaries(int page, int size, String sortColumn) {
		this.page = page;
		this.size = size;
		this.sortColumn = sortColumn;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

}
