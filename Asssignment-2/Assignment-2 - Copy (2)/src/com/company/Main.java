package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static Scanner scan = new Scanner(System.in);
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
                    i.Instructors_menu();
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
                        for(int qwe=0;qwe<Comments.size();qwe++){
                            ArrayList<String> we = Comments.get(qwe);
                            System.out.println(we.get(1)+" - "+we.get(0));
                            System.out.println(we.get(2));
                        }
                    }
                    else if (n.equals("8")) {
                        String time =i.Time();
                        System.out.println("Enter comments: ");
                        String comment = scan.nextLine();
                        ArrayList<String> r = new ArrayList<>();
                        r.add("I"+id);
                        r.add(comment);
                        r.add(time);
                        Comments.add(r);
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
                    s.Student_menu();
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
                        for(int qwe=0;qwe<Comments.size();qwe++){
                            ArrayList<String> we = Comments.get(qwe);
                            System.out.println(we.get(1)+" - "+we.get(0));
                            System.out.println(we.get(2));
                        }
                    }
                    else if (n.equals("6")) {
                        String time =i.Time();
                        System.out.println("Enter comments: ");
                        String comment = scan.nextLine();
                        ArrayList<String> r = new ArrayList<>();
                        r.add("s"+id);
                        r.add(comment);
                        r.add(time);
                        Comments.add(r);
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
