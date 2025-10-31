package com.crio.xlido.Repository;

import java.util.*;
import com.crio.xlido.entities.Event;

public class EventRepository implements IEventRepository{

    private final Map<Long, Event> eventDB = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public Event save(Event event) {
        if(event.getId() == null){
            event.setId(idCounter++);
        }
        eventDB.put(event.getId(), event);
        return event;
    }

    @Override
    public Event delete(Long id) {
        return eventDB.remove(id);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return Optional.ofNullable(eventDB.get(id));
    }

}
