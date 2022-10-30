package game.logic;

public class Room {
    private int roomNo;
    private String desc;
    
    public Room(int roomNumber, String roomDesc){
        setRoomNo(roomNumber);
        setDesc(roomDesc);
    }

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
