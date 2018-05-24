package example.hp.wandroid.bean;

import java.util.List;

public class SearchArticleList {
    private int curPage;
    private List<SearchArticle> datas;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;

    public SearchArticleList(int curPage, List<SearchArticle> datas, int offset, boolean over, int pageCount, int size, int total) {
        this.curPage = curPage;
        this.datas = datas;
        this.offset = offset;
        this.over = over;
        this.pageCount = pageCount;
        this.size = size;
        this.total = total;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<SearchArticle> getDatas() {
        return datas;
    }

    public void setDatas(List<SearchArticle> datas) {
        this.datas = datas;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
