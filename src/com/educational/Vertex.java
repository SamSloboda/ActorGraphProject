package com.educational;

public class Vertex {
    private String Name;
    private int ID;
    private boolean isActor;

    public Vertex(String name, int id, boolean actor){
        this.Name=name;
        this.ID=id;
        this.isActor = actor;
    }

    public String getName(){
        return this.Name;
    }
    public void setName(String name){
        this.Name = name;
    }
    public int getID(){
        return this.ID;
    }

    public void setID(int id) {
        this.ID = id;
    }
    public boolean getIsActor() {
        return isActor;
    }
    public void setActor(boolean actor) {
        isActor = actor;
    }


}
