/*
 * MIT License
 *
 * Copyright (c) 2024 Shady Ahmed
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
package com.shady1997.credit.e2e;

import com.shady1997.credit.client.RestrictionsClient;
import com.shady1997.credit.client.SimulationsClient;
import com.shady1997.credit.data.changeless.TestSuiteTags;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;

class FullSimulationE2ETest {

    private final RestrictionsClient restrictionsClient = new RestrictionsClient();
    private final SimulationsClient simulationsClient = new SimulationsClient();

    @Test
    @Tag(TestSuiteTags.E2E)
    @DisplayName("Should submit a successful simulation for a non-restricted CPF")
    void completeSimulation() {
        var notFound = restrictionsClient.queryRestrictionAndReturnNotFound();
        assertThat(notFound.getStatusCode()).isEqualTo(SC_NOT_FOUND);

        var successfulSimulation = simulationsClient.submitSuccessfulSimulation();
        assertThat(successfulSimulation.getHeader("Location")).isNotEmpty();
    }
}
