package web.com.until;

import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * crud工具类
 * @author 宗明禄
 *
 */
public class MySqlUtil<T> {
	//数据库连接的url =>url还有一些参数 这里连接的是本地的mysql8 端口3309 ->my.ini中 
	//?key=value&key=value
	private static final String url = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC";
	//数据库连接的user
	private static final String user = "root";
	//数据库连接的密码
	private static final String password = "123456";

	public MySqlUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 自己封装的一个方法，返回一个连接对象
	 * 
	 * @return Connection对象
	 */
	public static Connection getConn() {

		Connection conn = null;
		try {
			// 1 加载驱动
			 //com.mysql.cj.jdbc.Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2获取连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	/**
	 * 封装的增加 删除 和修改通用代码(针对任何表)
	 * 
	 * @param sql    sql语句
	 * @param params 参数
	 * @return true 操作成功 false 操作失败
	 */
	public static int exEdit(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			// 2获取连接
			conn = getConn();
			// 3得到一个PrepardStatement
			pstmt = conn.prepareStatement(sql);
			// 调用自定义方法，设置参数
			setParameters(pstmt, params);
			// 4执行具体操作 增加删除以及修改
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6释放资源

			closeAll(null, pstmt, conn);
		}
		return n;

	}

	/**
	 * 设置参数的方法
	 * 
	 * @param pstmt  PreparedStatement 对象
	 * @param params Object... params 可变参数
	 * @throws SQLException SQLException 异常
	 */
	public static void setParameters(PreparedStatement pstmt, Object... params) throws SQLException {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
	}

	/**
	 * 通用查询方法(返回结果是一个集合)
	 * 
	 * @param sql    查询语句
	 * @param cla    Class对象
	 * @param params 参数
	 * @return List 集合
	 */
	public static List exQuery(String sql, Class cla, Object... params) {
		List list = new ArrayList();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 2获取连接
			conn = getConn();
			// 3得到一个PrepardStatement
			pstmt = conn.prepareStatement(sql);
			// 设置占位符的参数
			setParameters(pstmt, params);

			// 4执行具体操作 (ResultSet 结果集)
			rs = pstmt.executeQuery();
			// 5遍历rs
			while (rs.next()) {
				Object obj = convert(rs, cla);
				// 得到一个obj ,将其加入list
				list.add(obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}


	/**
	 * 分页查询
	 * @param sql
	 * @param cla
	 * @param pageNum
	 * @param pageSize
	 * @param params
	 * @return PageData
	 */
	public PageData<T> exQueryByPageData(String sql, Class cla, int pageNum, int pageSize, Object... params) {
		List<T> list = new ArrayList();

		String CountSql ="select count(*) as f from ( " + sql + " ) as t";
		int totalCount = exQueryPageDataNum(CountSql,params);
		int start = (pageNum - 1) * pageSize;
		sql = sql + " limit " + start + "," + pageSize;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 2获取连接
			conn = getConn();
			// 3得到一个PrepardStatement
			pstmt = conn.prepareStatement(sql);
			// 设置占位符的参数
			setParameters(pstmt, params);

			// 4执行具体操作 (ResultSet 结果集)
			rs = pstmt.executeQuery();
			// 5遍历rs
			while (rs.next()) {
				Object obj = convert(rs, cla);
				// 得到一个obj ,将其加入list
				list.add((T) obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		PageData<T> pageData = new PageData<T>();
		pageData.setPageNum(pageNum);
		pageData.setPageSize(pageSize);
		pageData.setList(list);
		pageData.setTotalCount(totalCount);
		return pageData;
	}


	/**
	 * 查询数据个数
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int exQueryPageDataNum(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int number = 0;
		try {
			// 2获取连接
			conn = getConn();
			// 3得到一个PrepardStatement
			pstmt = conn.prepareStatement(sql);
			// 设置占位符的参数
			setParameters(pstmt, params);

			// 4执行具体操作 (ResultSet 结果集)
			rs = pstmt.executeQuery();
			// 5遍历rs
			if (rs.next()) {
				number = rs.getInt("f");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return number;
	}

	/**
	 * 转换方法 将rs读取结果转换对象
	 * 
	 * @param rs  结果集
	 * @param cla  Class对象
	 * @return  Object
	 */
	private static Object convert(ResultSet rs, Class cla) {

		Object obj = null;
		try {
			obj = cla.newInstance();
			ResultSetMetaData rsmd = rs.getMetaData();
			// System.out.println(rsmd);

			// System.out.println(rsmd.getColumnCount()); //列数量
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				// getColumnLabel 如果有别名，就是别名 as 后; getColumnName 和表中的列 一致->列名
				// System.out.println(rsmd.getColumnLabel(i)+","+rsmd.getColumnName(i));
				String name = rsmd.getColumnLabel(i);
				Object objvalue = rs.getObject(name);
				// XX.set方法(对象,属性,属性的值); 属性 和列名一致
				BeanUtils.setProperty(obj, name, objvalue);
			}
		} catch (InstantiationException | IllegalAccessException | SQLException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	/**
	 * 释放资源
	 * 
	 * @param rs    ResultSet对象
	 * @param pstmt PreparedStatement 对象
	 * @param conn  Connection对象
	 */
	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		// 6释放资源
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

