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
package com.gs.dmn.feel.synthesis;

import com.gs.dmn.feel.analysis.FEELAnalyzer;
import com.gs.dmn.feel.analysis.FEELAnalyzerImpl;
import com.gs.dmn.transformation.basic.BasicDMN2JavaTransformer;

public class FEELTranslatorImpl extends AbstractFEELTranslator {
    public FEELTranslatorImpl(FEELAnalyzer feelAnalyzer, FEELToJavaVisitor expressionVisitor, SimpleExpressionsToJavaVisitor simpleExpressionsVisitor) {
        super(feelAnalyzer, expressionVisitor, simpleExpressionsVisitor);
    }

    public FEELTranslatorImpl(BasicDMN2JavaTransformer dmnTransformer) {
        this(new FEELAnalyzerImpl(dmnTransformer), new FEELToJavaVisitor(dmnTransformer), new SimpleExpressionsToJavaVisitor(dmnTransformer));
    }
}
