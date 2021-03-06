/**
 * Copyright 2016 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.gs.dmn.maven.configuration;

import org.codehaus.plexus.classworlds.realm.ClassRealm;
import org.codehaus.plexus.component.configurator.BasicComponentConfigurator;
import org.codehaus.plexus.component.configurator.ComponentConfigurationException;
import org.codehaus.plexus.component.configurator.ConfigurationListener;
import org.codehaus.plexus.component.configurator.expression.ExpressionEvaluator;
import org.codehaus.plexus.configuration.PlexusConfiguration;

public class DMNMojoComponentConfigurator extends BasicComponentConfigurator {

    @Override
    public void configureComponent(final Object component, final PlexusConfiguration configuration,
                                   final ExpressionEvaluator evaluator, final ClassRealm realm,
                                   final ConfigurationListener listener) throws ComponentConfigurationException {

        // Register custom type conversion for optionally-configurable types, i.e. those which can be specified as a
        // simple string or as a components with a name and configuration
        converterLookup.registerConverter(new OptionallyConfigurableComponentConverter());

        super.configureComponent(component, configuration, evaluator, realm, listener);
    }

}
