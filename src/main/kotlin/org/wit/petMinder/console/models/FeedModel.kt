package org.wit.petMinder.console.models

data class FeedModel (var id: Long,
                      var petId: Long,
                      var time: String="",
                      var weigth: Float=0.0f,
)