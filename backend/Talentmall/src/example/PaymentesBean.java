package example;

public class PaymentesBean {
    private int orders_idx;
    private int idx;
    private String pay_date;
    private String purchaser_id; //구매자 id
    private String bank; //입금은행명
    private int total_pay; //총결제금액

    public int getOrders_idx() {
        return orders_idx;
    }

    public void setOrders_idx(int orders_idx) {
        this.orders_idx = orders_idx;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getPurchaser_id() {
        return purchaser_id;
    }

    public void setPurchaser_id(String purchaser_id) {
        this.purchaser_id = purchaser_id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getTotal_pay() {
        return total_pay;
    }

    public void setTotal_pay(int total_pay) {
        this.total_pay = total_pay;
    }
}
