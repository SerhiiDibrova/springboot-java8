package hello.model;

import hello.model.Model;

public class AjustMTSModel extends Model {
    private String cashDesk;
    private String slotMachine;
    private double transactionAmount;

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

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}