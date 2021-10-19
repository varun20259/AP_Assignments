package com.company;
import java.time.LocalDateTime;
import java.util.*;

class Instructor implements Comment{
    String id;
    String name;
    private static ArrayList<ArrayList<String>> Lecture_materials= new ArrayList<>();
    private static ArrayList<ArrayList<String>> Lecture_assessments = new ArrayList<>();
    private static ArrayList<ArrayList<String>> Assessment = new ArrayList<>();

    public static ArrayList<String> getClosed_assessment() {
        return Closed_assessment;
    }

    private static ArrayList<String> Closed_assessment= new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    private static ArrayList<String> instructor = new ArrayList<>();

    public static ArrayList<ArrayList<String>> getLecture_materials() {
        return Lecture_materials;
    }

    private static ArrayList<ArrayList<String>> videos=new ArrayList<>();
    private static ArrayList<ArrayList<String>> Comments = new ArrayList<>();
     void Add_Instructor(){
        instructor.add("0");
        instructor.add("I0");
        instructor.add("1");
        instructor.add("I1");
    }

    public static ArrayList<String> getInstructor() {
        return instructor;
    }
    public void View_comment(String id){

    }
    public void Add_comment(String id) {
        System.out.print("Enter comment: ");
        String comment=scan.nextLine();
        ArrayList<String> aa = new ArrayList<>();
        aa.add(id);
        aa.add(name);
        aa.add(comment);
        Comments.add(aa);
    }

   /* public void View_material(String id) {

    }*/
    public void View_assessments(String id) {
        ArrayList<ArrayList<String>> Ass =getAssessment();
        for(int h=0;h<Ass.size();h++){
            ArrayList<String> temp = Ass.get(h);
            if(temp.get(3).equals("A")){
                System.out.println("ID : "+temp.get(2)+" Assignment: "+temp.get(4)+" Maximum marks: "+temp.get(5));
            }
            else if(temp.get(3).equals("Q")) {
                System.out.println("ID : "+temp.get(2)+" Question: "+temp.get(4));
            }
            System.out.println("----------------------------------------------------------------------------");
        }
    }
    ArrayList<ArrayList<String>> students_data(String x,Students s){
            int num = Integer.parseInt(x);
            if(num==0){
               return s.getS0_assignments();
            }
            else if(num==1){
                return s.getS1_assignments();
            }
            else if(num==2){
                return s.getS2_assignments();
            }
            return null;
    }
    void close_assessment(){
        System.out.println("Open Assessments: ");
         for(int i=0;i<Assessment.size();i++){
             ArrayList<String> xyz = Assessment.get(i);
             if(!Closed_assessment.contains(xyz.get(2))){
                 if(xyz.get(3).equals("A")){
                     System.out.println("ID : "+xyz.get(2)+" Assignment: "+xyz.get(4)+" Maximum marks: "+xyz.get(5));
                 }
                 else if(xyz.get(3).equals("Q")) {
                     System.out.println("ID : "+xyz.get(2)+" Question: "+xyz.get(4));
                 }
                 System.out.println("----------------------------------------------------------------------------");
             }
         }
         System.out.println("Enter Id of assignment you want to close: ");
         String s = scan.nextLine();
         Closed_assessment.add(s);

    }
  void Grade_submission(Students s,Instructor j,String id_of_instructor){
      System.out.print("Enter ID of assessment to view submissions: ");
      ArrayList<String> aa=new ArrayList<>();
      String id = scan.nextLine();
      for(int z=0;z<Assessment.size();z++) {
          ArrayList<String> ttemp = Assessment.get(z);
          if (ttemp.get(2).equals(id)) {
              aa = ttemp;
          }
      }
      ArrayList<String> q = new ArrayList<>();
      int abc=0;
      int cv=0;
      System.out.println(aa);
      if(aa.get(3).equals("A")){
          cv=6;
      }
      else{
          cv=5;
      }

      for(int u=cv;u<aa.size();u++) {

          ArrayList<ArrayList<String>> z;
          z = students_data(aa.get(u), s);

          for (int y = 0; y < z.size(); y++) {
              ArrayList<String> temp = z.get(y);

              if (temp.get(3).equals("") && temp.get(0).equals(id)) {
                  if (abc == 0) {
                      System.out.println("Choose ID from these ungraded submissions: ");
                      abc = 1;
                  }
                  System.out.println(aa.get(u) + ": s" + aa.get(u));
                  q.add(aa.get(u));
              }
          }
          System.out.println(q);

      }
      if (q.size() == 0) {
          System.out.println("No, Ungraded submissions");
          return;
      }
      String id_of_student=scan.nextLine();
      ArrayList<ArrayList<String>> student = students_data(id_of_student,s);
      for(int o=0;o<student.size();o++){
          ArrayList<String> tempo = student.get(o);
          if(tempo.get(0).equals(id) && tempo.get(3).equals("")){
              System.out.println("Submission: "+tempo.get(2));
              System.out.println("------------------------------------------------");
              String instructor = "I"+id_of_instructor;
              if(tempo.get(1).equals("A")){System.out.println("Max marks: "+tempo.get(4));
                  System.out.print("Marks scored: ");
                  String marks = scan.nextLine();
                  tempo.set(3,instructor);
                  tempo.set(5,marks);
              }
              else{
                  tempo.set(3,instructor);
                  System.out.println("Is the answer correct: ");
                  String answer = scan.nextLine();
                  tempo.add(answer);
              }
              return;
          }
      }
  }

    public void Logout() {

    }
    String Time(){
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        String time= month+" "+day+" "+year+" "+hour+":"+minute+":"+second+" IST 2021";
        return time;
    }
    void Add_Lecture_slides(String id) {
        String name = getInstructor(id);;
        ArrayList<String> slide_details = new ArrayList<>();
        System.out.print("Enter topic of slides: ");
        String topic = scan.nextLine();
        System.out.print("Enter number of slides: ");
        String number = scan.nextLine();
        slide_details.add(id);
        slide_details.add(name);
        slide_details.add("1");
        String time =Time();
        slide_details.add(time);
        slide_details.add(topic);
        for (int j = 0; j < Integer.parseInt(number); j++) {
            System.out.print("Enter content of slide-"+(j+1)+" :");
            String content = scan.nextLine();
            slide_details.add(content);
        }
        Lecture_materials.add(slide_details);
    }
    void Add_Lecture_videos(String id){
        String name = getInstructor(id);
        ArrayList<String> video_details = new ArrayList<>();
        System.out.print("Enter topic : ");
        String topic =scan.nextLine();
        while(topic.equals("")) {topic =scan.nextLine();}
        System.out.print("Enter filename of video : ");
        String filename= scan.nextLine();
        while(!filename.endsWith(".mp4")){
            System.out.println("Wrong file format!!\n" +
                    "Choose another file: ");
            filename=scan.nextLine();
        }
        String time =Time();
        video_details.add(id);
        video_details.add(name);
        video_details.add("0");
        video_details.add(time);
        video_details.add(topic);
        video_details.add(filename);
        Lecture_materials.add(video_details);
    }

    public static ArrayList<ArrayList<String>> getAssessment() {
        return Assessment;
    }

    ArrayList<String> Add_Assessment(String id){
        System.out.print("Enter problem statement: ");
        String s = scan.nextLine();
        while(s.equals("")) {s =scan.nextLine();}
        System.out.print("Enter max marks: ");
        String marks = scan.nextLine();
        String name = getInstructor(id);;
        ArrayList<String> Asses = new ArrayList<>();
        String id_of_assessment =String.valueOf(Assessment.size());
        Asses.add(id);
        Asses.add(name);
        Asses.add(id_of_assessment);
        Asses.add("A");
        Asses.add(s);
        Asses.add(marks);
        Assessment.add(Asses);
        return Asses;
    }
    ArrayList<String> Add_Quiz(String id){
        System.out.println("Enter quiz question: ");
        String question=scan.nextLine();
        ArrayList<String> Q= new ArrayList<>();
        String name = getInstructor(id);;
        String id_of_assessment =String.valueOf(Assessment.size());
        Q.add(id);
        Q.add(name);
        Q.add(id_of_assessment);
        Q.add("Q");
        Q.add(question);
        Assessment.add(Q);
        return Q;
    }
    String getInstructor(String id){
        for(int k=0;k<instructor.size();k+=2){
            if(id.equals(instructor.get(k))){
                return instructor.get(k+1);
            }
        }
        return "Incorrect Id:";
    }
    void show_instructors(){
         for(int i=0;i<instructor.size();i+=2){System.out.println(instructor.get(i)+" - "+instructor.get(i+1));}

    }
    void Instructors_menu(){
        System.out.println("INSTRUCTOR MENU\n" +
                "1. Add class material\n" +
                "2. Add assessments\n" +
                "3. View lecture materials\n" +
                "4. View assessments\n" +
                "5. Grade assessments\n" +
                "6. Close assessment\n" +
                "7. View comments\n" +
                "8. Add comments\n" +
                "9. Logout");
    }

}
