package karazin.scala.users.group.week3.homework

import model._
import services._

import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/*
  Write test for all service in karazin.scala.users.group.week3.homework.services

  Review:
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
 */

class ServicesSuite extends munit.FunSuite:
  
  test("getUserProfile async test") {
    val userId = UUID.randomUUID()
    Future {
      getUserProfile(userId) map { profile => assertEquals(profile.userId, userId) }
    }
  }

  test("getPosts async test") {
    val userId = UUID.randomUUID()
    Future {
      getPosts(userId) map { posts => posts map { post => assertEquals(post.userId, userId) } }
    }
  }

  test("getComments async test") {
    val postId = UUID.randomUUID()
    Future {
      getComments(postId) map { comments => comments map { comment => assertEquals(comment.postId, postId) } }
    }
  }

  test("getLikes async test") {
    val postId = UUID.randomUUID()
    Future {
      getLikes(postId) map { likes => likes map { like => assertEquals(like.postId, postId) } }
    }
  }

  test("getShares async test") {
    val postId = UUID.randomUUID()
    Future {
      getShares(postId) map { shares => shares map { share => assertEquals(share.postId, postId) } }
    }
  }