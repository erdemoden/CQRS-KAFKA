package org.erdem.cqrs.Components;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommandEventsFactory {

    private final ApplicationContext applicationContext;

    public CommandEventsFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ICommandEvents getCommandEvents(String beanName) {
        return applicationContext.getBean(beanName, ICommandEvents.class);
    }
}