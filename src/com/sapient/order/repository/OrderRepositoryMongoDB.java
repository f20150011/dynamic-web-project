package com.sapient.order.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sapient.order.dto.Order;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class OrderRepositoryMongoDB implements IOrderRepository {

	public void save(Order order) {

		// Creating a Mongo client
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Creating Credentials
		// MongoCredential credential = MongoCredential.createCredential("sampleUser",
		// "myDb", "password".toCharArray());

		// Accessing the database
		MongoDatabase database = mongo.getDatabase("sapient");

		MongoCollection<Document> collection = database.getCollection("sapient");

		// writing to db
		Document document = new Document("company", order.getCompany())
				.append("location", order.getLocation())
				.append("price", order.getPrice());
		collection.insertOne(document);

		// reading from db
		// Getting the iterable object
		FindIterable<Document> iterDoc = collection.find();

		// Getting the iterator
		MongoCursor<Document> it = iterDoc.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		mongo.close();

	}
}
