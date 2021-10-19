package com.company;
import java.util.*;
class Students  extends Person implements Comment, Assessment {
    static Scanner scan = new Scanner(System.in);

    public static ArrayList<ArrayList<String>> getS0_assignments() {
        return s0_assignments;
    }

    public static void setS0_assignments(ArrayList<ArrayList<String>> s0_assignments) {
        Students.s0_assignments = s0_assignments;
    }

    private static ArrayList<ArrayList<String>> s0_assignments=new ArrayList<>();

    public static ArrayList<ArrayList<String>> getS1_assignments() {
        return s1_assignments;
    }

    public static void setS1_assignments(ArrayList<ArrayList<String>> s1_assignments) {
        Students.s1_assignments = s1_assignments;
    }

    private static ArrayList<ArrayList<String>> s1_assignments=new ArrayList<>();

    public static ArrayList<ArrayList<String>> getS2_assignments() {
        return s2_assignments;
    }

    public static void setS2_assignments(ArrayList<ArrayList<String>> s2_assignments) {
        Students.s2_assignments = s2_assignments;
    }

    private static ArrayList<ArrayList<String>> s2_assignments=new ArrayList<>();
    private static ArrayList<String> ID_of_assignments=new ArrayList<>();
    void Assign(ArrayList<String>assignments, Instructor j) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(assignments.get(2));// id of assessment
        temp.add(assignments.get(3));// Type of assessment like A for assignment and Q for quiz
        String submission = "";
        String marks_scored = "";
        String graded_by = "";
        temp.add(submission);
        temp.add(graded_by);
        if (assignments.get(3).equals("A")) {
            temp.add(assignments.get(5));//Marks if present
        }
        temp.add(marks_scored);
        temp.add(assignments.get(4));// problem set
        ArrayList<String> a = new ArrayList<>(temp);
        Collections.copy(a,temp);
        ArrayList<String> b = new ArrayList<>(temp);
        Collections.copy(b,temp);
        ArrayList<String> c = new ArrayList<>(temp);
        Collections.copy(c,temp);
        s0_assignments.add(a);
        s1_assignments.add(b);
        s2_assignments.add(c);
    }
    void View_grades(String id){
        ArrayList<ArrayList<String>> a= Student_assignment_data(id);
        System.out.println("Graded submissions");
        for(int i=0;i<a.size();i++){
            ArrayList<String> c = a.get(i);
            if(!c.get(3).equals("")){
                if(c.get(1).equals("A")){
                    System.out.println("Id of assignment: "+c.get(0));
                    System.out.println("Submission: "+c.get(2));
                    System.out.println("Marks scored: "+c.get(5));
                    System.out.println("Graded by: "+c.get(3));
                }
                else{
                    System.out.println("Id of assignment: "+c.get(0));
                    System.out.println("Answer given: "+c.get(2));
                    System.out.println("Status: "+c.get(6));
                    System.out.println("Graded by: "+c.get(3));
                }
            }
        }
        System.out.println("Ungraded submissions");
        for(int i=0;i<a.size();i++){
            ArrayList<String> c = a.get(i);
            if(c.get(3).equals("")){
                if(c.get(1).equals("A")){
                    System.out.println("Id of assignment: "+c.get(0)+""+" Submission: "+c.get(2));
                }
                else{
                    System.out.println("Id of assignment: "+c.get(0)+" Answer given: "+c.get(2));
                }
            }
        }
    }

    @Override
    public void Add_comment(String id, Instructor k){
        Main m = new Main();
        String time =k.Time();
        ArrayList<ArrayList<String>> x=m.getComments();
        System.out.println("Enter comments: ");
        String comment = scan.nextLine();
        ArrayList<String> r = new ArrayList<>();
        r.add("s"+id);
        r.add(comment);
        r.add(time);
        x.add(r);

    }
    /*public void View_material(String id) {

    }*/
    ArrayList<ArrayList<String>> Student_assignment_data(String id){
        int num = Integer.parseInt(id);
        ArrayList<ArrayList<String>> aa = new ArrayList<>();
        if(num==0){
           aa=s0_assignments;
        }
        else if(num==1){
            aa=s1_assignments;
        }
        else if(num==2){
            aa=s2_assignments;
        }
        return aa;
    }
    /*void Graded_Ungraded_submissions(String id,Instructor j){
        ArrayList<ArrayList<String>> aa =Student_assignment_data(id);
        System.out.println("Graded submissions");
        for(int k=0;k<aa.size();k++){
            ArrayList<String> temp = aa.get(k);
            if(!temp.get(3).equals("")){
                if(temp.get(1).equals("A")){
                    System.out.println("ID : "+temp.get(0)+", Assignment: "+temp.get(6)+"Maximum marks: "+temp.get(4));
                    System.out.println("Submission:"+temp.get(2));
                    System.out.println("----------------------------------------------------------------------------");
                }
                else if(temp.get(1).equals("Q")) {
                    System.out.println("ID : "+temp.get(0)+", Question: "+temp.get(5));
                    System.out.println("Submission:"+temp.get(2));
                    System.out.println("----------------------------------------------------------------------------");
                }

            }
        }
        System.out.println("Ungraded submissions");
        for(int k=0;k<aa.size();k++){
            ArrayList<String> temp = aa.get(k);
            if(temp.get(3).equals("")){
                if(temp.get(1).equals("A")){
                    System.out.println("ID : "+temp.get(0)+", Assignment: "+temp.get(6)+"Maximum marks: "+temp.get(4));
                    System.out.println("----------------------------------------------------------------------------");
                }
                else if(temp.get(1).equals("Q")) {
                    System.out.println("ID : "+temp.get(0)+", Question: "+temp.get(5));
                    System.out.println("----------------------------------------------------------------------------");
                }

            }
        }
    }*/
    void Submit_assessments(String id,Instructor j){
        ArrayList<ArrayList<String>> aa =Student_assignment_data(id);
            ArrayList<String> pending = new ArrayList<>();
            System.out.println("Pending assessments");
            for(int k=0;k<aa.size();k++){
                ArrayList<String> temp = aa.get(k);
                if(temp.get(2).equals("")){
                    if(temp.get(1).equals("A")){
                        System.out.println("ID : "+temp.get(0)+", Assignment: "+temp.get(6)+", Maximum marks: "+temp.get(4));
                    }
                    else if(temp.get(1).equals("Q")) {
                        System.out.println("ID : "+temp.get(0)+", Question: "+temp.get(5));
                    }
                    System.out.println("----------------------------------------------------------------------------");
                    pending.add(temp.get(0));
                    pending.add(temp.get(1));
                }
            }
            if(pending.size()==0){
                System.out.println("WOW, no pending assignments");
                return;
            }
            System.out.println("Enter ID of assessment: ");
            String ID = scan.nextLine();
            if(j.getClosed_assessment().contains(ID)){
                System.out.println("This assessment is no longer accepting responses");return;
            }
            String filename="";
            for(int h=0;h<pending.size();h+=2){
                if(pending.get(h).equals(ID)){
                    if(pending.get(h+1).equals("Q")){
                        System.out.println("Type your answer");
                        filename = scan.nextLine();
                    }
                    else{
                        System.out.println("Enter filename of assignment: ");
                        filename= scan.nextLine();
                        while(!filename.endsWith(".zip")) {
                            System.out.println("Only zip files are allowed !");
                            filename = scan.nextLine();
                        }
                    }
                }
            }

        ArrayList<ArrayList<String>> Ass =j.getAssessment();
        for(int e=0;e<Ass.size();e++){
            ArrayList<String> problems = Ass.get(e);
            if(problems.get(2).equals(ID)){
                Ass.get(e).add(id);
            }
        }
            for(int y=0;y<aa.size();y++){
                ArrayList<String> temp = aa.get(y);
                if(temp.get(0).equals(ID)){
                    aa.get(y).set(2,filename);
                }
            }
    }


    public void Logout() {

    }
    void Add_material(){

    }

    public void menu(){
        System.out.println("STUDENT MENU\n" +
                "1. View lecture materials\n" +
                "2. View assessments\n" +
                "3. Submit assessment\n" +
                "4. View grades\n" +
                "5. View comments\n" +
                "6. Add comments\n" +
                "7. Logout");
    }

    void getStudent(){
        System.out.println("Students:\n" +
                "0 - S0\n" +
                "1 - S1\n" +
                "2 - S2");
    }
    void View_lecture_materials(Instructor j) {
        ArrayList<ArrayList<String>> LM = j.getLecture_materials();

        for (int k = 0; k < LM.size(); k++) {
            ArrayList<String> temp = LM.get(k);

            if (temp.get(2).equals("1")) {
                System.out.println("Title: " + temp.get(4));
                int number_of_slides = 0;
                for (int i = 5; i < temp.size(); i++) {
                    System.out.println("Slides" + (i - 4) + ": " + temp.get(i));
                    number_of_slides++;
                }

                System.out.println("Number of slides: " + number_of_slides);
                System.out.println("Date of upload: " + temp.get(3));
                System.out.println("Uploaded by: " + temp.get(1));
            } else {
                System.out.println("Title: " + temp.get(4));
                System.out.println("Video file: " + temp.get(5));
                System.out.println("Date of upload: " + temp.get(3));
                System.out.println("Uploaded by: " + temp.get(1));
            }
        }
     }
    }
