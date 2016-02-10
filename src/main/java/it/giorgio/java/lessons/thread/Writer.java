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

import java.security.SecureRandom;

/**
 * This class represents the 'producer' object that is in concurrency with 'consumer' objects.
 * Writer object add objects inside storage queue.
 * 
 * In this scenario consumers ares reader object instances, producers are the writer object
 * instances.
 * 
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class Writer implements Runnable {

  private StatusEnum state = StatusEnum.SLEEP;

  private Storage storage = Storage.getInstance();

  private String name = null;

  private boolean running = false;

  /**
   * Instantiates a new writer.
   *
   * @param name the name of writer
   */
  public Writer(String name) {
    this.name = name;

    running = true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {

    state = StatusEnum.RUNNING;

    System.out.println(name + ". START");

    SecureRandom sr = new SecureRandom();
    int min = 1;
    int max = 100000;

    // loop until controller / manager of thread say to stop !
    while (running) {

      // 2nd check
      while (!storage.isQueueFull()) {

        state = StatusEnum.RUNNING;

        // create object
        Object obj = "Book " + (sr.nextInt(max) - min);

        // add object
        storage.add(obj);

        System.out.println(name + ". Add Book: " + obj.toString());
      }

      // go in wait
      waitWriter();
    }

    // put state in sleep
    state = StatusEnum.SLEEP;

    System.out.println(name + ". END");
  }

  /**
   * Send Writer instance in wait status
   */
  public void waitWriter() {
    state = StatusEnum.WAIT;

    try {
      System.out.println(name + ". SLEEP");
      Thread.sleep(Storage.SLEEP_TIME);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public StatusEnum getState() {
    return state;
  }

  public String getName() {
    return name;
  }


}
