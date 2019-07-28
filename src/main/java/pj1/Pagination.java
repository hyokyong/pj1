package pj1;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Pagination {
   
	int currentPage = 1;
    int pageSize = 15;
    int start;
    int end;
    int recordCount;
    int boardId;
    int srchType;
    String srchText = "";

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
   
    public int getStart() {
		return (currentPage-1)*pageSize;
	}

	public void setStart(int currentPage) {
		this.start = (currentPage-1)*pageSize;
	}
	
	public int getEnd() {
		return currentPage*pageSize;
	}

	public void setEnd(int pageSize, int currentPage) {
		this.end = currentPage*pageSize;
	}

	public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	public int getSrchType() {
        return srchType;
    }

    public void setSrchType(int srchType) {
        this.srchType = srchType;
    }

    public String getSrchText() {
        return srchText;
    }

    public void setSrchText(String srchText) {
        this.srchText = srchText;
    }

	/* query string과 같은 이름의 메소드들 구현 */
    public int getPg() {
        return currentPage;
    }

    public void setPg(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSz() {
        return pageSize;
    }

    public void setSz(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public int getBd() {
        return boardId;
    }

    public void setBd(int boardId) {
        this.boardId = boardId;
    }
    
    public int getSs() {
        return srchType;
    }

    public void setSs(int srchType) {
        this.srchType = srchType;
    }

    public String getSt() {
        return srchText;
    }

    public void setSt(String srchText) {
        this.srchText = srchText;
    }

    /* 멤버 변수 값들을 quey string으로 출력하기 위한 메소드 */
    public String getQueryString() throws UnsupportedEncodingException {
        String temp = (srchText == null) ? "" : URLEncoder.encode(srchText, "UTF-8");
        return String.format("pg=%d&sz=%d&bd=%d&ss=%d&st=%s", currentPage, pageSize, boardId, srchType, temp);
    }


    /* 화면 하단에 페이지 번호 링크들을 출력하기 위한 메소드와 클래스 */
    public List<Page> getPageList() {
        ArrayList<Page> list = new ArrayList<Page>();
        int pageCount = (recordCount + pageSize - 1) / pageSize;
        int basePage = ((currentPage - 1) / 10) * 10;
        if (basePage > 0)
            list.add(new Page("Prev", basePage));
        for (int i = 1; i <= 10 && basePage + i <= pageCount; ++i)
            list.add(new Page(basePage + i, currentPage == basePage + i));
        if (basePage + 11 <= pageCount)
            list.add(new Page("Next", basePage + 11));
        return list;
    }

    public class Page {
        String label;
        int number;
        String cssClass;

        public Page(int number, boolean active) {
            this.label = "" + number;
            this.number = number;
            this.cssClass = active ? "active" : "";
        }

        public Page(String label, int number) {
            this.label = label;
            this.number = number;
            this.cssClass = "";
        }

        public Object getLabel() {
            return label;
        }

        public int getNumber() {
            return number;
        }

        public String getCssClass() {
            return cssClass;
        }
    }

}
