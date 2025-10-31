package com.crio.xlido.entities;

public class Event {
    private Long id;
    private Long organizer_id;
    private String name;

    public Event(){

    }

    public Event(Long id, Long organizer_id, String name){
        this.id = id;
        this.organizer_id = organizer_id;
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getOrganizer_id(){
        return organizer_id;
    }

    public void setOrganizer_id(Long organizer_id){
        this.organizer_id = organizer_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
