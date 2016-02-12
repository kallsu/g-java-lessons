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
package it.giorgio.java.lessons.test.concurrency1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

import it.giorgio.java.lessons.concurrency1.Reader;
import it.giorgio.java.lessons.concurrency1.Writer;

/**
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class ReaderWriterTest {

  List<Runnable> threads = null;

  @Before
  public void setUp() {
    threads = new ArrayList<>(0);

    threads.add(new Writer("Writer #" + 1));
    threads.add(new Writer("Writer #" + 2));
    threads.add(new Writer("Writer #" + 3));
    threads.add(new Writer("Writer #" + 4));
    threads.add(new Writer("Writer #" + 5));

    threads.add(new Reader("Reader #" + 1));
    threads.add(new Reader("Reader #" + 2));
    threads.add(new Reader("Reader #" + 3));
    threads.add(new Reader("Reader #" + 4));
    threads.add(new Reader("Reader #" + 5));
  }

  @Test
  public void testRun() {

    ExecutorService executor = Executors.newWorkStealingPool(threads.size());

    // init writer
    for (Runnable t : threads) {
      executor.submit(t);
    }

    // wait a condition and decide to stop all thread
    // if (condition == true) {
    // // stop all thread
    // for (Runnable t : threads) {
    // if (t instanceof Writer) {
    // ((Writer) t).setRunning(false);
    // }
    // else {
    // ((Reader) t).setRunning(false);
    // }
    // }
    // }

    // wait executor
    while (!executor.isTerminated()) {
      executor.shutdown();
    }
  }

}
