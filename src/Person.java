public class Person {
    private int numOfGuests=0;//number of guests
    private String fname="empty";//first name
    private String sname="empty";//surname
    private int creaditCardNum=0;//credit number

    Person(){

    }
    Person(int numOfGuests,String fname,String sname,int creaditCardNum){
        this.numOfGuests=numOfGuests;
        this.fname=fname;
        this.sname=sname;
        this.creaditCardNum=creaditCardNum;
    }
    //setters
    public void setNumOfGuests(int numOfGuests){

        this.numOfGuests=numOfGuests;
    }
    public void setFname(String fname){

        this.fname=fname;
    }
    public void setSname(String sname){

        this.sname=sname;
    }
    public void setCreaditCardNum(int creaditCardNum){

        this.creaditCardNum=creaditCardNum;
    }
    //getters
    public int getNumOfGuests(){
        return numOfGuests;
    }
    public String getFname(){
        return fname;
    }
    public String getSname(){
        return sname;
    }
    public int getCreaditCardNum(){
        return creaditCardNum;
    }

}
