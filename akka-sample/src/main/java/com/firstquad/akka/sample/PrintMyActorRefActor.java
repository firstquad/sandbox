package com.firstquad.akka.sample;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
class PrintMyActorRefActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("printit", p -> {
                    ActorRef secondRef = getContext().actorOf(Props.empty(), "second-actor");
                    System.out.println("Second: " + secondRef);
                })
                .build();
    }
}