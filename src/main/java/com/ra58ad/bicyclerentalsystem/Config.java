package com.ra58ad.bicyclerentalsystem;

public class Config {

    private static String database;
    private static String username;
    private static String password;
    private static Config _instance;

    private Config(){
        
    };
    
    public void setDB(String db){
        database = db;
    }

    public void setUser(String user){
        username = user;
    }

    public void setPass(String pass){
        password = pass;
    }

    public String getDB(){
        return database;
    }

    public String getUser(){
        return username;
    }

    public String getPass(){
        return password;
    }

    public Config getInstance(){
        if (_instance == null){
            _instance = new Config();
            return _instance;
        } else {
            return _instance;
        }
    }
}
