package mongo.file;

import java.io.File;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class MongoFile {
	
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017);
   	 	DB db = mongoClient.getDB("mycol");
		File file=new File("E:/1.png");
		String fileid="1";
		String filename="haha.png";
		String collectionName="test";
		SaveFile(collectionName,file,fileid,filename,db);
		GridFSDBFile retrieveFileOne = retrieveFileOne(collectionName,filename,db);
		System.out.println(retrieveFileOne);
	}
	
	
	/**
     * 存储文件 
     * @param collectionName 集合名 
     * @param file 文件 
     * @param fileid 文件id 
     * @param companyid 文件的公司id 
     * @param filename 文件名称
	 * @param db 
     */
    public static void SaveFile(String collectionName, File file, String fileid, String filename, DB db) {
        try {
//        	 MongoClient mongoClient = new MongoClient( "localhost" , 27017);
//        	 DB db = mongoClient.getDB("mycol");
            //DB db = mongoTemplate.getDb();
            // 存储fs的根节点
            GridFS gridFS = new GridFS(db, collectionName);
            GridFSInputFile gfs = gridFS.createFile(file);
            gfs.put("filename", fileid);
            gfs.put("contentType", filename.substring(filename.lastIndexOf(".")));
            gfs.save();
            System.out.println("123");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("存储文件时发生错误！！！");
        }
    }

    // 取出文件
    public static GridFSDBFile retrieveFileOne(String collectionName, String filename,DB db) {
        try {
            //DB db = mongoTemplate.getDb();
        	/*MongoClient mongoClient = new MongoClient( "localhost" , 27017);
       	 	DB db = mongoClient.getDB("mycol");*/
            // 获取fs的根节点
            GridFS gridFS = new GridFS(db, collectionName);
            GridFSDBFile dbfile = gridFS.findOne(filename);
            if (dbfile != null) {
                return dbfile;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}
