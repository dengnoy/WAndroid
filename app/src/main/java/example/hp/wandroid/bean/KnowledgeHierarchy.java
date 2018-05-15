package example.hp.wandroid.bean;

import android.text.TextUtils;

import java.util.List;

/*
一级分类
 */
public class KnowledgeHierarchy {
    /*
   children		[3]
courseId	:	13
id	:	150
name	:	开发环境
order	:	1
parentChapterId	:	0
visible	:	1
     */
    private List<ClassifyTwo> children;
    private int courseid;
    private int id;
    private String name;
    private int order;
    private int parentchapterid;
    private int visible;
    private String mChildrenNameMerge = "";//二级分类名称合并  ：“分类一 分类二 。。”

    public KnowledgeHierarchy(List<ClassifyTwo> children, int courseid, int id, String name, int order, int parentchapterid, int visible) {
        this.children = children;
        this.courseid = courseid;
        this.id = id;
        this.name = name;
        this.order = order;
        this.parentchapterid = parentchapterid;
        this.visible = visible;
    }


    public String getChildrenNameMerge() {

        if (mChildrenNameMerge == null) {
            List<ClassifyTwo> classifyTwoList = getChildren();
            if (classifyTwoList != null)

                mChildrenNameMerge = TextUtils.join(" ", classifyTwoList);

        }
        return mChildrenNameMerge;
    }

    public List<ClassifyTwo> getChildren() {
        return children;
    }

    public void setChildren(List<ClassifyTwo> children) {
        this.children = children;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentchapterid() {
        return parentchapterid;
    }

    public void setParentchapterid(int parentchapterid) {
        this.parentchapterid = parentchapterid;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public static class ClassifyTwo {

        /*

        	children		[0]
    courseId	:	13
    id	:	60
    name	:	Android Studio相关
    order	:	1000
    parentChapterId	:	150
    visible	:	1
         */

        private List<?> children;

        private int courseid;
        private int id;
        private String name;
        private int order;

        private int parentchapterid;
        private int visible;

        public ClassifyTwo(List<?> children, int courseid, int id, String name, int order, int parentchapterid, int visible) {
            this.children = children;
            this.courseid = courseid;
            this.id = id;
            this.name = name;
            this.order = order;
            this.parentchapterid = parentchapterid;
            this.visible = visible;
        }

        public int getCourseid() {
            return courseid;
        }

        public void setCourseid(int courseid) {
            this.courseid = courseid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getParentchapterid() {
            return parentchapterid;
        }

        public void setParentchapterid(int parentchapterid) {
            this.parentchapterid = parentchapterid;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public String toString() {
            return getName();
        }
    }

}
