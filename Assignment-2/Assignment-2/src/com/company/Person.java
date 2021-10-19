package com.company;
import java.util.ArrayList;

abstract class Person implements Assessment, Comment{

    public static ArrayList<ArrayList> getComments() {
        return Comments;
    }
    public void View_assessments(String id,Instructor j) {
        ArrayList<ArrayList<String>> Ass =j.getAssessment();
        for(int h=0;h<Ass.size();h++){
            ArrayList<String> temp = Ass.get(h);
            if(temp.get(3).equals("A")){
                System.out.println("ID : "+h+" Assignment: "+temp.get(4)+" Maximum marks: "+temp.get(5));
            }
            else if(temp.get(3).equals("Q")) {
                System.out.println("ID : "+h+" Question: "+temp.get(4));
            }
            System.out.println("----------------------------------------------------------------------------");
        }
    }
    public void View_comment(String id,Instructor i){
        Main m = new Main();
        ArrayList<ArrayList<String>> x=m.getComments();
        for(int qwe=0;qwe<x.size();qwe++){
            ArrayList<String> we = x.get(qwe);
            System.out.println(we.get(1)+" - "+we.get(0));
            System.out.println(we.get(2));
        }
    }


    private static ArrayList<ArrayList> Comments = new ArrayList<ArrayList>();


}
