package karazin.scala.users.group.week3.homework

import model._
import program._
import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


/*
  Write test for all programs in karazin.scala.users.group.week3.homework.program

  Review:
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
 */

class ProgramSuite extends munit.FunSuite:
  
  test("getPostView test") {
    val postId = UUID.randomUUID()
    val userId = UUID.randomUUID()
    getPostView(Post(userId, postId)) map {postView => assertEquals(postView.post, Post(userId, postId))}
  }
