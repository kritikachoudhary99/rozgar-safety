public class JobPost {
    
    String companyName;
    String jobTitle;
    int salaryOffered;
    boolean feeRequired;
    int feeAmount;
    String contactMethod;
    String contactEmail;
    boolean urgentJoining;

    public JobPost(String companyName, String jobTitle, 
                   int salaryOffered, boolean feeRequired,
                   int feeAmount, String contactMethod, 
                   String contactEmail, boolean urgentJoining) {
        this.companyName   = companyName;
        this.jobTitle      = jobTitle;
        this.salaryOffered = salaryOffered;
        this.feeRequired   = feeRequired;
        this.feeAmount     = feeAmount;
        this.contactMethod = contactMethod;
        this.contactEmail  = contactEmail;
        this.urgentJoining = urgentJoining;
    }

    public void printSummary() {
        System.out.println("\n--- JOB POST SUMMARY ---");
        System.out.println("Company  : " + companyName);
        System.out.println("Role     : " + jobTitle);
        System.out.println("Salary   : ₹" + salaryOffered + "/month");
        System.out.println("Fee      : " + (feeRequired ? "YES ₹" + feeAmount : "No"));
        System.out.println("Contact  : " + contactMethod);
        System.out.println("Email    : " + contactEmail);
        System.out.println("Urgent   : " + (urgentJoining ? "YES" : "No"));
    }
}