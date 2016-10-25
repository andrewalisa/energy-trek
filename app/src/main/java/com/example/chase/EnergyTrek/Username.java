package com.example.chase.EnergyTrek;



public class Username {

    //variables for this class to manage
    int id;
    String name;

    // Empty constructor
    public Username(){

    }
    // constructor
    public Username(int id, String name){
        this.id = id;
        this.name = name;
    }

    // constructor
    public Username(String name){

        this.name = name;
    }

    // getting ID
    public int getID(){

        return this.id;
    }

    // setting id
    public void setID(int id){

        this.id = id;
    }

    // setting name
    public void setName(String name){

        this.name = name;
    }

    public String getName(){

        return name;
    }
    public void Search(){


    }

}
