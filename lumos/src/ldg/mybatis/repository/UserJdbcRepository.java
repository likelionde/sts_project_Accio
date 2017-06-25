package ldg.mybatis.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import ldg.mybatis.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

@Repository
public class UserJdbcRepository {
	protected NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public User selectCommentByPrimaryKey(int u_id) {
		Assert.notNull(u_id, "판매자가 없습니다.");

		StringBuilder sql = new StringBuilder("");
		sql.append("SELECT u_id, nickname, email, pwd FROM BUYER WHERE u_id = :u_id ");

		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("u_id", u_id);
		SqlParameterSource namedParameters = new MapSqlParameterSource(condition);
		List<User> result = this.jdbcTemplate.query(sql.toString(), namedParameters, 
				new RowMapper<User>() {	
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User comment = new User();
						comment.setU_id(rs.getInt("u_id"));
						comment.setStu_num(rs.getString("stu_num"));
						comment.setPwd(rs.getString("pwd"));
						return comment;
					} 
				}
		);

		if (!CollectionUtils.isEmpty(result)) {
			return result.get(0);
		}
		return null;
	}
	
	
	public Integer insertComment(User comment) {
		Assert.notNull(comment, "판매자 데이터가 없습니다.");

		StringBuilder sql = new StringBuilder("");
		sql.append("INSERT INTO BUYER(u_id, nickname, email, pwd) ");
		sql.append("VALUES (:u_id, :nickname, :email, :pwd) ");

		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(comment);
		return this.jdbcTemplate.update(sql.toString(), namedParameters);
	}

	public Integer deleteComment(int u_id) {
		Assert.notNull(u_id, "판매자가 없습니다.");

		StringBuilder sql = new StringBuilder("");
		sql.append("DELETE FROM BUYER WHERE u_id = :u_id ");

		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("u_id", u_id);
		SqlParameterSource namedParameters = new MapSqlParameterSource(condition);
		return this.jdbcTemplate.update(sql.toString(), namedParameters);
	}

}