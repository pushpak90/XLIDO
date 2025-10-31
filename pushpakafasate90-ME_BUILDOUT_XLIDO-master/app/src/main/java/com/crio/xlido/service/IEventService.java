package com.crio.xlido.service;

import com.crio.xlido.entities.Event;

public interface IEventService {
    Event addEvent(String name, Long organizerId);
    void deleteEvent(Long event_id, Long user_id);
}
