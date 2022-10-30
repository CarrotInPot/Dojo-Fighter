package game.logic;

public class Room {
    //private variables
    private int roomNo;
    private String desc;
    
    //constructor 
    public Room(int roomNumber, String roomDesc){
        setRoomNo(roomNumber);
        setDesc(roomDesc);
    }
     
    //getter and setters 
    public int getRoomNo() {
        return this.roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
