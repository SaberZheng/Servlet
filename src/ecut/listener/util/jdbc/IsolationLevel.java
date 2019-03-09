package ecut.listener.util.jdbc;

/**
 * 表示 事务隔离级别 的枚举类 ，声明了常用的事务隔离级别对应的枚举常量
 */
public enum IsolationLevel {
	/** NONE : Connection.TRANSACTION_NONE ，不支持事务*/
	NONE(0),
	/** READ_UNCOMMITTED : Connection.TRANSACTION_READ_UNCOMMITTED ，读未提交 */
	READ_UNCOMMITTED(1),
	/** READ_COMMITTED : Connection.TRANSACTION_READ_COMMITTED ，读已提交 */
	READ_COMMITTED(2),
	/** REPEATABLE_READ : Connection.TRANSACTION_REPEATABLE_READ ， 可重复读 */
	REPEATABLE_READ(4),
	/** SERIALIZABLE : Connection.TRANSACTION_SERIALIZABLE ，序列化 */
	SERIALIZABLE(8),
	/** DEFAULT : 采用与正在使用的数据库的事务隔离级别相一致的隔离级别*/
	DEFAULT(-1) ;
	
	private int level ;
	
	private IsolationLevel( int level ){
		this.level = level ;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
