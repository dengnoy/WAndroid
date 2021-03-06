package example.hp.wandroid.bean;

import java.util.List;

public class NavigationClassify {
    private int cid;
    private String name;
    private List<NavigationClassifyArticle> articles;

    public NavigationClassify(int cid, String name, List<NavigationClassifyArticle> articles) {
        this.cid = cid;
        this.name = name;
        this.articles = articles;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NavigationClassifyArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<NavigationClassifyArticle> articles) {
        this.articles = articles;
    }

    public static class NavigationClassifyArticle {
        private String apkLink;
        private String author;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String origin;
        private String projectLink;
        //private int publishTime;
        private int superChapterid;
        private String superChaptername;
        private List<String> tags;
        private String title;
        private int type;
        private int userId;
        private int visible;
        private int zan;

        public NavigationClassifyArticle(String apkLink, String author, int chapterId, String chapterName, boolean collect, int courseId, String desc, String envelopePic, boolean fresh, int id, String link, String niceDate, String origin, String projectLink, int superChapterid, String superChaptername, List<String> tags, String title, int type, int userId, int visible, int zan) {
            this.apkLink = apkLink;
            this.author = author;
            this.chapterId = chapterId;
            this.chapterName = chapterName;
            this.collect = collect;
            this.courseId = courseId;
            this.desc = desc;
            this.envelopePic = envelopePic;
            this.fresh = fresh;
            this.id = id;
            this.link = link;
            this.niceDate = niceDate;
            this.origin = origin;
            this.projectLink = projectLink;

            this.superChapterid = superChapterid;
            this.superChaptername = superChaptername;
            this.tags = tags;
            this.title = title;
            this.type = type;
            this.userId = userId;
            this.visible = visible;
            this.zan = zan;
        }

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
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

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }



        public int getSuperChapterid() {
            return superChapterid;
        }

        public void setSuperChapterid(int superChapterid) {
            this.superChapterid = superChapterid;
        }

        public String getSuperChaptername() {
            return superChaptername;
        }

        public void setSuperChaptername(String superChaptername) {
            this.superChaptername = superChaptername;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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
