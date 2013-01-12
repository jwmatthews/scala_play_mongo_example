package models

import com.novus.salat._
import com.novus.salat.global._
import com.mongodb.casbah.Imports._


case class Registration(
  username: String,
  password: String,
  confirm: String,
  realName: String
  )

object Registrations {
  val registrations = MongoConnection()("scala_play_mongo_example")("registrations")

  def all = registrations.map(grater[Registration].asObject(_)).toList
  def create(registration: Registration) {
    println("models.Registration.create(" + registration + ") invoked")
    println("grater[Registration].asDBObject("+registration+") = "+ grater[Registration].asDBObject(registration))
    registrations += grater[Registration].asDBObject(registration)

  }

}
