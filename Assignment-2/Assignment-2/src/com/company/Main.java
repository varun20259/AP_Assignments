package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static Scanner scan = new Scanner(System.in);

    public static ArrayList<ArrayList<String>> getComments() {
        return Comments;
    }

    private static ArrayList<ArrayList<String>> Comments = new ArrayList<>();
    public static void main(String[]args) {
        String a = "0";
        Instructor i = new Instructor();
        Students s = new Students();
        i.Add_Instructor();
        while (!a.equals("3")) {
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            a = scan.nextLine();
            if (a.equals("1")) {
                i.show_instructors();
                System.out.println("Choose id: ");
                String id = scan.nextLine();
                String retu = i.getInstructor(id);
                while (retu.equals("Incorrect Id:")) {
                    System.out.println("Enter correct Id: ");
                    id = scan.nextLine();
                    retu = i.getInstructor(id);
                }
                System.out.println("Welcome " + retu);
                while (true) {
                    i.menu();
                    String n = scan.nextLine();
                    if (n.equals("1")) {
                        System.out.println("1. Add Lecture Slide\n" +
                                "2. Add Lecture Video");
                        String option = scan.nextLine();
                        if (option.equals("1")) {
                            i.Add_Lecture_slides(id);
                        } else {
                            i.Add_Lecture_videos(id);
                        }

                    }
                    else if (n.equals("2")) {
                        System.out.println("1. Add Assignment\n" +
                                "2. Add Quiz");
                        String option = scan.nextLine();
                        ArrayList<String> w;
                        if (option.equals("1")) {
                            w=i.Add_Assessment(id);
                        } else {
                            w =i.Add_Quiz(id);
                        }
                        s.Assign(w,i);
                    }
                    else if (n.equals("3")) {
                        s.View_lecture_materials(i);
                    }
                    else if (n.equals("4")) {
                        s.View_assessments("0",i);
                    }
                    else if (n.equals("5")) {
                        System.out.println("List of assessments");
                        s.View_assessments("0",i);
                        i.Grade_submission(s,i,id);
                    }
                    else if (n.equals("6")) {
                        i.close_assessment();
                    }
                    else if (n.equals("7")) {
                       i.View_comment(id,i);
                    }
                    else if (n.equals("8")) {
                        i.Add_comment(id,i);

                    }
                    else {
                        break;
                    }
                    System.out.println("----------------------------------------------------------------------------");
                }

            }
            else if(a.equals("2")) {
                s.getStudent();
                System.out.println("Choose id: ");
                String id = scan.nextLine();
                System.out.println("Welcome " + "s"+id);
                while (true) {
                    s.menu();
                    String n = scan.nextLine();

                    if (n.equals("1")) {
                        s.View_lecture_materials(i);

                    }
                    else if (n.equals("2")) {
                        s.View_assessments(id, i);
                    }
                    else if (n.equals("3")) {
                        s.Submit_assessments(id, i);
                    }
                    else if (n.equals("4")) {
                        s.View_grades(id);

                    }
                    else if (n.equals("5")) {
                        s.View_comment(id,i);
                    }
                    else if (n.equals("6")) {
                        s.Add_comment(id,i);
                    }
                    else  {
                        break;
                    }
                    System.out.println("----------------------------------------------------------------------------");
                }

            }
            else{
                break;
            }
        }
    }
}
