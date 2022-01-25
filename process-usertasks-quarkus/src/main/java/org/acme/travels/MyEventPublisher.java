/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.acme.travels;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import org.jbpm.process.instance.impl.humantask.BaseHumanTaskLifeCycle;
import org.kie.kogito.event.DataEvent;
import org.kie.kogito.event.EventPublisher;
import org.kie.kogito.event.impl.CloudEventConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class MyEventPublisher implements EventPublisher {
    private static final Logger logger = LoggerFactory.getLogger(MyEventPublisher.class);

    @Override
    public void publish(DataEvent<?> event) {
        logger.info(event.getSubject());
    }

    @Override
    public void publish(Collection<DataEvent<?>> events) {
        events.forEach(e -> {
            logger.info(e.getSubject());
        });
    }
}
