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
package com.shady1997.credit.data.provider;

import com.shady1997.credit.data.factory.SimulationDataFactory;
import com.shady1997.credit.data.changeless.SimulationErrorsData;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SimulationDataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {

        var simulationLessThanMinAmount = SimulationDataFactory.simulationLessThanMinAmount();
        var simulationExceedAmount = SimulationDataFactory.simulationExceedAmount();
        var simulationLessThanMinInstallments = SimulationDataFactory.simulationLessThanMinInstallments();
        var simulationExceedInstallments = SimulationDataFactory.simulationExceedInstallments();
        var simulationWithNotValidEmail = SimulationDataFactory.simulationWithNotValidEmail();
        var simulationWithEmptyName = SimulationDataFactory.simulationWithEmptyName();

        return Stream.of(
                arguments(simulationLessThanMinAmount, SimulationErrorsData.ERRORS_AMOUNT_GREATER.key, SimulationErrorsData.ERRORS_AMOUNT_GREATER.message),
                arguments(simulationExceedAmount, SimulationErrorsData.ERRORS_AMOUNT_LESS.key, SimulationErrorsData.ERRORS_AMOUNT_LESS.message),
                arguments(simulationLessThanMinInstallments, SimulationErrorsData.ERRORS_INSTALLMENTS_GREATER.key, SimulationErrorsData.ERRORS_INSTALLMENTS_GREATER.message),
                arguments(simulationExceedInstallments, SimulationErrorsData.ERRORS_INSTALLMENTS_LESS.key, SimulationErrorsData.ERRORS_INSTALLMENTS_LESS.message),
                arguments(simulationWithNotValidEmail, SimulationErrorsData.ERRORS_EMAIL.key, SimulationErrorsData.ERRORS_EMAIL.message),
                arguments(simulationWithEmptyName, SimulationErrorsData.ERRORS_NAME.key, SimulationErrorsData.ERRORS_NAME.message)
        );
    }
}
