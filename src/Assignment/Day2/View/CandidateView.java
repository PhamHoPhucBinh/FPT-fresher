package Assignment.Day2.View;

import Assignment.Day2.Util.CommonUtil;

public class CandidateView {
    public static void show(){
        System.out.println("----- Candidates View: ------\n"+
                "1. Add new Candidates\n"+
                "2. Edit Candidates\n"+
                "3. Delete Candidates\n"+
                "4. Return main menu");

        int choice= CommonUtil.getChoice(1,4);

        switch (choice) {
            case 1 -> System.out.println("1. Add Candidate"); // edit sau
            case 2 -> System.out.println("1. Edit Candidate");
            case 3 -> System.out.println("3. delete Candidate");
            case 4 -> HomeView.displayHomeView();
        }
    }
}
