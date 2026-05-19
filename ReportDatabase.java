import java.io.*;
import java.util.ArrayList;

public class ReportDatabase {

    String filePath = "data/scam_reports.txt";

    public void saveReport(ScamReport report) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write(report.toFileString() + "\n");
            fw.close();
            System.out.println("✅ Report saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    public ArrayList<ScamReport> getAllReports() {
        ArrayList<ScamReport> reports = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 6) {
                        ScamReport r = new ScamReport(
                            parts[0], parts[1], parts[2],
                            Integer.parseInt(parts[3]),
                            parts[4], parts[5]
                        );
                        reports.add(r);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No reports found yet.");
        }
        return reports;
    }

    public void searchByCompany(String companyName) {
        ArrayList<ScamReport> all = getAllReports();
        int count = 0;
        System.out.println("\n--- REPORTS FOR: " + companyName + " ---");
        for (ScamReport r : all) {
            if (r.companyName.toLowerCase()
                .contains(companyName.toLowerCase())) {
                r.printReport();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No reports found for this company.");
            System.out.println("Doesn't mean it's safe — always verify!");
        } else {
            System.out.println("Total reports found: " + count);
        }
    }

    public void showAllReports() {
        ArrayList<ScamReport> all = getAllReports();
        if (all.isEmpty()) {
            System.out.println("No reports yet. Be the first to report!");
            return;
        }
        System.out.println("\n--- ALL SCAM REPORTS (" + all.size() + " total) ---");
        for (ScamReport r : all) {
            r.printReport();
        }
    }
}