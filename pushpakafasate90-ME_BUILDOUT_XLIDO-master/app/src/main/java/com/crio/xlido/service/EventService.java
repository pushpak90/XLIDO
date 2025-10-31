package com.crio.xlido.service;

import com.crio.xlido.Repository.IEventRepository;
import com.crio.xlido.Repository.IUserRepository;
import com.crio.xlido.entities.Event;

public class EventService implements IEventService{

    private final IEventRepository _IEventRepository;
    private final IUserRepository _IUserRepository;

    public EventService(IEventRepository IEventRepository, IUserRepository userRepository){
        this._IEventRepository = IEventRepository;
        this._IUserRepository = userRepository;
    }

    @Override
    public Event addEvent(String name, Long organizerId) {
        if (organizerId != 1) {
            throw new RuntimeException("User with an id " + organizerId + " does not exist");
        }
        Event event = new Event(null, organizerId, name);    
        return _IEventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long event_id, Long user_id) {
        _IUserRepository.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User with an id " + user_id + " does not exist"));
    
        Event event = _IEventRepository.findById(event_id)
                .orElseThrow(() -> new RuntimeException("Event with an id " + event_id + " does not exist"));
    
        if (!event.getOrganizer_id().equals(user_id)) {
            throw new RuntimeException("User with an id " + user_id + " is not a organizer of Event with an id " + event_id);
        }
    
        _IEventRepository.delete(event_id);
        System.out.println("EVENT_DELETED " + event_id);
    }
    
}
