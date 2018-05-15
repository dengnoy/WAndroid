package example.hp.wandroid.bean;

import java.util.List;

public class FavArticle {
    int curPage;
    int offset;
    boolean over;
    int pageCount;
    int size;
    int total;
    List<ArticleInfo> datas;


    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
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

    public List<ArticleInfo> getArticleInfo() {
        return datas;
    }

    public void setArticleInfo(List<ArticleInfo> articleInfo) {
        this.datas = articleInfo;
    }

    public static class ArticleInfo {
        /**
         * "author": "MrTangFB",
         * "chapterId": 140,
         * "chapterName": "dagger2",
         * "courseId": 13,
         * "desc": "",
         * "envelopePic": "",
         * "id": 11196,
         * "link": "https://www.jianshu.com/p/b35a658bb1ba",
         * "niceDate": "21小时前",
         * "origin": "",
         * "originId": 2910,
         * "publishTime": 1526275746000,
         * "title": "Android Dagger2 从零单排(二) @Qualifier",
         * "userId": 5672,
         * "visible": 0,
         * "zan": 0
         */
        private String author;

        private int chapterid;

        private String chaptername;

        private int courseid;
        private String desc;

        private String envelopepic;
        private int id;
        private String link;

        private String niceDate;
        private String origin;

        private int originid;

        private int publishtime;
        private String title;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterid() {
            return chapterid;
        }

        public void setChapterid(int chapterid) {
            this.chapterid = chapterid;
        }

        public String getChaptername() {
            return chaptername;
        }

        public void setChaptername(String chaptername) {
            this.chaptername = chaptername;
        }

        public int getCourseid() {
            return courseid;
        }

        public void setCourseid(int courseid) {
            this.courseid = courseid;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopepic() {
            return envelopepic;
        }

        public void setEnvelopepic(String envelopepic) {
            this.envelopepic = envelopepic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNicedate() {
            return niceDate;
        }

        public void setNicedate(String nicedate) {
            this.niceDate = nicedate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getOriginid() {
            return originid;
        }

        public void setOriginid(int originid) {
            this.originid = originid;
        }

        public int getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(int publishtime) {
            this.publishtime = publishtime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
