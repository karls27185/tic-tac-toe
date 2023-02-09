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

package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;

/**
 * @author Karl
 * @link https://babayan.keenetic.link/
 */
public class DataPrinterImpl {

    private final CellNumberConverter cellNumberConverter;

    public DataPrinterImpl(final CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    public void printMappingTable() {
        /*System.out.println("-------------");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("-------------");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("-------------");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("-------------");*/
//        for (int i = 0; i < 3; i++) {
//            System.out.println("-------------");
//            for (int j = 0; j < 3; j++) {
//                System.out.print("| " + cellNumberConverter.toNumber(new Cell(i, j)) + " ");
//            }
//            System.out.println("|");
//        }
//        System.out.println("-------------");

//Лямбда выражение
        print((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));

//Анонимный класс
        /*
        print(new Lambda() {
            @Override
            public String getValue(final int i, final int j) {
                return String.valueOf(cellNumberConverter.toNumber(new Cell(i, j)));
            }
        });
        */
    }

    public void printGameTable(final GameTable gameTable) {
/*        System.out.println("-------------");
        System.out.println("| " +
                gameTable.getSign(new Cell(0, 0)) + " | " +
                gameTable.getSign(new Cell(0, 1)) + " | " +
                gameTable.getSign(new Cell(0, 2)) + " | " );
        System.out.println("-------------");
        System.out.println("| " +
                gameTable.getSign(new Cell(1, 0)) + " | " +
                gameTable.getSign(new Cell(1, 1)) + " | " +
                gameTable.getSign(new Cell(1, 2)) + " | " );
        System.out.println("-------------");
        System.out.println("| " +
                gameTable.getSign(new Cell(2, 0)) + " | " +
                gameTable.getSign(new Cell(2, 1)) + " | " +
                gameTable.getSign(new Cell(2, 2)) + " | " );
        System.out.println("-------------");*/
//        for (int i = 0; i < 3; i++) {
//            System.out.println("-------------");
//            for (int j = 0; j < 3; j++) {
//                System.out.print("| " + gameTable.getSign(new Cell(i, j)) + " ");
//            }
//            System.out.println("|");
//        }
//        System.out.println("-------------");

//Лямбда выражение
        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));

//Анонимный класс
        /*
        print(new Lambda() {
            @Override
            public String getValue(final int i, final int j) {
                return String.valueOf(gameTable.getSign(new Cell(i, j)));
            }
        });
   */
    }

    private void print(final Lambda lambda) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i, j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    @FunctionalInterface
    private interface Lambda {
        String getValue(int i, int j);
    }
}
