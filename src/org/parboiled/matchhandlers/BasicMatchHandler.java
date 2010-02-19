/*
 * Copyright (C) 2009-2010 Mathias Doenitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.parboiled.matchhandlers;

import org.parboiled.MatcherContext;
import org.parboiled.MatchHandler;
import org.jetbrains.annotations.NotNull;
import com.google.common.base.Supplier;

/**
 * The most trivial implementation of the {@link MatchHandler} interface.
 * It does not report any parse errors nor recover from them. Therefore it never causes the parser to perform more
 * than one parsing run and is the faster way to determine whether a given input conforms to the rule grammar.
 *
 * @param <V>
 */
public class BasicMatchHandler<V> implements MatchHandler<V> {

    public boolean matchRoot(@NotNull Supplier<MatcherContext<V>> rootContextSupplier) {
        return rootContextSupplier.get().runMatcher();
    }

    public boolean match(MatcherContext<V> context) throws Throwable {
        return context.getMatcher().match(context);
    }

}
