/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/12
        Info: Talent DTO (BEAN)
        Time: 9:02 오전
        Class:TalentBean
        To change this template use File | Settings | File Templates.
        */
package Talent.Model;

public class TalentBean {
    private int idx;
    private String title;
    private String contents;
    private String start_date;
    private String end_date;
    private String member_id;
    private String category_id;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String  getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
}
