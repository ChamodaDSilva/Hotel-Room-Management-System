import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Hotel {
    public static void main(String[] args){
        Room num1=new Room(1,"empty");//the objects that contains number of rooms and owner name
        Room num2=new Room(2,"empty");
        Room num3=new Room(3,"empty");
        Room num4=new Room(4,"empty");
        Room num5=new Room(5,"empty");
        Room num6=new Room(6,"empty");
        Room num7=new Room(7,"empty");
        Room num8=new Room(8,"empty");

        Person p1=new Person();// the objects that contains personal details of the room owners
        Person p2=new Person();//these are parallel for room objets
        Person p3=new Person();
        Person p4=new Person();
        Person p5=new Person();
        Person p6=new Person();
        Person p7=new Person();
        Person p8=new Person();

        Room[] rooms={num1,num2,num3,num4,num5,num6,num7,num8};//Room array of objects
        Person[] people={p1,p2,p3,p4,p5,p6,p7,p8};//person array of object parallel for the the Room array

        //objects for the queue
        QueueforNumbers queueforNumberofGuests=new QueueforNumbers(6);//queue for number of geusts
        QueueforNumbers queueforCreditCard=new QueueforNumbers(6);//queue for credit card number
        QueueforStrings queueforName=new QueueforStrings(6);//queue for name
        QueueforStrings queueforFname=new QueueforStrings(6);//queueu for first name
        QueueforStrings queueforSname=new QueueforStrings(6);//queueu for surname

        QueueforNumbers[] queueforNumbers={queueforNumberofGuests,queueforCreditCard};//made all queue numbers in array objetc
        QueueforStrings[] queueforStrings={queueforName,queueforFname,queueforSname};//did the same for strings
        mainMenu(rooms,people, queueforStrings,queueforNumbers);// calling main menu to start the process
    }
    public static void sortNames(Room[] hotel, Person[] people, QueueforStrings[] queueforStrings,QueueforNumbers[] queueforNumbers){
        //to sort data by names
        System.out.println("\n-------View Rooms Alphabetically ------\n");
        String [] new_arr=new String[hotel.length];
        for(int i=0;i< hotel.length;i++){//to get array clone without referencing
            new_arr[i]=hotel[i].getname();
        }

        String temp=null;// a temporary variable
        for(int i=0;i< new_arr.length;i++){
            for(int j=1;j< new_arr.length;j++){
                if(new_arr[j-1].compareToIgnoreCase(new_arr[j])>0){//check the comparison (used bubble sorting)
                    temp=new_arr[j-1];//keep a element in the temp and swap
                    new_arr[j-1]=new_arr[j];
                    new_arr[j]=temp;
                }
            }
        }
        for(int i=0;i< new_arr.length;i++){//to print the array which contains name with the real room number
            if(!new_arr[i].equals("empty")){//to exclude the empty rooms
                for(int j=0;j< new_arr.length;j++) {
                    if(new_arr[i].equals(hotel[j].getname())) {// to get room number
                        System.out.println(new_arr[i] + " got room number "+ (j+1));
                        System.out.println("First Name: "+people[j].getFname()+" Surname: "+people[j].getSname());
                        System.out.println("Number of guests: "+people[j].getNumOfGuests()+ " Credit Card Number: "+people[j].getCreaditCardNum());
                        System.out.println("-----------------------------------------------------");
                    }
                }
            }
        }
        mainMenu(hotel,people, queueforStrings,queueforNumbers);// automatically redirect to the main menu
    }

    public static void loadData(Room[] hotel, Person[] people, QueueforStrings[] queueforStrings,QueueforNumbers[] queueforNumbers){
        //to get data from a file
        try {
            File fileName = new File("Data.txt");//making file object
            Scanner reader = new Scanner(fileName);
            String[] splitedItems;//array to store splitted items
            while (reader.hasNextLine()) {
                String data = reader.nextLine();//reader
                splitedItems=data.split("=");//store item splitted to the array
                hotel[Integer.parseInt(splitedItems[0])-1].setname(splitedItems[1]);//passing name
                people[Integer.parseInt(splitedItems[0])-1].setFname(splitedItems[2]);//passing first name
                people[Integer.parseInt(splitedItems[0])-1].setSname(splitedItems[3]);//passing surnmae
                people[Integer.parseInt(splitedItems[0])-1].setNumOfGuests(Integer.parseInt(splitedItems[4]));//parsing string in text wanted int
                people[Integer.parseInt(splitedItems[0])-1].setCreaditCardNum(Integer.parseInt(splitedItems[5]));//parsing string in text wanted int


            }
            reader.close();
        } catch (FileNotFoundException e) {//check errors
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Loaded the values..");
        mainMenu(hotel,people, queueforStrings,queueforNumbers);//redirect to the main menu

    }
    public static void storeData(Room[] hotel, Person[] people, QueueforStrings[] queueforStrings,QueueforNumbers[] queueforNumbers) {
        // for print the data in a text file

        try {
            FileWriter fileWriter = new FileWriter("Data.txt");// file printing is output.txt
            for(int i=0;i<8;i++){
                fileWriter.write(hotel[i].getroom_num()+"="+hotel[i].getname()+"=");
                fileWriter.write(people[i].getFname()+"="+people[i].getSname()+"=");
                fileWriter.write(people[i].getNumOfGuests()+"="+people[i].getCreaditCardNum()+"\n");
            }
            fileWriter.close();
            System.out.println("Successfully wrote to the file..");
        } catch (IOException e) {//checking errors
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        mainMenu(hotel,people, queueforStrings,queueforNumbers);//redirect to the main menu
    }
    public static void findCustomerFromName(Room[] hotel, Person[] people, QueueforStrings[] queueforStrings,QueueforNumbers[] queueforNumbers) {
        Scanner input = new Scanner(System.in);
        System.out.println("------Find Customer------");
        while(true) {
            System.out.print("\nEnter the customer name: ");
            String name = input.nextLine();//name user want to find
            int count = 0;//to count rooms found
            for (int x = 0; x < 8; x++) {//checking through all rooms
                if (name.equals(hotel[x].getname())) {//check name got a room
                    System.out.println(name + " got room number " + (x + 1));
                    System.out.println("First Name: " + people[x].getFname() + " Surname: " + people[x].getSname());
                    System.out.println("Number of guests: " + people[x].getNumOfGuests() + " Credit Card NUmber: " + people[x].getCreaditCardNum());
                    count += 1;//increase the number of counts by 1
                }
            }
            if (count == 0) {//if didn't find it says no rooms got
                System.out.println("No rooms for " + name + ".");
            }

            System.out.print("Do you want to quit(y/n): ");// quiting and repeating option
            String command = input.nextLine();
            if (command.equals("y")||command.equals("Y")) {
                mainMenu(hotel, people, queueforStrings, queueforNumbers);
                break;
            }
        }
    }
    public static void deleteCustomer(Room[] hotel, Person[] people, QueueforStrings[] queueforStrings,QueueforNumbers[] queueforNumbers) {
        System.out.println("\n-------Delete a customer--------");// this method to delete customer from rooms
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println();
            System.out.print("Enter room number you want to delete: ");
            int roomNum = checkingRoomNumberInt();//get a value input with validate
            while(roomNum>8||roomNum<1){
                System.out.println("Enter a correct room number(1-8)..");
                System.out.print("Enter room number you want to delete: ");
                roomNum = checkingRoomNumberInt();//get a value input with validate
            }


            System.out.println("Deleted " + hotel[roomNum - 1].getname() + " from room number " + roomNum);
            hotel[roomNum - 1].setname("empty");// assign empty when it is deleted
            people[roomNum - 1].setNumOfGuests(0);//assining 0 to deleted item is an integer
            people[roomNum - 1].setSname("empty");
            people[roomNum - 1].setFname("empty");
            people[roomNum - 1].setCreaditCardNum(0);

            if(!queueforStrings[0].isEmpty()) {//if the waiting list is not empty
                hotel[roomNum - 1].setname(queueforStrings[0].getElementByQueue());//pass the values to the variables by the queue --name
                people[roomNum - 1].setFname(queueforStrings[1].getElementByQueue());//first name
                people[roomNum - 1].setSname(queueforStrings[2].getElementByQueue());// surname

                people[roomNum - 1].setNumOfGuests(queueforNumbers[0].getElementByQueue());// pass the number of guests to the variables
                people[roomNum - 1].setCreaditCardNum(queueforNumbers[1].getElementByQueue());//pass the credit card number
                System.out.println(hotel[roomNum - 1].getname() + " added to the room " + roomNum + " from the waiting list..");//showig adding waiting list(alerting)
            }else{
                System.out.println("No waiting customer in the queue..");
            }


            //input.nextLine();
            System.out.print("Do you want quit(y/n):");//repeating option
            String command = input.nextLine();
            if (command.equals("y")||command.equals("Y")) {
                mainMenu(hotel, people, queueforStrings, queueforNumbers);
                break;
            }
        }

    }

    public static void displayEmptyRooms(Room[] hotel, Person[] people, QueueforStrings[] queueforStrings,QueueforNumbers[] queueforNumbers) {
        System.out.println("----------Display Empty Rooms---------");// this methods to show empty rooms
        int count=0;//to count empty rooms
        for (int x = 0; x < 8; x++) {
            if (hotel[x].getname().equals("empty")) {//check name is equal to empty
                System.out.println("room " + (x + 1) + " is empty");
                count+=1;
            }
        }
        if (count==0){//run when no empty rooms
            System.out.println("No empty rooms..");
        }
        mainMenu(hotel,people, queueforStrings,queueforNumbers);// redirect to the main menu

    }
    public static void view(Room[] hotel, Person[] people, QueueforStrings[] queueforStrings,QueueforNumbers[] queueforNumbers) {
        System.out.println("\n-------View Rooms------\n");
        for (int x = 0; x < 8; x++) {
            System.out.println("Room " + (x + 1) + " is occupied by " + hotel[x].getname());//room number=index+1
            System.out.println("First Name: "+people[x].getFname()+" Surname: "+people[x].getSname());
            System.out.println("Number of Guests: "+people[x].getNumOfGuests()+" Credit Card Number: "+people[x].getCreaditCardNum());
            System.out.println("--------------------------------------------------------");
        }
        mainMenu(hotel,people, queueforStrings,queueforNumbers);//redirect to the main menu
    }



    public static void addCustomer(Room[] hotel, Person[] people, QueueforStrings[] queueforStrings,QueueforNumbers[] queueforNumbers) {
        System.out.println("\n--------Add a new Customer---------\n");
        Scanner input = new Scanner(System.in);

        int roomNum;//room number
        int numberOfPersons=0;//number of guests
        int personCreaditCardNumber=0;//credit card number
        String roomName,personFname,personSname;//name,firstname,surname
        while(true) {//repeating option
            int count = 0;//to count the how many rooms are empty
            for (int i = 0; i < 8; i++) {
                if (hotel[i].getname().equals("empty")) {//check the number of empty rooms
                    count++;
                }
            }
            if (count == 0) {//if empty rooms are 0 it goes for the queue

                if (!queueforStrings[0].isFull()) {//check the queue also full(if not this runs)

                    System.out.println("Rooms are full.. Adding to the queue..");
                    System.out.print("Enter name : ");
                    roomName = input.nextLine();
                    System.out.print("Enter first name for room : ");
                    personFname = input.nextLine();
                    System.out.print("Enter Surname for room : ");
                    personSname = input.nextLine();
                    try {// check the user input are correct
                        System.out.print("Enter number of guests : ");
                        numberOfPersons = input.nextInt();
                        System.out.print("Enter credit card number : ");
                        personCreaditCardNumber = input.nextInt();
                    }catch (Exception e){//otherwise program goes to the run again
                        System.out.println("Enter valid inputs next time..");
                        addCustomer(hotel, people, queueforStrings, queueforNumbers);// get a recursion
                    }
                    input.nextLine();// to make scanner getting strings
                    queueforStrings[0].sendElementToQueue(roomName);// adding items to deleted by the queue
                    queueforStrings[1].sendElementToQueue(personFname);//first name
                    queueforStrings[2].sendElementToQueue(personSname);//surname
                    queueforNumbers[0].sendElementToQueue(numberOfPersons);//number of guests in the room
                    queueforNumbers[1].sendElementToQueue(personCreaditCardNumber);// credit card number
                    System.out.println("Added "+roomName+" to the queue");//alerting
                }else{
                    System.out.println("Sorry queue also full..");//alert when queue is full
                }

            } else {
                while (true) {//checking the room number in range of 0<num<9
                    System.out.print("Enter the room number: ");
                    roomNum = checkingRoomNumberInt();// getting room numbers// validating the input is an integer or not
                    if (roomNum > 0 && roomNum < 9) {
                        break;
                    } else {
                        System.out.println("Enter a correct room number(1-8)..");
                    }
                }
                if (hotel[roomNum-1].getname().equals("empty")){//check the given room number is empty or not

                    System.out.print("Enter name for room " + roomNum + " : ");// getting name for customer
                    //input.nextLine();// to make scanner getting strings
                    roomName = input.nextLine();
                    System.out.print("Enter first name for room " + roomNum + " : ");
                    personFname = input.nextLine();
                    System.out.print("Enter surname for room " + roomNum + " : ");
                    personSname = input.nextLine();

                    try {//handled inputs if wrong input it automatically goes to main menu
                        System.out.print("Enter number of guests for room " + roomNum + " : ");
                        numberOfPersons = input.nextInt();
                        System.out.print("Enter credit card number for room " + roomNum + " : ");
                        personCreaditCardNumber = input.nextInt();

                    } catch (Exception e) {//if a error got this will occur
                        System.out.println("Enter valid inputs next time..");
                        addCustomer(hotel, people, queueforStrings, queueforNumbers);//recursion
                    }

                    hotel[roomNum - 1].setname(roomName);// sending values for room object
                    people[roomNum - 1].setFname(personFname);//sending values for person object
                    people[roomNum - 1].setSname(personSname);//surname pass to object
                    people[roomNum - 1].setNumOfGuests(numberOfPersons);//number of guests
                    people[roomNum - 1].setCreaditCardNum(personCreaditCardNumber);//credit card number
                    input.nextLine();// to make scanner getting strings

                }else{//if the given room number is not empty
                    System.out.println("Customer is already in room number "+roomNum);
                }
            }


            System.out.print("Do you want to quit(y/n): ");// quiting and repeating option
            String command = input.nextLine();
            if (command.equals("y")||command.equals("Y")) {
                mainMenu(hotel, people, queueforStrings, queueforNumbers);//redirect to the main menu
                break;
            }else{
                System.out.println();
            }
        }
    }
    public static int checkingRoomNumberInt(){//for get valid number for room number
        Scanner input=new Scanner(System.in);

        try {
            return input.nextInt();// return the value input

        } catch (Exception e) {
            System.out.println("It's not a number.");
        }

        return 0;

    }


    public static void mainMenu(Room[] hotel, Person[] people, QueueforStrings[] queueforStrings,QueueforNumbers[] queueforNumbers) {
        Scanner input = new Scanner(System.in);// the main menu of the program that control all things
        System.out.println("\n-----------------------------------------------");
        System.out.println("|                 Main Menu                   |");
        System.out.println("-----------------------------------------------");
        System.out.println("| Enter 'A' for Add a new customer            |");
        System.out.println("| Enter 'V' for view rooms                    |");
        System.out.println("| Enter 'E' for display empty rooms           |");
        System.out.println("| Enter 'D' for delete a customer             |");
        System.out.println("| Enter 'F' for find room from customer name  |");
        System.out.println("| Enter 'S' for store program data into a file|");
        System.out.println("| Enter 'L' for load program data from file   |");
        System.out.println("| Enter 'O' for view guest in alphabetic order|");
        System.out.println("-----------------------------------------------");
        System.out.print("Enter options(A/V/E/D/F/S/L/O): ");
        String command = input.nextLine();
        command=command.toUpperCase();// to make sense for any case
        if (command.equals("V")) {//comparing elements
            view(hotel,people, queueforStrings,queueforNumbers);
        } else if (command.equals("A")) {
            addCustomer(hotel,people, queueforStrings,queueforNumbers);
        } else if (command.equals("E")) {
            displayEmptyRooms(hotel,people, queueforStrings,queueforNumbers);
        } else if (command.equals("D")) {
            deleteCustomer(hotel,people, queueforStrings,queueforNumbers);
        } else if (command.equals("F")) {
            findCustomerFromName(hotel,people, queueforStrings,queueforNumbers);
        } else if (command.equals("S")) {
            storeData(hotel,people, queueforStrings,queueforNumbers);
        } else if (command.equals("L")) {
            loadData(hotel,people, queueforStrings,queueforNumbers);
        } else if (command.equals("O")) {
            sortNames(hotel,people, queueforStrings,queueforNumbers);
        }else{
            System.out.println("Enter a correct option..");//if given input not valid alert this and again call the main menu
            mainMenu(hotel,people, queueforStrings,queueforNumbers);
        }
    }

}
