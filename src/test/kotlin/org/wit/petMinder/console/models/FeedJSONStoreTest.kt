package org.wit.petMinder.console.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.random.Random

class FeedJSONStoreTest {
    val feedStore = FeedJSONStore()

    @Test
    fun findAllTest() {
        val test1 = FeedModel(0,3,"Moring", 2.2f)
        feedStore.create(test1)
        assertEquals(feedStore.findAll().size, feedStore.feeds.size)
    }

    @Test
    fun findByPetTest(){
        val length = feedStore.feeds.size
        val test1 = FeedModel(0,3,"Eveing", 1.2f)
        val test2 = FeedModel(1,3,"Afternoon", 1.5f)
        feedStore.create(test1)
        feedStore.create(test2)
        val listOfFeed= feedStore.findByPet(3)
        assertEquals(listOfFeed.size, length + 2)
    }

    @Test
    fun findOneTest(){
        val test1 = FeedModel(petId = 3,time =  "Moring", weigth = 0.5f)
        feedStore.create(test1)
        assertEquals(
            feedStore.feeds[feedStore.feeds.size - 1],
            feedStore.findOne(feedStore.feeds[feedStore.feeds.size - 1].id)
        )
    }

    @Test
    fun createTest(){
        val test1 = FeedModel(0,3,"Afternoon", 3.2f)
        feedStore.create(test1)
        assertTrue(feedStore.feeds.contains(test1))
    }

    @Test
    fun updateTest(){
        val updating = feedStore.feeds[0]
        val newWeight = Random.nextFloat()
        updating.weigth = newWeight
        feedStore.update(updating)
        assertEquals(updating.weigth, newWeight)
    }


    @Test
    fun deleteOneTest(){
        val deleting = feedStore.feeds[0]
        feedStore.deleteOne(deleting.id)
        Assertions.assertFalse(feedStore.feeds.contains(deleting))
    }

}