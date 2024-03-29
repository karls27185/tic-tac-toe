/*
 * Copyright (c) 2019.
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
 *
 */

package academy.devonline.tictactoe.model.game;

import academy.devonline.tictactoe.component.Move;

/**
 * @author Karl
 * @link <a href="https://babayan.keenetic.link/">https://babayan.keenetic.link</a>
 */
public final class Player {
    private final Sign sing;
    private final Move move;

    public Player(final Sign sing, final Move move) {
        this.sing = sing;
        this.move = move;
    }

    public Sign getSing() {
        return sing;
    }

//    public Move getMove() {
//        return move;
//    }

    public void makeMove(final GameTable gameTable) {
        move.make(gameTable, sing);
    }

    @Override
    public String toString() {
        return "'" + sing + "'";
    }
}
