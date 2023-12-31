package my.playground
package fpinscala.datastructures

import fpinscala.datastructures.List.*
import org.scalatest.funsuite.AnyFunSuite

class ListSpec extends AnyFunSuite:
  test(testName = "List should handle it's construction") {
    val emptyList  = Nil
    val stringList = Cons("Hello", Cons("World", Cons("!", Nil)))
    val intList    = List(1, 2, 3)

    assert(stringList == List("Hello", "World", "!"))
    assert(intList == Cons(1, Cons(2, Cons(3, Nil))))
  }

  test(testName = "List should calculate the sum when data is empty") {
    val sumOfEmptyList = sum(Nil)
    assert(sumOfEmptyList == 0)
  }

  test(testName = "List should calculate the sum data is not empty") {
    val sumOfInts = sum(List(34, 90, 45))
    assert(sumOfInts == 169)
  }

  test(testName = "List should calculate the product when data is empty") {
    val productOfEmptyList = product(Nil)
    assert(productOfEmptyList == 1.0)
  }

  test(testName = "List should calculate the sum when data contains 0") {
    val productOfInts = product(List(34, 0, 45))
    assert(productOfInts == 0.0)
  }

  test(testName = "List should calculate the sum when data doesn't contain 0") {
    val productOfInts = product(List(5, 10, 3))
    assert(productOfInts == 150)
  }

  test("tail: should throw error when the list is empty") {
    assertThrows[RuntimeException](tail(Nil))
  }

  test("tail: should return tail when the list is not empty") {
    val tailOfList = tail(List(1, 2, 3, 4))
    assert(tailOfList == List(2, 3, 4))
  }

  test("setHead: should return empty when the list is empty") {
    val newList = setHead(Nil, 10)
    assert(newList == Nil)
  }

  test("setHead: should set head when the list is nonempty") {
    val newList = setHead(List(1, 2, 3), 10)
    assert(newList == List(10, 2, 3))
  }

  test("drop: should remove n elements from the list") {
    val xs = List(1, 2, 3, 4, 5, 6)
    assert(drop(xs, 3) == List(4, 5, 6))
  }

  test("drop: should return empty when removing more elements from the list") {
    val xs = List(1, 2, 3)
    assert(drop(xs, 5) == Nil)
  }

  test("dropWhile: should remove elements from the list unless condition is not met") {
    val xs       = List(2, 4, 6, 7, 8)
    val remained = dropWhile(xs, x => x % 2 == 0)
    assert(remained == List(7, 8))
  }

  test("dropWhile: should return empty when all elements are removed") {
    val xs       = List(10, 25, 38, 19)
    val remained = dropWhile(xs, x => x >= 10)
    assert(remained == Nil)
  }

  test("append: should return the first list when the second list is empty") {
    val result = append(List("A", "B"), Nil)
    assert(result == List("A", "B"))
  }

  test("append: should return the second list when the first list is empty") {
    val result = append(Nil, List("A", "B"))
    assert(result == List("A", "B"))
  }

  test("append: should append when two lists are nonempty") {
    val result = append(List("A", "B"), List("X", "Y"))
    assert(result == List("A", "B", "X", "Y"))
  }

  test("init: return all but the last element") {
    val result = init(List(1, 3, 5, 7, 9))
    assert(result == List(1, 3, 5, 7))
  }

  test("init: return empty when only one element in the list") {
    val result = init(List(2))
    assert(result == Nil)
  }

  test("init: return empty when only the list is empty") {
    val result = init(Nil)
    assert(result == Nil)
  }

  test(testName = "sumViaFoldRight: should calculate the sum data is not empty") {
    val sumOfInts = sumViaFoldRight(List(34, 90, 45))
    assert(sumOfInts == 169)
  }

  test(testName = "productViaFoldRight: should calculate the sum when data doesn't contain 0") {
    val productOfInts = productViaFoldRight(List(5, 10, 3))
    assert(productOfInts == 150)
  }

  test("foldRight: pass Nil and Cons as parameters") {
    val result = foldRight(List(1, 2, 3), Nil: List[Int], Cons(_, _))
    assert(result == Cons(1, Cons(2, Cons(3, Nil))))
  }

  test("len: return the length of the list") {
    val len = length(List(1, 3, 5, 7, 9))
    assert(len == 5)
  }

  test("len: return 0 when list is empty") {
    val len = length(Nil)
    assert(len == 0)
  }

end ListSpec
