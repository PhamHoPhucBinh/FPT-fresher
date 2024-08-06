package Assignment.Day2.View;

import Assignment.Day2.Util.CommonUtil;

public class HomeView {
    public static void main(String[] args) {
displayHomeView();
    }
    public static void displayHomeView(){
        System.out.println("----- Welcome to FPT Candidates Management -----\n" +
                "1. Candidate Management\n" +
                "2. Certificate Management\n" +
                "3. Show all Candidates \n" +
                "4. Show all Certificates\n" +
                "6. Exit");

        int choice= CommonUtil.getChoice(1,5);

        switch (choice){
            case 1 -> CandidateView.show();
//            case 2 -> CertificateView.show();
//            case 3 -> showAllCandidates();
//            case 4 -> showAllCertificates();
            case 5 -> System.exit(0);
        }

        backToHomeMenu();
    }
    private static void backToHomeMenu() {
        System.out.print("Do you back to main menu (Y/N): ");

        if (CommonUtil.getScanner().nextLine().equalsIgnoreCase("y")){
            displayHomeView();
        }
        else{
            System.exit(0);
        }
    }
}
