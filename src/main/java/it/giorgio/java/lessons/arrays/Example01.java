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
package it.giorgio.java.lessons.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Example01 show a standard method to find duplicate inside an integer array using
 * {@linkplain java.util.List} and {@linkplain java.util.Set} implementation.
 * 
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class Example01 {


  /**
   * Find 1st element that already exists inside array, using {@linkplain java.util.List}
   * implementation structure.
   *
   * Time complexity of this method is array size O(n), because need to examinate all input array
   * elements.
   * 
   * @param array the array
   * 
   * @return the integer that already exists inside array, otherwise -1 if not exists
   */
  public int findDuplicateWithList(int[] array) {

    int result = -1;

    // create temporary list
    List<Integer> list = new ArrayList<>(0);

    // iterate on array
    for (int i = 0; i < array.length; i++) {

      // create obejct
      Integer tmp = array[i];

      //
      if (list.contains(tmp)) {
        result = array[i];
        break;
      }

      // add to list
      list.add(tmp);
    }

    return result;
  }


  /**
   * Find 1st element that already exists inside array, using {@linkplain java.util.Set}
   * implementation structure.
   * 
   * @param array the array
   * 
   * @return the integer that already exists inside array, otherwise -1 if not exists
   */
  public int findDuplicateWithSet(int[] array) {

    int result = -1;

    // create temporary set
    Set<Integer> set = new HashSet<>(0);

    // iterate on array
    for (int i = 0; i < array.length; i++) {

      // create obejct
      Integer tmp = array[i];

      // add element, if tmp already exists add return false
      if (!set.add(tmp)) {
        result = array[i];
        break;
      }
    }

    return result;
  }
}
