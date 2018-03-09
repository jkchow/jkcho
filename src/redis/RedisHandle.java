package redis;


import redis.clients.jedis.Jedis;

public class RedisHandle {
	
	public RedisHandle() {
		setup();
	}
	
	public static void main(String[] args) {
		RedisHandle rh = new RedisHandle();
		Jedis jedis = rh.getJedis();
		
		jedis.set("Hello", "by Leo Chen");
		
		System.out.println(jedis.get("Hello"));
	}
	
	
	private Jedis jedis; 
	
	public Jedis getJedis() {
		return jedis;
	}

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

	public void setup() {
		String filePath = this.getClass().getClassLoader().getResource("init.properties").getPath();
		Configuration config = new Configuration(filePath);
		
		String serverIp = config.getValue("redis.server.ip");
		String serverPort = config.getValue("redis.server.port");
		String serverPassword = config.getValue("redis.server.password");
		
		try {
			jedis = new Jedis(serverIp, Integer.parseInt(serverPort));
			jedis.getClient().setTimeout(100000);
			jedis.auth(serverPassword);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Warn:Redis 启动失败～请检查启动参数（serverIp="+ serverIp +",serverPort="+ serverPort +",serverPassword="+ serverPassword +"）");
		}
	}
}

