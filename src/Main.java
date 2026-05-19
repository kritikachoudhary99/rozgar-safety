import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ReportDatabase db = new ReportDatabase();
    static RedFlagEngine engine = new RedFlagEngine();

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("  🛡️  ROZGAR SAFETY — Protect Your Career");
        System.out.println("     Fighting Job Scams Across India");
        System.out.println("=============================================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getInt("Enter choice: ");
            switch (choice) {
                case 1: checkJobPosting();   break;
                case 2: reportScam();        break;
                case 3: db.showAllReports(); break;
                case 4: searchCompany();     break;
                case 5: showAwareness();     break;
                case 6:
                    System.out.println("\nStay safe. Never pay for a job. 🇮🇳");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void printMenu() {
        System.out.println("\n=============================================");
        System.out.println("1. 🔍 Check if a Job Posting is Suspicious");
        System.out.println("2. 🚨 Report a Fake Recruiter / Company");
        System.out.println("3. 📋 View All Reported Scam Companies");
        System.out.println("4. 🔎 Search a Company Name");
        System.out.println("5. 📖 Learn Red Flags (Awareness Guide)");
        System.out.println("6. 🚪 Exit");
        System.out.println("=============================================");
    }

    static void checkJobPosting() {
        System.out.println("\n--- ENTER JOB DETAILS ---");
        System.out.print("Company Name        : ");
        String company = sc.nextLine();

        System.out.print("Job Title           : ");
        String title = sc.nextLine();

        int salary = getInt("Salary Offered (₹/month): ");

        System.out.print("Is Fee Required? (yes/no): ");
        boolean fee = sc.nextLine().equalsIgnoreCase("yes");
        int feeAmt = 0;
        if (fee) feeAmt = getInt("Fee Amount (₹): ");

        System.out.print("Contact Method (WhatsApp/Email/LinkedIn): ");
        String method = sc.nextLine();

        System.out.print("Contact Email       : ");
        String email = sc.nextLine();

        System.out.print("Urgent Joining Pressure? (yes/no): ");
        boolean urgent = sc.nextLine().equalsIgnoreCase("yes");

        JobPost job = new JobPost(company, title, salary, fee,
                                  feeAmt, method, email, urgent);
        job.printSummary();
        engine.analyze(job);
        engine.printResult();
    }

    static void reportScam() {
        System.out.println("\n--- REPORT A SCAM ---");
        System.out.print("Company Name    : ");
        String company = sc.nextLine();

        System.out.print("Their Number    : ");
        String number = sc.nextLine();

        System.out.print("How contacted? (WhatsApp/Email/LinkedIn): ");
        String method = sc.nextLine();

        int amount = getInt("Amount demanded (₹, enter 0 if none): ");

        System.out.print("Your City       : ");
        String city = sc.nextLine();

        String date = java.time.LocalDate.now().toString();

        ScamReport report = new ScamReport(company, number,
                                           method, amount, city, date);
        db.saveReport(report);
        System.out.println("Thank you for protecting others! 🙏");
    }

    static void searchCompany() {
        System.out.print("\nEnter company name to search: ");
        String name = sc.nextLine();
        db.searchByCompany(name);
    }

    static void showAwareness() {
        System.out.println("\n========= 📖 SCAM AWARENESS GUIDE =========");
        System.out.println("\n🔴 TOP RED FLAGS:");
        System.out.println("  1. Any fee required = SCAM");
        System.out.println("  2. Salary too high for fresher = SCAM");
        System.out.println("  3. WhatsApp/Telegram only contact = SCAM");
        System.out.println("  4. Gmail/Yahoo from MNC = SCAM");
        System.out.println("  5. Urgent joining pressure = SCAM");
        System.out.println("  6. No interview, direct selection = SCAM");
        System.out.println("\n✅ HOW TO VERIFY:");
        System.out.println("  • Check mca.gov.in for company registration");
        System.out.println("  • Search company + 'scam' on Google");
        System.out.println("  • Real offers come on company domain email");
        System.out.println("\n🆘 IF SCAMMED:");
        System.out.println("  • Call 1930 (Cyber Crime Helpline)");
        System.out.println("  • Report at cybercrime.gov.in");
        System.out.println("===========================================\n");
    }

    static int getInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Enter a number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }
}