package hello.model;

public class AjustMotifDlgModel {
    private String cashDesk;
    private String slotMachine;
    private double amount;
    private String transactionInfo;

    public String getCashDesk() {
        return cashDesk;
    }

    public void setCashDesk(String cashDesk) {
        this.cashDesk = cashDesk;
    }

    public String getSlotMachine() {
        return slotMachine;
    }

    public void setSlotMachine(String slotMachine) {
        this.slotMachine = slotMachine;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(String transactionInfo) {
        this.transactionInfo = transactionInfo;
    }
}