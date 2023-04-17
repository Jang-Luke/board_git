package dto;

import java.sql.Timestamp;

public class MemberDTO {
    private String id;
    private String pw;
    private String phone;
    private String email;
    private String zipcode;
    private String address_1;
    private String address_2;
    private Timestamp join_date;

    public MemberDTO(String id, String pw, String phone, String email, String zipcode, String address_1, String address_2, Timestamp join_date) {
        this.id = id;
        this.pw = pw;
        this.phone = phone;
        this.email = email;
        this.zipcode = zipcode;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.join_date = join_date;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public Timestamp getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Timestamp join_date) {
        this.join_date = join_date;
    }
}
