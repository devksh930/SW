/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/12
        Info: order DTO(bean)
        Time: 9:02 오전
        To change this template use File | Settings | File Templates.
        */
package example;

public class OrderBean {
    private int idx;
    private String register_date;
    private String state;
    private String member_id;
    private String commission_idx;
    private String talent_idx;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getCommission_idx() {
        return commission_idx;
    }

    public void setCommission_idx(String commission_idx) {
        this.commission_idx = commission_idx;
    }

    public String getTalent_idx() {
        return talent_idx;
    }

    public void setTalent_idx(String talent_idx) {
        this.talent_idx = talent_idx;
    }
}
