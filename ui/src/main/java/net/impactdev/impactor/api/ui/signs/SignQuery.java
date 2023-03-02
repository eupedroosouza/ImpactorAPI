/*
 * This file is part of Impactor, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2018-2022 NickImpact
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

package net.impactdev.impactor.api.ui.signs;

import net.impactdev.impactor.api.Impactor;
import net.impactdev.impactor.api.platform.players.PlatformPlayer;
import net.impactdev.impactor.api.utility.builders.Builder;
import net.kyori.adventure.text.Component;
import org.spongepowered.math.vector.Vector3i;

import java.util.List;

public interface SignQuery {

    String TEXT_FORMAT = "{\"text\":\"%s\"}";
    int action = 9;

    List<Component> text();

    Vector3i position();

    boolean shouldReopenOnFailure();

    SignSubmission submissionHandler();

    void sendTo(PlatformPlayer player);

    @SuppressWarnings("unchecked")
    static SignQueryBuilder builder() {
        return Impactor.instance().builders().provide(SignQueryBuilder.class);
    }

    interface SignQueryBuilder extends Builder<SignQuery> {

        SignQueryBuilder text(List<Component> text);

        SignQueryBuilder position(Vector3i position);

        SignQueryBuilder reopenOnFailure(boolean state);

        SignQueryBuilder response(SignSubmission response);

    }

}
