package org.apache.maven.surefire.testng.conf;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.maven.surefire.testset.TestSetFailedException;

/**
 * TestNG 6.5.2 configurator. Changed objectFactory type to String
 *
 * @author <a href='mailto:marvin[at]marvinformatics[dot]com'>Marvin Froeder</a>
 * @since 2.13
 */
public class TestNG652Configurator
    extends TestNGMapConfigurator
{

    Map getConvertedOptions( Map options )
        throws TestSetFailedException
    {
        Map convertedOptions = super.getConvertedOptions( options );
        for ( Iterator iterator = convertedOptions.entrySet().iterator(); iterator.hasNext(); )
        {
            Entry entry = (Entry) iterator.next();
            String key = (String) entry.getKey();
            if ( "-objectfactory".equals( key ) )
            {
                Class value = (Class) entry.getValue();
                convertedOptions.put( key, value.getName() );
                break;
            }
        }
        return convertedOptions;
    }
}