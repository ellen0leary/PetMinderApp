package org.wit.petMinder.console.models

interface FeedStore {
    fun findAll(): List<FeedModel>
    fun findByPet(petId: Long): List<FeedModel>
    fun findOne(id: Long): FeedModel?
    fun create(feed: FeedModel)
    fun update(feed: FeedModel)
    fun deleteOne(feedID: Long)
    fun deleteByPet(petId: Long)
}