/*

Fix the code to make it compilable
Write tests */

package karazin.scala.users.group.week3.homework

import java.util.UUID
import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure

import scala.concurrent.ExecutionContext.Implicits.global

import model._


object services:
  
  def getUserProfile(userId: UUID): Future[UserProfile] =
    Future {
      UserProfile(userId)
    }
  
  // Fix the code make it compilable
  def getPosts(userId: UUID): Future[List[Post]] =
    Future {
      Post(userId = userId, postId = UUID.randomUUID()) :: Nil
    }
  
  // Fix the code make it compilable
  def getComments(postId: UUID): Future[List[Comment]] = 
    Future {
      // Emulating time consumed operation
      Thread.sleep(5000)
      Comment(userId = UUID.randomUUID(), postId = postId) :: Nil
    }
  
  def getLikes(postId: UUID): Future[List[Like]] = 
    Future {
      // Emulating time consumed operation
      Thread.sleep(2000)
      Like(userId = UUID.randomUUID(), postId = postId) :: Nil
    }
  
  def getShares(postId: UUID): Future[List[Share]] = 
    Future {
      // Emulating time consumed operation
      Thread.sleep(500)
      Share(userId = UUID.randomUUID(), postId = postId) :: Nil
    }