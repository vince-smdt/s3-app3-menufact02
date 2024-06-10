package Commandes;

import plats.PlatChoisi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<Chef>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, Chef listener) {
        List<Chef> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, Chef listener) {
        List<Chef> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, PlatChoisi plat) {
        List<Chef> users = listeners.get(eventType);
        for (Chef listener : users) {
            listener.update(eventType, plat);
        }
    }
}
