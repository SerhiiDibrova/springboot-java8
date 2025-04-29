package hello.dto;

public class WarehouseReportDTO {
    private String response;
    private String symbol;

    public WarehouseReportDTO() {
        this.response = "YES";
        this.symbol = "✔️";
    }

    public String getResponse() {
        return response;
    }

    public String getSymbol() {
        return symbol;
    }

    public String toString() {
        return "Response: " + response + ", Symbol: " + symbol;
    }

    public boolean isAffirmative() {
        return "YES".equalsIgnoreCase(response);
    }
}