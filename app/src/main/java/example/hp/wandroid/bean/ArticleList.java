package example.hp.wandroid.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ArticleList {

    private int curpage;
    private List<Article> datas;
    private int offset;
    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    public List<Article> getDatas() {
        return datas;
    }

    public void setDatas(List<Article> datas) {
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

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
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

    private boolean over;

    private int pagecount;
    private int size;
    private int total;

    public static class Article {

        private String apklink;
        private String author;

        private int chapterid;

        private String chaptername;
        private boolean collect;

        private int courseid;
        private String desc;

        private String envelopepic;
        private boolean fresh;
        private int id;
        private String link;

        private String niceDate;
        private String origin;

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        private String projectlink;

        private int publishtime;

        private int superchapterid;

        private String superchaptername;

        private String title;
        private int type;
        private int visible;
        private int zan;


        public String getApklink() {
            return apklink;
        }

        public void setApklink(String apklink) {
            this.apklink = apklink;
        }

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

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
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

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
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

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getProjectlink() {
            return projectlink;
        }

        public void setProjectlink(String projectlink) {
            this.projectlink = projectlink;
        }

        public int getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(int publishtime) {
            this.publishtime = publishtime;
        }

        public int getSuperchapterid() {
            return superchapterid;
        }

        public void setSuperchapterid(int superchapterid) {
            this.superchapterid = superchapterid;
        }

        public String getSuperchaptername() {
            return superchaptername;
        }

        public void setSuperchaptername(String superchaptername) {
            this.superchaptername = superchaptername;
        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }


    }
}
