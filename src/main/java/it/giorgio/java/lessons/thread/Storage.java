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

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class Storage {

  /**
   * Sleep time in milliseconds.
   */
  public static final long SLEEP_TIME = 5500;

  /**
   * Capacity of storage
   */
  public static final int CAPACITY = 100;

  /**
   * Mutex
   */
  private static final Object MUTEX = new Object();

  /**
   * Instance for singleton
   */
  private static Storage instance = null;

  /**
   * The queue
   */
  private final Queue<Object> queue = new LinkedList<>();

  /**
   * Private constructor
   */
  private Storage() {}

  /**
   * Gets the single instance of MainBase.
   *
   * @return single instance of MainBase
   */
  public static Storage getInstance() {

    // instead of sinchronization: use TEST-TEST-and-SET procedure
    if (instance == null) {
      synchronized (MUTEX) {
        if (instance == null) {
          instance = new Storage();
        }
      }
    }

    return instance;
  }

  /**
   * Checks if queue is full.
   *
   * @return true, if queue is full
   */
  public boolean isQueueFull() {
    return (queue.size() == CAPACITY);
  }

  /**
   * Checks if queue is empty.
   *
   * @return true, if queue is empty
   */
  public boolean isQueueEmpty() {
    return queue.isEmpty();
  }

  /**
   * Push element in the tail of the queue.
   *
   * @param element the element
   */
  public void add(Object element) {

    // synch on queue
    synchronized (queue) {

      // no check about insert
      queue.add(element);
    }
  }

  /**
   * Pull the element from head of queue.
   *
   * @return the first element of queue
   */
  public Object remove() {

    Object element = null;

    // synch on queue
    synchronized (queue) {
      element = queue.remove();
    }

    return element;
  }

}
