package com.crio.xlido.Repository;

import java.util.*;
import com.crio.xlido.entities.Event;

public interface IEventRepository {
    Event save(Event event);
    Event delete(Long id);
    Optional<Event> findById(Long id);
}
