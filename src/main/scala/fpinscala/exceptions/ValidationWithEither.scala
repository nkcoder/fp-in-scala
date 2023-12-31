package my.playground
package fpinscala.exceptions

import fpinscala.exceptions.Either.{map2Both, Left, Right}

class ValidationWithEither

case class Name private (value: String)
object Name:
  def apply(name: String): Either[String, Name] =
    if name == "" || name == null then Left("Name is empty")
    else Right(new Name(name))

case class Age private (value: Int)
object Age:
  def apply(age: Int): Either[String, Age] =
    if age < 0 then Left("Age is out of range")
    else Right(new Age(age))

case class Person(name: Name, age: Age)
object Person:
  // only reports the first error encountered
  def make(name: String, age: Int): Either[String, Person] =
    Name(name).map2(Age(age))(Person(_, _))

  // accumulate all errors
  def makeBoth(name: String, age: Int): Either[List[String], Person] =
    map2Both(Name(name), Age(age))(Person(_, _))
