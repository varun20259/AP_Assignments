package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
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
            System.out.println("{Menu Options}");
            System.out.print("Enter code: ");
            n = scanner.nextInt();
            if (n == 1) {
                Vaccine v = new Vaccine();
                v.add_Vaccine();
                //v.DisplayVaccines();
            }
            else if (n == 2) {
                Hospital h = new Hospital();
                h.add_Hospital();
            }
            else if (n == 3) {
                citizen c = new citizen();
                c.register_citizen();
            }
            else if (n == 4) {
                Hospital h = new Hospital();
                System.out.print("Enter Hospital Id: ");
                String id = scanner.next();
                h.add_slot(id);
            }
            else if (n == 5) {
                System.out.print("Enter patient Unique ID: ");
                String Unique_id = scanner.next();
                while(Unique_id.length()<12){
                    System.out.print("Enter correct patient Unique ID, again: ");
                    Unique_id = scanner.next();
                }
                citizen c = new citizen();
                c.set_vaccine_given(Unique_id);
            }
            else if (n == 6) {
                Hospital h = new Hospital();
                System.out.print("Enter hospital ID: ");
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

class citizen {
    static ArrayList<ArrayList<String>> citizen = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    void register_citizen() {
        ArrayList<String> citizen_data = new ArrayList<>();
        System.out.print("Citizen Name: ");
        String Cname = scanner.next();
        System.out.print("Age: ");
        String age = scanner.next();
        System.out.print("Unique ID: ");
        String id = scanner.next();
        for(int y=0;y<citizen.size();y++) {
            ArrayList<String> temp = citizen.get(y);
            while(temp.contains(id)){
                System.out.println("Same id already present, please enter another id: ");
                id = scanner.next();
            }
        }
        while (id.length() < 12) {
            System.out.println("Enter correct Unique id:");
            id = scanner.next();
        }
        String status = "REGISTERED";
        String vac_num = "";
        String number_of_doses_taken = "0";
        String due_date = "0";
        String previous_date = "0";
        if (Integer.parseInt(age) < 18) {
            System.out.println("Only above 18 are allowed");
            return;
        }
        citizen_data.add(id);
        citizen_data.add(Cname);
        citizen_data.add(age);
        citizen_data.add(status);
        citizen_data.add(vac_num);
        citizen_data.add(number_of_doses_taken);
        citizen_data.add(due_date);
        citizen_data.add(previous_date);
        citizen.add(citizen_data);
        System.out.println("Citizen Name: " + Cname + ", Age: " + age + ", Unique ID: " + id + "\n" + status);
    }

    void show_status(String id) {
        for (int i = 0; i < citizen.size(); i++) {
            ArrayList<String> data = citizen.get(i);
            Vaccine v = new Vaccine();
            String name_of_vaccine="";
            if (id.equals(data.get(0))) {
                for(int u=0;u<v.vaccine.size(); u++){
                    ArrayList<String> temp = v.vaccine.get(u);
                    if(temp.get(0).equals(data.get(4))){
                        name_of_vaccine= temp.get(1);
                    }
                }
                System.out.println("Vaccination status: " + data.get(3));
                System.out.println("Vaccine given: " + name_of_vaccine);
                System.out.println("Number of Doses given: " + data.get(5));
                System.out.println("Next Dose due date: " + data.get(6));
            }
        }
    }

    void set_vaccine_given(String unique_id) {
        for (int q = 0; q < citizen.size(); q++) {
            ArrayList<String> citizen_data = citizen.get(q);
            if (unique_id.equals(citizen_data.get(0))) {
                if (citizen_data.get(3).equals("FULLY VACCINATED")) {
                    System.out.println("The person is fully vaccinated");
                    return;
                }
            }
        }
        System.out.println("1. Search by area\n" +
                "2. Search by Vaccine\n" +
                "3. Exit");
        System.out.print("Enter Option: ");
        String operation = scanner.next();
        if ("1".equals(operation)) {
            System.out.print("Enter PinCode: ");
            String pincode = scanner.next();
            ArrayList<String> hospital_in_that_area = new ArrayList<>();
            Hospital h = new Hospital();
            int count = 0;
            for (int k = 0; k < h.Hospitals.size(); k++) {
                ArrayList<String> a = h.Hospitals.get(k);
                if (pincode.equals(a.get(2))) {
                    hospital_in_that_area.add(a.get(0));
                    System.out.println(a.get(0) + " " + a.get(1));
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("Enter hospital id: ");
                String hospital_id = scanner.next();
                citizen_to_hospital(hospital_id, unique_id, count);
            } else {
                System.out.println("No hospital in this area");
            }
        } else if ("2".equals(operation)) {
            System.out.print("Enter vaccine name: ");
            String name_of_vaccine = scanner.next();
            Hospital h2 = new Hospital();
            ArrayList<String> hospital_that_has_vaccine = new ArrayList<>();
            int count = 0;
            for (int k = 0; k < h2.Hospitals.size(); k++) {
                ArrayList<String> a = h2.Hospitals.get(k);
                for (int j = 4; j < a.size(); j += 3) {
                    Vaccine v = new Vaccine();
                    String vac_num = "";
                    for (int u = 0; u < v.vaccine.size(); u++) {
                        ArrayList<String> temp = v.vaccine.get(u);
                        if (name_of_vaccine.equals(temp.get(1))) {
                            vac_num = temp.get(0);
                            break;
                        }
                    }
                    if (vac_num.equals(a.get(j))) {
                        if (Integer.parseInt(a.get(j + 1)) > 0) {
                            if (!hospital_that_has_vaccine.contains(a.get(0))) {
                                hospital_that_has_vaccine.add(a.get(0));
                                System.out.println(a.get(0) + " " + a.get(1));
                                count++;
                            }
                        }
                    }
                }
            }
            if (count > 0) {
                System.out.println("Enter hospital id: ");
                String hospital_id = scanner.next();
                citizen_to_hospital(hospital_id, unique_id, count);
            } else {
                System.out.println("Vaccine unavailable");
            }
        } else if ("3".equals(operation)) {

        } else {
            System.out.println("Oops!!, looks like you entered something wrong");
        }
    }

    void citizen_to_hospital(String id_of_the_hospital, String unique_id, int count) {
        Hospital h = new Hospital();
        h.display_slot(id_of_the_hospital);
        System.out.println("Choose slot: ");
        String slot = scanner.next();
        for (int w = 0; w < h.Hospitals.size(); w++) {
            ArrayList<String> temp = h.Hospitals.get(w);
            if(temp.get(0).equals(id_of_the_hospital)){
                if (temp.size() < 3+ Integer.parseInt(slot) * 3) {
                    System.out.println("Incorrect data !!!");
                    return;
                }
            }
        }
        Vaccine v = new Vaccine();
        for (int y = 0; y < h.Hospitals.size(); y++) {
            ArrayList<String> x = h.Hospitals.get(y);
            if (id_of_the_hospital.equals(x.get(0))) {
                String vac_num = x.get(3 * Integer.parseInt(slot) + 1);
                Integer quantity = Integer.parseInt(x.get(3 * Integer.parseInt(slot) + 2));
                if (quantity != 0) {
                    for (int q = 0; q < citizen.size(); q++) {
                        ArrayList<String> cit = citizen.get(q);
                        if (unique_id.equals(cit.get(0))) {
                            String name_of_person = cit.get(1);
                            if (!vac_num.equals(cit.get(4)) && Integer.parseInt(cit.get(5)) > 0) {
                                System.out.println("ERROR, the person can not take 2 different vaccines");
                                return;
                            }
                            //System.out.println("vac_num " + vac_num);
                            //System.out.println(cit.toString());
                            //System.out.println(x.get(3 * Integer.parseInt(slot)));
                            if (Integer.parseInt(x.get(3 * Integer.parseInt(slot))) < Integer.parseInt(cit.get(6)) && Integer.parseInt(cit.get(5)) > 0) {
                                System.out.println("ERROR, you can not book your next dose, before your due date");
                                return;
                            }
                            ArrayList<String> data_of_vaccine = v.vaccine.get(Integer.parseInt(vac_num));
                            if (Integer.parseInt(data_of_vaccine.get(2)) == Integer.parseInt(cit.get(5)) + 1) {
                                cit.set(3, "FULLY VACCINATED");
                                cit.set(6, "FULLY VACCINATED");
                                System.out.println(cit.get(1) + " vaccinated with " + data_of_vaccine.get(1));
                                Integer the_amount_of_vaccines_left = Integer.parseInt(x.get(3 * Integer.parseInt(slot) + 2)) - 1;
                                cit.set(4, data_of_vaccine.get(0));
                                cit.set(5, data_of_vaccine.get(2));
                                x.set(3 * Integer.parseInt(slot) + 2, String.valueOf(the_amount_of_vaccines_left));
                            } else if (Integer.parseInt(data_of_vaccine.get(2)) > Integer.parseInt(cit.get(5)) + 1) {
                                cit.set(3, "PARTIALLY VACCINATED");
                                String number_of_doses_taken = cit.get(5);
                                String updated_doses = String.valueOf(Integer.parseInt(number_of_doses_taken) + 1);
                                cit.set(5, updated_doses);
                                String gap_needed = data_of_vaccine.get(3);
                                String day_on_which_vaccine_is_give = x.get(3 * Integer.parseInt(slot));
                                Integer updated_day_on_which_vaccine_is_give = Integer.parseInt(x.get(3 * Integer.parseInt(slot))) + Integer.parseInt(gap_needed);
                                cit.set(7, String.valueOf(Integer.parseInt(x.get(3 * Integer.parseInt(slot)))));
                                cit.set(6, String.valueOf(updated_day_on_which_vaccine_is_give));
                                cit.set(4, data_of_vaccine.get(0));
                                System.out.println(cit.get(1) + " vaccinated with " + data_of_vaccine.get(1));
                                Integer the_amount_of_vaccines_left = Integer.parseInt(x.get(3 * Integer.parseInt(slot) + 2)) - 1;
                                x.set(3 * Integer.parseInt(slot) + 2, String.valueOf(the_amount_of_vaccines_left));
                            }
                            System.out.println(cit.toString());
                        }
                    }
                } else {
                    System.out.println("Sorry, no vaccines left");
                }
            }
        }
    }
}


class Vaccine {
    static String i = "0";
    static ArrayList<ArrayList<String>> vaccine = new ArrayList<>();
    void add_Vaccine() {
        Scanner scanner = new Scanner(System.in);
        isInteger ii= new isInteger();
        ArrayList<String> vaccine_data= new ArrayList<>();
        System.out.print("Vaccine Name: ");
        String Vname = scanner.next();
        System.out.print("Number of Doses: ");
        String dose = scanner.next();
        while(!ii.isInteger(dose)){
            System.out.print("Please enter correct data: ");System.out.print("Number of Doses: ");dose=scanner.next();}
        System.out.print("Gap between Doses: ");
        String gap = scanner.next();
        while(!ii.isInteger(gap)){
            System.out.print("Please enter correct data: ");System.out.print("Gap between Doses: ");gap=scanner.next();}
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
        for (int k = 0; k < vaccine.size(); k++) {
            ArrayList<String> s = vaccine.get(k);
            System.out.println(k + ". " + s.get(1));
        }
    }
}
class isInteger {
    public boolean isInteger(String s){
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

}
class Hospital extends Vaccine {
    static ArrayList<ArrayList<String>> Hospitals = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    void add_Hospital() {
        ArrayList<String> Hospital__data = new ArrayList<>();
        System.out.print("Hospital Name: ");
        String Hname = scanner.next();
        System.out.print("PinCode: ");
        String PinCode = scanner.next();
        while (PinCode.length() < 6) {
            System.out.print("Enter correct PinCode");
            PinCode = scanner.next();
        }
        int id = (int) (Math.random() * 1000000);
        String HosId = String.valueOf(id);
        Hospital__data.add(HosId);
        Hospital__data.add(Hname);
        Hospital__data.add(PinCode);
        Hospitals.add(Hospital__data);
        System.out.println("Hospital Name: " + Hname + ", PinCode: " + PinCode + ", Unique id: " + id);

    }

    void add_slot(String id) {
        System.out.println(Hospitals.size());
        for (int i = 0; i < Hospitals.size(); i++) {
            ArrayList ll = Hospitals.get(i);
            if (id.equals(ll.get(0))) {
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
                    String ab = "";
                    for (int h = 0; h < vaccine.size(); h++) {
                        ArrayList<String> q = vaccine.get(h);
                        if (vac_num.equals(q.get(0))) {
                            ab = q.get(1);
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

    void display_slot(String id) {
        for (int i = 0; i < Hospitals.size(); i++) {
            ArrayList ll = Hospitals.get(i);
            if (id.equals(ll.get(0))) {
                int count = 1;
                for (int k = 4; k < ll.size() - 1; k += 3) {
                    String b = ll.get(k).toString();
                    String name_of_vaccine = "";
                    for (int h = 0; h < vaccine.size(); h++) {
                        ArrayList<String> q = vaccine.get(h);
                        if (b.equals(q.get(0))) {
                            name_of_vaccine = q.get(1);
                        }
                    }
                    String s = ll.get(k + 1).toString();
                    if (Integer.parseInt(s) > 0) {
                        System.out.println(count + " Day" + ll.get(k - 1) + ": Vaccine: " + name_of_vaccine + ", Available Qyt: " + s);
                    } else {
                        System.out.println("Day" + ll.get(k - 1) + ": Vaccine: " + name_of_vaccine + "Not Available");
                    }
                    count++;
                }
            }
        }
    }
}
