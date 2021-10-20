package org.wit.petMinder.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging
import org.wit.placemark.console.helpers.exists
import org.wit.placemark.console.helpers.read
import org.wit.placemark.console.helpers.write
import java.util.ArrayList

private val logger = KotlinLogging.logger {}

val JSON_FILE_FEED = "feed.json"
val gsonBuilder_feed = GsonBuilder().setPrettyPrinting().create()
val listType_feed = object : TypeToken<ArrayList<FeedModel>>() {}.type

class FeedJSONStore: FeedStore {
    var feeds = mutableListOf<FeedModel>()
    init {
        if (exists(JSON_FILE_EXE)) {
            deserialize()
        }
    }

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
        serialize()
    }

    override fun update(feed: FeedModel) {
        var foundFeed = findOne(feed.id!!)
        if(foundFeed != null) {
            foundFeed.time = feed.time
            foundFeed.weigth = feed.weigth
        }
        serialize()
    }

    override fun deleteOne(feedId: Long) {
        val foundFeed = findOne(feedId)
        if(foundFeed!= null){
            feeds.remove(foundFeed)
        }
        serialize()
    }

    override fun deleteByPet(petId: Long) {
        for (i in feeds) {
            if (i.petId == petId) {
                var foundFeed = findOne(i.id!!)
                if (foundFeed != null) {
                    feeds.remove(foundFeed)
                }
            }
        }
        serialize()
    }

    internal fun logAll() {
        feeds.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder_feed.toJson(feeds, listType_feed)
        write(JSON_FILE_FEED, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        feeds = Gson().fromJson(jsonString, listType_feed)
    }
}