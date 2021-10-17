package org.wit.petMinder.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger{}
var lastFeedId = 0L

internal fun getFeedId(): Long{
    return lastFeedId++
}
class FeedMemStore: FeedStore {
    val feeds = ArrayList<FeedModel>()

    override fun findAll(): List<FeedModel>{
        return feeds
    }

    override fun findByPet(petId: Long): List<FeedModel> {
        val list =  ArrayList<FeedModel>()
        for(i in feeds){
            if(i.petId == petId){
                list.add(i)
            }
        }
        return list
    }

    override fun findOne(id: Long): FeedModel? {
        var foundFeed : FeedModel? = feeds.find{p -> p.id == id}
        return foundFeed
    }

    override fun create(feed: FeedModel) {
        feed.id = getFeedId()
        feeds.add(feed)
        logAll()
    }

    override fun update(feed: FeedModel) {
        var foundFeed = findOne(feed.id!!)
        if(foundFeed != null) {
            foundFeed.time = feed.time
            foundFeed.weigth = feed.weigth
        }
    }

    override fun deleteOne(feedId: Long) {
        val foundFeed = findOne(feedId)
        if(foundFeed!= null){
            feeds.remove(foundFeed)
        }
    }

    override fun deleteByPet(petId: Long) {
        for(i in feeds){
            if(i.petId == petId){
                var foundFeed = findOne(i.id!!)
                if(foundFeed!= null){
                    feeds.remove(foundFeed)
                }
            }
        }
    }

    internal fun logAll() {
        feeds.forEach{logger.info("${it}")}
    }
}