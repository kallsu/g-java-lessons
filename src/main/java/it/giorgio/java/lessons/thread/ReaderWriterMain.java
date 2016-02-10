/**
 * -------------------------------------------------------------------------------------------------
 * 
 * Copyright 2015 - Giorgio Desideri
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * 
 * See the License for the specific language governing permissions and limitations under the
 * License.
 * 
 */
package it.giorgio.java.lessons.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class ReaderWriterMain {

  /*
   * Main method
   */
  public static void main(String[] args) {

    ExecutorService executor = Executors.newWorkStealingPool(10);

    // init writer
    for (int i = 0; i < 5; i++) {
      executor.submit(new Writer("Writer #" + i));
      executor.submit(new Reader("Reader #" + i));
    }

    // write code to handle the stop of threads.

    // wait executor
    while (!executor.isTerminated()) {
      executor.shutdown();
    }

  }

}
