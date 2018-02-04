package com.exchange.scheduler;

import com.exchange.facade.CantorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Lenovo on 04.02.2018.
 */
@Component
public class ActualizationScheduler {

    @Autowired
    private CantorFacade cantorFacade;

    @Scheduled(fixedRate = 60000L)
    private void actualizeCantor(){
       cantorFacade.actualizeCantor();
    }

    @PostConstruct
    private void openCantor(){
        cantorFacade.openCantor();
    }
}
