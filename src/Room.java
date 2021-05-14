public class Room {
    private int room_num;//room number
    private String name="empty";//owner


    Room(){

    }
    Room(int room_num,String name){
        this.room_num=room_num;
        this.name=name;
    }
    //setters
    public void setroom_num(int room_num){

        this.room_num=room_num;
    }
    public void setname(String name){

        this.name=name;
    }
    //getters
    public int getroom_num(){

        return room_num;
    }
    public String getname(){
        return name;

    }

}
