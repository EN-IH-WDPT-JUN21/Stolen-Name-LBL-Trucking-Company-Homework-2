//Holds and increments the Unique ID for all created objects

abstract class ClientInformation {


    static Integer uniqueID = 0;
    protected String id;

    public Integer generateID() {
        uniqueID++;
        return uniqueID;
    }

    public ClientInformation() {
        id = generateID().toString();
    }

}
