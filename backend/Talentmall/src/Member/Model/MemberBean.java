/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/12
        Info: member DTO(BEAN)
        Time: 9:02 오전
        Class:MemberBean
        To change this template use File | Settings | File Templates.
        */
package Member.Model;

public class MemberBean {
    private String id;
    private String pw;
    private String name;
    private String phone;
    private String kind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getKind() {
        if(kind.equals("1")){
            kind ="소비자";
        }else if(kind.equals("2")){
            kind = "생산자";
        }
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
