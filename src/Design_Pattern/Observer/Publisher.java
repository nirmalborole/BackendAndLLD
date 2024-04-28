package Design_Pattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<EventHandler> eventHandlers;
    private Publisher(){
        eventHandlers=new ArrayList<>();
    }

    private static Publisher Instance= new Publisher();

    public static Publisher getInstance(){
        return Instance;
    }

    public void register(EventHandler eventHandler){
        eventHandlers.add(eventHandler);
    }

    public void unregister(EventHandler eventHandler){
        eventHandlers.remove(eventHandler);
    }

    public void PlaceOrder(){
        for(EventHandler eventHandler: eventHandlers){
            eventHandler.handle();
        }
    }
}
