package uitls;

//专门进行分页
public class PageModel {
	// 每页多少条数据
	private final int PAGE_SIZE = 5;
	// 当前页
	private int pageIndex;
	// 每页多少条
	private int pageSize;
	// 总共有多少条数据
	private int recordCount;

	public int getPageIndex() {
		return pageIndex <= 1 ? 1 : pageIndex;
	}

	public int getPageSize() {
		return pageSize < 1 ? PAGE_SIZE : pageSize;
	}
	
	public int getTotalPage(){
		return (this.getRecordCount()-1)/this.getPageSize()+1;
	}
	
	public int getStarRow(){
		return (this.getPageIndex()-1)* this.getPageSize();
	}
	
	public void setPageIndex(int pageIndex) {
		this.pageIndex=pageIndex;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	
}
