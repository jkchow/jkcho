package mongo.file;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
  /*   
    //数据库连接实例
  	ServerAddress address = new ServerAddress(hostNameOrIp, port);
      mongoClient = new MongoClient(address, myOptions);   
  	
  	//带验证的
  	List<MongoCredential> mongoCredentialList = new ArrayList<MongoCredential>();
  	mongoCredentialList.add(MongoCredential.createMongoCRCredential(user, DBString, password.toCharArray()));
    MongoClient  mongoClient = new MongoClient(address, mongoCredentialList, myOptions);*/
	
	
    /**
     * 需要验证用户名  密码的 MongoDB的连接方式   com.mongodb.MongoClient.getDatabase("数据库名")
     * @return
     */
    public MongoDatabase getConnection() {
         try {  
                //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址  
                //ServerAddress()两个参数分别为 服务器地址 和 端口  
                ServerAddress serverAddress = new ServerAddress("localhost",27017);  
                List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
                addrs.add(serverAddress);  
                  
                //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码  
                MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());  
                List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
                credentials.add(credential);  
                  
                //通过连接认证获取MongoDB连接  
                MongoClient mongoClient = new MongoClient(addrs,credentials);  
                  
                //连接到数据库  
                MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");  
                System.out.println("连接成功");  
                return mongoDatabase;
            } catch (Exception e) {  
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );  
            }  
         return null;
    }
    
    /**
     * 不需要验证  用户名+密码  的获取连接的方式 com.mongodb.MongoClient.getDatabase("数据库名")
     * @return
     */
    public MongoDatabase getConnectionBasis(){
        try {
            //连接到mongodb服务
            MongoClient mongoClient = new MongoClient("localhost",27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
            System.out.println("连接成功");
            return mongoDatabase;
        } catch (Exception e) {
            System.out.println(e.getClass().getName()+":"+e.getMessage());
        }
        return null;
    }
    
}
