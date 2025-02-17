/*
 * MIT License
 *
 * Copyright (c) 2020 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.shady1997.credit.commons;

import com.shady1997.credit.config.ConfigurationManager;
import com.shady1997.credit.data.changeless.SimulationData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.text.MessageFormat.format;

public class MessageFormat {

    private static final Logger log = LogManager.getLogger(MessageFormat.class);

    private MessageFormat() {}
    /*
     * This method was created to remove the post if is a test environment because the 443 port must be informed
     * to make the requests, but should not be show in the URL
     */
    public static String locationURLByEnvironment() {
        String locationURL;
        var configuration = ConfigurationManager.getConfiguration();

        locationURL = configuration.port() < 8000
                ? format("{0}{1}{2}", configuration.baseURI(), configuration.basePath(), SimulationData.SERVICE)
                : format("{0}:{1}{2}{3}", configuration.baseURI(), String.valueOf(configuration.port()), configuration.basePath(), SimulationData.SERVICE);

        log.debug(locationURL);
        return locationURL;
    }
}
