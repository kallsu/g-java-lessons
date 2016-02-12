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
package it.giorgio.java.lessons.concurrency1;

/**
 * This class represents the 'consumer' object that is in concurrency with 'producer' objects.
 * Reader object reads the object inside storage queue and remove them from queue.
 * 
 * In this scenario consumers ares reader object instances, producers are the writer object
 * instances.
 * 
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class Reader implements Runnable {

  private StatusEnum state = StatusEnum.SLEEP;

  private Storage storage = Storage.getInstance();

  private String name = null;

  private boolean running = false;

  /**
   * Instantiates a new reader.
   *
   * @param name the name of reader
   */
  public Reader(String name) {
    this.name = name;

    // go baby go !
    running = true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    // put state in run
    state = StatusEnum.RUNNING;

    System.out.println(name + ". START");

    // loop until controller / manager of thread say to stop !
    while (running) {

      // 2nd check
      while (!storage.isQueueEmpty()) {

        state = StatusEnum.RUNNING;

        // remove object
        Object obj = storage.remove();

        // use object
        System.out.println(name + ". Read book: " + obj.toString());
      }

      // go in wait
      waitReader();
    }

    state = StatusEnum.SLEEP;

    System.out.println(name + ". END");
  }

  /**
   * Send Writer instance in wait status
   */
  public void waitReader() {

    try {
      state = StatusEnum.WAIT;
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

  public boolean isRunning() {
    return running;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }

}
