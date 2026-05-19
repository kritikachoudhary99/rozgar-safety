# RozgarSafety

A Java CLI tool to help Indian youth detect and report 
fake job postings and recruitment scams.

## The Problem
Every year lakhs of Indian freshers lose money to fake 
recruiters on WhatsApp, Telegram and LinkedIn. No simple 
verification tool exists for first-time job seekers from 
Tier 2/3 cities like Jodhpur, Patna, Indore.

## What This Does
- Analyzes any job posting for 6+ scam red flags
- Gives a Scam Risk Score from 0 to 100
- Community-powered scam reporting database
- Search any company name for past reports
- Built-in awareness guide with real helpline numbers

## How to Run
git clone https://github.com/kritikachoudhary99/rozgar-safety.git
cd rozgar-safety
javac src/Main.java
java -cp src Main

## Project Structure
rozgar-safety/
├── src/
│   ├── Main.java              - Menu and entry point
│   ├── JobPost.java           - Job posting data class
│   ├── ScamReport.java        - Scam report data class
│   ├── RedFlagEngine.java     - Scam detection brain
│   └── ReportDatabase.java    - Save and read reports
├── data/
│   └── scam_reports.txt       - Community reports database
└── README.md

## Red Flags Detected
| Red Flag                      | Risk Points |
|-------------------------------|-------------|
| Fee or money demanded         | +40         |
| Unrealistic salary for fresher| +20         |
| Fake MNC company name         | +30         |
| WhatsApp or Telegram only     | +15         |
| Gmail or Yahoo email from MNC | +15         |
| Urgent joining pressure       | +10         |

## Test It Yourself
Company  : TCS Recruitment Services Pvt Ltd
Salary   : 85,000 per month
Fee      : 3,000
Contact  : WhatsApp
Email    : tcsrecruitment@gmail.com
Urgent   : Yes

Result   : SCAM RISK SCORE 100/100 - VERY HIGH RISK

## If You Are Scammed
- Call 1930 - Cyber Crime Helpline
- Report at cybercrime.gov.in
- File complaint at nearest police station

## Built With
Java - OOP, File I/O, ArrayList, String Processing
No external libraries - pure Java

## Developer
Kritika Choudhary - B.Tech CSE, VIT Vellore
Built as a 1st year Java project to solve a real 
problem affecting Indian youth.

## Future Plans
- Web version with Spring Boot
- WhatsApp message paste and scan
- Hindi language support
- Connect to MCA21 to verify company registration
