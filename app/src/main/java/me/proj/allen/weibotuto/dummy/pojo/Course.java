package me.proj.allen.weibotuto.dummy.pojo;

/**
 * Created by Allen on 2018/2/22.
 */
public class Course {
    /**
     * The ID of the course.
     */
    private int id;

    /**
     * The section this course belongs to.
     */
    private int type;

    /**
     * The title of this course.
     */
    private String title;

    /**
     * The resource id of the cover picture.
     */
    private int cover_pic_res_id;

    /**
     * Content of this course. Shall be updated as rich-contents including video, pics, etc.
     */
    private Content content;

    public Course(int id, int type, String title, int cover_pic_res_id) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.cover_pic_res_id = cover_pic_res_id;
    }

    public Course(int id, int type, String title, int cover_pic_res_id, Content content) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.cover_pic_res_id = cover_pic_res_id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getCover_pic_res_id() {
        return cover_pic_res_id;
    }

    public Content getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover_pic_res_id(int cover_pic_res_id) {
        this.cover_pic_res_id = cover_pic_res_id;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
