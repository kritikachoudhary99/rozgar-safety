import java.util.ArrayList;

public class RedFlagEngine {

    ArrayList<String> flagsFound = new ArrayList<>();
    int scamScore = 0;

    public void analyze(JobPost job) {

        flagsFound.clear();
        scamScore = 0;

        if (job.feeRequired) {
            flagsFound.add("✗ Fee demanded (₹" + job.feeAmount + 
                           ") — Legitimate companies NEVER charge fees");
            scamScore += 40;
        }

        if (job.salaryOffered > 60000) {
            flagsFound.add("✗ Salary too high for fresher (₹" + 
                           job.salaryOffered + "/month) — Unrealistic offer");
            scamScore += 20;
        }

        if (job.contactMethod.equalsIgnoreCase("WhatsApp") || 
            job.contactMethod.equalsIgnoreCase("Telegram")) {
            flagsFound.add("✗ Only " + job.contactMethod + 
                           " contact — Real companies use official email/phone");
            scamScore += 15;
        }

        if (job.contactEmail.contains("gmail") || 
            job.contactEmail.contains("yahoo")) {
            flagsFound.add("✗ Personal email (" + job.contactEmail + 
                           ") — Real MNCs use company domain emails");
            scamScore += 15;
        }

        if (job.urgentJoining) {
            flagsFound.add("✗ Urgent joining pressure — Classic scam tactic");
            scamScore += 10;
        }

        String name = job.companyName.toLowerCase();
        if (name.contains("tcs") || name.contains("infosys") || 
            name.contains("wipro") || name.contains("accenture")) {
            if (name.contains("services") || name.contains("recruitment") || 
                name.contains("pvt") || name.contains("solutions")) {
                flagsFound.add("✗ Fake company name — Impersonating real MNC");
                scamScore += 30;
            }
        }

        if (scamScore > 100) scamScore = 100;
    }

    public void printResult() {
        System.out.println("\n=============================");
        System.out.println("   SCAM ANALYSIS RESULT");
        System.out.println("=============================");
        System.out.println("SCAM RISK SCORE : " + scamScore + "/100");

        if (scamScore >= 70) {
            System.out.println("VERDICT : 🚨 VERY HIGH RISK — Likely SCAM");
        } else if (scamScore >= 40) {
            System.out.println("VERDICT : ⚠️  MEDIUM RISK — Be Very Careful");
        } else if (scamScore >= 15) {
            System.out.println("VERDICT : 🟡 LOW RISK — Verify Before Applying");
        } else {
            System.out.println("VERDICT : ✅ LOOKS SAFE — Still verify company");
        }

        System.out.println("\nRed Flags Found:");
        if (flagsFound.isEmpty()) {
            System.out.println("✓ No major red flags detected");
        } else {
            for (String flag : flagsFound) {
                System.out.println("  " + flag);
            }
        }
        System.out.println("\n📞 If scammed: Call 1930 or visit cybercrime.gov.in");
        System.out.println("=============================\n");
    }
}