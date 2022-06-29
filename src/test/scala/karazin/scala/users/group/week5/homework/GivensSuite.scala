package karazin.scala.users.group.week5.homework

import scala.concurrent.Future
import givens._

/*
  Write test for all programs in karazin.scala.users.group.week4.homework.givens

  Make sure that the following cases are tested:
    • json string representation for integers works
    • json string representation for booleans works
    • json string representation for strings works
    • json string representation for lists for integers, booleans and strings works
    • json string representation for maps fails on compile time

  Review:
    • https://www.json.org/json-en.html
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
    • https://scalameta.org/munit/docs/assertions.html#compileerrors
    
  NB: Do not use sync, this homework does not belong async stuff
    
 */
class GivensSuite extends munit.FunSuite :

  test("Int test") {
    assertEquals(EncodeToJsonRepresentation[Int] encode 0, "0")
  }

  test("Bool test") {
    assertEquals(EncodeToJsonRepresentation[Boolean] encode false, "false")
  }

  test("String test") {
    assertEquals(EncodeToJsonRepresentation[String] encode "Egg", "\"Egg\"")
  }

  test("List[Int] test") {
    assertEquals(EncodeToJsonRepresentation[List[Int]] encode 0 :: -2 :: 3 :: Nil, "[0, -2, 3]")
  }

  test("List[String] test") {
    assertEquals(EncodeToJsonRepresentation[List[String]] encode "I" :: "believe" :: "I" :: Nil, "[\"I\", \"believe\", \"I\"]")
  }

  test("List[Boolean] test") {
    assertEquals(EncodeToJsonRepresentation[List[Boolean]] encode false :: true :: false :: Nil, "[false, true, false]")
  }

  test("Json Map") {
    compileErrors(EncodeToJsonRepresentation[Map[String, Int]] encode Map("1" -> 1, "2" -> 2, "3" -> 3))
  }