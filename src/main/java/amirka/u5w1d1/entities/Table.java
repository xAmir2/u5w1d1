package amirka.u5w1d1.entities;

public class Table {
    private int tableNumber;
    private int maxSeats;
    private TableStatus status;

    public Table(int tableNumber, int maxSeats) {
        this.tableNumber = tableNumber;
        this.maxSeats = maxSeats;
        this.status = TableStatus.FREE;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", maxSeats=" + maxSeats +
                ", status=" + status +
                '}';
    }
}
