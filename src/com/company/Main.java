package com.company;
import java.util.*;
import java.lang.Math;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String[],HashMap<String,String[]>> Hospital = new HashMap<>();
    static HashMap<String,String[]> Citizen = new HashMap<>();
    static class citizen{
            void register_citizen(){
                System.out.print("Citizen Name: ");
                String Cname = scanner.next();
                System.out.print("Age: ");
                String age = scanner.next();
                System.out.print("Unique ID: ");
                String id = scanner.next();
                String status ="REGISTERED";
                String vaccine="";
                String number_of_doses_taken="";
                String due_date ="";
                if(Integer.parseInt(age)<18){
                    System.out.println("Only above 18 are allowed");return;}
                String [] citizen_data={Cname,age,status,vaccine,number_of_doses_taken,due_date};
                Citizen.put(id,citizen_data);
                System.out.println("Citizen Name: "+Cname +", Age: " +age+", Unique ID: "+id +"\n"+ status);
            }
            void show_status(String id){
                String [] data=Citizen.get(id);
                System.out.println("Vaccination status: "+data[2]);
                System.out.println("Vaccine given: "+data[3]);
                System.out.println("Number of Doses given: "+data[4]);
                System.out.println("Next Dose due date: "+data[5]);
            }
            void set_vaccine_given(String id){

            }
    }
    static class Hospital{
        public Hospital(){
            System.out.print("Hospital Name: ");
            String Hname = scanner.next();
            System.out.print("PinCode: ");
            String PinCode  = scanner.next();
            int id= (int)(Math.random()*1000000);
            String NaPinId[]= {Hname,PinCode,String.valueOf(id)};
            HashMap<String,String[]> Hospital_vaccine = new HashMap<>();
            Hospital.put(NaPinId,Hospital_vaccine);
            System.out.println("Hospital Name: "+ Hname +", PinCode: "+ PinCode +"Unique id: "+ id);
        }
        void DisplayHospital(){

        }
        void add_slot(String id){
            System.out.print("Enter number of Slots to be added: ");
            int slots = scanner.nextInt();
            for(int i=0;i<slots;i++){
                System.out.print("Enter day number: ");
                int day = scanner.nextInt();
                System.out.print("Enter quantity: ");
                int dose = scanner.nextInt();
                System.out.print("Select Vaccine: ");
                Vaccine v = new Vaccine();
                v.DisplayVaccines();
                String vac_num = scanner.next();
                System.out.println("");


            }
        }
    }
    static HashMap<String,String[]> vaccine = new HashMap<>();
    static class Vaccine{
        static String i="0";
        void add_Vaccine(){
            System.out.print("Vaccine Name: ");
            String Vname = scanner.next();
            System.out.print("Number of Doses: ");
            String dose = scanner.next();
            System.out.print("Gap between Doses: ");
            String gap = scanner.next();
            String arr[]= {Vname,dose,gap};
            vaccine.put(i,arr);
            System.out.println("Vaccine Name: "+ Vname +", Number of Doses: "+ dose + ", Gap Between Doses: " + gap);
            int x =Integer.parseInt(i)+1;
            i=""+x;
            return;
        }
        void DisplayVaccines(){
            int j=0;
            for(String k: vaccine.keySet()){
                String []data=vaccine.get(k);
                System.out.println(k+". "+data[0]);
                return;
            }
        }
    }

    public static void main(String[] args) {

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
        int n =0;
        while(n!=8){
            System.out.print("Enter code: ");
            n = scanner.nextInt();
            if(n==1){
                Vaccine v = new Vaccine();
                v.add_Vaccine();
                v.DisplayVaccines();
            }
            else if(n==2){
                Hospital h = new Hospital();
                h.DisplayHospital();
            }
            else if(n==3){
                citizen c = new citizen();
                c.register_citizen();
            }
            else if(n==4){
                Hospital h = new Hospital();
                String id= scanner.nextLine();;
                h.add_slot(id);

            }
            else if(n==5){

            }
            else if(n==6){

            }
            else if (n==7){
                System.out.print("Unique Citizen id: ");
                String id = scanner.next();
                citizen a = new citizen();
                a.show_status(id);
            }
            else{
                break;
            }

    }
        System.out.println("EXIT --- Thanks for using COWIN");
}
}
