public class ScamReport {
    
    String companyName;
    String contactNumber;
    String contactMethod;
    int amountDemanded;
    String reportedBy;
    String date;

    public ScamReport(String companyName, String contactNumber, 
                      String contactMethod, int amountDemanded, 
                      String reportedBy, String date) {
        this.companyName    = companyName;
        this.contactNumber  = contactNumber;
        this.contactMethod  = contactMethod;
        this.amountDemanded = amountDemanded;
        this.reportedBy     = reportedBy;
        this.date           = date;
    }

    public void printReport() {
        System.out.println("------------------------------");
        System.out.println("Company      : " + companyName);
        System.out.println("Contact No   : " + contactNumber);
        System.out.println("Via          : " + contactMethod);
        System.out.println("Amount Asked : ₹" + amountDemanded);
        System.out.println("Reported By  : " + reportedBy);
        System.out.println("Date         : " + date);
        System.out.println("------------------------------");
    }

    public String toFileString() {
        return companyName + "|" + contactNumber + "|" + 
               contactMethod + "|" + amountDemanded + "|" + 
               reportedBy + "|" + date;
    }
}