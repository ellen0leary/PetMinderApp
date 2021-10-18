package org.wit.petMinder.console.views

import org.wit.petMinder.console.models.FeedJSONStore
import org.wit.petMinder.console.models.FeedMemStore
import org.wit.petMinder.console.models.FeedModel

class FeedView {

    fun listAllFeed(feeds: FeedJSONStore){
        println("List All Feeds")
        println()
        feeds.logAll()
        println()
    }

    fun showFeeds(feeds: FeedModel){
        if(feeds!= null)
            println("Feed Details [ $feeds ]")
        else
            println("Feed Not Found...")
    }

    fun addFeedData(feed: FeedModel): Boolean {
        //petId time - weight
        feed.weigth = -1f
        feed.petId = -1L
        println()
        print("Find a pet: ")
        feed.petId = readLine()!!.toLong()
        print("Enter a time: ")
        feed.time = readLine()!!
        print("Enter a weight for the food: ")
        feed.weigth = readLine()!!.toFloat()

        return (feed.petId> -1) && (feed.time.isNotEmpty()) && feed.weigth>-1
    }

    fun updateFeedData(feed: FeedModel): Boolean{
        var tempId: Long?
        var tempTime : String?
        var tempWeight :  Float?

        if(feed!= null){
            print("Find a new pet: ")
            tempId = readLine()!!.toLong()
            print("Find a new time for ["+feed.time+"]: ")
            tempTime = readLine()!!
            print("Enter a new Weight for [ "+feed.weigth+ "] :")
            tempWeight = readLine()!!.toFloat()

            if (!tempTime.isNullOrEmpty() && tempId != null && tempWeight !=null) {
                feed.petId = tempId
                feed.time = tempTime
                feed.weigth = tempWeight
                return true
            }
        }
       return false
    }

    fun getId(): Long {
        var strId: String?
        var searchId: Long
        print("Enter id to Search/Update")
        strId = readLine()!!
        searchId = if(strId.toLongOrNull() != null && strId.isNotEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }

}