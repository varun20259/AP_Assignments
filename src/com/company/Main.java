package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static com.company.Main.Vaccine.vaccine;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    //public static HashMap<String, ArrayList<String>> Hospital = new HashMap<>();
    static HashMap<String, String[]> Citizen = new HashMap<>();
    //static HashMap<Integer, String[]> vaccine = new HashMap<>();
    static class citizen {
        void register_citizen() {
            System.out.print("Citizen Name: ");
            String Cname = scanner.next();
            System.out.print("Age: ");
            String age = scanner.next();
            System.out.print("Unique ID: ");
            String id = scanner.next();
            String status = "REGISTERED";
            String vaccine = "";
            String number_of_doses_taken = "";
            String due_date = "";
            if (Integer.parseInt(age) < 18) {
                System.out.println("Only above 18 are allowed");
                return;
            }
            String[] citizen_data = {Cname, age, status, vaccine, number_of_doses_taken, due_date};
            Citizen.put(id, citizen_data);
            System.out.println("Citizen Name: " + Cname + ", Age: " + age + ", Unique ID: " + id + "\n" + status);
        }

        void show_status(String id) {
            String[] data = Citizen.get(id);
            System.out.println("Vaccination status: " + data[2]);
            System.out.println("Vaccine given: " + data[3]);
            System.out.println("Number of Doses given: " + data[4]);
            System.out.println("Next Dose due date: " + data[5]);
        }

        void set_vaccine_given(String unique_id) {

        }
    }

    static class Hospital {
        static ArrayList<ArrayList<String>> Hospitals = new ArrayList<>();
        void add_Hospital() {
            ArrayList<String> Hospital__data=new ArrayList<>();
            System.out.print("Hospital Name: ");
            String Hname = scanner.next();
            System.out.print("PinCode: ");
            String PinCode = scanner.next();
            int id = (int) (Math.random() * 1000000);
            String HosId= String.valueOf(id);
            Hospital__data.add(HosId);
            Hospital__data.add(Hname);
            Hospital__data.add(PinCode);
            Hospitals.add(Hospital__data);
            System.out.println("Hospital Name: " + Hname + ", PinCode: " + PinCode + ", Unique id: " + id);

        }

        void add_slot(String id) {
            System.out.println( Hospitals.size());
            for(int i=0;i<Hospitals.size();i++){
                ArrayList ll=Hospitals.get(i);
                System.out.println(ll.toString());
                if(id.equals(ll.get(0))){
                    System.out.print("Enter number of Slots to be added: ");
                    int slots = scanner.nextInt();
                    for (int j = 0; j < slots; j++) {
                        System.out.print("Enter day number: ");
                        String day = scanner.next();
                        System.out.print("Enter quantity: ");
                        String quantity = scanner.next();
                        System.out.println("Select Vaccine: ");
                        Vaccine v = new Vaccine();
                        v.DisplayVaccines();
                        String vac_num = scanner.next();
                        String ab="";
                        for(int h=0;h<vaccine.size();h++){
                            ArrayList <String >q=vaccine.get(h);
                            if(vac_num.equals(q.get(0))){
                                ab=q.get(1);
                            }
                        }
                        System.out.println("Slot added by Hospital " + id + " for Day: " + day + " Available Qyt: " + quantity + " of Vaccine: " + ab);
                        ll.add(day);
                        ll.add(vac_num);
                        ll.add(quantity);
                    }
                }
            }
        }
        void display_slot(String id){
            for (int i=0;i<Hospitals.size();i++){
                ArrayList ll=Hospitals.get(i);
                System.out.println(ll.toString());
                if(id.equals(ll.get(0))){
                    for(int k=4;k<ll.size()-1;k+=3){
                        String b=ll.get(k).toString();
                        String name_of_vaccine="";
                        for(int h=0;h<vaccine.size();h++){
                            ArrayList <String >q=vaccine.get(h);
                            if(b.equals(q.get(0))){
                                name_of_vaccine=q.get(1);
                            }
                        }
                        String s=ll.get(k+1).toString();
                        String day=ll.get(k-1).toString();
                        if(Integer.parseInt(s)>0){
                            System.out.println(s);
                            System.out.println("Day"+day+": Vaccine: "+name_of_vaccine+"Available Qyt: "+s);
                        }
                        else{
                            System.out.println("Day"+(k+1)+": Vaccine: "+name_of_vaccine+"Not Available");
                        }

                    }
                }
            }
        }
    }

    static class Vaccine {
        static String i = "0";
        static ArrayList<ArrayList<String>> vaccine = new ArrayList<>();
        void add_Vaccine() {
            ArrayList<String> vaccine_data= new ArrayList<>();
            System.out.print("Vaccine Name: ");
            String Vname = scanner.next();
            System.out.print("Number of Doses: ");
            String dose = scanner.next();
            System.out.print("Gap between Doses: ");
            String gap = scanner.next();
            vaccine_data.add(i);
            vaccine_data.add(Vname);
            vaccine_data.add(dose);
            vaccine_data.add(gap) ;
            vaccine.add(vaccine_data);
            System.out.println("Vaccine Name: " + Vname + ", Number of Doses: " + dose + ", Gap Between Doses: " + gap);
            int x = Integer.parseInt(i) + 1;
            i = "" + x;
        }

        void DisplayVaccines() {
            for (int k =0;k<vaccine.size();k++) {
                ArrayList<String> s= vaccine.get(k);
                System.out.println(k + ". " + s.get(1));
            }
        }

    }
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("CoWin Portal initialized....\n" +
                "---------------------------------\n" +
                "1. Add Vaccine\n" +
                "2. Register Hospital\n" +
                "3. Register Citizen\n" +
                "4. Add Slot for Vaccination\n" +
                "5. Book Slot for Vaccination\n" +
                "6. List all slots for a hospital\n" +
                "7. Check Vaccination Status\n" +
                "8. Exit\n" +
                "---------------------------------");
        int n = 0;
        while (n != 8) {
            System.out.println("---------------------------------");
            System.out.print("Enter code: ");
            n = scanner.nextInt();
            if (n == 1) {
                Vaccine v = new Vaccine();
                v.add_Vaccine();
                v.DisplayVaccines();
            }
            else if (n == 2) {
                Hospital h = new Hospital();
                h.add_Hospital();
                //h.DisplayHospital();
            }
            else if (n == 3) {
                citizen c = new citizen();
                c.register_citizen();
            }
            else if (n == 4) {
                Hospital h = new Hospital();
                //h.DisplayHospital();
                System.out.println("Enter Hospital Id: ");
                String id = scanner.next();
                h.add_slot(id);
            }
            else if (n == 5) {

            }
            else if (n == 6) {
                Hospital h = new Hospital();
                System.out.println("Enter hospital ID: ");
                String id= scanner.next();
                h.display_slot(id);
            }
            else if (n == 7) {
                System.out.print("Unique Citizen id: ");
                String id = scanner.next();
                citizen a = new citizen();
                a.show_status(id);
            }
            else {
                break;
            }

        }
        System.out.println("EXIT --- Thanks for using COWIN");
    }
}
