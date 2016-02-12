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
package it.giorgio.java.lessons.test.array;

import org.junit.Assert;
import org.junit.Test;

import it.giorgio.java.lessons.arrays.Example01;

/**
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class TestExample01 {

  @Test
  public void testDuplicat() {

    int[] array2 = {12, 9, 12, 9};

    // with list
    int duplicate = new Example01().findDuplicateWithList(array2);
    Assert.assertFalse(duplicate == 9);

    // with set
    duplicate = new Example01().findDuplicateWithList(array2);
    Assert.assertTrue(duplicate == 12);


    int[] array = {12, 20, 3, 4, 5, 4, 8};

    // with list
    duplicate = new Example01().findDuplicateWithList(array);
    Assert.assertTrue(duplicate == 4);

    // with set
    duplicate = new Example01().findDuplicateWithList(array);
    Assert.assertTrue(duplicate == 4);
  }

}
