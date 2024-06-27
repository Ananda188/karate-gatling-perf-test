package PerformanceLoadTests


import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._

class KarateGatlingTest extends Simulation {
  val protocol = karateProtocol(

    //Member Registrations
    "api/register" -> Nil,
    //Login
    "api/login" -> Nil,
    //Create User
    "api/users" -> Nil,
    //Update/delete/list single user
    "api/users/{userId}" -> Nil,
    //List multiple users
    "api/users" -> Nil
)
 //Get transaction names
  protocol.nameResolver = (req, ctx) => req.getHeader("gatling-txn-name")

  //Define scenarios
  //Member Registration
  val post_registration = scenario("Successful Member Registration").repeat(1){exec(karateFeature("src/test/karate/features/POST_Register.feature")).pause(30, 33)}
 //demo login
  val post_login = scenario("Successful Login").repeat(1){exec(karateFeature("src/test/karate/features/POST_Login.feature")).pause(30,33)}

  val post_createUser = scenario("Successfully create user").repeat(1){exec(karateFeature("src/test/karate/features/POST_CreateUser.feature")).pause(22, 27)}
  val put_updateUser = scenario("Successfully update user details").repeat(1){exec(karateFeature("src/test/karate/features/PUT_UpdateUser.feature")).pause(22,27)}
  val delete_User = scenario("Successfully delete user").repeat(1){exec(karateFeature("src/test/karate/features/DELETE_User.feature")).pause(22,27)}
  val get_viewMultipleUsers = scenario("View multiple user details").repeat(1){exec(karateFeature("src/test/karate/features/GET_MultipleUsers.feature")).pause(52,65)}
  val get_viewSingleUser = scenario("View single user details").repeat(1){exec(karateFeature("src/test/karate/features/GET_User.feature")).pause(28,37)}


  //Load Test
  setUp(
    post_registration.inject(rampConcurrentUsers(0).to(2).during(60),
    constantConcurrentUsers(2).during(120)),
    post_login.inject(rampConcurrentUsers(0).to(2).during(60),
      constantConcurrentUsers(2).during(120)),
    // demo login
    post_createUser.inject(rampConcurrentUsers(0).to(2).during(120),
    constantConcurrentUsers(5).during(120)),

    put_updateUser.inject(rampConcurrentUsers(0).to(2).during(120),
    constantConcurrentUsers(5).during(120)),

    delete_User.inject(rampConcurrentUsers(0).to(2).during(120),
    constantConcurrentUsers(5).during(120)),

    get_viewMultipleUsers.inject(rampConcurrentUsers(0).to(5).during(180),
    constantConcurrentUsers(10).during(120)),

    get_viewSingleUser.inject(rampConcurrentUsers(0).to(5).during(180),
    constantConcurrentUsers(10).during(120))

  ).protocols(protocol)

}