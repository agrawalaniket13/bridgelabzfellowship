public class InvoiceSummary {
    private final int numofRides;
    private final double totalFare;
    private final double averageFare;
    public InvoiceSummary(int numOfRides, double totalFare){
        this.numofRides=numOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numofRides;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o==null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numofRides == that.numofRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }
}
