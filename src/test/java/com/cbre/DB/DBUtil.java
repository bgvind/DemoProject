package com.cbre.DB;

import java.util.Map;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DBUtil {

	@SuppressWarnings({ "rawtypes", "deprecation", "resource" })
	public static Map getDocument(String collectionName, String searchBy, String searchValue) {
		com.mongodb.MongoClient mongo = new MongoClient("localhost", 27017);
		DB database = mongo.getDB("si_demo");
		DBCollection collection = database.getCollection(collectionName);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(searchBy, searchValue);
		DBObject dBObject = collection.findOne(searchQuery);
		Map dataMap = dBObject.toMap();
		System.out.println(dataMap);
		return dBObject.toMap();
	}

}
