package com.company;
import java.util.*;
public class Main {
    static int NumberOfHospitals=-1;
    static Scanner scanner = new Scanner(System.in);
    static String Vaccine []= new String[500005];
    static class HospitalNode{
        static String Hospital[]= new String[500005];
        String Name;
        String Pincode;
        int id;
        String [] vaccines = new String[500005];
        public HospitalNode(){
            this.Name=scanner.nextLine();
            this.Pincode=scanner.nextLine();
            this.id = NumberOfHospitals+1;
            NumberOfHospitals++;

        }
    }
    static void AddVaccine(String Name, int Doses, int Gap){

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
        int n = scanner.nextInt();
        while(n!=8){
            if(n==1){
            }
            if(n==2){

            }
            if(n==3){

            }
            if(n==4){

            }
            if(n==5){

            }
            if(n==6){

            }
            if(n==7){

            }

    }
        System.out.println("EXIT --- Thanks for using COWIN");
}
}
