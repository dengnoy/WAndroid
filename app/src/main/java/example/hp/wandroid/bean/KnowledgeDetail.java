package example.hp.wandroid.bean;

import java.util.List;

public class KnowledgeDetail {
    private int offset;
    private int pageCount;
    private boolean over;
    private int size;
    private int total;
    private int curPage;
    private List<KnowledgeArticle> datas;

    public KnowledgeDetail(int offset, int pageCount, boolean over, int size, int total, int curPage, List<KnowledgeArticle> datas) {
        this.offset = offset;
        this.pageCount = pageCount;
        this.over = over;
        this.size = size;
        this.total = total;
        this.curPage = curPage;
        this.datas = datas;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
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

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<KnowledgeArticle> getDatas() {
        return datas;
    }

    public void setDatas(List<KnowledgeArticle> datas) {
        this.datas = datas;
    }
}
