/*
 * Copyright 2015 Ayuget
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ayuget.redface.ui.event;

import android.support.annotation.Nullable;

import com.ayuget.redface.data.api.model.Topic;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PageSelectedEvent {
    public abstract Topic topic();
    public abstract int page();
    @Nullable public abstract OverriddenPagePosition overriddenPagePosition();

    public static PageSelectedEvent create(Topic topic, int page, OverriddenPagePosition overriddenPagePosition) {
        return new AutoValue_PageSelectedEvent(topic, page, overriddenPagePosition);
    }
}
