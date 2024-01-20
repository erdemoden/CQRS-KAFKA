package org.erdem.cqrs.Enums;

import org.erdem.cqrs.Components.CommandEventsFactory;
import org.erdem.cqrs.Components.ICommandEvents;

public enum EventTypes {
    CREATE("Create","createCommandEvent");

    String eventType;
    String commandEvents;

    EventTypes(String eventType,String commandEvents){
        this.commandEvents = commandEvents;
        this.eventType = eventType;
    }

    public static ICommandEvents getCommandEvent(String type,CommandEventsFactory commandEventsFactory){

        for (EventTypes eventTypes : EventTypes.values()){
            if(eventTypes.eventType.equals(type)){
                return commandEventsFactory.getCommandEvents(eventTypes.commandEvents);
            }
        }
        return null;
    }


}
