package org.wit.petMinder.console.controllers

import mu.KotlinLogging
import org.wit.petMinder.console.models.FeedJSONStore
import org.wit.petMinder.console.models.FeedModel
import org.wit.petMinder.console.views.FeedView

class FeedController {
    val feeds = FeedJSONStore()
    val feedView = FeedView()
    val logger = KotlinLogging.logger {}

    fun add(){
        var aFeed =FeedModel()
        if(feedView.addFeedData(aFeed)){
            feeds.create(aFeed)
        }else{
            logger.info{"Feed not added"}
        }
    }

    fun list() {
        feedView.listAllFeed(feeds)
    }

    fun update(){
        feedView.listAllFeed(feeds)
        var searchId = feedView.getId()
        val aFeed = search(searchId)

        if(aFeed != null){
            if(feedView.updateFeedData(aFeed)){
                feeds.update(aFeed)
                feedView.showFeeds(aFeed)
                logger.info{"Feed Updated: [ $aFeed ]"}
            }else {
                logger.info { "Pet Not Updated" }
            }
        }else{
            logger.info { "Pet Not Updated..." }
        }
    }

    fun search(){
        val aFeed= search(feedView.getId())!!
        feedView.showFeeds(aFeed)

    }

    fun search(id: Long): FeedModel?{
        val foundFeed = feeds.findOne(id)
        return foundFeed
    }

    fun delete(){
        feedView.listAllFeed(feeds)
        var searchId = feedView.getId()
        val aFeed = search(searchId)

        if(aFeed != null) {
            feeds.deleteOne(aFeed.id)
            println("Feed Deleted...")
            feedView.listAllFeed(feeds)
        }
        else
            println("Feed Not Deleted...")
    }

    fun listByPet(id: Long){
        val foundFeed = feeds.findByPet(id)
        feedView.listByPet(foundFeed)
    }
    fun dummyData(){
        //add later
    }
}